import java.io.*;

public class Read {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("output.txt"));
            String s;
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        }catch(Exception ex) {
            return;
        }
    }
}
