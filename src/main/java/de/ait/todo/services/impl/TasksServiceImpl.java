package de.ait.todo.services.impl;

import de.ait.todo.dto.TasksPage;
import de.ait.todo.models.Task;
import de.ait.todo.repositories.TasksRepository;
import de.ait.todo.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static de.ait.todo.dto.TaskDto.from;

/**
 * 6/11/2023
 * backend-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;

    @Value("${app.default-page-size}")
    private int defaultPageSize;

    @Override
    public TasksPage getAll(int page) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);

        Page<Task> tasksPage = tasksRepository.findAll(pageRequest);

        return TasksPage.builder()
                .tasks(from(tasksPage.getContent()))
                .totalPages(tasksPage.getTotalPages())
                .build();
    }
}
