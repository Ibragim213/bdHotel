package com.example.bdhotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "servise", schema = "public", catalog = "postgres")
public class Servise {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id") // Имя столбца в базе данных
    private Long id; // Поле для первичного ключа

    @Column(name = "serviceId") // Имя столбца в базе данных
    private Long serviceId;

    @Column(name = "priceAdditionalServices")
    private int priceAdditionalServices;

    @Column(name = "Additionaervices")
    private String Additionaervices;

}