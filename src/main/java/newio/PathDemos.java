package newio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemos {
    public static void main(String[] args) {
        Path projectDir = Paths.get(".");
        System.out.println(projectDir.toAbsolutePath());
        System.out.println("As a URI " + projectDir.toUri());

        for (Path path : projectDir.toAbsolutePath()) {
            System.out.println(path);
        }

        File localDir = new File("..");
        System.out.println(localDir.toPath().toAbsolutePath());

    }
}
