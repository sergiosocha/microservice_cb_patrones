package com.notifier.patrones_B;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacion")
public class AldeamoController {

    @PostMapping
    public String recibirNotificacion(@RequestBody NotificacionRequest notificacion) {
        System.out.println("Aldeamo recibió: " + notificacion.getMensaje());
        return "Aldeamo";
    }
}
