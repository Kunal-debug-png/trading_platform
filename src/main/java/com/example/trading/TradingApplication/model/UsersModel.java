package com.example.trading.TradingApplication.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users_table", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
@EqualsAndHashCode
@ToString
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String email;
    private Double balance = 5000.0;
}
