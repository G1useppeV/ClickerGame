import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UnsortedScores {
    public static void Reader2() throws IOException {
        int lines;
      BufferedReader reader = new BufferedReader(new FileReader("leader.txt"));
      String line;
      
      while ((line = reader.readLine()) != null) {
          
          
          lines = Integer.parseInt(line);
     
           ClickGame.unsortedScores.add(lines);        
}
      reader.close();
  }
}
