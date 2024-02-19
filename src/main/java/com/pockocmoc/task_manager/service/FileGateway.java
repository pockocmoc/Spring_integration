package com.pockocmoc.task_manager.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Интерфейс-шлюз для записи данных в файл.
 */
@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateway {

    /**
     * Метод для записи данных в файл.
     *
     * @param filename имя файла
     * @param data     данные для записи
     */
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);

}