package de.ait.todo.controllers.api;

import de.ait.todo.dto.StandardResponseDto;
import de.ait.todo.dto.TaskDto;
import de.ait.todo.dto.TasksPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 6/11/2023
 * backend-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Tags(value = {
        @Tag(name = "Tasks")})
@RequestMapping("/api/tasks")
@ApiResponse(responseCode = "403", description = "Пользователь не аутентифицирован",
        content = {
                @Content(mediaType = "application/json",
                        schema = @Schema(ref = "StandardResponseDto"))
        }
)
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
    ResponseEntity<TasksPage> getAll();

    @Operation(summary = "Получение задачи")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Задача",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TaskDto.class))
                    }
            ),
            @ApiResponse(responseCode = "404", description = "Не найдено",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            )
    })
    @GetMapping("/{task-id}")
    ResponseEntity<TaskDto> getById(@PathVariable("task-id") Long taskId);


    @Operation(summary = "Удаление задачи")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Задача удалена"
            ),
            @ApiResponse(responseCode = "404", description = "Не найдено",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            )
    })
    @DeleteMapping("/{task-id}")
    void deleteTask(@PathVariable("task-id") Long taskId);
}