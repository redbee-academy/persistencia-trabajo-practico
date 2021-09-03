package io.redbee.academy.persistencia.repository;

import io.redbee.academy.persistencia.model.Task;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("TaskFileRepository test suite")
public class TaskFileRepositoryTest {

    @Disabled
    @Test
    @DisplayName("Get all tasks")
    public void testGetAllTasks() {
    }

    @Test
    @DisplayName("Save single task")
    public void testSaveTask() {
        Task task = new Task("Task description", LocalDate.now(), 1);

        TaskRepository repository = new TaskFileRepository("some/fake/path.csv");

        var exception = assertThrows(UnsupportedOperationException.class, () -> repository.save(task));

        assertEquals("Requested operation is not supported", exception.getMessage());
    }

    @Test
    @DisplayName("Save a list of tasks")
    public void testSaveTasksList() {
        TaskRepository repository = new TaskFileRepository("some/fake/path.csv");

        List<Task> tasks = List.of(
                new Task("Task 1", LocalDate.MAX, 1),
                new Task("Task 2", LocalDate.MAX, 1),
                new Task("Task 3", LocalDate.MAX, 1)
        );

        var exception = assertThrows(UnsupportedOperationException.class, () -> repository.save(tasks));

        assertEquals("Requested operation is not supported", exception.getMessage());
    }

}
