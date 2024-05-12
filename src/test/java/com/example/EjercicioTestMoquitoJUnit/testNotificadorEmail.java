package com.example.EjercicioTestMoquitoJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)

public class testNotificadorEmail {

    @Mock
    private NotificadorCliente notificadorClienteMock;

@DisplayName("Primera prueba " + "  Verificar si se llamó a los argumentos correctos." )
    @Test
    public void testNotificar () {
        NotificadorEmail notificador = new NotificadorEmail(notificadorClienteMock);
        notificador.notificar ("ejemplo@test.com", "Hola mundo");

        verify(notificadorClienteMock).enviar("ejemplo@test.com", "Hola mundo");
    }
    @DisplayName("Segunda pruba " + "Verificar que no se envie correo vacío")
    @Test
    public void testNotificarConDireccioVacia () {
        NotificadorEmail notificador = new NotificadorEmail(notificadorClienteMock);
        notificador.notificar("", null);

        verify(notificadorClienteMock, times(0)).enviar(anyString(), anyString());
    }

    @DisplayName("Tercera prueba " + " Verificar el comportamiento con mensaje nulo")
    @Test
    public void testNotificarMensajeNulo () {
        NotificadorEmail notificador = new NotificadorEmail(notificadorClienteMock);
        notificador.notificar("ejemplo@test.com", null);

            verify(notificadorClienteMock, times(0)).enviar(anyString(), anyString());
    }
    @DisplayName("Cuarta prueba " + " Prueba de notificación  para cubrir casos esquina")
    @Test
    public void testNotificarCasoEsquina () {
        NotificadorEmail notiricador = new NotificadorEmail(notificadorClienteMock);
        notiricador.notificar("ejemplo@test.com", null );

        verify(notificadorClienteMock, times(0)).enviar(anyString(), anyString());
    }
@DisplayName("Quinta prueba " + " Cubrir un comportamiento inesperado")
    @Test
    public void testNotificarCasoInesperado () {
        NotificadorEmail notificador = new NotificadorEmail(notificadorClienteMock);
        String mensajeLargo = generarMensajeLargo ();
        notificador.notificar("ejemplo@test.com", mensajeLargo);
    }

    private String generarMensajeLargo() {
        return "Inconvenientes por el tamaño del texto que se desea enviar";
    }
}
