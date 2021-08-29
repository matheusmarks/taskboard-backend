package com.taskboard.taskboard.repositories;

import java.util.List;
import java.util.UUID;

import com.taskboard.taskboard.models.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskAndTaskGroupRepository extends JpaRepository<Task, UUID> {

}
