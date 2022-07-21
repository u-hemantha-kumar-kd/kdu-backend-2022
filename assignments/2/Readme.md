# Crypto Trading Application

## Problem Statement
The aim of this project was to build a crypto based trading application that can help user's with information needs such as getting list of top fifty coins based on price, top five traders and bottom five traders based on the profit/loss that they have made etc.

## Project Directory
- `csv-files` folder consists of CSV files that will be used to build the Application Structure classes into memory during execution.
- `json-files` folder consists of JSON files that will be used to do transactions during execution.
- `src` folder consists of the source code

## Setup
1. Open this root directory in IntelliJ IDE
2. Click Run `src/main/java/com.cryptoTradingInfo/client/MainClass.java`

## About the Project
The project has been built by designing the application structure using object oriented modelling principles consisting of classes such as Trader, Coin etc.

The Project mainly consist of 5 packages - client, entities, exceptions, readFiles, threads. 

client package consists of a MainClass that will be used by the user to interact with the system.

entities package consists of the main entities of the system like Trader and Coin.

exceptions package consists of Classes that will be used for Exception Handling.

readfiles package is used for reading the csv files and json files and the processing logic for updating the transactions.

threads package consists of TransactionThread class and TransactionThreadUtils class that are responsible for providing the logic for the transaction methods like buyCoins, sellCoins, updatePrice and addVolume etc.

The outputs are printed on the console in an interactive manner providing the user with a list of options to choose from.

For any further information, detailed documentation is present in the source code files.