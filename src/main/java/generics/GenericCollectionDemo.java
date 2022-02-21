package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericCollectionDemo {

    public void noGenerics(){
        List nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
//        nums.add("hello");

        for (Object num : nums) {
            Integer n = (Integer) num;
            System.out.println(n);
        }

    }

    public void genericsList(){
        List<Integer> nums = new ArrayList<>();
        nums.add(1); nums.add(2);
//        nums.add("hello");
        nums.forEach(System.out::println);

    }

    public static void main(String[] args) {
        GenericCollectionDemo genericCollectionDemo = new GenericCollectionDemo();
        genericCollectionDemo.noGenerics();
        genericCollectionDemo.genericsList();

    }

}
