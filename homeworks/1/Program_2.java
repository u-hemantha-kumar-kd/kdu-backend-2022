package homework1;
import java.util.*;

public class Program_2 {
    public static void divisibleBy3(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            if(i % 3 == 0)
            {
                System.out.print(i + ", ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number until which you want to print divisibles of 3:");
        int n = sc.nextInt();
        divisibleBy3(n);
    }
}
