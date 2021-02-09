import java.io.*;

public class Write {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("output.txt"));
            bw.write("Raleigh\n");
            bw.write("San Antonio\n");
            bw.write("New York");
            bw.close();
        }catch(Exception ex) {
            return;
        }
    }
}

