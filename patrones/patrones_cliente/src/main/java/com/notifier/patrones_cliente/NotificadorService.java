package com.notifier.patrones_cliente;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Value;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.time.LocalDateTime;

@Service
public class NotificadorService {
    private final RestTemplate restTemplate;
    private final FileLoggerService fileLoggerService;

    private String twilioUrl = "http://localhost:8081/notificacion";
    private String aldeamoUrl = "http://localhost:8082/notificacion";

    public NotificadorService(RestTemplate restTemplate, FileLoggerService fileLoggerService) {
        this.restTemplate = restTemplate;
        this.fileLoggerService = fileLoggerService;
    }


    @CircuitBreaker(name = "notificationService", fallbackMethod = "fallbackTwilio")
    public String enviarNotificacion(NotificacionCliente notificacion) {
        LocalDateTime startTime = LocalDateTime.now(); // Captura tiempo de inicio

        try {
            String response = restTemplate.postForObject(aldeamoUrl, notificacion, String.class);
            fileLoggerService.log("Aldeamo", startTime);
            return response;
        } catch (ResourceAccessException e) {
            return fallbackTwilio(notificacion, e, startTime);
        }


    }

    public String fallbackTwilio(NotificacionCliente notificacion, Throwable t, LocalDateTime startTime) {
        String response = restTemplate.postForObject(twilioUrl, notificacion, String.class);
        fileLoggerService.log("Twilio", startTime);
        return response;
    }

}