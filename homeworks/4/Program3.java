package homework4;

class Notify1 extends Thread {
    public void run() {
        synchronized (this) {
            System.out.println("Starting of " + Thread.currentThread().getName());
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "...notified");
        }
    }
}

class Notify2 extends Thread {

    public void run() {
        synchronized (this) {
            System.out.println("Starting of " + Thread.currentThread().getName());
            try {
                this.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "...notified");
        }
    }
}


class Notify3 extends Thread {
    Notify1 notify1;
    Notify3(Notify1 notify1) {
        this.notify1 = notify1;
    }

    public void run() {
        synchronized (this.notify1) {
            System.out.println("Starting of " + Thread.currentThread().getName());
            // call the notify() method
            this.notify1.notify();
            System.out.println(Thread.currentThread().getName() + "...notified");
        }
    }
}

public class Program3 {
    public static void main(String[] args) throws InterruptedException {
        Notify1 notify1 = new Notify1();
        Notify2 notify2 = new Notify2();
        Notify3 notify3 = new Notify3(notify1);

        // creating the threads
        Thread t1 = new Thread(notify1, "Thread-1");
        Thread t2 = new Thread(notify2, "Thread-2");
        Thread t3 = new Thread(notify3, "Thread-3");

        // call run() method
        t1.start();
        Thread.sleep(1000);
        t3.start();
        t1.join();
        t2.start();

    }
}