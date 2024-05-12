package com.example.EjercicioTestMoquitoJUnit;

public interface NotificadorCliente {
    void enviar (String direccion, String mensaje);

    void logWarning(String mensaje);
}
