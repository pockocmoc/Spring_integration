package com.pockocmoc.task_manager.service;

import com.pockocmoc.task_manager.model.Task;
import com.pockocmoc.task_manager.model.TaskStatus;

import java.util.List;

/**
 * Сервис для работы с задачами.
 */
public interface TaskService {

    /**
     * Получить все задачи.
     *
     * @return список задач
     */
    List<Task> getAllTasks();

    /**
     * Создать новую задачу.
     *
     * @param task детали задачи
     * @return созданная задача
     */
    Task createTask(Task task);

    /**
     * Получить задачи по статусу.
     *
     * @param status статус задачи
     * @return список задач с указанным статусом
     */
    List<Task> getTasksByStatus(TaskStatus status);

    /**
     * Обновить статус задачи.
     *
     * @param id          идентификатор задачи
     * @param taskDetails детали задачи для обновления
     * @return обновленная задача
     */
    Task updateTaskStatus(Long id, Task taskDetails);

    /**
     * Удалить задачу.
     *
     * @param id идентификатор задачи
     */
    void deleteTask(Long id);
}
