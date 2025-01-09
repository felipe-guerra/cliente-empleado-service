package org.miproyecto.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

/**
 * Clase que representa un empleado en el sistema bancario.
 * Contiene los atributos y las relaciones de la entidad empleado
 * en la base de datos.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@Entity // Indica que esta clase es una entidad JPA
@Data // Genera automáticamente los métodos getter, setter, toString, etc.
@Table(name = "empleado") // Especifica el nombre de la tabla en la base de datos
public class Empleado {

    /**
     * Código único que identifica al empleado. Este campo es la clave primaria
     * de la entidad Empleado en la base de datos.
     */
    @Id // Define este campo como la clave primaria de la entidad
    @Column(length = 9) // Establece que el campo "codigo" tiene una longitud de 9
    private String codigo;

    /**
     * Nombre del empleado. Este campo se almacena como una cadena de texto.
     */
    private String nombre;

    /**
     * Apellido del empleado. Este campo se almacena como una cadena de texto.
     */
    private String apellido;

    /**
     * Edad del empleado, representada como un entero.
     */
    private Integer edad;

    /**
     * Número de cuenta asociado al empleado. Este campo es almacenado
     * en la base de datos como "numero_cuenta".
     */
    @Column(name = "numero_cuenta") // Especifica el nombre de la columna en la base de datos
    private String numeroCuenta;

    /**
     * Cargo del empleado dentro de la organización. Este campo se almacena
     * como una cadena de texto.
     */
    private String cargo;

    /**
     * Relación uno a muchos con la entidad Movimiento. Esta relación indica
     * que un empleado puede tener múltiples movimientos asociados.
     * Se utiliza la anotación JsonManagedReference para indicar que esta es
     * la parte principal de la relación y se evitará la recursión infinita
     * durante la serialización JSON.
     */
    @JsonManagedReference // Se indica que esta es la parte principal de la relación
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movimiento> movimientos; // Lista de movimientos asociados al empleado
}
