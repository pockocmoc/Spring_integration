package com.pockocmoc.task_manager.repository;

import com.pockocmoc.task_manager.model.Task;
import com.pockocmoc.task_manager.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с задачами.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Метод для поиска задач по статусу.
     *
     * @param status статус задачи
     * @return список задач с указанным статусом
     */
    List<Task> findByStatus(TaskStatus status);
}
