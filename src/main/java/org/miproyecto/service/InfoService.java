package org.miproyecto.service;

import org.miproyecto.model.Cliente;
import org.miproyecto.repository.ClienteRepository;
import org.miproyecto.util.CifradoAESUtil;
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

    /**
     * Método que obtiene la información de un cliente por su código.
     * Si no se encuentra, lanza una excepción.
     *
     * @param identificacion Código del cliente
     * @return Cliente con la información solicitada
     */
    public Cliente getClienteInfo(String identificacion) throws Exception {
        // Busca al cliente en el repositorio por su código

            Cliente cliente = clienteRepository.findById(identificacion)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

            String clave = "1234567890abcdef"; // 16 caracteres
            String textoOriginal = cliente.getNumeroCliente();

            String cifrado = CifradoAESUtil.cifrar(textoOriginal, clave);
            System.out.println("Texto cifrado: " + cifrado);

            cliente.setNumeroCliente(cifrado);
            return cliente;

    }

}
