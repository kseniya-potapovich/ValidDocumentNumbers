import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String numbers = "";
        try (FileReader fileReader = new FileReader("D:\\Courses\\Valid document numbers\\Document numbers")) {
            int i;
            while ((i = fileReader.read()) != -1) {
                numbers = numbers + (char) i;
            }
        } catch (IOException e) {
            System.out.println(e);
        }


    }
}
