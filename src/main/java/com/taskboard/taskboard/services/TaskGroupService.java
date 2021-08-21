/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.services;

import java.util.List;
import java.util.UUID;

import com.taskboard.taskboard.models.TaskGroup;

public interface TaskGroupService {
    public TaskGroup createTaskGroup(TaskGroup taskGroup);

    public TaskGroup findByUUID(UUID id);

    public List<TaskGroup> findAllTaskGroups();

    public TaskGroup updateTaskGroup(UUID id, TaskGroup taskGroup);

    public void deleteTaskGroup(UUID id);
}
