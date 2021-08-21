/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.controllers;

import java.util.List;
import java.util.UUID;
import com.taskboard.taskboard.models.Task;
import com.taskboard.taskboard.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {

    // http://localhost:8080/api/task

    @Autowired
    TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping(value = "/{id}")
    public Task fetchTaskByUUID(@PathVariable("id") UUID id) {
        return taskService.findByUUID(id);
    }

    @GetMapping
    public List<Task> fetchAllTasks() {
        return taskService.findAllTasks();
    }

    @PutMapping(value = "/{id}")
    public Task updateTask(@PathVariable("id") UUID id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable("id") UUID id) {
        taskService.deleteTask(id);
    }
}
