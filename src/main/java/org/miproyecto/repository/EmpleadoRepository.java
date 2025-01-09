package org.miproyecto.repository;

import org.miproyecto.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que define el repositorio para la entidad Empleado.
 * Extiende de JpaRepository para proporcionar métodos CRUD básicos.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@Repository // Anotación que indica que esta interfaz es un repositorio de Spring
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    // Al extender JpaRepository, no es necesario declarar métodos adicionales
    // ya que proporciona implementación automática para operaciones CRUD.
}
