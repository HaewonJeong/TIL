package com.ohgiraffers.exceptionhandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @RestControllerAdvice - @ExceptionHandler 어노테이션
 * 여러 Controller에서 발생한 예외를 한 곳에서 처리
 * 모든 전역에서 Controller에서 예외가 발생했는지 감시하다가, 예외가 발생하면 @ExceptionHandler를 실행
 *  @ExceptionHandler(MemberNotFoundException.class)
 *  : 특정 예외를 어떤 메서드가 처리할지 지정
 * Rest~ 어노테이션을 사용할떄는 View(화면)이 아닌 Json 데이터를 반환한다는 의미
 */

/* * 여러 Controller에서 발생한 예외를 한 곳에서 처리하고 JSON body로 응답 * */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //특정 예외를 어떤 메서드가 처리할지 지정
    @ExceptionHandler(MemberNotFoundException.class)
        public ResponseEntity<ErrorResponse> handlerMemberNotFound(
            MemberNotFoundException exception,
            HttpServletRequest request) {

            ErrorResponse response = new ErrorResponse(

                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.name(),
                    exception.getMessage(),
                    request.getRequestURI()
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }

    @ExceptionHandler(InvalidMemberRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMemberRequest(
            InvalidMemberRequestException exception,
            HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(response);
    }

    /*위에서 따로 처리하지 않은 예외를 마지막으로 받는 역할*/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception exception,
            HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                "서버 내부 오류가 발생했습니다.",
                request.getRequestURI()
        );

        return ResponseEntity.internalServerError().body(response);
    }
}
