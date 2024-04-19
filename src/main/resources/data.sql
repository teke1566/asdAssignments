INSERT INTO users (email, name, password)
VALUES ('admin@gmail.com', 'Dentist', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (email, name, password)
VALUES ('source@gmail.com', 'abe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (email, name, password)
VALUES ('foo@gmail.com', 'Mtek', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
--123
INSERT INTO role (role)
VALUES ('OFFICE_MANAGER');
INSERT INTO role (role)
VALUES ('PATIENT');
INSERT INTO role (role)
VALUES ('DENTIST');


INSERT INTO users_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO users_role (user_id, role_id)
VALUES (2, 2);
INSERT INTO users_role (user_id, role_id)
VALUES (3, 3);



-- Insert dummy data into Address table
INSERT INTO Address (street, city, state, zip_code) VALUES
                                                        ('123 Main St', 'Cityville', 'Stateville', '12345'),
                                                        ('456 Elm St', 'Townville', 'Stateville', '54321'),
                                                        ('789 Oak St', 'Villageville', 'Stateville', '98765');



-- Insert dummy data into Dentist table
INSERT INTO Dentist (first_name, last_name, email, specialization) VALUES
                                                                       ('John', 'Doe', 'john@example.com', 'General Dentistry'),
                                                                       ('Jane', 'Smith', 'jane@example.com', 'Orthodontics'),
                                                                       ('Michael', 'Johnson', 'michael@example.com', 'Pediatric Dentistry');

-- Insert dummy data into Patient table
INSERT INTO Patient (first_name, last_name, email, date_of_birth,address_id) VALUES
                                                                      ('Alice', 'Johnson', 'alice@example.com', '1990-05-15',1),
                                                                      ('Bob', 'Smith', 'bob@example.com', '1985-10-20',2),
                                                                      ('Charlie', 'Brown', 'charlie@example.com', '1978-03-28',3);



-- Insert dummy data into Surgery table
INSERT INTO Surgery (name, address_id) VALUES
                                           ('General Surgery', 1),
                                           ('Orthopedic Surgery', 2),
                                           ('Cardiothoracic Surgery', 3);
INSERT INTO Appointment (appointment_date, appointment_time, status, surgery_id, patient_id, dentist_id)
VALUES
    ('2024-04-12', '2024-04-12 10:08:05'::timestamp, 'COMPLETED', 1, 1, 1),
    ('2024-04-13', '2024-04-13 11:02:09'::timestamp, 'SCHEDULED', 2, 2, 2),
    ('2024-04-14', '2024-04-14 12:03:08'::timestamp, 'CANCELLED', 3, 3, 3);

