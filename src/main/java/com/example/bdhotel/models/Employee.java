package com.example.bdhotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee", schema = "public", catalog = "postgres")
public class Employee {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id") // Имя столбца в базе данных
    private Long id; // Поле для первичного ключа

    @Column(name = "name") // Имя столбца в базе данных
    private String name;

    @Column(name = "age")
    private String  age;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


}
