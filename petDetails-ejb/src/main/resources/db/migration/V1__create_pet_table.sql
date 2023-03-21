CREATE TABLE pet (
    id INT NOT NULL AUTO_INCREMENT,
    pet_name VARCHAR(255) NOT NULL,
    pet_age INT,
    last_vaccine_date DATE,
    owner_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_owner_pet FOREIGN KEY (owner_id) REFERENCES owner(id)
);