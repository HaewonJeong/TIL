package com.ohgiraffers.filebridge.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

/*
* FastAPI의 python 함수를 직접 실행하지 않고 HTTP 요청으로 호출한다.
* */
//파이썬의 FastAPI로 만들어진 Health. Spring -> Python 보낸 요청 처리

@Service
public class FastAppiFileClient {

    private final RestClient restClient;

    public FastAppiFileClient(@Value("${fastapi.url}") String baseUrl) {

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(new SimpleClientHttpRequestFactory())
                .build();
    }

    public HealthResponse checkHealth(){
        return restClient.get()
                .uri("/health") //파이썬의 FastAPI로 만들어진 Health. Spring -> Python 보낸 요청 처리
                .retrieve()
                .body(HealthResponse.class);
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record HealthResponse(String status, String service, String version){

    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record FileInfo(
            String id,
            String originalName,
            String contentType,
            long size,
            String description,
            String soredName
    )

}
