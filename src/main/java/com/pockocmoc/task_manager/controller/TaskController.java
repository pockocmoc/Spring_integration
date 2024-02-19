package com.pockocmoc.task_manager.controller;

import com.pockocmoc.task_manager.model.Task;
import com.pockocmoc.task_manager.model.TaskStatus;
import com.pockocmoc.task_manager.service.FileGateway;
import com.pockocmoc.task_manager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final FileGateway fileGateway;

    /**
     * Получает все задачи.
     *
     * @return список всех задач
     */
    @GetMapping()
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    /**
     * Добавляет новую задачу.
     *
     * @param task новая задача
     * @return созданная задача
     */
    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        task.setCreationTime(LocalDateTime.now());
        fileGateway.writeToFile(task.getDescription() + ".txt", task.toString());
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    /**
     * Получает задачи по указанному статусу.
     *
     * @param status статус задачи
     * @return список задач с указанным статусом
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status) {
        return new ResponseEntity<>(taskService.getTasksByStatus(status), HttpStatus.OK);
    }

    /**
     * Обновляет статус задачи.
     *
     * @param id          идентификатор задачи
     * @param taskDetails детали задачи для обновления
     * @return обновленная задача
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable(value = "id") Long id, @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTaskStatus(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    /**
     * Удаляет задачу по указанному идентификатору.
     *
     * @param id идентификатор задачи
     * @return успешный статус ответа
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

}
