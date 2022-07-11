package homework2;

import java.util.Scanner;

public class Program3 {

    public static void removeDuplicateCharacters(String str)
    {
        int n = str.length();
        str = str.toLowerCase();
        boolean [] isPresent = new boolean[26];
        for(int i = 0; i<n; i++)
        {
            char character = str.charAt(i);
            isPresent[character - 'a'] = true;
        }

        for(int i = 0; i<n; i++)
        {
            char character = str.charAt(i);
            if(isPresent[character - 'a'])
                System.out.print(character);
            isPresent[character - 'a'] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        removeDuplicateCharacters(str);
    }
}
