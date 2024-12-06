package com.example.bdhotel.dal;


import com.example.bdhotel.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session session = null;

    @PersistenceContext
    private EntityManager entityManager;


//    creatr

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
        if (session != null) {
            session.close();
        }
    }

    public void createRooms(Rooms newRooms) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newRooms);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }


    public void createBooking(Booking newBooking) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newBooking);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }



    public void createRoomsType(RoomsType newRoomsType) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newRoomsType);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }


    //delete
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
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteRoomsById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Rooms rooms = session.get(Rooms.class, id);
        session.remove(rooms);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteRoomsTypeById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        RoomsType roomsType = session.get(RoomsType.class, id);
        session.remove(roomsType);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }




    public void deleteServiseById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Servise servise = session.get(Servise.class, id);
        session.remove(servise);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }


    //get
    public Client getClientById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
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
        try {
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
        try {
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
        try {
            Rooms rooms = session.get(Rooms.class, id);
            return rooms;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }



    public RoomsType getRoomsTypeById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
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
        try {
            Servise servise = session.get(Servise.class, id);
            return servise;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public Client getClientFromDatabaseByUsername(String email) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query<Client> query = session
                .createQuery("FROM Client where email = :email", Client.class)
                .setParameter("email", email);
        Client client = query.uniqueResult();
        if (client == null) {
            return null;
        }
        return client;
    }

    public boolean existsClientByEmail(String email) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            Query<Client> query = session
                    .createQuery("FROM Client WHERE email = :email", Client.class)
                    .setParameter("email", email);
            List<Client> clients = query.list();
            return !clients.isEmpty();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Client patchClientById(long id, Client client) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Client updatedClient = session.get(Client.class, id);
            if (updatedClient != null) {
                updatedClient.setSurname(client.getSurname());
                updatedClient.setAge(client.getAge());
                updatedClient.setName(client.getName());
                updatedClient.setPatronymic(client.getPatronymic());
                updatedClient.setIssuedByWhomAndWhen(client.getIssuedByWhomAndWhen());
                updatedClient.setPhoneNumber(client.getPhoneNumber());
                updatedClient.setEmail(client.getEmail());
                updatedClient.setDateOfBirth(client.getDateOfBirth());
                updatedClient.setSex(client.getSex());
                updatedClient.setLogin(client.getLogin());
                updatedClient.setPassword(client.getPassword());

                session.merge(updatedClient);
                session.getTransaction().commit();
                return updatedClient;
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Booking patchBookingById(long id, Booking booking) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Booking updatedBooking = session.get(Booking.class, id);
            updatedBooking.setNumberBooking(updatedBooking.getNumberBooking());
            updatedBooking.setCheckInTime(updatedBooking.getCheckInTime());
            updatedBooking.setCheckInDate(updatedBooking.getCheckInDate());
            updatedBooking.setCheckInTime(updatedBooking.getCheckInTime());
            updatedBooking.setDepartureDate(updatedBooking.getDepartureDate());
            updatedBooking.setDepartureTime(updatedBooking.getDepartureTime());
            updatedBooking.setFinalPrice(updatedBooking.getFinalPrice());
            updatedBooking.setLoginEmployee(updatedBooking.getLoginEmployee());
            updatedBooking.setLoginClients(updatedBooking.getLoginClients());
            updatedBooking.setTotalAmount(updatedBooking.getTotalAmount());
            updatedBooking.setNearestAvailabilityDate(updatedBooking.getNearestAvailabilityDate());


            session.merge(updatedBooking);
            session.getTransaction().commit();
            return updatedBooking;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employee patchEmployeeById(long id, Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Employee updatedEmployee = session.get(Employee.class, id);
            if (updatedEmployee != null) {
                updatedEmployee.setName(employee.getName());
                updatedEmployee.setAge(employee.getAge());
                updatedEmployee.setSurname(employee.getSurname());
                updatedEmployee.setMiddleName(employee.getMiddleName());
                updatedEmployee.setLogin(employee.getLogin());
                updatedEmployee.setPassword(employee.getPassword());

                session.merge(updatedEmployee);
                session.getTransaction().commit();
                return updatedEmployee;
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Rooms patchRoomsById(long id, Rooms rooms) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Rooms updatedRooms = session.get(Rooms.class, id);
            if (updatedRooms != null) {
                updatedRooms.setNumberNumber(rooms.getNumberNumber());
                updatedRooms.setClassName(rooms.getClassName());
                updatedRooms.setCostPerDay(rooms.getCostPerDay());
                updatedRooms.setStatus(rooms.getStatus());

                session.merge(updatedRooms);
                session.getTransaction().commit();
                return updatedRooms;
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public RoomsType patchRoomsTypeById(long id, RoomsType roomsType) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            RoomsType updatedRoomsType = session.get(RoomsType.class, id);
            if (updatedRoomsType != null) {
                updatedRoomsType.setTypeRoom(roomsType.getTypeRoom());
                updatedRoomsType.setName(roomsType.getName());

                session.merge(updatedRoomsType);
                session.getTransaction().commit();
                return updatedRoomsType;
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createServise(Servise newServise) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newServise);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public Servise patchServiseTypeById(long id, Servise servise) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Servise updatedServise = session.get(Servise.class, id);
            if (updatedServise != null) {
                updatedServise.setAdditionaervices(servise.getAdditionaervices());
                updatedServise.setPriceAdditionalServices(servise.getPriceAdditionalServices());

                session.merge(updatedServise);
                session.getTransaction().commit();
                return updatedServise;
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}


