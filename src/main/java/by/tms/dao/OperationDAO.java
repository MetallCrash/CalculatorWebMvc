package by.tms.dao;

import by.tms.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OperationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Operation operation) {
        Session session = sessionFactory.openSession();
        session.save(operation);
        session.close();
    }

//    public List<Operation> findAll(long id) {
//        Session session = sessionFactory.openSession();
//        return session.createQuery("from Operation where pUser_FK=:id", Operation.class).setParameter("id", id).getResultList();
//    }
//    public List<Operation> findAll() {
//        Session session = sessionFactory.openSession();
//        session.find(Operation.class, )
//        return session.createQuery("from Operation", Operation.class)
//                .getResultList();
//    }
}
