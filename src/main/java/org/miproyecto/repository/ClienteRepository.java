package org.miproyecto.repository;

import org.miproyecto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que define el repositorio para la entidad Cliente.
 * Extiende de JpaRepository para proporcionar métodos CRUD básicos.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@Repository // Indica que esta interfaz es un repositorio de Spring
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    // No es necesario agregar métodos aquí, JpaRepository ya proporciona
    // métodos básicos como save(), findById(), deleteById(), etc.
}
