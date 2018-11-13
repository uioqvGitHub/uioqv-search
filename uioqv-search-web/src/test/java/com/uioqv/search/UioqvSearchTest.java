package com.uioqv.search;

import com.uioqv.base.entity.Result;
import com.uioqv.search.dto.DocumentDTO;
import com.uioqv.search.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
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
        projectDTO.setDocumentId("5be10d0c79dc39599946d4cb");
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

    @Test
    public void saveDocument() {
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setDocumentName("订饭");
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        webClient.post().uri("/documents")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(documentDTO))
                .exchange()
                .flatMapMany(rep -> rep.bodyToFlux(Result.class))
                .doOnNext((p)->{
                    System.out.println(p);
                }).blockLast();
    }

    @Test
    public void findDocument() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        webClient.get().uri("/documents")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .flatMapMany(rep -> rep.bodyToFlux(Result.class))
                .doOnNext(System.out::println)
                .blockLast();
    }
}
