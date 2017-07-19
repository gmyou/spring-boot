drop database if exists member;
create database member;
use member;
create table member
(
	id BIGINT not null auto_increment,
	username varchar(50) not null,
	password varchar(50) not null,
	account varchar(50) not null,
	primary key (id)
) ENGINE=InnoDB;