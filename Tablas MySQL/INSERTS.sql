USE sgtb;

INSERT INTO administrador (nombre, apellido, email) VALUES 
('Juan', 'González', 'juan.gonzalez@gmail.com'), ('María', 'Pérez', 'maria.perez@gmail.com'),  ('Carlos', 'Lopez', 'carlos.lopez@gmail.com'),
('Lucía', 'Martinez', 'lucia.martinez@gmail.com');

INSERT INTO jugador (nombre, apellido, edad, email, puntaje) VALUES 
('Pedro', 'Ramirez', 30, 'pedro.ramirez@gmail.com', 150), ('Ana', 'Fernandez', 25, 'ana.fernandez@gmail.com', 200), ('Luis', 'Garcia', 28, 'luis.garcia@gmail.com', 180),
('Sofia', 'Martinez', 22, 'sofia.martinez@gmail.com', 170), ('Jorge', 'Lopez', 35, 'jorge.lopez@gmailv.com', 160), ('Carla', 'Gomez', 27, 'carla.gomez@gmail.com', 190),
('Diego', 'Alvarez', 29, 'diego.alvarez@gmail.com', 210), ('Laura', 'Sanchez', 26, 'laura.sanchez@gmail.com', 140);

INSERT INTO ranking (jugador, puntos) VALUES 
(1, 150), (2, 200), (3, 180), (4, 170), (5, 160), (6, 190),  (7, 210), (8, 140); 

INSERT INTO torneo (nombre, fecha, estado) -- Estado 1 = activo -- Estado 0 = inactivo
VALUES 
('Torneo de Primavera', '2024-09-21 10:00:00', 1), ('Torneo de Verano', '2024-12-21 15:00:00', 0),   ('Torneo Anual', '2024-01-01 09:30:00', 1);      

INSERT INTO partido (jugador1, jugador2, fecha, resultado, administrador, torneo) VALUES
(1, 2, '2024-10-10 10:00:00', '3-1', 1, 1), -- Pedro vs Ana, Administrador Juan, Torneo de Primavera
(3, 4, '2024-10-10 11:00:00', '2-3', 1, 1), -- Luis vs Sofia, Administrador Juan, Torneo de Primavera
(5, 6, '2024-10-10 12:00:00', '1-3', 2, 1), -- Jorge vs Carla, Administradora María, Torneo de Primavera
(7, 8, '2024-10-10 13:00:00', '3-0', 2, 1), -- Diego vs Laura, Administradora María, Torneo de Primavera
(1, 3, '2024-11-15 10:00:00', '3-2', 3, 2), -- Pedro vs Luis, Administrador Carlos, Torneo de Verano
(4, 5, '2024-11-15 11:00:00', '1-3', 3, 2), -- Sofia vs Jorge, Administrador Carlos, Torneo de Verano
(6, 7, '2024-11-15 12:00:00', '3-1', 4, 2), -- Carla vs Diego, Administradora Lucía, Torneo de Verano
(8, 2, '2024-11-15 13:00:00', '2-3', 4, 2), -- Laura vs Ana, Administradora Lucía, Torneo de Verano
(1, 4, '2024-12-20 10:00:00', '3-0', 1, 3), -- Pedro vs Sofia, Administrador Juan, Torneo Anual
(5, 8, '2024-12-20 11:00:00', '2-3', 2, 3); -- Jorge vs Laura, Administradora María, Torneo Anual
