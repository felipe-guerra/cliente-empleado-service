package org.miproyecto.service;

import org.miproyecto.model.Cliente;
import org.miproyecto.model.Empleado;
import org.miproyecto.repository.ClienteRepository;
import org.miproyecto.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que gestiona la lógica de negocio para obtener información
 * de clientes y empleados desde los repositorios correspondientes.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@Service // Anotación que indica que esta clase es un servicio gestionado por Spring
public class InfoService {

    // Inyección de dependencias para el repositorio de Cliente
    @Autowired
    private ClienteRepository clienteRepository;

    // Inyección de dependencias para el repositorio de Empleado
    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * Método que obtiene la información de un cliente por su código.
     * Si no se encuentra, lanza una excepción.
     *
     * @param codigo Código del cliente
     * @return Cliente con la información solicitada
     */
    public Cliente getClienteInfo(String codigo) {
        // Busca al cliente en el repositorio por su código
        return clienteRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    /**
     * Método que obtiene la información de un empleado por su código.
     * Si no se encuentra, lanza una excepción.
     *
     * @param codigo Código del empleado
     * @return Empleado con la información solicitada
     */
    public Empleado getEmpleadoInfo(String codigo) {
        // Busca al empleado en el repositorio por su código
        return empleadoRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }
}
