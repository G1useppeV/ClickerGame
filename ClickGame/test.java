import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class test {
    static ArrayList<Integer> testing = new ArrayList<Integer>();
    public static void Writer() {
        System.out.println("got here");
        try {
            Reader();
        } catch (IOException e) {
            System.out.println("pp2");
            e.printStackTrace();
        }
    
    try (FileWriter writer = new FileWriter("leader.txt")) {
    
        
        for (int test : testing){
            
            writer.write(test + "\n");

        }
        testing.clear();
        writer.close();
    } catch (IOException e) {
        System.out.println("pp");
        e.printStackTrace();
    }
}


public static void Reader() throws IOException {
    int lines;
  BufferedReader reader = new BufferedReader(new FileReader("leader.txt"));
  String line;
  
  while ((line = reader.readLine()) != null) {
      
      
      lines = Integer.parseInt(line);
       
       testing.add(lines);
        
        
}
System.out.println("Testing:");
System.out.println(testing);
       
        int index = ClickGame.namess.indexOf(ClickGame.name);
        testing.set(index,ClickGame.num);
reader.close();
}
}



