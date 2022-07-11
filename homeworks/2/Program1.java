package homework2;

class Credentials{
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name ;
    private int count;

    //since we are using a private constructor, object cannot be instantiated,so we create a public constructor which supplies the default values to the private constructor
    public Credentials(){
        this("Hemanth", 10);
    }

    private Credentials(String name, int count){
        this.name = name;
        this.count = count;
    }

}

public class Program1 {
    public static void main(String[] args) {
        Credentials cr = new Credentials();
        System.out.println("Name: "+cr.getName());
        System.out.println("Count: "+cr.getCount());
    }
}
