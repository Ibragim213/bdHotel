package com.example.bdhotel.models;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

@Data
@Entity
@Table(name = "booking", schema = "public", catalog = "postgres")
public class Booking {

    @Id // Добавляем аннотацию для первичного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации
    @Column(name = "id") // Имя столбца в базе данных
    private Long id; // Поле для первичного ключа

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
    private VarcharJdbcType loginEmployee;

    @Column(name = "loginClients")
    private VarcharJdbcType loginClients;

    @Column(name = "idRooms")
    private Long idRooms;

    @Column(name = " totalAmount")
    private int totalAmount;

    @Column(name = "nearestAvailabilityDate")
    private int nearestAvailabilityDate;

}

