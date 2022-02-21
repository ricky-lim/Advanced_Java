package generics;

public class TupleDemo {
    public static void main(String[] args) {
        Tuple<Integer, Integer> t = new Tuple<>(1, 3);
        System.out.println(t);
        Tuple<Integer, String> u = new Tuple<>(1, "Ricky");
        System.out.println(u);
    }
}
