package com.example.bdhotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rooms")
public class Rooms {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "idrooms") // Имя столбца в базе данны
    private long idRooms;
    @Column(name = "numberNumber") // Имя столбца в базе данных\
    private int numberNumber;

    @Column(name = "class")
    private String className;

    @Column(name = "costPerDay")
    private double costPerDay;


    @Column(name = "status")
    private String status;

}