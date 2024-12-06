package com.example.bdhotel.security;

import com.example.bdhotel.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Data
@AllArgsConstructor
public class ClientsDetalesImpl implements UserDetails {
    private Long clientId; // Идентификатор клиента
    private String fullName; // Полное имя клиента
    private String age; // Возраст клиента
    private String issuedByWhomAndWhen; // Данные паспорта
    private String passportSeriesAndNumber; // Серия и номер паспорта
    private String phoneNumber; // Номер телефона клиента
    private String email; // Электронная почта клиента
    private String sex; // Пол клиента
    private String login; // Логин клиента
    private String password; // Пароль клиента

    // Метод для создания экземпляра ClientsDetailsImpl из объекта Client
    public static ClientsDetalesImpl build(Client client) {
        return new ClientsDetalesImpl(
                client.getIdClient(), // Получение идентификатора клиента
                client.getSurname() + " " + client.getName() + " " + client.getPatronymic(), // Формирование полного имени
                client.getAge(), // Получение возраста
                client.getIssuedByWhomAndWhen(), // Получение данных о паспорте
                client.getPassport(), // Получение серии и номера паспорта
                client.getPhoneNumber(), // Получение номера телефона
                client.getEmail(), // Получение электронной почты
                client.getSex(), // Получение пола клиента
                client.getLogin(), // Получение логина клиента
                client.getPassword() // Получение пароля
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")); // Пример роли пользователя
    }

    @Override
    public String getPassword() {
        return password; // Возвращает пароль
    }

    @Override
    public String getUsername() {
        return login; // Возвращает логин клиента как имя пользователя
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Указывает, что аккаунт не истек
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Указывает, что аккаунт не заблокирован
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Указывает, что учетные данные не истекли
    }

    @Override
    public boolean isEnabled() {
        return true; // Указывает, что аккаунт активен (можно добавить дополнительную логику)
    }
}
