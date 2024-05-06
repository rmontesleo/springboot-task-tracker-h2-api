package com.demo.task.tracker.dto;

import java.util.Objects;

//TODO: Verify who to put a default for reminder value
public record TaskDto(
    Long id, 
    String text, 
    String day, 
    Boolean reminder) {

    
        @Override
        public String text(){
            return Objects.requireNonNullElse(this.text, "");
        }

        @Override
        public String day(){
            return Objects.requireNonNullElse(this.day, "");
        }
        
        
        
}
