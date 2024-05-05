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

        private TaskDto taskToDtoMapper(Task input) {
                Function<Task, TaskDto> mapper = task -> new TaskDto(
                                task.getId(),
                                task.getText(),
                                task.getDay(),
                                task.getReminder());

                return mapper.apply(input);
        }

        private Task dtoToTaskMapper(TaskDto input) {
                Function<TaskDto, Task> mapper = dto -> Task
                                .builder()
                                .day(dto.day())
                                .text(dto.text())
                                .id(dto.id())
                                .reminder(dto.reminder())
                                .build();

                return mapper.apply(input);

        }

        public List<TaskDto> getAllTask() {
                return taskRepository
                                .findAll()
                                .stream()
                                .map(this::taskToDtoMapper )
                                .collect(Collectors.toList());
        }

        public TaskDto saveTask(NewTaskDto newTask) {
                Task persistTask = new Task();
                persistTask.setDay(newTask.day());
                persistTask.setText(newTask.text());
                persistTask.setReminder(false);
                taskRepository.save(persistTask);
                return taskToDtoMapper(persistTask);
        }

        public Optional<TaskDto> findTaskById(Long id) {
                return taskRepository
                                .findById(id)
                                .map(this::taskToDtoMapper);
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
                                .map(taskDto -> dtoToTaskMapper(updatedTask))
                                .map(taskRepository::save)
                                .map(this::taskToDtoMapper);
        }

}
