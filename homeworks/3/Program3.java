package homework3;

import java.sql.Array;
import java.util.ArrayList;

//user defined class example of generics
class MyClass <T>{
    T data;
    MyClass(T data)
    {
        this.data = data;
    }
    public T getData()
    {
        return this.data;
    }
}

public class Program3 {

    //Generic method
    public static <T> void printArray(T[] inputArray ) {
        for(T element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyClass<Integer> myClass = new MyClass<>(10);
        MyClass<String> myClass1 = new MyClass<>("Hemanth");
        System.out.println(myClass.getData());
        System.out.println(myClass1.getData());
        System.out.println();

        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("Array integerArray contains:");
        printArray(intArray);

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray);

        System.out.println("\nArray characterArray contains:");
        printArray(charArray);


        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        listOfNumbers.add(1);
        listOfNumbers.add(2);
        listOfNumbers.add(3);
        listOfNumbers.add(4);
        listOfNumbers.add(5);

        System.out.println("Arraylist of Integers");
        System.out.println(listOfNumbers);


        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Hello");
        listOfStrings.add("Good");
        listOfStrings.add("Morning");
        listOfStrings.add("Everyone");
        System.out.println("ArrayList of Strings");
        System.out.println(listOfStrings);

    }
}
