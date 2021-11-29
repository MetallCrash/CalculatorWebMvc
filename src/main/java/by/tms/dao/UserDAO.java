package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    public boolean findUserByLogin(User user) {
        try {
            Session session = sessionFactory.openSession();
            Query<User> query = session.createQuery("FROM User WHERE login =:login", User.class);
            query.setParameter("login", user.getLogin());
            User optUser = query.getSingleResult();
            return optUser != null;
        } catch (NoResultException nre) {
            return false;
        }
    }

    public boolean checkUser(User user) {
        try {
            Session session = sessionFactory.openSession();
            User optUser = session.createQuery("FROM User WHERE login=:login and password=:password", User.class)
                    .setParameter("login", user.getLogin())
                    .setParameter("password", user.getPassword())
                    .getSingleResult();
            return optUser != null;
        } catch (NoResultException nre) {
            return false;
        }
    }
}
