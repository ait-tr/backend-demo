package de.ait.todo.controllers.api;

import de.ait.todo.dto.TasksPage;
import de.ait.todo.security.details.AuthenticatedUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 6/11/2023
 * backend-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Tags(value = {
        @Tag(name = "Tasks")})
@RequestMapping("/api/tasks")
@ApiResponse(responseCode = "403", description = "Пользователь не аутентифицирован", content = {
        @Content(mediaType = "application/json")
})
public interface TasksApi {

    @Operation(summary = "Получение списка задач")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Страница с задачами",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TasksPage.class))
                    }
            )
    })
    @GetMapping
    ResponseEntity<TasksPage> getAll(@Parameter(description = "Номер страницы") @RequestParam("page") int page,
                                     @Parameter(hidden = true) AuthenticatedUser currentUser);
}