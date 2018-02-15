create table if not exists Ingredient (
id varchar(4) not null,
name varchar(25) not null,
type varchar(10) not null
);
create table if not exists Taco (
id identity,
name varchar(50) not null,
createdAt timestamp not null
);
create table if not exists Taco_Ingredients (
taco bigint not null,
ingredient varchar(4) not null
);
alter table Taco_Ingredients
add foreign key (taco) references Taco(id);
alter table Taco_Ingredients
add foreign key (ingredient) references Ingredient(id);
create table if not exists Taco_Order (
id identity,
deliveryName varchar(50) not null,
deliveryStreet varchar(50) not null,
deliveryCity varchar(50) not null,
deliveryState varchar(2) not null,
deliveryZip varchar(10) not null,
ccNumber varchar(16) not null,
ccExpiration varchar(5) not null,
ccCVV varchar(3) not null,
placedAt timestamp not null
);
create table if not exists Taco_Order_Tacos (
tacoOrder bigint not null,
taco bigint not null
);


alter table Taco_Order_Tacos
add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
add foreign key (taco) references Taco(id);

create table if not exists Users (
username varchar(64) not null,
password varchar(64) not null,
enabled boolean
);

create table if not exists authorities (
username varchar(64) not null,
authority varchar(15) not null,
);

create table if not exists groups (
id identity not null,
group_name varchar(64) not null,
authority varchar(15) not null
);

alter table authorities
add foreign key (username) references Users(username);

alter table groups
add foreign key (authority) references authorities(authority);

