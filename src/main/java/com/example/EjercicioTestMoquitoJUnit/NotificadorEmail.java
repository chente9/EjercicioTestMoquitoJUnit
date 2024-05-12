package com.example.EjercicioTestMoquitoJUnit;

public class NotificadorEmail {

    private NotificadorCliente notificadorCliente;

    public NotificadorEmail (NotificadorCliente notificadorCliente) {
        this.notificadorCliente = notificadorCliente;

    }

    public void notificar (String direccion, String mensaje) {
        notificadorCliente.enviar (direccion, mensaje);
    }
}
