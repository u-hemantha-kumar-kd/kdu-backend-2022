package homework2;

class Credentials{
    private String name ;
    private int count;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    //    static Credentials obj = new Credentials();
    private Credentials(){
        this.name = "Hemanth";
        this.count = 20;
    }


    public static Credentials getInstance()
    {
        return new Credentials();
    }

}

public class Program1 {
    public static void main(String[] args) {
        Credentials cr = Credentials.getInstance();
        System.out.println("Name: "+cr.getName());
        System.out.println("Count: "+cr.getCount());
    }
}
