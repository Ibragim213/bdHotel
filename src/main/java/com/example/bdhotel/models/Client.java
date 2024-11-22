package com.example.bdhotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id_Client") // Имя столбца в базе данных
    private Long idClient; // Поле для первичного ключа
    @Column(name = "surname") // Имя столбца в базе данных
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "issuedByWhomAndWhen")
    private String issuedByWhomAndWhen;
    @Column(name = "passportSeriesAndNumber")
    private String passportSeriesAndNumber;
    @Column(name = "number")
    private String number;
    @Column(name = "dateOfBirth")
    private String dateOfBirth;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "sex")
    private String sex;
    @Column(name = "login")
    private String login;
    @Column(name = "pasword")
    private String password;

//    {
//    "surname": "Титов",
//    "name": "Иван",
//    "patronymic": "фсфс",
//    "issuedByWhomAndWhen": "Иван",
//    "passportSeriesAndNumber": "141141",
//    "number": "5151515",
//    "dateOfBirth": "фафафаф",
//    "phoneNumber": "фафафаф",
//    "email": "ibragimnagiev@mail.ru",
//    "sex": "м",
//    "login": "ibra",
//    "password": "981973191"
//    }
}
