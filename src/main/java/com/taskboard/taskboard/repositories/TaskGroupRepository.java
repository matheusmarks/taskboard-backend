/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.repositories;

import java.util.UUID;
import com.taskboard.taskboard.models.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, UUID> {

    @Query("SELECT t from TaskGroup t WHERE t.name = ?1")
    public TaskGroup findByGroupName(String groupName);
}
