package com.example.bdhotel.dal;


import com.example.bdhotel.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


@Component
public class DataAccessLayer {
    private SessionFactory sessionFactory;

    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session session = null;

    public void createClient(Employee newEmployee) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newEmployee);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
}