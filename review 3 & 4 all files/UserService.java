public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    // Register a user
    public boolean registerUser(User user) {
        return userDao.registerUser(user);
    }

    // Validate login
    public boolean validateLogin(String email, String password) {
        return userDao.validateLogin(email, password);
    }

    // Get user details by email
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
