package org.miproyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal para arrancar la aplicación Spring Boot.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@SpringBootApplication // Anotación que indica que esta es la clase de configuración de Spring Boot
public class ClienteEmpleadoServiceApplication {

    /**
     * Método principal que se encarga de arrancar la aplicación Spring Boot.
     *
     * @param args Argumentos de línea de comandos pasados a la aplicación
     */
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot
        SpringApplication.run(ClienteEmpleadoServiceApplication.class, args);
    }
}
