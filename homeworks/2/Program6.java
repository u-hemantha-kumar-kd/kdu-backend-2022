package homework2;

import java.util.Scanner;


class ParallelLinesException  extends Exception
{
    public ParallelLinesException (String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}
class Line{
    int m;
    int c;
    Line(int m, int c)
    {
        this.m = m;
        this.c = c;
    }
}

public class Program6 {

    static void checkIfParallel(Line l1, Line l2) throws ParallelLinesException
    {
        //parallel lines
        if(l1.m == l2.m && l1.c != l2.c)
        {
            throw new ParallelLinesException("Two lines are parallel!");
        }
        else {
            double x = (l2.c - l1.c)/(l1.m - l2.m);
            double y = l1.m * x  + l1.c;
            System.out.println("Point of Intersection is: (" +x + ","+y+")");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter slope and y-intercept for line - 1");
        int m1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.println("Enter slope and y-intercept for line- 2");
        int m2 = sc.nextInt();
        int c2 = sc.nextInt();

        Line l1 = new Line(m1, c1);
        Line l2 = new Line(m2, c2);

        try{
            checkIfParallel(l1, l2);
        }
        catch(ParallelLinesException ex){
            System.out.println("Caught the exception");
            // printing the message from ParallelLinesException object
            System.out.println("Exception occured: " + ex);
        }
        finally{
            sc.close();
        }
    }
}
