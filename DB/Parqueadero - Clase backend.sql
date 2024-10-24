CREATE TABLE "usuario" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "documento_identificacion" varchar UNIQUE NOT NULL,
  "nombre" varchar NOT NULL,
  "apellido" varchar NOT NULL,
  "contrasena" varchar NOT NULL
);

CREATE TABLE "rol" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "nombre" varchar NOT NULL
);

CREATE TABLE "usuario_rol" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "id_usuario" integer NOT NULL,
  "id_rol" integer NOT NULL,
  FOREIGN KEY ("id_usuario") REFERENCES "usuario"("id"),
  FOREIGN KEY ("id_rol") REFERENCES "rol"("id")
);

CREATE TABLE "vehiculo" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "id_usuario" integer NOT NULL,
  "id_tipo_vehiculo" integer NOT NULL,
  "placa" varchar NOT NULL,
  FOREIGN KEY ("id_usuario") REFERENCES "usuario"("id"),
  FOREIGN KEY ("id_tipo_vehiculo") REFERENCES "tipo_vehiculo"("id")
);

CREATE TABLE "tipo_vehiculo" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "nombre" varchar NOT NULL,
  "tarifa" decimal(10,2) NOT NULL
);

CREATE TABLE "parqueadero" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "id_vehiculo" integer UNIQUE,
  "ubicacion" varchar NOT NULL,
  "disponibilidad" bool,
  FOREIGN KEY ("id_vehiculo") REFERENCES "vehiculo"("id")
);

CREATE TABLE "reserva" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "id_parqueadero" integer NOT NULL,
  "id_vehiculo" integer NOT NULL,
  "hora_entrada" timestamp NOT NULL,
  "estado" varchar,
  FOREIGN KEY ("id_parqueadero") REFERENCES "parqueadero"("id"),
  FOREIGN KEY ("id_vehiculo") REFERENCES "vehiculo"("id")
);

CREATE TABLE "tiquete" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "id_vehiculo" integer NOT NULL,
  "id_parqueadero" integer NOT NULL,
  "hora_entrada" timestamp NOT NULL,
  "hora_salida" timestamp,
  "descuento" decimal(10,2),
  "valor" decimal(10,2),
  FOREIGN KEY ("id_vehiculo") REFERENCES "vehiculo"("id"),
  FOREIGN KEY ("id_parqueadero") REFERENCES "parqueadero"("id")
);

CREATE TABLE "factura" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "valor" decimal(10,2) NOT NULL
);

INSERT INTO "usuario" ("documento_identificacion", "nombre", "apellido", "contrasena")
VALUES ('1234567890', 'Juan', 'Pérez', 'contraseña123'),
('9876543210', 'Victor', 'Estupinan', 'contraseña321');

INSERT INTO "tipo_vehiculo" ("nombre", "tarifa")
VALUES ('Automóvil', 4000),
('Moto', 2000);

INSERT INTO "vehiculo" ("id_usuario", "id_tipo_vehiculo", "placa")
VALUES (1, 1, 'ABC123'),
(1, 2, 'ABC321'),
(2, 1, 'CBA123'),
(2, 2, 'CBA321');

INSERT INTO "parqueadero" ("id_vehiculo", "ubicacion", "disponibilidad")
VALUES (null, 'Piso 1, Espacio 01', true),
(null, 'Piso 1, Espacio 02', true),
(null, 'Piso 1, Espacio 03', true);