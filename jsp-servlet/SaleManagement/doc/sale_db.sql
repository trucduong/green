create database sale_db;
use sale_db;

CREATE TABLE account (
    code INT IDENTITY(1,1) PRIMARY KEY,
    email NVARCHAR(100) NOT NULL,
	password NVARCHAR(50) NOT NULL,
    full_name NVARCHAR(100) NOT NULL,
	birth_date DATE NOT NULL,
	address NVARCHAR(200) ,
	gender CHAR(1) NOT NULL,
	image NVARCHAR(50),
	active BIT NOT NULL
);

CREATE TABLE category (
    code INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    description NVARCHAR(1000)
);

CREATE TABLE product (
    code INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
	image NVARCHAR(50),
	price BIGINT NOT NULL,
	category_code INT NOT NULL,
	status VARCHAR(10) NOT NULL,
    description NVARCHAR(1000)
);


ALTER TABLE product
ADD CONSTRAINT fk_product_category
FOREIGN KEY (category_code) REFERENCES category(code);
