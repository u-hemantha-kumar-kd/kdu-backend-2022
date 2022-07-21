package com.cryptoTradingInfo.threads;

import com.cryptoTradingInfo.entities.Coin;
import com.cryptoTradingInfo.entities.Trader;
import com.cryptoTradingInfo.exceptions.AddressNotFoundException;
import com.cryptoTradingInfo.exceptions.CodeNotFoundException;

import static com.cryptoTradingInfo.readfiles.ReadAndProcessJsonFiles.returnCoinWithGivenCode;
import static com.cryptoTradingInfo.readfiles.ReadAndProcessJsonFiles.returnTraderWithGivenWalletAddress;

//this is a utility class that provides implementations for methods like buy coins, sell coins, update price, add volume etc.
public class TransactionThreadUtils {

    //this method updates the coins that a particular trader has and also updates the remaining volume of coins for a particular type in all_coins list
    //when a buy operation takes place, the number of coins of a particular type gets increased by the quantity of coins parameter, and subsequently result in decrease in all_coins list for that type and also updates the balance of the trader
    public void buyCoins(String code_of_the_coin, long quantity_of_the_coin,String wallet_address_of_trader){
        Trader trader;
        Coin coin;
        try {
            trader = returnTraderWithGivenWalletAddress(wallet_address_of_trader);
        } catch (AddressNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            coin = returnCoinWithGivenCode(code_of_the_coin);
        } catch (CodeNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(coin != null && trader!= null && coin.getCirculating_supply() >= quantity_of_the_coin)
        {
            coin.setCirculating_supply(coin.getCirculating_supply() - quantity_of_the_coin);
            trader.setCoin_to_count_of_coins_map(code_of_the_coin, (trader.getCoin_to_count_of_coins_map().getOrDefault(code_of_the_coin, 0l) + quantity_of_the_coin));
            double cost_for_all_coins_bought = (quantity_of_the_coin * coin.getPrice());
            double updated_balance = trader.getBalance() - cost_for_all_coins_bought;
            trader.setBalance(updated_balance);
            System.out.println("Bought Coins Successfully!");
        }
    }

//    this method decreases the number of coins of a particular type that a trader has, increases the number of coins in all_coins list,  and updates the balance amount by adding the product of quantity of coins sold with the price of each coin.
    public void sellCoins(String code_of_the_coin, long quantity_of_the_coin,String wallet_address_of_trader) {
        Trader trader;
        Coin coin;
        try {
            trader = returnTraderWithGivenWalletAddress(wallet_address_of_trader);
        } catch (AddressNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            coin = returnCoinWithGivenCode(code_of_the_coin);
        } catch (CodeNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(coin != null && trader!= null && trader.getCoin_to_count_of_coins_map().get(code_of_the_coin) != null && trader.getCoin_to_count_of_coins_map().get(code_of_the_coin) >= quantity_of_the_coin)
        {
            coin.setCirculating_supply(coin.getCirculating_supply() + quantity_of_the_coin);
            trader.setCoin_to_count_of_coins_map(code_of_the_coin, (trader.getCoin_to_count_of_coins_map().get(code_of_the_coin) - quantity_of_the_coin));
            double cost_for_all_coins_sold = quantity_of_the_coin * coin.getPrice();
            double updated_balance = trader.getBalance() + cost_for_all_coins_sold;
            trader.setBalance(updated_balance);
            System.out.println("Sold Coins Successfully!");
        }

    }

    //this method simply adds the volume of the coins of a particular type in the all_coins list
    public  void addVolume(String code_of_the_coin, long volume_of_the_coin){

        Coin coin = null;
        try {
            coin = returnCoinWithGivenCode(code_of_the_coin);
        } catch (CodeNotFoundException e) {
            throw new RuntimeException(e);
        }
        coin.setCirculating_supply(coin.getCirculating_supply() + volume_of_the_coin);
        System.out.println("Volume added successfully!");
    }

    //this method simply updates the price of a particular coin in the all_coins list
    public  void updatePrice(String code_of_the_coin, double price_of_the_coin)  {

        Coin coin = null;
        try {
            coin = returnCoinWithGivenCode(code_of_the_coin);
        } catch (CodeNotFoundException e) {
            throw new RuntimeException(e);
        }
        coin.setPrice(price_of_the_coin);

        System.out.println("Price Updated successfully!");
    }
}
