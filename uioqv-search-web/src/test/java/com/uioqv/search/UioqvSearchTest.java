package com.uioqv.search;

import com.uioqv.search.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author LiuGuoQing
 * @since 2018-10-25
 */
@Slf4j
public class UioqvSearchTest {

    @Test
    public void findProject() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        webClient.get().uri("/projects")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .flatMapMany(rep -> rep.bodyToFlux(Result.class))
                .doOnNext(System.out::println)
                .blockLast();
    }
    @Test
    public void saveProject() {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectName("订饭");
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        webClient.post().uri("/projects")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(projectDTO))
                .exchange()
                .flatMapMany(rep -> rep.bodyToFlux(Result.class))
                .doOnNext((p)->{
                    System.out.println(p);
                }).blockLast();
    }
}
