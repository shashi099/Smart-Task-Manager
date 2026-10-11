package com.shashi.taskmanager.service;

import com.shashi.taskmanager.dto.CreateTaskRequest;
import com.shashi.taskmanager.dto.TaskResponse;
import com.shashi.taskmanager.entity.Task;
import com.shashi.taskmanager.enums.TaskPriority;
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

    /* create and save task
    public void save(Task task){
        taskRepository.save(task);
    } */

    // Create a task using the request DTO
    public TaskResponse createTask(CreateTaskRequest request){
        // Convert DTO into entity
        Task task = new Task();

        task.setTitle(request.title());

        task.setDescription(request.description());

        task.setPriority(
                request.taskPriority() != null
                        ? request.taskPriority()
                        : TaskPriority.MEDIUM
        );

        task.setDueDate(request.dueDate());

        // Status remains TODO by default
        // createdAt is set by the entity's @PrePersist method

        Task savedTask = taskRepository.save(task);

        // Convert saved entity into response DTO
        return toResponse(savedTask);
    }

    /* retrieve all tasks
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    } */

    // get all tasks
    public List<TaskResponse> getAllTasks(){
        return taskRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    /* Retrieve a task by id
    public Task getById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
    } */

    // Retrieve one task by Id
    public TaskResponse getTaskById(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Task not Found with Id " + id));

        return toResponse(task);
    }

    // Delete a task by ID
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    // Convert Task entity into TaskResponse DTO
    private TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getDueDate(),
                task.getCreatedAt()
        );
    }


}
