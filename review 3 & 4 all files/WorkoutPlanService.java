import java.util.*;

public class WorkoutPlanService {
    private WorkoutPlanDao workoutPlanDao;

    public WorkoutPlanService() {
        this.workoutPlanDao = new WorkoutPlanDao();
    }

    // Get all workout plans
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanDao.getAllWorkoutPlans();
    }

    // Add a new workout plan
    public boolean addWorkoutPlan(WorkoutPlan plan) {
        return workoutPlanDao.addWorkoutPlan(plan);
    }
}
