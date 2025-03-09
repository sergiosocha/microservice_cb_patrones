package com.notifier.patrones_A;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacion")
public class TwilioController {

    @PostMapping
    public String recibirNotificacion(@RequestBody NotificacionRequest notificacion) {
        System.out.println("Twilio recibió: " + notificacion.getMensaje());
        return "Twilio";
    }
}
