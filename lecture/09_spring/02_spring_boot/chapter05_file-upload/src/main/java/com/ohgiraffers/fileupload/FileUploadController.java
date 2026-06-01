package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {

    private final Path uploadRoot;

    //@Value : 프로퍼티 파일의 값을 읽어옴
    public FileUploadController(@Value("${file.upload-dir}") String uploadDir) {
        this.uploadRoot = Paths.get(uploadDir).toAbsolutePath().normalize();
        //절대 경로 > normalize를 거쳐 uploadRoot에 초기화 시킴
    }

    //1. 단일 파일 업로드
    @PostMapping("/single")
    public ResponseEntity<Map<String, Object>> uploadSingleFile(
            // 💡 프론트가 "file"로 보냈으니, 여기서도 딱 맞춰서 "file"을 적어줘야 함!
                /* 1. 🌐 프론트엔드 (JavaScript / React 등)
                프론트에서는 파일을 보낼 때 FormData라는 주머니를 만들어서 데이터를 채워 넣어.
                JavaScript
                const formData = new FormData();
                // 💡 첫 번째 인자 "file"이 바로 [이름표(Key)] 역할을 하는 거야!
                formData.append("file", fileData);
                * */
            //  formData.append("file",file); 이름과 같이 맞춰줘야함
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "description", required = false) String description) throws IOException {

        FileDTO uploadFile = saveFile(file, "single", description);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "단일 파일 업로드 성공");
        response.put("file", uploadFile);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    //2. 여러개의 파일 업로드
    @PostMapping("/multiple")
    public ResponseEntity<Map<String, Object>> uploadMultipleFiles(
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam(value = "description", required = false) String description) throws IOException {

        if (files == null || files.isEmpty()) {
            throw new IllegalArgumentException("업로드 할 파일 목록이 비어 있습니다.");
        }
        List<FileDTO> uploadFiles = new ArrayList<>();

        try {
            for (MultipartFile file : files) {
                uploadFiles.add(saveFile(file, "multiple", description));
            }
        } catch (IOException | RuntimeException e) {
            /*여러 파일 중간에 실패하면 이미 저장된 파일을 삭제*/
            for (FileDTO uploadedFile : uploadFiles) {
                Files.deleteIfExists(Paths.get(uploadedFile.getFilePath()));
            }
            throw e;
        }
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "다중 파일 업로드 성공");
        response.put("count", uploadFiles.size());
        response.put("files", uploadFiles);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    private FileDTO saveFile(MultipartFile file, String directoryName, String description) throws IOException {

        validateFile(file);
        //기본 업로드 경로 뒤에 하위 디렉토리 이름을 붙인다.(chapter05_file-upload/uploads/single)
        Path uploadPath = uploadRoot.resolve(directoryName).normalize();
        Files.createDirectories(uploadPath);

        String originalFileName = file.getOriginalFilename();
        String extension = extractExtension(originalFileName);

        //UUID("범용 고유 식별자")를 생성, toString을 이용해 문자열로 변환, replace를 이용해 -를 빈문자열로 제거
        String savedFileName = UUID.randomUUID().toString().replace("-", "") + extension;
        //실제 저장된 경로를 targetPath로 받아 온다.
        Path targetPath = uploadPath.resolve(savedFileName).normalize();

        //실제로 파일을 디스크에 저장한다. (targetPath에 파일을 저장한다.)
        file.transferTo(targetPath);

        return new FileDTO(
                originalFileName,
                savedFileName,
                targetPath.toString(),
                description,
                file.getSize(),
                file.getContentType()
        );
    }

    //파일을 저장하기 전에 유효성 검사
    //1. 파일에 대한 유효성 검사
    private void validateFile(MultipartFile file) {
        /*빈 파일 요청은 정상 업로드 처리하지 않음*/
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("업로드 할 파일이 비어 있습니다.");
        }

        /*확장자 추출과 저장 파일명 생성을 위해 원본 파일명이 필요*/
        if (file.getOriginalFilename() == null || file.getOriginalFilename().isBlank()) {
            throw new IllegalArgumentException("원본 파일명이 없습니다.");
        }
    }

    //2. 원본 파일명에서 확장자 추출
    private String extractExtension(String originalFileName) {
        //파일명에 점이 여러 개 있을 수 있으니 마지막 점을 확장자 기준으로 삼는다.
        int lastDotIndex = originalFileName.lastIndexOf(".");

        if (lastDotIndex == -1) {
            return "";
        }

        //마지막 점부터 끝까지 잘라서 .png, .txt 처럼 정믈 포함한 확장자 반환
        return originalFileName.substring(lastDotIndex);
    }
}