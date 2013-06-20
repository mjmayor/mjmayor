create database mjmayor4;
use mjmayor4;

create table alumno(
	id int primary key,
	dni varchar(9),
	nombre varchar(20),
	apellidos varchar(30),
	email varchar(30)
);

create table profesor(
	id int primary key,
	nombre varchar(20),
	apellidos varchar(30)
);


create table asignatura(
	id int primary key,
	nombre varchar(30),
	curso int,
	creditos double(2,1),
	id_profesor int,
	
	foreign key(id_profesor)
		references profesor(id)
);


create table matricula(
	id int primary key,
	id_alumno int,
	id_asignatura int,
	
	foreign key(id_alumno)
		references alumno(id),
		
	foreign key(id_asignatura)
		references asignatura(id)
);


insert into alumno values (1,"11111111H", "pepe", "perez", "a@a.com");
insert into alumno values (2,"11111111H", "manuel", "rodriguez", "b@b.com");
insert into alumno values (3,"11111111H", "pedro", "garcia", "c@c.com");

insert into profesor values (1,"juan","lopez");
insert into profesor values (2,"antonio","sanchez");
insert into profesor values (3,"luis","vazquez");

insert into asignatura values (1,"asignatura 1",1,9,1);
insert into asignatura values (2,"asignatura 2",3,7.5,1);
insert into asignatura values (3,"asignatura 3",5,6,2);
