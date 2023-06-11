package de.ait.todo.runners;

import de.ait.todo.models.Task;
import de.ait.todo.models.User;
import de.ait.todo.repositories.TasksRepository;
import de.ait.todo.repositories.UsersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InitialDataRunner implements CommandLineRunner {

    UsersRepository usersRepository;

    TasksRepository tasksRepository;

    @Override
    public void run(String... args) {

        if (!usersRepository.existsById(1L)) {
            User admin = User.builder()
                    .email("admin@ait-tr.de")
                    .role(User.Role.ADMIN)
                    .hashPassword("$2a$10$YijmlwvWMcfIhT2qQOQ7EeRuMiByNjPtKXa78J7Y8z7XZWJJQTDa.") // admin
                    .build();

            usersRepository.save(admin);
        }

        if (tasksRepository.count() == 0) {
            tasksRepository.saveAll(Arrays.asList(
                    Task.builder().name("Name 1").description("Description 1").build(),
                    Task.builder().name("Name 1").description("Description 1").build(),
                    Task.builder().name("Name 1").description("Description 1").build(),
                    Task.builder().name("Name 1").description("Description 1").build()
            ));
        }


    }
}