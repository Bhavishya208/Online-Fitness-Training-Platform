import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnlineFitnessTrainingPlatformTest {

    private User user;
    private Trainer trainer;
    private BMI_Calculator bmiCalculator;
    private ProgressTracking progressTracking;

    // Before each test, we initialize the objects that will be used
    @BeforeEach
    void setUp() {
        user = new User("John Doe", "john@email.com", "password123", 25, "Male");
        trainer = new Trainer("Jane Smith", "trainer@email.com", "trainerpassword", "Fitness Trainer");
        bmiCalculator = new BMI_Calculator();
        progressTracking = new ProgressTracking();
    }

    // Test case for User Registration
    @Test
    void testUserRegistration() {
        assertNotNull(user.getName(), "User's name should not be null");
        assertEquals("John Doe", user.getName(), "User's name should be John Doe");
        assertTrue(user.getEmail().contains("@"), "Email should contain '@'");
        assertTrue(user.getPassword().length() >= 8, "Password should have a minimum length of 8 characters");
    }

    // Test case for BMI Calculation
    @Test
    void testBMICalculation() {
        // Example: Weight = 70kg, Height = 1.75m
        double bmi = bmiCalculator.calculateBMI(70, 1.75);
        assertEquals(22.86, bmi, 0.01, "BMI should be calculated correctly");

        // Test BMI for overweight case
        bmi = bmiCalculator.calculateBMI(90, 1.75);
        assertTrue(bmi > 25, "BMI should be greater than 25 for overweight person");
    }

    // Test case for Progress Tracking
    @Test
    void testProgressTracking() {
        // Test adding and retrieving progress
        progressTracking.addProgress(user.getName(), 30, 1.75, 70);  // (days, height, weight)
        double trackedWeight = progressTracking.getWeight(user.getName(), 30);
        assertEquals(70, trackedWeight, "User's weight should be 70kg on day 30");

        // Test for empty progress
        assertThrows(IllegalArgumentException.class, () -> progressTracking.getWeight("Unknown User", 30), "Exception should be thrown for unknown user");
    }

    // Test case for user BMI recommendation based on BMI
    @Test
    void testBMIRecommendation() {
        // BMI calculator with weight = 75kg and height = 1.65m
        double bmi = bmiCalculator.calculateBMI(75, 1.65);
        String recommendation = bmiCalculator.getBMICategory(bmi);

        // Assert that the recommendation is correct
        assertEquals("Overweight", recommendation, "Recommendation should be Overweight for this BMI");
    }

    // Test case for user login
    @Test
    void testUserLogin() {
        assertTrue(user.login("john@email.com", "password123"), "User should be able to login with correct credentials");
        assertFalse(user.login("john@email.com", "wrongpassword"), "User should not be able to login with incorrect password");
    }

    // Test case for trainer adding workout plan
    @Test
    void testTrainerAddWorkoutPlan() {
        // Trainer adds a workout plan
        String workoutPlan = trainer.addWorkoutPlan("Strength Training", "45-minute weight lifting session");
        assertNotNull(workoutPlan, "Workout plan should not be null after being added");
        assertTrue(workoutPlan.contains("Strength Training"), "Workout plan should contain the title 'Strength Training'");
    }

    // Test case for validating email format
    @Test
    void testValidateEmailFormat() {
        assertTrue(user.getEmail().contains("@"), "Email should contain '@'");
        assertFalse(user.getEmail().endsWith(".com"), "Email should not end with '.com'");  // Example of an invalid case to test
    }
}
