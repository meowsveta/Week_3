import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String file = args[0];
        String operation = args[1];
        StringBuilder text = new StringBuilder();
        if (args.length > 2) {
            for (int i = 2; i< args.length; i++ )
             text.append(" ").append(args[i]);
        }

        switch (operation) {
            case "-create" -> create(file);
            case "-write" -> write(file, text.toString());
            case "-delete" -> delete(file);
            case "-read" -> read(file);
        }
    }

    public static void read(String path) throws IOException{ // /Users/svetlanaklimova/Desktop/Week_3/Java8/src/main/java/text.txt -read
        FileReader reader = new FileReader(path);
        while (reader.read() != -1) {
            System.out.print((char)reader.read());
        }
        reader.close();
    }

    public static void write(String path , String text) throws IOException { // /Users/svetlanaklimova/Desktop/Week_3/Java8/src/main/java/text.txt -write test
        FileWriter writer = new FileWriter(path);
        writer.write(text);
        writer.flush();
        writer.close();
    }

    public static void delete(String path){ // /Users/svetlanaklimova/Desktop/Week_3/Java8/src/main/java/text.txt -delete
        File file = new File(path);
        file.delete();
    }

    public static void create(String path) throws IOException { ///Users/svetlanaklimova/Desktop/Week_3/Java8/src/main/java/ -create
        File path1 = new File(path);
        if (path1.isDirectory()){
            Files.createFile(Path.of(path + "test.txt"));
        }
    }

}
