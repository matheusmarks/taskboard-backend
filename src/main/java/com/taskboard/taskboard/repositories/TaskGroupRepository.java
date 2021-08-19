/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.repositories;

import java.util.UUID;
import com.taskboard.taskboard.models.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, UUID>{
    
}
