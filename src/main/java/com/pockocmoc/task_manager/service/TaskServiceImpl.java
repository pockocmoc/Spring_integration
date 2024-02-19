package com.pockocmoc.task_manager.service;

import com.pockocmoc.task_manager.model.Task;
import com.pockocmoc.task_manager.model.TaskStatus;
import com.pockocmoc.task_manager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Реализация сервиса для работы с задачами.
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    /**
     * Получить все задачи.
     *
     * @return список задач
     */
    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Создать новую задачу.
     *
     * @param task детали задачи
     * @return созданная задача
     */
    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    /**
     * Получить задачи по статусу.
     *
     * @param status статус задачи
     * @return список задач с указанным статусом
     */
    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Обновить статус задачи.
     *
     * @param id          идентификатор задачи
     * @param taskDetails детали задачи для обновления
     * @return обновленная задача
     */
    @Override
    public Task updateTaskStatus(Long id, Task taskDetails) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(taskDetails.getStatus());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * Удалить задачу.
     *
     * @param id идентификатор задачи
     */
    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
