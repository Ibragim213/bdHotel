package com.example.bdhotel.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roomsServise")
public class RoomsServise {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id_roomServise") // Имя столбца в базе данных
    private Long idRoomServise; // Поле для первичного ключа

    @Column(name = "idNumber") // Имя столбца в базе данных
    private int idNumber;

    @Column(name = "idServices")
    private int idServices;

}