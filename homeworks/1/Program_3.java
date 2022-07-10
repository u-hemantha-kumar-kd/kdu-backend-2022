package homework1;
import java.util.*;

public class Program_3  {
    public static boolean isPalindrome(String str)
    {
        int i = 0, j = str.length() - 1;

        while(i < j)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String str = sc.next();
        boolean ans = isPalindrome(str);
        if(ans)
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not Palindrome");
        }
    }
}
