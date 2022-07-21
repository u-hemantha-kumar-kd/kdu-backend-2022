package com.cryptoTradingInfo.readfiles;

import com.cryptoTradingInfo.entities.Coin;
import com.cryptoTradingInfo.entities.Trader;
import com.cryptoTradingInfo.exceptions.AddressNotFoundException;
import com.cryptoTradingInfo.exceptions.CodeNotFoundException;
import com.cryptoTradingInfo.threads.TransactionThread;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;

import static com.cryptoTradingInfo.readfiles.ReadFiles.*;

//This class reads the transaction json file and processes each json object one by one, by calling the appropriate methods based upon the type of transaction
public class ReadAndProcessJsonFiles {

    private static HashMap<String, Trader> wallet_address_to_trader_map = new HashMap<>();
    private static HashMap<String, Coin> code_to_coin_map = new HashMap<>();


    //given the wallet address, this method will return the corresponding trader details
    public static Trader getTraderWithGivenWalletAddress(String wallet_address)
    {
       Trader trader_with_given_wallet_address = null;

       for(int i = 0; i<all_traders.size(); i++){
           Trader current_trader = all_traders.get(i);
           if(current_trader.getWallet_address().toLowerCase().equals(wallet_address.toLowerCase()))
           {
               trader_with_given_wallet_address =  current_trader;
               break;
           }
       }

       return trader_with_given_wallet_address;
    }

    //given the wallet address, this method will return the corresponding trader details using hashmap
    public static Trader returnTraderWithGivenWalletAddress(String wallet_address) throws AddressNotFoundException
    {
            Trader trader =  wallet_address_to_trader_map.get(wallet_address);
            if(trader == null)
            {
                throw new AddressNotFoundException("Wallet Address Not found! Please Enter a Valid Wallet Address!");
            }
            return trader;
    }


    //given the code of the coin, this method will return the corresponding coin details
    private static Coin getCoinWithGivenCode(String code)
    {
        for(int i = 0; i< all_coins.size(); i++)
        {
            Coin current_coin = all_coins.get(i);
            if(current_coin.getSymbol().toLowerCase().equals(code.toLowerCase()))
            {
                return current_coin;
            }
        }
        return null;
    }

    //given the code of the coin, this method will return the corresponding coin details using hashmap
    public static Coin returnCoinWithGivenCode(String code) throws CodeNotFoundException
    {
        Coin coin =  code_to_coin_map.get(code);
        if(coin == null)
        {
            throw new CodeNotFoundException("Coin with this code is not Available!");
        }
        return coin;
    }

    //this method takes a json transaction object and creates a new thread for each transaction
    private static void parseTransactionObject(JSONObject transaction)
    {
        JSONObject transaction_data_object = (JSONObject) transaction.get("data");
        String wallet_address_of_trader = (String) transaction_data_object.get("wallet_address");
        if(wallet_address_of_trader!=null)
            wallet_address_to_trader_map.put(wallet_address_of_trader, getTraderWithGivenWalletAddress(wallet_address_of_trader));
        String code_of_the_coin = (String) transaction_data_object.get("coin");
        code_to_coin_map.put(code_of_the_coin, getCoinWithGivenCode(code_of_the_coin));
        String hash = getBlockHash();
        TransactionThread t1 = new TransactionThread(transaction);
        t1.start();
    }

    //this method loops through each of the json object one by one and passes the object to paresTransactionObject method for further processsing
    public static void readAndProcessJsonFile()
    {
        //reading the json files
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(basePath + "/json-files/test_transaction.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray transaction_list =  (JSONArray) obj;
            transaction_list.forEach( transaction -> parseTransactionObject( (JSONObject) transaction ) );
        }  catch (IOException e) {
            e.printStackTrace();
        }  catch (
                ParseException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Method generates the unique block hash required
     * for transactions made using the cryptocurrencies
     * @return - string representing the transaction hashcode
     */
    private static String getBlockHash() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();
/**
 * Introducing delay mimicking complex
 * calculation being performed.
 */
        for(double i=0;i<199999999; i++){
            i = i;
        }
        while (transactionHash.length() < 128) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }
        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }
}
