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