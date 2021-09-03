package io.redbee.academy.persistencia.repository;

import io.redbee.academy.persistencia.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> getAll();

    void save(Task task);

    void save(List<Task> tasks);

}
