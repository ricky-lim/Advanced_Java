package concurrency;

public class MyThread extends Thread{
    private int id;

    public MyThread(int id){
        this.id = id;
    }

    @Override
    public void run(){
        System.out.printf("Hello from %s %n", this);
    }

    @Override
    public String toString() {
        return String.format("MyThread{id=%d}", id);
    }
}
