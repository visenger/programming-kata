package de.bhtb.external.data.files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathPlayground {

    public static void main(String... args) {

        Path path = Paths.get("/Users/visenger/IdeaProjects/LEHRE/src/main/resources/sonne.txt");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,3): %s%n", path.subpath(0, 3));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());
    }
}
