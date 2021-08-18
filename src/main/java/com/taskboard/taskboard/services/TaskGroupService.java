package com.taskboard.taskboard.services;

import java.util.List;
import com.taskboard.taskboard.models.TaskGroup;

public interface TaskGroupService {
    public TaskGroup createTaskGroup();

    public TaskGroup findByUUID();

    public List<TaskGroup> findAllTaskGroups();

    public TaskGroup updateTaskGroup();

    public void deleteTaskGroup();
}
