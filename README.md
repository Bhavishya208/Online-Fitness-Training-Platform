# 🏋️ **Online Fitness Training Platform**
## 📜 **Project Description**
Welcome to the **Online Fitness Training Platform**! This web-based solution connects **users**, **trainers**, and **admins** for an enhanced fitness journey. With personalized workout plans, progress tracking, and role-specific features, the platform is designed to help users achieve their fitness goals with expert guidance.

---

##✨ **Features**
**User Roles**:

  - **Use**r: Access and follow personalized workout plans.
  - **Trainer**: Create and manage workout plans, monitor user progress.
  - **Admin**: Manage users, trainers, and overall platform activities.
- 💪 **Personalized Workout Plans**:
Tailor-made fitness plans based on user goals, preferences, and fitness levels.

- 📈 **Progress Tracking**:
Track workout history, improvements in performance, and overall fitness progress.

- 🔗 **Database Integration**:
Uses MySQL to store user data, workout plans, trainer details, and progress logs.

##🚀 **Technologies Used**
- **Java (JDK)**: Backend development.
- **JDBC**: Database connectivity.
- **MySQL**: Database storage.
- **VS Code**: Development environment.
- **MySQL JDBC Driver**: Connects Java to MySQL.

---

## 🛠️ **Database Schema**
The system uses a MySQL database with the following key tables:

### 🧑‍🤝‍🧑 **Users Table**


```sql
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15),
    address TEXT,
    role ENUM('user', 'trainer', 'admin') DEFAULT 'user'
);
```


### 🏋️ **Workout Plans Table**


```sql
CREATE TABLE WorkoutPlans (
    plan_id INT PRIMARY KEY AUTO_INCREMENT,
    trainer_id INT NOT NULL,
    plan_name VARCHAR(100) NOT NULL,
    description TEXT,
    difficulty_level ENUM('beginner', 'intermediate', 'advanced'),
    duration INT NOT NULL,  -- duration in weeks
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```


### 💪 **User Progress Table**


```sql
CREATE TABLE UserProgress (
    progress_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    plan_id INT NOT NULL,
    date DATE NOT NULL,
    progress_notes TEXT,
    workout_completed BOOLEAN NOT NULL,
    performance_metrics TEXT,  -- e.g. weight lifted, distance run, etc.
    achieved_goals TEXT  -- user-specific milestones
);
```


### 🎓 **Trainer Table**


```sql
CREATE TABLE Trainers (
    trainer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    bio TEXT,
    specialty VARCHAR(50),
    phone_number VARCHAR(15),
    email VARCHAR(100),
    certification TEXT
);
```


## 🗂️ **Project Structure**

```
online-fitness-training/
├── src/
│   └── com/
│       └── fitnessplatform/
│           ├── User.java
│           ├── UserDAO.java
│           ├── WorkoutPlanDAO.java
│           ├── UserProgressDAO.java
│           ├── TrainerDAO.java
│           └── DBConnection.java
├── lib/
│   └── mysql-connector-java-x.x.x.jar (MySQL JDBC Driver)
├── assets/
│   └── database-connection-success.png
├── .gitignore
├── README.md
└── Main.java
```

--- 

With the Online Fitness Training Platform, achieving fitness goals is easier, more accessible, and guided by expert trainers. Whether you're a beginner or an experienced athlete, our personalized workout plans and progress tracking ensure that your journey toward fitness is effective and motivating!
