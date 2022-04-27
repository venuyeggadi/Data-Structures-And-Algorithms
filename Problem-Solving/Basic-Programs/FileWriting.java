import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

class FileWriting {
    public static void main(String[] args) throws IOException{
        FileWriter fw = new FileWriter("text1.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Hey hello\n");
        bw.write("What the\n");
        bw.close();
    }
}