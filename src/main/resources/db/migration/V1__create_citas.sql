CREATE TABLE citas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    paciente VARCHAR(100) NOT NULL,
    doctorId BIGINT NOT NULL,
    estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA') NOT NULL,
    notas VARCHAR(500) NULL
);
INSERT INTO citas (fecha, hora, paciente, doctorId, estado, notas) VALUES
('2025-06-10', '09:30:00', 'Juan Pérez', 1, 'PENDIENTE', 'Revisión general'),
('2025-06-11', '11:00:00', 'María López', 2, 'CONFIRMADA', 'Control de presión arterial'),
('2025-06-12', '14:15:00', 'Carlos Gómez', 3, 'CANCELADA', 'Paciente no disponible'),
('2025-06-13', '16:00:00', 'Ana Torres', 4, 'PENDIENTE','Consulta de seguimiento.'),
('2025-06-14', '10:45:00', 'Luis Ramírez', 5, 'CONFIRMADA', 'Requiere análisis de sangre');
