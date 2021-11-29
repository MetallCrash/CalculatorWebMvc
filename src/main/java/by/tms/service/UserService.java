package by.tms.service;

import by.tms.dao.UserDAO;
import by.tms.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean registerUser(User user) {
        if (!userDAO.findUserByLogin(user)) {
            userDAO.saveUser(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUser(User user) {
        return userDAO.checkUser(user);
    }
}
