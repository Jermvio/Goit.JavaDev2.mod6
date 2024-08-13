-- Вибір бази данних
USE MegaSoft;

-- Додавання працівників
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('John Doe', '1990-05-15', 'Senior', 6000),
('Jane Smith', '1985-10-20', 'Middle', 4500),
('Alice Johnson', '1992-07-11', 'Junior', 2000),
('Bob Brown', '1988-03-22', 'Trainee', 800),
('Charlie Davis', '1979-12-05', 'Senior', 7000),
('Eve White', '1995-09-18', 'Middle', 4000),
('Frank Black', '1991-02-10', 'Junior', 1800),
('Grace Green', '1993-06-25', 'Trainee', 900),
('Hank Blue', '1984-04-30', 'Senior', 6500),
('Ivy Red', '1987-11-03', 'Middle', 4700);

-- Додавання клієнтів
INSERT INTO client (NAME) VALUES
('Client A'),
('Client B'),
('Client C'),
('Client D'),
('Client E');

-- Додавання проєктів
INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
(1, '2023-01-01', '2024-01-01'),
(2, '2023-02-15', '2023-12-15'),
(3, '2023-03-01', '2023-09-01'),
(4, '2023-04-01', '2025-04-01'),
(5, '2023-05-01', '2023-06-01'),
(1, '2023-06-15', '2024-06-15'),
(2, '2023-07-01', '2024-07-01'),
(3, '2023-08-01', '2023-12-01'),
(4, '2023-09-01', '2024-05-01'),
(5, '2023-10-01', '2024-01-01');

-- Назначення працівників на проєкти
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(4, 9),
(5, 10),
(6, 1),
(6, 3),
(7, 2),
(7, 4),
(7, 5),
(8, 6),
(8, 7),
(9, 8),
(9, 9),
(10, 10),
(10, 1),
(10, 2);
