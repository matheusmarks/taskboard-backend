/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.services.serviceImpl;

import java.util.List;
import java.util.UUID;
import com.taskboard.taskboard.models.Task;
import com.taskboard.taskboard.repositories.TaskRepository;
import com.taskboard.taskboard.services.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findByUUID(UUID id) {
        return taskRepository.getById(id);
    }

    @Override
    public List<Task> findAllTasks() {
        return null;
    }

    @Override
    public Task updateTask(UUID id, Task task) {
        Task updatedTask = taskRepository.getById(id);
        BeanUtils.copyProperties(task, updatedTask, "id");
        return taskRepository.save(updatedTask);
    }

    @Override
    public void deleteTask(UUID id) {
        Task deletedTask = taskRepository.getById(id);
        taskRepository.delete(deletedTask);
    }
}
