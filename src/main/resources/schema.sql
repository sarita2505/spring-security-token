--for mysql
create table users(
	username varchar(50) not null primary key,
	password varchar(200) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(200) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

--for inmemory
--create table users(
--	username varchar_ignorecase(50) not null primary key,
--	password varchar_ignorecase(50) not null,
--	enabled boolean not null
--);
--
--create table authorities (
--	username varchar_ignorecase(50) not null,
--	authority varchar_ignorecase(50) not null,
--	constraint fk_authorities_users foreign key(username) references users(username)
--);

create unique index ix_auth_username on authorities (username,authority);