package org.miproyecto.controller;

import org.miproyecto.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Controlador encargado de gestionar las solicitudes HTTP relacionadas con
 * la obtención de información de clientes y empleados. Proporciona dos
 * endpoints para acceder a los datos específicos de un cliente o empleado
 * por su código.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@RestController
@RequestMapping("/api") // Define la ruta base para todos los métodos en este controlador
@CrossOrigin(origins = "http://localhost:4200") // Habilita solicitudes CORS
public class InfoController {

    // Inyección de dependencia del servicio que gestiona la lógica de negocio
    // para obtener la información de los clientes y empleados
    @Autowired
    private InfoService infoService;

    /**
     * Método que maneja las solicitudes GET para obtener la información de
     * un cliente. Se valida que el código proporcionado tenga exactamente
     * 9 dígitos antes de proceder con la consulta.
     *
     * @param identificacion Código único del cliente (debe tener exactamente 9 dígitos)
     * @return ResponseEntity con el resultado de la solicitud, ya sea un
     *         mensaje de error o la información solicitada.
     */
    @GetMapping("/cliente/{identificacion}")
    public ResponseEntity<?> getClienteInfo(@PathVariable String identificacion) {
        // Validación de que el código del cliente tenga exactamente 9 dígitos

        // Si la validación es exitosa, se obtiene la información del cliente a
        // través del servicio
        try {
            return ResponseEntity.ok(infoService.getClienteInfo(identificacion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente ccnffo encontrado.");
        }
    }

}
