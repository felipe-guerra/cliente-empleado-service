package org.miproyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase que maneja las excepciones globalmente para toda la aplicación.
 * Utiliza un manejo centralizado de errores, proporcionando respuestas
 * adecuadas para las excepciones no controladas.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@RestControllerAdvice // Permite que esta clase maneje las excepciones globalmente
public class GlobalExceptionHandler {

    /**
     * Método que maneja las excepciones de tipo RuntimeException.
     * Devuelve una respuesta con el código de estado HTTP 404 (Not Found)
     * y un mensaje de error en formato JSON.
     *
     * @param ex Excepción capturada de tipo RuntimeException
     * @param request Solicitud HTTP que causó la excepción
     * @return ResponseEntity con el mensaje de error y el estado 404
     */
    @ExceptionHandler(RuntimeException.class) // Captura todas las excepciones RuntimeException
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex, WebRequest request) {
        // Verifica el header "Accept" para determinar el formato de respuesta
        String acceptHeader = request.getHeader("Accept");

        // Respuesta en formato JSON, generando un cuerpo de mensaje con el error
        return ResponseEntity.status(HttpStatus.NOT_FOUND) // Estado HTTP 404
                .body("{\"message\": \"" + ex.getMessage() + "\"}"); // Respuesta en formato JSON
    }
}
