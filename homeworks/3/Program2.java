package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program2 {
    public static void main(String[] args) {
        String file = "/home/lenovo/Training/KickdrumJava/src/country-list.csv";
        BufferedReader reader = null;
        String line = "";
        TreeMap<String, String> country_capital_map = new TreeMap<>();


        try {
            int count = 0;

            //reading the csv file and storing the country capital pairs in a map
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null) {

                String[] row = line.split(",");
                if(count < 10)
                {
                    System.out.println(line);
                }
                count++;
                country_capital_map.put(row[0], row[1]);
            }


            //sorting the map
            Map<String, String> sorted_country_capital_map = country_capital_map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));


            System.out.println("Last 10 pairs of Countries and Capitals in Sorted Map");

            int sortPrintCount = 0;
            for(Map.Entry<String, String> entry: sorted_country_capital_map.entrySet())
            {
                if(sortPrintCount < 10)
                {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                    sortPrintCount++;
                }
                else {
                    break;
                }
            }
        }

        catch(Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
