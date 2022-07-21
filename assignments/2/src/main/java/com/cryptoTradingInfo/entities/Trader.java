package com.cryptoTradingInfo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.HashMap;

//This class consists of the basic fields of the traders.csv file and contains a hashmap that maps the code of the coin to the count of the coins that each trader has.
@Data
@AllArgsConstructor
public class Trader {
    private int id;
    private String first_name;
    private String last_name;
    private String phone;
    private String wallet_address;
    private double balance;
    private HashMap<String, Long> coin_to_count_of_coins_map;
    public void setCoin_to_count_of_coins_map(String code_of_the_coin, long l) {
        this.coin_to_count_of_coins_map.put(code_of_the_coin, l);
    }
}
