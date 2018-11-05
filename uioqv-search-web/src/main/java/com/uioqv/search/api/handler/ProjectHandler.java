package com.uioqv.search.api.handler;

import com.uioqv.search.Result;
import com.uioqv.search.dto.ProjectDTO;
import com.uioqv.search.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.*;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.*;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-24
 */
@Controller
public class ProjectHandler {
    @Autowired
    private ProjectService projectService;

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<ProjectDTO> project = request.bodyToMono(ProjectDTO.class);
        return ok().contentType(APPLICATION_JSON).body(
                projectService.createProject(project).map(Result::success),
                Result.class
        );
    }
    public Mono<ServerResponse> find(ServerRequest serverRequest) {
        return ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(
                projectService.findProject().map(Result::success)
                , Result.class
        );
    }
}
