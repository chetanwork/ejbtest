CREATE TABLE vaccine (
    id INT NOT NULL AUTO_INCREMENT,
    vaccine_name VARCHAR(255) NOT NULL,
    pet_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_pet_vaccine FOREIGN KEY (pet_id) REFERENCES pets(id)
);