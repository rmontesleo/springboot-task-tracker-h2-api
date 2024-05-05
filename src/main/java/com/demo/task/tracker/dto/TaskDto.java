package com.demo.task.tracker.dto;

public record TaskDto(
    Long id, 
    String text, 
    String day, 
    Boolean reminder) {
}
