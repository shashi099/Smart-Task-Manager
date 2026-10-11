package com.shashi.taskmanager.dto;

import com.shashi.taskmanager.enums.TaskPriority;
import com.shashi.taskmanager.enums.TaskStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateTaskRequest (
    @NotBlank(message = "Task title is required")
    @Size(max = 150, message = "character must not exceeds length 150")
    String title,
    @Size(max = 2000, message = "Description must not exceed 2000 characters")
    String description,
    LocalDate dueDate,
    TaskPriority taskPriority
){}
