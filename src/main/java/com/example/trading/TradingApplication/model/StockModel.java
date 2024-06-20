package com.example.trading.TradingApplication.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stock_table")
@EqualsAndHashCode
@ToString
public class StockModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String sname;
    private Double sprice;
}
