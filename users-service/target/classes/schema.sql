drop table if exists users
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table users (id bigint not null, userid varchar(100) not null, name varchar(100), primary key(id))