package concurrency.blockingqueue;

public final class Message {
    private int id;

    public int getId() {
        return id;
    }

    public Message(int id) {
        this.id = id;
    }
}
