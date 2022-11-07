create database candy;

use candy;



create table product(
					product_id int primary key,
                    product_name varchar(255),
					product_price decimal,
                    product_quantity int
                    );

select * from product;


create table if not exists users(
username varchar(30) not null,
password char(30) not null,
email varchar(255) not null,
userID int,
primary key(userID),
unique(username)
);            

select * from user;
            



create table orders(
					order_id int primary key,
                    order_date date,
				   product_id int,
                   user_id int,
                   product_quantity int,
                   foreign key(user_id) references user(userID),
                   foreign key(product_id) references product(product_id)
                   );
                  

select * from orders;

                    
                    
                    






