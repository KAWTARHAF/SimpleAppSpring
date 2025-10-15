DROP TABLE IF EXISTS employees;

-- Création de la table employees
CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    mail VARCHAR(150),
    password VARCHAR(150)
);
