package com.taskboard.taskboard.services;

import java.util.List;
import com.taskboard.taskboard.models.Task;

public interface TaskService {

    public Task createTask();

    public Task findByUUID();

    public List<Task> findAllTasks();

    public Task updateTask();

    public void deleteTask();
}
