package innerclasses;

public class UseInnerClasses {
    public static void main(String[] args) {
        new Outer().new Inner().myMethod();
        new Outer.InnerStatic().myMethod();
    }

}
