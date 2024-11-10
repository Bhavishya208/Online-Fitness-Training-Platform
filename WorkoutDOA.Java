package com.fitnessplatform.dao;

import com.fitnessplatform.model.Workout;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDAO {

    public void addWorkout(Workout workout) throws SQLException {
        String sql = "INSERT INTO workouts (user_id, workout_name, workout_type, duration, calories_burned) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, workout.getUserId());
            stmt.setString(2, workout.getWorkoutName());
            stmt.setString(3, workout.getWorkoutType());
            stmt.setInt(4, workout.getDuration());
            stmt.setInt(5, workout.getCaloriesBurned());
            stmt.executeUpdate();
        }
    }

    public List<Workout> getWorkoutsByUser(int userId) throws SQLException {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workouts WHERE user_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Workout workout = new Workout(
                            rs.getInt("workout_id"),
                            rs.getInt("user_id"),
                            rs.getString("workout_name"),
                            rs.getString("workout_type"),
                            rs.getInt("duration"),
                            rs.getInt("calories_burned")
                    );
                    workouts.add(workout);
                }
            }
        }
        return workouts;
    }
}
