package lambdastreams;


import java.util.stream.IntStream;

public class LazyStreams {
    public static int multipleByTwo(int n){
        System.out.printf("Inside multiple by two with arg: %s%n", n);
        return 2 * n;
    }

    public static void main(String[] args) {

        int firstDoubleDivBy3 = IntStream.range(100, 200)
                .map(LazyStreams::multipleByTwo)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .orElse(999);
        System.out.printf("First double divided by 3 is: %s%n", firstDoubleDivBy3);

    }
}
