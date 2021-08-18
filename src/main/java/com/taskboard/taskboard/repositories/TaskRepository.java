package com.taskboard.taskboard.repositories;

import java.util.UUID;
import com.taskboard.taskboard.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}
