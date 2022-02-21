package interfaces.defaults;

public interface Employee {
    String getFirstName();
    String getLastName();
    void work();
    default String getName(){
        return getFirstName() + " " + getLastName();
    }
}
