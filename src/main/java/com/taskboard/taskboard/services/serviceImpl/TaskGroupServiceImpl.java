/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.services.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
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
    TaskServiceImpl taskService;

    @Autowired

    TaskRepository taskRepository;

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
        List<Task> tasks = taskRepository.findAll();

        BeanUtils.copyProperties(taskGroup, updatedTaskGroup, "task_group_id");

        TaskGroup saveTaskGroup = taskGroupRepository.save(updatedTaskGroup);

        System.out.println(saveTaskGroup.getTask_group_id());

        List<Task> allTasks = tasks.stream()
                .filter(task -> task.getTask_group().getTask_group_id() == saveTaskGroup.getTask_group_id())
                .collect(Collectors.toList());

        for (int i = 0; i < allTasks.size(); i++) {
            allTasks.get(i).setGroup_name(taskGroup.getName());
            taskService.updateTask(allTasks.get(i).getTask_id(), allTasks.get(i));
        }

        return saveTaskGroup;
    }

    @Override
    public void deleteTaskGroup(UUID id) {
        TaskGroup deletedTaskGroup = taskGroupRepository.getById(id);
        taskGroupRepository.delete(deletedTaskGroup);
    }
}
