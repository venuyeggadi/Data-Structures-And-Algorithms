import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

class FileReading {
    public static void main(String[] args)throws IOException {
        FileReader fr = new FileReader("text.txt");
        BufferedReader br = new BufferedReader(fr);
        //#1
        String str;
        while((str = br.readLine()) != null) {
            System.out.println(str);
        }
        System.out.println();
        fr.close();
        
        //#2
        File file = new File("text.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        System.out.println();
        sc.close();

        //#3
        File file1 = new File("text.txt");
        Scanner sc1 = new Scanner(file1);
        sc1.useDelimiter("\\Z");
        System.out.println(sc1.next());
        sc1.close();
    }
}
