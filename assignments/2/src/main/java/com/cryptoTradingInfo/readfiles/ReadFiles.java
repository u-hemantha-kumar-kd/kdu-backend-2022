package com.cryptoTradingInfo.readfiles;

import com.cryptoTradingInfo.entities.Coin;
import com.cryptoTradingInfo.entities.Trader;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//this class just reads the csv files provided and stores the details of the coins and traders in appropriate lists for further usage
public class ReadFiles {
    static String basePath = new File("").getAbsolutePath();
    public static List<Trader> all_traders = new ArrayList<>();
    public static List<Coin> all_coins = new ArrayList<>();
    public static void readFiles() throws IOException
    {

        String coinsPath = basePath + "/csv-files/coins.csv";
        String tradersPath = basePath + "/csv-files/traders.csv";

        try{
            FileReader tradersFile = new FileReader(tradersPath);
            BufferedReader br = new BufferedReader(tradersFile);
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] currentTraderLine = line.split(",");
                Trader trader = new Trader(Integer.parseInt(currentTraderLine[0]), currentTraderLine[1], currentTraderLine[2], currentTraderLine[3], currentTraderLine[4], 0, new HashMap<>());
                all_traders.add(trader);
            }
        }
        catch (FileNotFoundException err)
        {
            System.out.println(err.getMessage());
            System.out.println("Terminating program");
            System.exit(1);
        }

        try{
            FileReader coinsFile = new FileReader(coinsPath);
            BufferedReader br = new BufferedReader(coinsFile);
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] currentCoinLine = line.split(",");
                Coin coin = new Coin(Integer.parseInt(currentCoinLine[1]), currentCoinLine[2], currentCoinLine[3], Double.parseDouble(currentCoinLine[4]), Long.parseLong(currentCoinLine[5]));
                all_coins.add(coin);
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
}
