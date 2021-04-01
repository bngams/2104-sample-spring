CREATE TABLE address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    line1 VARCHAR(255),
    line2 VARCHAR(255),
    city VARCHAR(255),
    zip_code VARCHAR(255),
    country VARCHAR(255),
    contact_id INT
);