package com.cryptoTradingInfo;

import com.cryptoTradingInfo.entities.Coin;
import com.cryptoTradingInfo.entities.Trader;

import java.util.*;
import java.util.stream.Collectors;

import static com.cryptoTradingInfo.readfiles.ReadFiles.all_coins;
import static com.cryptoTradingInfo.readfiles.ReadFiles.all_traders;

//This is a utility class for the menu showed to the user in the main class, this contains methods like getCoinByName, getCoinByCode, topFiveTraders, etc
public class Queries {

    //given the name of the coin, this method prints the details of that coin
    public  Coin getCoinByName(String name_of_the_coin) {
        int total_number_of_coins = all_coins.size();
        for (int i = 0; i < total_number_of_coins; i++) {
            Coin current_coin = all_coins.get(i);
            if (name_of_the_coin.toLowerCase().equals(current_coin.getName().toLowerCase())) {
                return current_coin;
            }
        }
        return null;
    }

    //given the code of the coin, it will return the details of that coin
    public  Coin getCoinByCode(String code_of_the_coin) {
        int total_number_of_coins = all_coins.size();
        for (int i = 0; i < total_number_of_coins; i++) {
            Coin current_coin = all_coins.get(i);
            if (code_of_the_coin.toUpperCase().equals(current_coin.getSymbol().toUpperCase())) {
                return current_coin;
            }
        }
        return null;
    }

    //this method will return the top_fifty_coins based on their price
    public  List<Coin> getTopFiftyCoinsBasedOnPrice() {
        List<Coin> sortedList = all_coins.stream()
                .sorted(Comparator.comparing(Coin::getPrice).reversed())
                .collect(Collectors.toList());
        List<Coin> top_fifty_coins = sortedList.stream().limit(50).collect(Collectors.toList());
        return top_fifty_coins;
    }

    //this method will return the portfolio details given the trader wallet address
    public HashMap<String, Long> getPortfolioOfTheTrader(Trader trader)
    {
        return trader.getCoin_to_count_of_coins_map();
    }

    //this method returns the amount present with the trader, if the amount is negative, then its loss else it is a profit, default value would be zero.
    public double returnTotalProfitOrLoss(Trader trader)
    {
        return trader.getBalance();
    }

    //returns the top five traders based on the amount that a particular trader possess
    public List<Trader> returnTopFiveTraders(List<Trader> sorted_list)
    {
        List<Trader> top_five_traders = new ArrayList<>();
        for(int i = 0; i<5; i++)
        {
            top_five_traders.add(sorted_list.get(all_traders.size() - i - 1));
        }
        return top_five_traders;
    }

    //returns the bottom five traders based on the amount that a particular trader possess
    public List<Trader> returnBottomFiveTraders(List<Trader> sorted_list)
    {
        List<Trader> bottom_five_traders = new ArrayList<>();

        for(int i = 0; i<5; i++)
        {
            bottom_five_traders.add(sorted_list.get(i));
        }

        return bottom_five_traders;
    }
}

