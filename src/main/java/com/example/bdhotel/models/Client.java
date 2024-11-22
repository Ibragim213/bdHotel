package com.example.bdhotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client", schema = "public", catalog = "postgres")
public class Client {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id") // Имя столбца в базе данных
    private Long id; // Поле для первичного ключа

    @Column(name = "surname") // Имя столбца в базе данных
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "issuedByWhomAndWhen")
    private String issuedByWhomAndWhen;

    @Column(name = "passportSeriesAndNumber")
    private int passportSeriesAndNumber;

    @Column(name = "number")
    private int number;

@Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private String sex;

    @Column(name = "login")
    private String login;

    @Column(name = "pasword")
    private String password;

    public Client() {
    }
}
