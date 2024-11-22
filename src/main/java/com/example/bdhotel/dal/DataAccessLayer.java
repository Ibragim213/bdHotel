package com.example.bdhotel.dal;


import com.example.bdhotel.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataAccessLayer {
    private final SessionFactory sessionFactory;
    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session session = null;

//    Post

    public void createClient(Client newClient) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newClient);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void createEmploy(Employee newEmployee) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newEmployee);
        session.getTransaction().commit();
        if (session != null){
            session.close();
        }
    }

    public void createRooms(Rooms newRooms) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newRooms);
        session.getTransaction().commit();
        if (session != null){
            session.close();
        }
    }



    public void createBooking(Booking newBooking) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newBooking);
        session.getTransaction().commit();
        if (session != null){
            session.close();
        }
    }

    public void createRoomsServise(RoomsServise newRoomsServise) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newRoomsServise);
        session.getTransaction().commit();
        if (session != null){
            session.close();
        }
    }

    public void createRoomsType(RoomsType newRoomsType) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newRoomsType);
        session.getTransaction().commit();
        if (session != null){
            session.close();
        }
    }

    public void deleteClientById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.remove(client);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteBookingById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Booking booking = session.get(Booking.class, id);
        session.remove(booking);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteEmployeeById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Booking booking = session.get(Booking.class, id);
        session.remove(booking);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteRoomsById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Booking booking = session.get(Booking.class, id);
        session.remove(booking);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteRoomsTypeById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        RoomsType roomsType= session.get(RoomsType.class, id);
        session.remove(roomsType);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }



    public void deleteRoomServise(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        RoomsServise roomsServise= session.get(RoomsServise.class, id);
        session.remove(roomsServise);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteServiseById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
       Servise servise= session.get(Servise.class, id);
        session.remove(servise);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public Client getClientById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Client client = session.get(Client.class, id);
            return client;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Booking getBookingById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Booking booking = session.get(Booking.class, id);
            return booking;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employee getEmployeeById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Employee employee = session.get(Employee.class, id);
            return employee;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Rooms getRoomsById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Rooms rooms = session.get(Rooms.class, id);
            return rooms;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public RoomsServise getRoomsServiseById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            RoomsServise roomsServise = session.get(RoomsServise.class, id);
            return roomsServise;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public RoomsType getRoomsTypeById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            RoomsType roomsType = session.get(RoomsType.class, id);
            return roomsType;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Servise getServiseById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Servise servise = session.get(Servise.class, id);
            return servise;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
