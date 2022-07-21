package com.cryptoTradingInfo.threads;

import org.json.simple.JSONObject;


//This is a thread class, it is instantiated and called for each transaction.
//This class calls the appropriate utility methods depending on the type of transaction like buy coins, sell coins, update price, add volume etc.

public class TransactionThread extends Thread{

    private JSONObject transaction;
    private TransactionThreadUtils defObj;
    private String transaction_type;
    private JSONObject transaction_data_object;
    public TransactionThread(JSONObject transaction)
    {
        this.transaction = transaction;
        defObj = new TransactionThreadUtils();
        transaction_type = (String) transaction.get("type");
        transaction_data_object = (JSONObject) transaction.get("data");
    }

    public void run() {
        String code_of_the_coin;
        long quantity_of_the_coin;
        String wallet_address_of_trader;
        switch (transaction_type){
            case "BUY":
                code_of_the_coin = (String) transaction_data_object.get("coin");
                quantity_of_the_coin = (long) transaction_data_object.get("quantity");
                wallet_address_of_trader = (String) transaction_data_object.get("wallet_address");
                defObj.buyCoins(code_of_the_coin, quantity_of_the_coin, wallet_address_of_trader);
                break;
            case "SELL":
                code_of_the_coin = (String) transaction_data_object.get("coin");
                quantity_of_the_coin = (long) transaction_data_object.get("quantity");
                wallet_address_of_trader = (String) transaction_data_object.get("wallet_address");
                defObj.sellCoins(code_of_the_coin,quantity_of_the_coin, wallet_address_of_trader);
                break;
            case "ADD_VOLUME":
                code_of_the_coin = (String) transaction_data_object.get("coin");
                long volume_of_the_coin = (long)transaction_data_object.get("volume");
                defObj.addVolume(code_of_the_coin, volume_of_the_coin);
                break;
            case "UPDATE_PRICE":
                code_of_the_coin = (String) transaction_data_object.get("coin");
                double price_of_the_coin = (double) transaction_data_object.get("price");
                defObj.updatePrice(code_of_the_coin, price_of_the_coin);
                break;
        }
    }
}
