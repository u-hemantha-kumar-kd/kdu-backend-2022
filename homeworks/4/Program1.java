package homework4;

import java.util.*;
import java.util.stream.Collectors;

class Product{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    Product(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return this.name + "->"+ this.price;
    }

    public boolean hasPriceOverFifty()
    {
        return this.price > 50;
    }

}

public class Program1 {


    public static double getAveragePriceOfTheProducts(Product [] products){
        int sum = 0;
        return Arrays.stream(products)
                .mapToInt(product -> product.getPrice())
                .average().orElse(0);

    }

    public static void main(String[] args) {
        Product [] products =new Product[]{
                new Product("Sugar", 10),
                new Product("Dal", 70),
                new Product("Oil", 10),
                new Product("Tea", 60),
                new Product("Coffee", 20)
        };

        Product maximumByPrice = Arrays.stream(products)
                .max(Comparator.comparing(Product::getPrice))
                .orElseThrow(NoSuchElementException::new);
        Product minimumByPrice = Arrays.stream(products)
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(NoSuchElementException::new);

        boolean priceMoreThan100 = Arrays.stream(products).anyMatch(product -> product.getPrice() > 100);
        boolean priceMoreThan50 = Arrays.stream(products).anyMatch(product -> product.getPrice() > 50);
        boolean priceEndsWithZero =Arrays.stream(products).allMatch(product -> product.getPrice() % 10 == 0);
        List<Product> productsWithPriceMoreThan50 = Arrays.stream(products)
                .filter(Product::hasPriceOverFifty)
                .collect(Collectors.toList());
        List<Product> sortedList = Arrays.stream(products)
                .sorted( (i1, i2) -> i1.getPrice() - i2.getPrice())
                .collect(Collectors.toList());

        Map<Integer, Long> counting = Arrays.stream(products).collect(
                Collectors.groupingBy(Product::getPrice, Collectors.counting()));

        double sumAfter25Increase =  Arrays.stream(products)
                .map(x -> 1.25 * x.getPrice()).reduce(0.0, (a, b) -> a + b);


        System.out.println(maximumByPrice);
        System.out.println(minimumByPrice);
        System.out.println("Products have price more than 100 : " +priceMoreThan100 );
        System.out.println("Products have rice more than 50: "+priceMoreThan50);
        System.out.println("Products price ends with zero: "+priceEndsWithZero);
        System.out.println("Products with price More than 50: " +productsWithPriceMoreThan50);
        System.out.println("Sorted Array of Products: "+ sortedList);
        System.out.println("Count of Products having same Price: "+counting);
        System.out.println("Average Price of the Products: "+getAveragePriceOfTheProducts(products));
        System.out.println("Sum Of the prices after the Product prices is increased by 25%: "+sumAfter25Increase);
    }
}
