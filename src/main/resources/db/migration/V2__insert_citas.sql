CREATE TABLE doctores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    estado ENUM('ACTIVO', 'INACTIVO') NOT NULL
);
INSERT INTO doctores (nombre, especialidad, estado)
VALUES
('Dr. Juan Pérez', 'Cardiología', 'ACTIVO'),
('Dra. María Torres', 'Dermatología', 'ACTIVO'),
('Dr. Luis Ramírez', 'Neurología', 'INACTIVO'),
('Dra. Sofía González', 'Pediatría', 'ACTIVO'),
('Dr. Ricardo Díaz', 'Oftalmología', 'INACTIVO');
