package com.example.bdhotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class Booking {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id_booking") // Имя столбца в базе данных
    private Long idBooking; // Поле для первичного ключа
    @Column(name = "numberBooking") // Имя столбца в базе данных
    private int numberBooking;
    @Column(name = "CheckInDate")
    private int checkInDate;
    @Column(name = "CheckInTime")
    private int checkInTime;
    @Column(name = "departureDate")
    private int departureDate;
    @Column(name = "departureTime")
    private int departureTime;
    @Column(name = "finalPrice")
    private int finalPrice;
    @Column(name = "loginEmployee")
    private String  loginEmployee;
    @Column(name = "loginClients")
    private String loginClients;
    @Column(name = "idRooms")
    private Long idRooms;
    @Column(name = " totalAmount")
    private int totalAmount;
    @Column(name = "nearestAvailabilityDate")
    private int nearestAvailabilityDate;

}

