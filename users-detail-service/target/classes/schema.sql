drop table if exists user_detail
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table user_detail (id bigint not null, userid varchar(100) not null, phone varchar(100), email varchar(100), primary key(id))
