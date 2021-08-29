/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.taskboard.taskboard.models.Task;
import com.taskboard.taskboard.models.TaskGroup;
import com.taskboard.taskboard.repositories.TaskAndTaskGroupRepository;
import com.taskboard.taskboard.repositories.TaskGroupRepository;
import com.taskboard.taskboard.repositories.TaskRepository;
import com.taskboard.taskboard.services.TaskGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskGroupServiceImpl implements TaskGroupService {

    @Autowired
    TaskGroupRepository taskGroupRepository;

    @Autowired
    TaskAndTaskGroupRepository taskAndTaskGroupRepository;

    @Override
    public TaskGroup createTaskGroup(TaskGroup taskGroup) {
        return taskGroupRepository.save(taskGroup);
    }

    @Override
    public TaskGroup findByUUID(UUID id) {
        return taskGroupRepository.findById(id).get();
    }

    @Override
    public List<TaskGroup> findAllTaskGroups() {
        return taskGroupRepository.findAll();
    }

    @Override
    public TaskGroup updateTaskGroup(UUID id, TaskGroup taskGroup) {
        TaskGroup updatedTaskGroup = taskGroupRepository.findById(id).get();
        BeanUtils.copyProperties(taskGroup, updatedTaskGroup, "task_group_id");
        return taskGroupRepository.save(updatedTaskGroup);
    }

    @Override
    public void deleteTaskGroup(UUID id) {
        TaskGroup deletedTaskGroup = taskGroupRepository.getById(id);
        taskGroupRepository.delete(deletedTaskGroup);
    }
}
