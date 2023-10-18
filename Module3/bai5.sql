CREATE DATABASE DemoDatabase;
USE DemoDatabase;

CREATE TABLE Products (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    productCode VARCHAR(10) NOT NULL,
    productName VARCHAR(50) NOT NULL,
    productPrice DECIMAL(10, 2) NOT NULL,
    productAmount INT NOT NULL,
    productDescription TEXT,
    productStatus BOOLEAN
);

INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
VALUES
    ('P001', 'Product 1', 10.99, 100, 'Description 1', 1),
    ('P002', 'Product 2', 19.99, 50, 'Description 2', 1),
    ('P003', 'Product 3', 5.99, 200, 'Description 3', 0);
    
-- Tạo Unique Index trên cột productCode
CREATE UNIQUE INDEX idx_productCode ON Products(productCode);

-- Tạo Composite Index trên cột productName và productPrice
CREATE INDEX idx_productNamePrice ON Products(productName, productPrice);

EXPLAIN SELECT * FROM Products WHERE productName = 'Product 1';

-- Tạo view để lấy các thông tin cần thiết
CREATE VIEW ProductView AS
SELECT productCode, productName, productPrice, productStatus
FROM Products;

-- Sửa đổi view (chẳng hạn, thêm một cột mới)
ALTER VIEW ProductView AS
SELECT productCode, productName, productPrice, productStatus, productAmount
FROM Products;

-- Xoá view
DROP VIEW ProductView;

-- Tạo store procedure để lấy tất cả thông tin sản phẩm
DELIMITER //
CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT * FROM Products;
END;
//
DELIMITER ;

-- Tạo store procedure để thêm sản phẩm mới
DELIMITER //
CREATE PROCEDURE AddNewProduct(IN code VARCHAR(10), IN name VARCHAR(50), IN price DECIMAL(10, 2), IN amount INT, IN description TEXT, IN status BOOLEAN)
BEGIN
    INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES (code, name, price, amount, description, status);
END;
//
DELIMITER ;

-- Tạo store procedure để sửa thông tin sản phẩm theo ID
DELIMITER //
CREATE PROCEDURE UpdateProductById(IN product_id INT, IN new_price DECIMAL(10, 2))
BEGIN
    UPDATE Products
    SET productPrice = new_price
    WHERE Id = product_id;
END;
//
DELIMITER ;

-- Tạo store procedure để xoá sản phẩm theo ID
DELIMITER //
CREATE PROCEDURE DeleteProductById(IN product_id INT)
BEGIN
    DELETE FROM Products WHERE Id = product_id;
END;
//
DELIMITER ;

