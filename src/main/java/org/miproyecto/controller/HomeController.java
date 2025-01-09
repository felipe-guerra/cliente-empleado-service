package org.miproyecto.controller;

/**
 * Controlador principal para gestionar las solicitudes HTTP.
 * Este controlador maneja las peticiones a la raíz del sistema y
 * responde con un mensaje de bienvenida.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /**
     * Método que maneja las solicitudes GET a la raíz del sistema ("/").
     * Retorna un mensaje de bienvenida al sistema bancario.
     *
     * @return Un mensaje de bienvenida.
     */
    @GetMapping("/")
    public String home() {
        // Retorna el mensaje de bienvenida cuando se accede a la raíz
        return "Bienvenido al sistema bancario";
    }
}
