package com.notifier.patrones_B;

public class NotificacionRequest {
    private String mensaje;

    public NotificacionRequest() {}

    public NotificacionRequest(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}