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

    public void registerUser(User user) {
        if (!userDAO.findUserByLogin(user)) {
            userDAO.addUser(user);
        }
    }
}
