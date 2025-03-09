package com.notifier.patrones_cliente;

import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class FileLoggerService {

    private static final String LOG_FILE = "logs/notificaciones.log";

    public void log(String serviceName, LocalDateTime startTime) {
        LocalDateTime endTime = LocalDateTime.now();

        long duration = Duration.between(startTime, endTime).toMillis();

        String logMessage = String.format("%s - Respuesta de: %s | Tiempo de respuesta: %d ms",
                endTime, serviceName, duration);

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}