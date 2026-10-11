package com.shashi.taskmanager.dto;

import com.shashi.taskmanager.enums.TaskPriority;
import com.shashi.taskmanager.enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        LocalDate dueDate,
        LocalDateTime createdAt
) {
}