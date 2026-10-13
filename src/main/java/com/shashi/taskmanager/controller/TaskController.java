package com.shashi.taskmanager.controller;

import com.shashi.taskmanager.dto.CreateTaskRequest;
import com.shashi.taskmanager.dto.TaskResponse;
import com.shashi.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    //Create Task
    @PostMapping
    public TaskResponse createTask(@RequestBody CreateTaskRequest request){
        TaskResponse response = service.createTask(request);
        return response;
    }

    // Get All Tasks
    @GetMapping
    public List<TaskResponse> getAllTasks(){
        return service.getAllTasks();
    }

    // Get Task By Id
    @GetMapping("/{id}")
    public TaskResponse getOneTask(@PathVariable Long id){
        TaskResponse response = service.getTaskById(id);
        return response;
    }

    // Delete Task By id
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }

}
