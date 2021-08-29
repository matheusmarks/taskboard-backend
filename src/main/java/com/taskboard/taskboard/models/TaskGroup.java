/**
 * @author Matheus Marques
 */

package com.taskboard.taskboard.models;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name = "task_groups")
public class TaskGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID task_group_id;

    @Column
    private String name;

    @OneToMany(mappedBy = "task_group", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Column
    private List<Task> tasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public UUID getTask_group_id() {
        return task_group_id;
    }

    public void setTask_group_id(UUID task_group_id) {
        this.task_group_id = task_group_id;
    }
}
