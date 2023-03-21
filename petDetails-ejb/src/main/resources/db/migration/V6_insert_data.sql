INSERT INTO User (id, userName, password) VALUES (1, 'john_doe', 'mysecretpassword');
INSERT INTO User (id, username, password) VALUES (2, 'johnDoe', 'password123');

INSERT INTO Owner (id, ownerName, telephoneNumber) VALUES (1, 'Jane Doe', '555-1234');
INSERT INTO Owner (id, ownerName, telephoneNumber) VALUES (2, 'Test Doe', '555-65432');

INSERT INTO vaccine (id, vaccineName) VALUES (1, 'Rabies');
INSERT INTO vaccine (id, vaccineName) VALUES (2, 'Distemper');
INSERT INTO vaccine (id, vaccineName) VALUES (3, 'Parvovirus');

INSERT INTO Pet (id, petName, petAge, lastVaccineDate, owner_id) VALUES (1, 'Fluffy', 3, '2022-01-01', 1);
INSERT INTO Pet (id, petName, petAge, lastVaccineDate, owner_id) VALUES (2, 'Max', 4, '2022-02-15', 2);
INSERT INTO Pet (id, petName, petAge, lastVaccineDate, owner_id) VALUES (3, 'Buddy', 5, '2022-03-10', 1);
