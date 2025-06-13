-- Insertar usuarios
INSERT INTO users (name, email, phone, is_admin, register_date)
VALUES
  ('Daniela Santa Cruz', 'ds@example.com', '70000001', false, NOW()),
  ('Juan Pablo Gonzales', 'jp@example.com', '70000002', true, NOW()),
  ('Rodrigo Baldiviezo', 'rb@example.com', '70000001', false, NOW());

-- Insertar espacios
INSERT INTO spaces (name, description, capacity, type, is_active)
VALUES
  ('Sala de Reuniones A', 'Sala para reuniones de hasta 10 personas.', 10, 'AUDITORIO', true),
  ('Coworking B', 'Espacio abierto para trabajo colaborativo.', 20, 'CANCHA', true);

-- Insertar reservas (bookings)
INSERT INTO bookings (start_time, end_time, observaciones, booking_status, creation_date, user_id, space_id)
VALUES
  ('2025-06-14 10:00:00', '2025-06-14 12:00:00', 'Primera reunión del día', 'CONFIRMADA', NOW(), 1, 1),
  ('2025-06-15 14:00:00', '2025-06-15 16:00:00', 'Sesión de trabajo en grupo', 'PENDIENTE', NOW(), 2, 2);

-- Insertar notificaciones
INSERT INTO notifications (recipient_email, subject, message, sent_at, is_success, user_id, space_id, booking_id)
VALUES
  ('juan@example.com', 'Confirmación de reserva', 'Tu reserva ha sido confirmada.', NOW(), true, 1, 1, 1),
  ('ana@example.com', 'Reserva pendiente', 'Tu reserva está pendiente de aprobación.', NOW(), true, 2, 2, 2);