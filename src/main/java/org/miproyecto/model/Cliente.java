package org.miproyecto.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

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

    @Id
    @Column(name = "identificacion", length = 20, nullable = false, unique = true)
    private String identificacion;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "numero_cuenta", length = 30, nullable = false, unique = true)
    private String numeroCuenta;

    @Column(name = "tipo_cuenta", length = 20, nullable = false)
    private String tipoCuenta;

    @Column(name = "saldo", precision = 15, scale = 2, nullable = false)
    private BigDecimal saldo = BigDecimal.ZERO;

    @Column(name = "estado_cuenta", length = 20, nullable = false)
    private String estadoCuenta;

    @Column(name = "numero_cliente", length = 255, nullable = false)
    private String numeroCliente;



}
