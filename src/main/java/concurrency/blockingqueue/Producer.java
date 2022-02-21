package concurrency.blockingqueue;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {
    private int id;
    private BlockingDeque<Message> queue;

    public Producer(int id, BlockingDeque<Message> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Message m = new Message(i);
            try {
                System.out.printf("Producer %d produced %d %n", id, m.getId());
                queue.put(m);
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            queue.put(new Message(-1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
