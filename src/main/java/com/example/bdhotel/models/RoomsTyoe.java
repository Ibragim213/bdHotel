package com.example.bdhotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roomsTyoe", schema = "public", catalog = "postgres")
public class RoomsTyoe {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id") // Имя столбца в базе данных
    private Long id; // Поле для первичного ключа

    @Column(name = "typeRoom") // Имя столбца в базе данных
    private int typeRoom;

    @Column(name = "name")
    private String name;

}