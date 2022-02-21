package interfaces.defaults;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultMethodsDemo {
    public static void main(String[] args) {
//        List<Integer> nums = Stream.of(-3, -1, 0, 10, 2).collect(Collectors.toList());
        List<Integer> nums = Stream.of(10, 2).collect(Collectors.toList());
        System.out.println(nums);

        boolean removed = nums.removeIf(n -> n <= 0);
        System.out.println("Elements are " + (removed ? "": "NOT ") + "removed");
        System.out.println(nums);

        nums.forEach(System.out::println);
    }
}
