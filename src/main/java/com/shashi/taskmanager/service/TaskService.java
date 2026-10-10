package com.shashi.taskmanager.service;

import com.shashi.taskmanager.entity.Task;
import com.shashi.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired  // called Constructor Injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // create and save task
    public void save(Task task){
        taskRepository.save(task);
    }

    // retrieve all tasks
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    // Retrieve a task by id
    public Task getById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
    }

    // Delete a task by ID
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with ID: " + id);
        }

        taskRepository.deleteById(id);
    }

}
