package io.redbee.academy.persistencia.repository;

import io.redbee.academy.persistencia.model.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TaskFileRepository test suite")
public class TaskFileRepositoryTest {

    @Test
    @DisplayName("Get all tasks ok")
    public void testGetAllTasksOk() {
        TaskFileRepository repository = new TaskFileRepository("./src/test/resources/valid-3-tasks.csv");

        List<Task> tasks = assertDoesNotThrow(repository::getAll);

        assertNotNull(tasks);

        assertEquals(3, tasks.size());
    }

    @Test
    @DisplayName("Get all task throws an exception")
    public void testGetAllTasksThrowsAnException() {
        TaskFileRepository repository = new TaskFileRepository("some/fake/path/throws/error.csv");

        var exception = assertThrows(RuntimeException.class, repository::getAll);

        assertEquals("Error reading tasks file", exception.getMessage());
    }

    @Test
    @DisplayName("Save single task")
    public void testSaveTask() {
        Task task = new Task("Task description", LocalDate.MAX, 1);

        TaskRepository repository = new TaskFileRepository("./src/test/resources/valid-3-tasks.csv");

        var exception = assertThrows(UnsupportedOperationException.class, () -> repository.save(task));

        assertEquals("Requested operation is not supported", exception.getMessage());
    }

    @Test
    @DisplayName("Save a list of tasks")
    public void testSaveTasksList() {
        TaskRepository repository = new TaskFileRepository("./src/test/resources/valid-3-tasks.csv");

        List<Task> tasks = List.of(
                new Task("Task 1", LocalDate.MAX, 1),
                new Task("Task 2", LocalDate.MAX, 1),
                new Task("Task 3", LocalDate.MAX, 1)
        );

        var exception = assertThrows(UnsupportedOperationException.class, () -> repository.save(tasks));

        assertEquals("Requested operation is not supported", exception.getMessage());
    }

}
