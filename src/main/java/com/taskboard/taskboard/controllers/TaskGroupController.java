/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.controllers;

import java.util.List;
import java.util.UUID;

import com.taskboard.taskboard.models.Task;
import com.taskboard.taskboard.models.TaskGroup;
import com.taskboard.taskboard.services.TaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/taskGroup")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskGroupController {

    // http://localhost:8080/api/taskGroup

    @Autowired
    TaskGroupService taskGroupService;

    @PostMapping
    public TaskGroup createTask(@RequestBody TaskGroup task) {
        return taskGroupService.createTaskGroup(task);
    }

    @GetMapping
    public List<TaskGroup> fetchAllTaskGroups() {
        return taskGroupService.findAllTaskGroups();
    }

    @GetMapping(value = "/{id}")
    public TaskGroup fetchTaskByUUID(@PathVariable("id") UUID id) {
        return taskGroupService.findByUUID(id);
    }

    @PutMapping(value = "/{id}")
    public TaskGroup updateTask(@PathVariable("id") UUID id, @RequestBody TaskGroup task) {
        return taskGroupService.updateTaskGroup(id, task);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable("id") UUID id) {
        taskGroupService.deleteTaskGroup(id);
    }
}
