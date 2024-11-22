package com.example.bdhotel.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roomServices", schema = "public", catalog = "postgres")
public class RoomServices {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id") // Имя столбца в базе данных
    private Long id; // Поле для первичного ключа

    @Column(name = "idNumber") // Имя столбца в базе данных
    private int idNumber;

    @Column(name = "idServices")
    private int idServices;

}