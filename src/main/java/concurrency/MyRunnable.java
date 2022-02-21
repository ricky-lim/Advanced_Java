package concurrency;

public class MyRunnable implements Runnable{
    private int id;
    private Thread thread = new Thread(this);

    public MyRunnable(int id){
        this.id = id;
    }

    public void start(){
        thread.start();
    }

    @Override
    public void run() {
        System.out.printf("Hello from my runnable: %s %n", this);
    }

    @Override
    public String toString() {
        return String.format("MyRunnable{id=%d}", id);
    }
}
