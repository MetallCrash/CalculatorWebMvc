package by.tms.dao;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private final List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    public boolean findUserByLogin(User user) {
        for (User optUser : userList) {
            if (optUser.getLogin().equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }
}
