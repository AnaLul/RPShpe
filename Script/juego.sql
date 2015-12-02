spool juego.log
drop user  admi cascade;
drop table Marcadores;
drop table Jugadores;

PROMPT SE CREA EL juez
create user admi identified by admi default tablespace users;
alter user admi quota unlimited on users;

PROMPT DAMOS TODOS LOS PERMISOS SESSION
grant create session to admi;

PROMPT PERMISO DE CREAR TABLAS TO PUBLIC
grant create table to public;

create table Jugadores(nombre varchar(20) not null, estrategia varchar(10),  puntaje number(20), primary key(nombre));
create table Marcadores(nomJugador varchar(20), puntMarcador number, primary key(nomJugador),foreign key(nomJugador) references Jugadores (nombre));
create table Archivo(direccion varchar(100));
spool off;

