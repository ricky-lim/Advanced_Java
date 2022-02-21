package generics;

public class PairDemo {
    public static void main(String[] args) {
        Pair<Integer> p1 = new Pair<>(1, 3);
        p1 = p1.swap();
        System.out.println(p1);

        Pair<Integer> p2 = new Pair<>(5, 9);
        Pair.swap(p2);
        System.out.println(p2);
    }
}
