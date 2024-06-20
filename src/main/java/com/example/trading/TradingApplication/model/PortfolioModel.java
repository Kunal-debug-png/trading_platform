package com.example.trading.TradingApplication.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="portfolio_table")
@EqualsAndHashCode
@ToString
public class PortfolioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "id")
    private UsersModel user;

    @ManyToOne
    @JoinColumn(name="stockid", referencedColumnName = "sid")
    private StockModel stock;

    private Integer qty;
    private Double price;
}
