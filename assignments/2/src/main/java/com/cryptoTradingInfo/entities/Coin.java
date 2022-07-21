package com.cryptoTradingInfo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

//This is the Coin class that contains the basic fields that are present in the souce coin.csv file along with getters and setters.
@Data
@AllArgsConstructor
public class Coin {
    private int rank;
    private String name;
    private String symbol;
    private double price;
    private long circulating_supply;
}
