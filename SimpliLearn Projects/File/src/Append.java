import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Append {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("output2.txt", false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Hello world, its a new dawn");
            pw.close();
        }catch (IOException e) {

            e.printStackTrace();
        }
    }
}
