import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int LENGTH_OF_SYMBOLS = 15;
    public static void main(String[] args) throws IOException {
        String numbers = "";
        try (FileReader fileReader = new FileReader("D:\\Courses\\Valid document numbers\\Document numbers.txt")) {
            int i;
            while ((i = fileReader.read()) != -1) {
                numbers = numbers + (char) i;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] number = numbers.split("\n");

        try (
                FileWriter fileWriter = new FileWriter("D:\\Courses\\Valid document numbers\\Valid documents.txt");
                FileWriter fileWriter1 = new FileWriter("D:\\Courses\\Valid document numbers\\Invalid documents.txt")
        ) {

            for (int i = 0; i < number.length; i++) {
                Pattern pattern = Pattern.compile("^[docnum&&[0-9a-zA-Z]]");
                Matcher matcher = pattern.matcher(number[i]);
                if (matcher.find()) {
                    fileWriter.write(number[i]);
                    fileWriter.flush();

                }else {
                    fileWriter1.write(number[i]);
                    fileWriter1.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
