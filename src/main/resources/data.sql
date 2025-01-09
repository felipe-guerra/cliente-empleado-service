-- Insertar datos de prueba en cliente
INSERT INTO cliente (codigo, nombre, apellido, edad, numero_cuenta, fecha_creacion_cuenta)
VALUES
    ('001384529', 'Jaimito', 'Pérez', 38, '98583000000', '2020-10-08');

-- Insertar datos de prueba en empleado
INSERT INTO empleado (codigo, nombre, apellido, edad, numero_cuenta, cargo)
VALUES
    ('008283819', 'Luis', 'Mendoza', 31, '13289000000', 'Desarrollador');

-- Insertar datos de prueba en movimiento para el cliente
INSERT INTO movimiento (tipo, monto, descripcion, fecha, cliente_codigo, empleado_codigo)
VALUES
    ('CREDITO', 1500.00, 'Salario', '2025-01-08 10:00:00', '001384529', NULL),
    ('DEBITO', 10.00, 'Compra Online', '2025-01-08 11:00:00', '001384529', NULL),
    ('DEBITO', 12.00, 'Transferencia a otro banco', '2025-01-08 12:00:00', '001384529', NULL),
    ('CREDITO', 80.00, 'Ahorro', '2025-01-08 13:00:00', '001384529', NULL);

-- Insertar datos de prueba en movimiento para el empleado
INSERT INTO movimiento (tipo, monto, descripcion, fecha, cliente_codigo, empleado_codigo)
VALUES
    ('CREDITO', 2000.00, 'Salario', '2025-01-08 10:00:00', NULL, '008283819'),
    ('DEBITO', 200.00, 'Compra Online', '2025-01-08 11:00:00', NULL, '008283819'),
    ('DEBITO', 12.00, 'Transferencia a otro banco', '2025-01-08 12:00:00', NULL, '008283819'),
    ('CREDITO', 80.00, 'Ahorro', '2025-01-08 13:00:00', NULL, '008283819');



