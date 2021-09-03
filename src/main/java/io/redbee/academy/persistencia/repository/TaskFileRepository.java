package io.redbee.academy.persistencia.repository;

import io.redbee.academy.persistencia.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TaskFileRepository implements TaskRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskFileRepository.class);
    private static final String DEFAULT_DATA_DELIMITER = ";";
    private static final Long HEADER_ROW_SIZE = 1L;

    private final String filePath;
    private final String dataDelimiter;

    public TaskFileRepository(String filePath) {
        this.filePath = filePath;
        this.dataDelimiter = DEFAULT_DATA_DELIMITER;
    }

    public TaskFileRepository(String filePath, String dataDelimiter) {
        this.filePath = filePath;
        this.dataDelimiter = dataDelimiter;
    }

    @Override
    public List<Task> getAll() {
        try {
            return Files.lines(Path.of(this.filePath))
                    .skip(HEADER_ROW_SIZE)
                    .map(fileLines -> fileLines.split(this.dataDelimiter))
                    .map(this::toModel)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Error reading file: {}", e.getMessage(), e);
            throw new RuntimeException("Error reading tasks file");
        }
    }

    @Override
    public void save(Task task) {
        throw new UnsupportedOperationException("Requested operation is not supported");
    }

    @Override
    public void save(List<Task> tasks) {
        throw new UnsupportedOperationException("Requested operation is not supported");
    }

    private Task toModel(String[] taskFileLine) {
        String description = taskFileLine[0];
        LocalDate deadlineAsString = LocalDate.parse(taskFileLine[1]);
        Integer employeeId = Integer.valueOf(taskFileLine[2]);
        return new Task(description, deadlineAsString, employeeId);
    }

}
