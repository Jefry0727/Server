create table users (
id SERIAL PRIMARY KEY,
username varchar (20) unique,
password varchar (40),
ip varchar (20)

)