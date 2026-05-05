create table Funcionarios(
  re int,
  nomevarchar(100),
  salario decimal(15,2),
  dataAdmissao date,
  primary key(re)
);

create table Alunos(
  ra int,
  nome varchar(100),
  dataNascimento date,
  renda decimal(15,2),
  primary key(ra));
  
create table USERS(
  username varchar(100),
  password varchar(200),
  enabled varchar(100),
  primary key(username));
  
create table AUTHORITIES(
  username varchar(100),
  authority varchar(200));
