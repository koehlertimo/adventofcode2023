import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private ArrayList<String> lines = new ArrayList<>();
    private String path;

    public FileReader(String path) {
        this.path = path;
    }

    public ArrayList<String> getInput() {
        File inputFile = new File(path);
        try (Scanner sc = new Scanner(inputFile)) {
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return lines;
    }
}
