# TallerSupaBase

En cada modelo con una relación fue necesario utilizar la etiqueta
@JsonIgnore esta etiqueta permite ignorar el parametro sobre el que se coloca
lo que permite manejar las peticiones de manera correcta y mantener 
parámetros únicamente para el control de la relación con otra tabla.

Para asegurar que las peticiones funcionen correctamente y conservar
las relaciones entre tablas fue necesario crear variables nuevas en los 
modelos que tienen la relación @ManyToOne, puesto que solo se necesita
el id como llave foránea, la variable nueva se usa para la creación y
actualización mientras que el objeto que referencia se usa para 
la lectura, por eso se usa de la siguiente forma @JoinColumn(name = "id_propietario", 
insertable = false, updatable = false), de esta forma la etiqueta
hace que el parametro solo se use para lectura.

Tanto el parámetro que se usa para el id como el que hace referencia al
modelo apuntan a la misma columna

Query de propietario específico con visitantes relacionados.
El query apunta al modelo propietario y se usa JOIN para apuntar
al objeto visitantes.

@Query("SELECT p, v FROM Propietario p JOIN p.visitantes v WHERE p.idPropietario = :id")
List<Object[]> buscarPropietarioVisitantes(@Param("id") Long id);

Query de propietario específico con reservas de parqueadero relacionadas.
El query apunta al modelo propietario y se usa JOIN para apuntar
al objeto reservaParqueaderos.

@Query("SELECT p, r FROM Propietario p JOIN p.reservaParqueaderos r WHERE p.idPropietario = :id")
List<Object[]> buscarPropietarioParqueadero(@Param("id") Long id);

Query de propietario específico con reserva zonas relacionadas.
El query apunta al modelo Propietario y se usa JOIN para apuntar
al objeto reservaZonas.

@Query("SELECT p, z FROM Propietario p JOIN p.reservaZonas z WHERE p.idPropietario = :id")
List<Object[]> buscarPropietarioZona(@Param("id") Long id);

Query de propietario específico con visitantes y reservas de parqueadero 
relacionados.
El query apunta al modelo propietario y se usa JOIN para apuntar
al objeto visitantes además del objeto reservaParqueaderos.

@Query("SELECT p, v, z FROM Propietario p JOIN p.visitantes v JOIN p.reservaParqueaderos z WHERE p.idPropietario = :id")
List<Object[]> buscarPropietarioParqueaderoZona(@Param("id") Long id);

Query inserción de registros:

Propoietario:

insert into
propietario (nombre, cedula, fecha_visita, hora_entrada)
values
('miguel', '354135', '2025-05-02', '12:00');

insert into
propietario (nombre, cedula, fecha_visita, hora_entrada)
values
('Jose', '68435133', '2025-05-02', '10:00');

insert into
propietario (nombre, cedula, fecha_visita, hora_entrada)
values
('Maria', '4789413', '2025-05-02', '11:00');

insert into
propietario (nombre, cedula, fecha_visita, hora_entrada)
values
('Camilo', '354968', '2025-05-02', '14:00');

insert into
propietario (nombre, cedula, fecha_visita, hora_entrada)
values
('Sofia', '984351', '2025-05-02', '5:00');

Visitante:

insert into
visitante (nombre, cedula, correo, telefono, id_propietario)
values
('Samuel', '354351', 'samuel@correo.com', '3212134561', '1');

insert into
visitante (nombre, cedula, correo, telefono, id_propietario)
values
('Francisco', '354351', 'francisco@correo.com', '3212134548', '2');

insert into
visitante (nombre, cedula, correo, telefono, id_propietario)
values
('Sara', '354351', 'sara@correo.com', '3212121561', '3');

insert into
visitante (nombre, cedula, correo, telefono, id_propietario)
values
('Camila', '354351', 'camila@correo.com', '3213234561', '4');

insert into
visitante (nombre, cedula, correo, telefono, id_propietario)
values
('sandra', '354351', 'sandra@correo.com', '3212156641', '5');

ZonaSocial:

insert into
zona_social (nombre, capacidad, ubicacion)
values
('zonaSocial_1', '20', 'ubicacion 1');

insert into
zona_social (nombre, capacidad, ubicacion)
values
('zonaSocial_2', '50', 'ubicacion 2');

insert into
zona_social (nombre, capacidad, ubicacion)
values
('zonaSocial_3', '30', 'ubicacion 3');

insert into
zona_social (nombre, capacidad, ubicacion)
values
('zonaSocial_4', '15', 'ubicacion 4');

insert into
zona_social (nombre, capacidad, ubicacion)
values
('zonaSocial_5', '25', 'ubicacion 5');

ReservaZona:

insert into
reserva_zona (fecha, hora_inicio, id_propietario, id_zona)
values
('2025-05-1', '10:00', '1', '1');

insert into
reserva_zona (fecha, hora_inicio, id_propietario, id_zona)
values
('2025-05-1', '15:00', '2', '2');

insert into
reserva_zona (fecha, hora_inicio, id_propietario, id_zona)
values
('2025-05-12', '18:00', '3', '3');

insert into
reserva_zona (fecha, hora_inicio, id_propietario, id_zona)
values
('2025-05-4', '2:00', '4', '4');

insert into
reserva_zona (fecha, hora_inicio, id_propietario, id_zona)
values
('2025-05-5', '8:00', '5', '5');

ReservaParqueadero:

insert into
reserva_parqueadero (fecha, hora_inicio, id_propietario)
values
('2025-05-5', '3:00', '1');

insert into
reserva_parqueadero (fecha, hora_inicio, id_propietario)
values
('2025-05-8', '16:00', '2');

insert into
reserva_parqueadero (fecha, hora_inicio, id_propietario)
values
('2025-05-4', '15:00', '3');

insert into
reserva_parqueadero (fecha, hora_inicio, id_propietario)
values
('2025-05-12', '12:00', '4');

insert into
reserva_parqueadero (fecha, hora_inicio, id_propietario)
values
('2025-05-3', '10:00', '5');