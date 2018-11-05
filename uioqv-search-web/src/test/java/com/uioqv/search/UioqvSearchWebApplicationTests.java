package com.uioqv.search;

import com.uioqv.search.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UioqvSearchWebApplicationTests {

    @Autowired
    private ProjectService projectService;

    @Test
    public void contextLoads() {
        projectService.findProject().subscribe((p) -> {
            System.out.println(p.getProjectName());
        });
        StepVerifier.create(
                projectService.findProject())
//                .expectNextCount(1)
//                .ex
                .verifyComplete();
    }

    @Test
    public void test() {
        Flux<String> source = Flux.just("foo", "bar");

        StepVerifier.create(
                appendBoomError(source))
                .expectNextCount(2)
                .expectNext("foo1")
                .expectNext("bar")
                .expectErrorMessage("boom")
                .verify();
    }

    public <T> Flux<T> appendBoomError(Flux<T> source) {
        return source.concatWith(Mono.error(new IllegalArgumentException("boom")));
    }

}
