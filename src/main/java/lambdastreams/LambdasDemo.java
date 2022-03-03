package lambdastreams;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdasDemo {
    public static void main(String[] args) {
        Stream.of(3, 1, 4, 6, 7).forEach(System.out::println);

        Stream.of(3, 13, 12, 2).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        // Define consumer separately
//        Consumer<Integer> printer = n -> System.out.println(n);
        IntConsumer printer = System.out::println;
        Stream.of(3, 1, 4, 6, 1)
                .mapToInt(n -> n)
                .forEach(printer);

        System.out.println();
        Predicate<Integer> mod3 = n -> n % 3 == 0;
        Stream.of(1, 3, 6, 8)
                .filter(mod3)
                .forEach(System.out::println);
    }
}
