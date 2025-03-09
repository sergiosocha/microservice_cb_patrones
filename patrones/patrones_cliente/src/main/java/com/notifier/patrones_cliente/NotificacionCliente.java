package com.notifier.patrones_cliente;

public class NotificacionCliente {
    private String mensaje;

    public NotificacionCliente() {}

    public NotificacionCliente(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}