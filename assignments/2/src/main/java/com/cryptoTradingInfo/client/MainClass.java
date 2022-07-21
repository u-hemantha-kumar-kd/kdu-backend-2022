package com.cryptoTradingInfo.client;

import com.cryptoTradingInfo.Queries;
import com.cryptoTradingInfo.entities.*;
import com.cryptoTradingInfo.exceptions.*;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.cryptoTradingInfo.readfiles.ReadAndProcessJsonFiles.*;
import static com.cryptoTradingInfo.readfiles.ReadFiles.*;


/*
This is the Main Class that is responsible for showing the menu based interface for the user to interact with.
Depending upon the choice selected by the user, this class will call the appropriate methods to print the output.

 */
public class MainClass {

    public static void main(String[] args) throws IOException, AddressNotFoundException {
        Scanner sc = new Scanner(System.in);
        //read the source csv files
        readFiles();

        //process each transaction one by one after reading the json file
        readAndProcessJsonFile();

        while (true)
        {
            String wallet_address;
            Trader trader;
            System.out.println("1.Enter Name of the coin to retrieve the details\n2.Enter the code of the coin to retrieve the details\n3.Display Top 50 coins in the market based on Price\n4.Enter the Wallet Address of the Trader to display his portfolio\n5.Enter the Wallet Address of the Trader to display the Profit or Loss he made\n6. Top 5 and Bottom 5 Traders based on their Profit or Loss\n7.Terminate Program");

            try {
                Queries query_methods = new Queries();
                System.out.println("Enter your choice!");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter the Name of the Coin!");
                        String name_of_the_coin = sc.nextLine();
                        Coin details_of_the_coin = query_methods.getCoinByName(name_of_the_coin);
                        if (details_of_the_coin != null) {
                            System.out.println(details_of_the_coin);
                        } else {
                            System.out.println("Coin Not Found with the given Name");
                        }
                        break;
                    case 2:
                        System.out.println("Enter the code of the coin");
                        String code_of_the_coin = sc.nextLine();
                        details_of_the_coin = query_methods.getCoinByCode(code_of_the_coin);
                        if (details_of_the_coin != null) {
                            System.out.println(details_of_the_coin);
                        } else {
                            System.out.println("Coin Not Found with the given Code");
                        }
                        break;
                    case 3:
                        List<Coin> top_fifty_coins = query_methods.getTopFiftyCoinsBasedOnPrice();
                        for(Coin coin : top_fifty_coins)
                        {
                            System.out.println(coin);
                        }
                        break;

                    case 4:
                        System.out.println("Enter the Wallet Address of the Trader");
                        wallet_address = sc.nextLine().trim();
                        trader = returnTraderWithGivenWalletAddress(wallet_address);
                        System.out.println(trader);
//                        System.out.println(query_methods.getPortfolioOfTheTrader(trader));
                        break;
                    case 5:
                        System.out.println("Enter the Wallet Address of the Trader");
                        wallet_address = sc.nextLine();
                        trader = returnTraderWithGivenWalletAddress(wallet_address);
                        System.out.println(query_methods.returnTotalProfitOrLoss(trader));
                        break;

                    case 6:
                        List<Trader> sortedList = all_traders.stream()
                                .sorted(Comparator.comparingDouble(Trader::getBalance))
                                .collect(Collectors.toList());
//                        System.out.println(sortedList.toString());
                        List<Trader> top_five_traders = query_methods.returnTopFiveTraders(sortedList);
                        List<Trader> bottom_five_traders = query_methods.returnBottomFiveTraders(sortedList);

                        System.out.println("Top Five Traders");
                        System.out.println(top_five_traders);

                        System.out.println("Bottom Five Traders");
                        System.out.println(bottom_five_traders);
                        break;

                    case 7:
                        System.exit(0);
                        break;


                    default:
                        System.out.println("Enter one of the Options!");
                }
            }
            catch(NumberFormatException err){
                System.out.println("Enter a number!");
            }
        }
    }
}
