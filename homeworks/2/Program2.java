package homework2;

import java.util.Scanner;

public class Program2 {

    public static void repeatingCharacters(String str, int n)
    {
        int [] count = new int[26];

        str = str.toLowerCase();

        for(int i = 0; i<n; i++)
        {
            char character = str.charAt(i);
            count[character - 'a'] += 1;
        }

        for(int i = 0; i<26; i++)
        {
            if(count[i] > 1)
            {
                char character =  (char)(i + 'a');
                System.out.println(character + " -> " + count[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        repeatingCharacters(str, n);
    }
}
