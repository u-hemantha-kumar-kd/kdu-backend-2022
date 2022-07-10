package homework1;

public class Program_1 {

    public static void progone(int n)
    {
        int a = 1, b = 4, c = 7;
        int d = a + b + c;

        System.out.print(a + " " + b + " " + c + " ");

        while(d < n)
        {
            System.out.print(d + " ");
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
    }

    public static void progtwo(int n)
    {
        for(int i = 1; ; i++)
        {
            if(i % 4 != 0)
            {
                int sq = i * i;
                if(sq <= n)
                    System.out.print(sq + " ");
                else break;
            }
        }
    }



    public static void progthree(int n)
    {
        int i = 1, j = 1;
        if (n > 0) {
            while (i <= n) {
                if (j % 3 != 0) {
                    System.out.print(i + " ");
                    i = i + 4 * j;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        progone(n);
        System.out.println();
        progtwo(n);
        System.out.println();
        progthree(n);
        System.out.println();
    }
}
