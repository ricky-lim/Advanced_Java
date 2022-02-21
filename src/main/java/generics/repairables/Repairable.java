package generics.repairables;

public interface Repairable {
    default void fix(){
        System.out.println(getClass().getName() + " is fixed");
    }
}
