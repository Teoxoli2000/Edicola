drop TABLE IF EXISTS coupon_product;
drop TABLE IF EXISTS circulation_coupons;
drop TABLE IF EXISTS supplies;
drop TABLE IF EXISTS shoppingcarts;
drop TABLE IF EXISTS inventory;
drop TABLE IF EXISTS products;
drop TABLE IF EXISTS storages;
drop TABLE IF EXISTS accounting;
drop TABLE IF EXISTS members;
drop TABLE IF EXISTS coupons;
drop TABLE IF EXISTS suppliers;
drop TABLE IF EXISTS coupons;

CREATE TABLE  suppliers (
	supplier_id int NOT NULL,
    phone_number bigint,
    
	street_name varchar(50),
	street_address varchar(50),
    city varchar(50),
    state varchar(50),
	zipCode varchar(50),
    
    PRIMARY KEY (supplier_id)
);

CREATE TABLE accounting (
	payment_id int NOT NULL,
    date_time datetime,
    type_accounting varchar(50),
    
    PRIMARY KEY (payment_id)
);

CREATE TABLE products (
	product_id int NOT NULL, 
    name_product varchar(100), 
    prize double,
    publication date,
	periodicity varchar(50),
    
    PRIMARY KEY (product_id)
);


CREATE TABLE storages (
	storage_id varchar(50), 
    priority int, 
    
    PRIMARY KEY (storage_id)
);

CREATE TABLE inventory (
	storage_id varchar(50), 
    product_id int NOT NULL, 
    quantity int,
    
    PRIMARY KEY (storage_id, product_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (storage_id) REFERENCES storages(storage_id)
);

CREATE TABLE shoppingcarts (
	payment_id int NOT NULL, 
    product_id int NOT NULL, 
    quantity int,
    
    PRIMARY KEY (payment_id, product_id),
	FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (payment_id) REFERENCES accounting(payment_id)
);

CREATE TABLE supplies(
	product_id int NOT NULL,
    supplier_id int NOT NULL,
    
	PRIMARY KEY (supplier_id, product_id),
	FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
);

CREATE TABLE members (
	member_id int NOT NULL,
    name_member varchar(50),
    email varchar(50),
    
    PRIMARY KEY (member_id)
);


 # coupons che ho nel sistema
CREATE TABLE coupons (
	coupon_id int NOT NULL,
	expire_coupon date,
    begin_coupon date,
    discount double,
    description_coupon varchar(200), 
    
    PRIMARY KEY (coupon_id)
);

CREATE TABLE circulation_coupons ( 
	coupon_code varchar(10),
    coupon_id int NOT NULL,

    PRIMARY KEY (coupon_code),
    FOREIGN KEY (coupon_id) REFERENCES coupons(coupon_id)
);

CREATE TABLE coupon_product( 
	coupon_id int NOT NULL,
	product_id int NOT NULL,

    PRIMARY KEY (coupon_id, product_id),
    FOREIGN KEY (coupon_id) REFERENCES coupons(coupon_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);




