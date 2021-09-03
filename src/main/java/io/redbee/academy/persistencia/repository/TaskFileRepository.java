package io.redbee.academy.persistencia.repository;

import io.redbee.academy.persistencia.model.Task;

import java.util.Collections;
import java.util.List;

public class TaskFileRepository implements TaskRepository {

    private final String filePath;

    public TaskFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Task> getAll() {
        return Collections.emptyList();
    }

    @Override
    public void save(Task task) {
        throw new UnsupportedOperationException("Requested operation is not supported");
    }

    @Override
    public void save(List<Task> tasks) {
        throw new UnsupportedOperationException("Requested operation is not supported");
    }

}
