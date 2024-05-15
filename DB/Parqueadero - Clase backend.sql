CREATE TABLE usuario (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  correo_electronico VARCHAR(100) UNIQUE NOT NULL,
  nombre_usuario VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE parqueadero (
  id SERIAL PRIMARY KEY,
  disponibilidad BOOLEAN NOT NULL,
  ubicacion VARCHAR(255) NOT NULL
);

CREATE TABLE "tipo_vehiculo" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "nombre" varchar NOT NULL,
  "tarifa" decimal(10,2) NOT NULL
);

CREATE TABLE reserva (
  id SERIAL PRIMARY KEY,
  usuario_id INTEGER NOT NULL REFERENCES usuario(id),
  parqueadero_id INTEGER NOT NULL REFERENCES parqueadero(id),
  tarifa_id INTEGER NOT NULL REFERENCES tarifa(id),
  hora_entrada TIMESTAMP NOT NULL,
  hora_salida TIMESTAMP,
  total DECIMAL(10,2)
)

INSERT INTO usuario (nombre, apellido, correo_electronico, nombre_usuario)
VALUES ('Juan', 'Pérez', 'juan.perez@example.com', 'j_perez'),
('Vale', 'Gilo', 'vale.gilo@example.com', 'v_gilo');

INSERT INTO tarifa (tipo_vehiculo, precio)
VALUES ('Carro', 2000), ('Moto', 1000);

INSERT INTO parqueadero (disponibilidad, ubicacion)
VALUES (TRUE, 'Piso 3, puesto 12');

INSERT INTO reserva (usuario_id, parqueadero_id, tarifa_id, hora_entrada)
VALUES (1, 1, 1, '2024-05-14 15:15:00');
