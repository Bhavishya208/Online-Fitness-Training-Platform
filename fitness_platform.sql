-- Create the database
CREATE DATABASE IF NOT EXISTS fitness_platform;

-- Use the newly created database
USE fitness_platform;

-- Create the 'users' table to store user information
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('user', 'trainer', 'admin') DEFAULT 'user',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the 'workouts' table to store workout data
CREATE TABLE IF NOT EXISTS workouts (
    workout_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    workout_name VARCHAR(100) NOT NULL,
    workout_type VARCHAR(50) NOT NULL,
    duration INT NOT NULL,  -- Duration in minutes
    calories_burned INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Create the 'sessions' table to store training session data
CREATE TABLE IF NOT EXISTS sessions (
    session_id INT AUTO_INCREMENT PRIMARY KEY,
    trainer_id INT NOT NULL,
    user_id INT NOT NULL,
    session_time TIMESTAMP NOT NULL,
    session_duration INT NOT NULL,  -- Session duration in minutes
    session_type VARCHAR(50) NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Sample Data Insertion (Optional)
-- Inserting sample users
INSERT INTO users (first_name, last_name, email, password, role) VALUES
('John', 'Doe', 'john.doe@example.com', 'password123', 'user'),
('Jane', 'Smith', 'jane.smith@example.com', 'password456', 'trainer'),
('Alex', 'Johnson', 'alex.johnson@example.com', 'admin123', 'admin');

-- Inserting sample workouts
INSERT INTO workouts (user_id, workout_name, workout_type, duration, calories_burned) VALUES
(1, 'Morning Yoga', 'Yoga', 30, 150),
(1, 'HIIT Training', 'Cardio', 45, 400),
(2, 'Strength Training', 'Strength', 60, 500);

-- Inserting sample sessions
INSERT INTO sessions (trainer_id, user_id, session_time, session_duration, session_type) VALUES
(2, 1, '2024-11-10 10:00:00', 60, 'Personal Training'),
(2, 1, '2024-11-11 14:00:00', 45, 'Group Training');
