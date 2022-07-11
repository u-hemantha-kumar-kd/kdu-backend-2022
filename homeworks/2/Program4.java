package homework2;

import java.util.Scanner;

public class Program4 {

    public static int startIndexOfLastOccurence(String s1, String s2)
    {
        return s1.lastIndexOf(s2);
    }

    public static String concatenateS1withS2(String s1, String s2, int insertionIndex)
    {
        //if insertionindex is negative, then we append first string s1 to second string s2
        if(insertionIndex < 0)
        {
            s1 = s2.concat(s1);
        }

//        if insertion index is greater than or equal to the length of the string s1, then we append string s2 to s1
        else if(insertionIndex >= s1.length())
        {
            s1 = s1.concat(s2);
        }

        //if insertion index is between the range 0 to s1.length() - 1, then we append s2 after the character at insertion index and then append the remaining substring of s1 to the resulting string

        else {
            String startString= s1.substring(0,insertionIndex + 1);
            String endString = s1.substring(insertionIndex + 1, s1.length());
            s1 = startString;
            s1 = s1.concat(s2);
            s1 = s1.concat(endString);
        }

        return s1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = "Hello, Hi! Hi! How are you?";
        String s2 = "Haha ";


        //Task - 1
        int startIndexOfLastOccurence = startIndexOfLastOccurence(s1, s2);
        if(startIndexOfLastOccurence == -1)
        {
            System.out.println("S2 is not present in S1");
        }
        else {
            System.out.println("S2 has its last occurence at index: "+startIndexOfLastOccurence);
        }



        //Task-2
        int insertionIndex = sc.nextInt();

        String concatenatedString = concatenateS1withS2(s1, s2, insertionIndex);
        System.out.println(concatenatedString);

    }
}
