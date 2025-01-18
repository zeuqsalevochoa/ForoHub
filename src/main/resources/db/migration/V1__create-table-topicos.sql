create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(400) not null,
    fecha_creacion datetime not null,
    status tinyint not null,
    autor varchar(200) not null,
    curso varchar(200) not null,

    primary key(id)
);