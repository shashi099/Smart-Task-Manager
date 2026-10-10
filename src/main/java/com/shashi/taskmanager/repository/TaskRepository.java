package com.shashi.taskmanager.repository;

import com.shashi.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /*
        Repository layer, which allows Spring Boot to perform database
        operations without requiring us to write every SQL query manually.
     */
}
