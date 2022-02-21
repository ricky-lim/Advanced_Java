package exceptions;

public class MyException extends Exception{
    public MyException() {
        this("My exception");
    }

    public MyException(String message) {
        super(message);
    }
}
