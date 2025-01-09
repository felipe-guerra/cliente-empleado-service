package org.miproyecto.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa un cliente en el sistema bancario.
 * Contiene los atributos y las relaciones de la entidad cliente
 * en la base de datos.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@Entity // Indica que esta clase es una entidad JPA
@Data // Genera automáticamente los métodos getter, setter, toString, etc.
@Table(name = "cliente") // Especifica el nombre de la tabla en la base de datos
public class Cliente {

    /**
     * Código único que identifica al cliente. Este campo es la clave primaria
     * de la entidad Cliente en la base de datos.
     */
    @Id // Define este campo como la clave primaria de la entidad
    @Column(length = 9) // Establece que el campo "codigo" tiene una longitud de 9
    private String codigo;

    /**
     * Nombre del cliente. Este campo se almacena como una cadena de texto.
     */
    private String nombre;

    /**
     * Apellido del cliente. Este campo se almacena como una cadena de texto.
     */
    private String apellido;

    /**
     * Edad del cliente, representada como un entero.
     */
    private Integer edad;

    /**
     * Número de cuenta asociado al cliente. Este campo es almacenado
     * en la base de datos como "numero_cuenta".
     */
    @Column(name = "numero_cuenta") // Especifica el nombre de la columna en la base de datos
    private String numeroCuenta;

    /**
     * Fecha de creación de la cuenta del cliente. Se almacena en la base de datos
     * como "fecha_creacion_cuenta" y se maneja como un objeto LocalDate.
     */
    @Column(name = "fecha_creacion_cuenta") // Especifica el nombre de la columna en la base de datos
    private LocalDate fechaCreacionCuenta;

    /**
     * Relación uno a muchos con la entidad Movimiento. Esta relación indica que
     * un cliente puede tener múltiples movimientos asociados.
     * Se utiliza la anotación JsonManagedReference para indicar que esta es
     * la parte principal de la relación y se evitará la recursión infinita
     * durante la serialización JSON.
     */
    @JsonManagedReference // Se indica que esta es la parte principal de la relación
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movimiento> movimientos; // Lista de movimientos asociados al cliente
}
