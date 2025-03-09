package com.notifier.patrones_cliente;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enviar-notificacion")
public class NotificadorController {
    private final NotificadorService notificadorService;

    public NotificadorController(NotificadorService notificadorService) {
        this.notificadorService = notificadorService;
    }

    @PostMapping
    public String enviarNotificacion(@RequestBody NotificacionCliente notificacion) {
        return notificadorService.enviarNotificacion(notificacion);
    }
}