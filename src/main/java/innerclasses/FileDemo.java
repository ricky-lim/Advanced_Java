package innerclasses;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;

public class FileDemo {
    public static void main(String[] args) {
        File dir = new File("src/main/java/innerclasses");
        for (String name: dir.list()) {
            System.out.println(name);
        }

        System.out.println("\nOnly Java files:");
        for (String name: dir.list(new JavaFilter())) {
            System.out.println(name);
        }

        System.out.println("\nOnly Java files with inner class");
        for (String name: Objects.requireNonNull(dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                return name.endsWith(".txt");
            }
        }))) {
            System.out.println(name);
        }


    }
}
