create table product(
  id serial primary key,
  name varchar(255) not null,
  amount integer not null default 0
);