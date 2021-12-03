package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        try(Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE login =:login", User.class);
            query.setParameter("login", user.getLogin());
            User optUser = query.getSingleResult();
            return optUser != null;
        } catch (NoResultException nre) {
            return false;
        }
    }

    public Optional<User> checkUser(User user) {
        try(Session session = sessionFactory.openSession()) {
            User optUser = session.createQuery("FROM User WHERE login=:login and password=:password", User.class)
                    .setParameter("login", user.getLogin())
                    .setParameter("password", user.getPassword())
                    .getSingleResult();
            return Optional.of(optUser);
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    public void saveOperation(User user, Operation operation) {
        Session session = sessionFactory.openSession();

        User userForMerge = session.find(User.class, user.getId());
        Transaction transaction = session.beginTransaction();

        operation.setUser(userForMerge);
        userForMerge.getOperationList().add(operation);

        session.merge(userForMerge);

        session.flush();
        transaction.commit();

        session.close();
    }

    public List<Operation> getOperationList(User user) {
        Session session = sessionFactory.openSession();
        List<Operation> operationList = session.createQuery("from Operation where user= :user")
                .setParameter("user", user).getResultList();
        session.close();
        return operationList;
    }
}
