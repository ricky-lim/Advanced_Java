package generics.repairables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepairShopDemo {
    public static void main(String[] args) {
        RepairShop.fixAll(Arrays.asList(
                new TV(), new Radio(), new Microwave()
        ));
    }
}
