package de.ait.todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 6/11/2023
 * backend-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Страница с задачами и общее количество страниц")
public class TasksPage {

    @Schema(description = "Список задач")
    private List<TaskDto> tasks;

    @Schema(description = "Количество доступных страниц", example = "5")
    private Integer totalPages;
}
