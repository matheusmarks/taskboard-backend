/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.services;

import java.util.List;
import java.util.UUID;

import com.taskboard.taskboard.models.Task;

public interface TaskService {

    public Task createTask(Task task);

    public Task findByUUID(UUID id);

    public List<Task> findAllTasks();

    public Task updateTask(UUID id, Task task);

    public void deleteTask(UUID id);
}
