CREATE TABLE ItemComer(
    id integer primary key,
    nome varchar(40),
    valor float,
    ingrediente varchar(100),
    tipo int
);


CREATE TABLE funcionario(
    CPF integer primary key,
    nome varchar(80),
    cargo varchar(60),
    salario float
);

CREATE TABLE gerente(
    CPF integer primary key,
    cargo varchar(7),
    salario float,
    senha varchar(10)
);

CREATE TABLE itempedido(
    id_pedido integer primary key,
    quantidade int,
    item varchar(200)
);


CREATE TABLE mesas(
    id_mesa integer primary key,
    id_pedido int not null,
    foreign key(id_pedido) references itempedido(id_pedido)
)