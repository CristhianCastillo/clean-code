DROP TABLE IF EXISTS inscription;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS course;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL,
  status VARCHAR(250) DEFAULT 'enabled'
);

CREATE TABLE course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    description VARCHAR(250) NULL,
    status VARCHAR(250) DEFAULT 'enabled'
);

CREATE TABLE inscription (
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    score INT DEFAULT 0,
    status VARCHAR(250) DEFAULT 'in progress',
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (course_id) REFERENCES course(id),
    PRIMARY KEY(user_id, course_id)
);

INSERT INTO user (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Ingenieria'),
  ('Bill', 'Gates', 'Medicina'),
  ('Folrunsho', 'Alakija', 'Derecho');

INSERT INTO course(name, description) VALUES
('Matematicas', 'Course Description'),
('Español', 'Course Description'),
('Ingles', 'Course Description');


