
    CREATE TABLE IF NOT EXISTS department (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255));


    CREATE TABLE IF NOT EXISTS employee (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        first_name VARCHAR(255),
        last_name VARCHAR(255),
        position VARCHAR(255),
        salary INT,
        department_id BIGINT,
        FOREIGN KEY (department_id) REFERENCES department(id));


