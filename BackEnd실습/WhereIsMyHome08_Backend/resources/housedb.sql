create table userinfo
(
	userid varchar(20) primary key,
	password varchar(20) not null,
	name varchar(50) not null,
	address varchar(100) not null,
	phone varchar(30) not null
);