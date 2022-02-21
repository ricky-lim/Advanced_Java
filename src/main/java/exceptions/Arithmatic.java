package exceptions;

public class Arithmatic {

    public static void main(String[] args) {
        int a = 3;
        int b = 0;

        double result = 0;
        try {
            result = a / b;
        } catch (Exception ignored) {
            result = Float.POSITIVE_INFINITY;
        }

        System.out.println(String.format("%d / %d = %f", a, b, result));

        try {
            throw new MyException("This is my issue!");
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }
}
