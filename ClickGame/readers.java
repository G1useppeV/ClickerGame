import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readers {
    public static void Reader() throws IOException{
    BufferedReader reader3;
        
    reader3 = new BufferedReader(new FileReader("\\Users\\giuse\\Documents\\steel hawks\\ClickGame\\names.txt"));

String line;

while ((line = reader3.readLine()) != null) {
     
 
     ClickGame.namess.add(line);
}
reader3.close();
    }
}
