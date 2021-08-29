/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.services.serviceImpl;

import java.util.List;
import java.util.UUID;
import com.taskboard.taskboard.models.Task;
import com.taskboard.taskboard.models.TaskGroup;
import com.taskboard.taskboard.repositories.TaskGroupRepository;
import com.taskboard.taskboard.repositories.TaskRepository;
import com.taskboard.taskboard.services.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskGroupRepository taskGroupRepository;

    @Override
    public Task createTask(Task task) {
        String groupName = task.getGroup_name();

        TaskGroup a = taskGroupRepository.findByGroupName(groupName);

        task.setTask_group(a);

        return taskRepository.save(task);
    }

    @Override
    public Task findByUUID(UUID id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(UUID id, Task task) {
        Task updatedTask = taskRepository.findById(id).get();

        String groupName = task.getGroup_name();

        TaskGroup a = taskGroupRepository.findByGroupName(groupName);

        task.setTask_group(a);

        BeanUtils.copyProperties(task, updatedTask, "task_id", "task_group_id");
        return taskRepository.save(updatedTask);
    }

    @Override
    public void deleteTask(UUID id) {
        Task deletedTask = taskRepository.getById(id);
        taskRepository.delete(deletedTask);
    }
}
