package org.miproyecto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Clase que representa un movimiento bancario. Contiene los atributos
 * y las relaciones de la entidad movimiento en la base de datos.
 *
 * Autor: Felipe Guerra
 * Fecha: 08/01/2025
 */
@Entity // Indica que esta clase es una entidad JPA
@Data // Genera automáticamente los métodos getter, setter, toString, etc.
@Table(name = "movimiento") // Especifica el nombre de la tabla en la base de datos
public class Movimiento {

    /**
     * Identificador único para el movimiento. Es la clave primaria de
     * la entidad Movimiento en la base de datos.
     */
    @Id // Define este campo como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de ID
    private Long id;

    /**
     * Tipo de movimiento (por ejemplo, CREDITO o DEBITO). Este campo
     * es almacenado con una longitud máxima de 10 caracteres.
     */
    @Column(length = 10) // Establece la longitud máxima del campo
    private String tipo;  // CREDITO/DEBITO

    /**
     * Monto del movimiento. Este campo tiene una precisión de 10 dígitos
     * y 2 decimales, representado como un BigDecimal.
     */
    @Column(precision = 10, scale = 2) // Establece la precisión y escala de los decimales
    private BigDecimal monto;

    /**
     * Descripción del movimiento. Este campo es un texto que detalla
     * la razón o información adicional sobre el movimiento.
     */
    private String descripcion;

    /**
     * Fecha y hora en que se realizó el movimiento. Este campo se almacena
     * como un LocalDateTime, lo que permite representar una fecha con hora.
     */
    private LocalDateTime fecha;

    /**
     * Relación muchos a uno con la entidad Cliente. Cada movimiento está
     * asociado a un cliente, y se utiliza JsonBackReference para indicar
     * que esta es la parte inversa de la relación.
     */
    @JsonBackReference // Se indica que esta es la parte inversa de la relación
    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno con carga perezosa
    @JoinColumn(name = "cliente_codigo") // Define la columna que hace referencia a Cliente
    private Cliente cliente;

    /**
     * Relación muchos a uno con la entidad Empleado. Cada movimiento está
     * asociado a un empleado, y se utiliza JsonBackReference para indicar
     * que esta es la parte inversa de la relación.
     */
    @JsonBackReference // Se indica que esta es la parte inversa de la relación
    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno con carga perezosa
    @JoinColumn(name = "empleado_codigo") // Define la columna que hace referencia a Empleado
    private Empleado empleado;
}
