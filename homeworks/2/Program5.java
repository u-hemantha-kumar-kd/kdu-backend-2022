package homework2;

import java.io.*;
import java.util.Scanner;

public class Program5 {

    public static void checkForIOException(){
        String file1 = "/home/lenovo/Training/KickdrumJava/src/hello.txt";
        String file2 = "/home/lenovo/Training/KickdrumJava/src/unavailablefile.txt";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file2));
            while((line = reader.readLine()) != null) {

                String[] row = line.split(",");

                for(String index : row) {
                    System.out.printf("%-20s", index);
                }
                System.out.println();
            }
        }
        catch(IOException e) {
            System.out.println("Caught IOException, not able to access file!");
        }
        finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println("Not able to close the reader!");
            }
        }
    }

    public static void checkForNumberFormatException(){
        String str = "hello";

        try{
            int number = Integer.parseInt(str);
            System.out.println("Converted the String into a number");
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Not able to convert invalid string to a number");
        }
    }

    public static void checkForArithmeticException() {
        int a = 5;
        int b = 0;
        try
        {
            System.out.println(a/b);

        }
        catch (ArithmeticException ex)
        {
            System.out.println("Not able to divide a number by zero, it causes Arithmetic Exception");
        }
    }

    public static void checkForArrayIndexOutOfBoundsException() {
        int [] arr = {1, 2, 3, 4, 5};

        try{
            for(int i = 0; i<=arr.length; i++)
            {
                System.out.println(arr[i]);
            }
        }catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Invalid index, Please adjust your looping variable");
        }
    }

    public static void checkForMultipleTryCatchBlocks(){
        try {
            int a[] = {30, 45, 60, 75, 90, 105, 120, 140, 160, 200};

            System.out.println("Element at index 8 = "+a[8]);

            try {
                System.out.println("Division");
                int res = 100/ 0;
            }
            catch (ArithmeticException ex2) {
                System.out.println("Division by zero isn't possible!");
            }
            finally{
                System.out.println("Inside finally of inner try-catch-finally block");
            }
        }
        catch (ArrayIndexOutOfBoundsException ex1) {
            System.out.println("ArrayIndexOutOfBoundsException Exception occured!");
        }
        finally{
            System.out.println("Inside finally of outer try-catch-finally block");
        }

    }

    public static void main(String[] args) {
        checkForIOException();
        checkForNumberFormatException();
        checkForArithmeticException();
        checkForArrayIndexOutOfBoundsException();
        checkForMultipleTryCatchBlocks();
    }
}
