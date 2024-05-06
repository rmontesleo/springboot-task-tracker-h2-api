package com.demo.task.tracker.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.task.tracker.dto.NewTaskDto;
import com.demo.task.tracker.dto.TaskDto;
import com.demo.task.tracker.models.Task;
import com.demo.task.tracker.repositories.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {

        private final TaskRepository taskRepository;     

        /*private TaskDto taskToDtoMapper(Task input) {
                Function<Task, TaskDto> mapper = task -> new TaskDto(
                                task.getId(),
                                task.getText(),
                                task.getDay(),
                                task.getReminder());

                return mapper.apply(input);
        }*/

        private static Function<Task, TaskDto> taskToDtoMapper = task -> new TaskDto(
                task.getId(),
                task.getText(),
                task.getDay(),
                task.getReminder());



        /*private Task dtoToTaskMapper(TaskDto input) {
                Function<TaskDto, Task> mapper = dto -> Task
                                .builder()
                                .day(dto.day())
                                .text(dto.text())
                                .id(dto.id())
                                .reminder(dto.reminder())
                                .build();

                return mapper.apply(input);

        }*/

        private static Function<TaskDto, Task>  dtoToTaskMapper = dto -> Task
                                .builder()
                                .day(dto.day())
                                .text(dto.text())
                                .id(dto.id())
                                .reminder(dto.reminder())
                                .build();

        public List<TaskDto> getAllTask() {
                return taskRepository
                                .findAll()
                                .stream()
                                .map(taskToDtoMapper )
                                .collect(Collectors.toList());
        }

        public TaskDto saveTask(NewTaskDto newTask) {
                Task persistTask = new Task();
                persistTask.setDay(newTask.day());
                persistTask.setText(newTask.text());
                persistTask.setReminder(false);
                taskRepository.save(persistTask);
                return taskToDtoMapper.apply(persistTask);
        }

        private Optional<Task> findTaskById(Long id) {
                return taskRepository.findById(id);                                
        }

        public Optional<TaskDto> findTaskDtoById(Long id) {
                return findTaskById(id)
                        .map(taskToDtoMapper);
        }

        public boolean deleteTask(Long id) {
                return findTaskById(id)
                                .map(task -> {
                                        taskRepository.deleteById(id);
                                        return true;
                                })
                                .orElse(false);
        }

        public Optional<TaskDto> updateTask(Long id, TaskDto updatedTask) {
                return findTaskById(id)
                        .map(item ->{
                           Task task = dtoToTaskMapper.apply(updatedTask);    
                           return taskRepository.save( task );     
                        })
                        .map(taskToDtoMapper);

        }
}
