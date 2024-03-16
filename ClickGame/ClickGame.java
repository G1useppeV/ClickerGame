import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.FlowLayout;


public class ClickGame {
    static ArrayList<Integer> scores = new ArrayList<Integer>();
JFrame screen = new JFrame();
JFrame newScreen = new JFrame(); // makes the second window
JLabel text2 = new JLabel(); 
JButton start = new JButton();
JButton button = new JButton();
RestartProgram Restart = new RestartProgram();
Counter listener = new Counter(); // counts the number of times button is pressed 
JLabel countdown = new JLabel(); // shows how much time is left 
Start go = new Start(); //controls the start button
JButton restartButton = new JButton();
int t;
int p;
static int num;
int i;
int q;
int pp;
Clip clip = AudioSystem.getClip();
static String name;

int y = 0;
static int kkkk = 0;


String K;
static ArrayList<Integer> unsortedScores = new ArrayList<Integer>();
static ArrayList<String> namess = new ArrayList<String>();
ArrayList<String> blanks = new ArrayList<String>();
Object[][] data = new Object[10][2];

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
        
        new ClickGame(); // creats object 
        
    }

public ClickGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
   GUI();
    //NewWindow();
    
   // fileReader.Reader();
   //NewWindow();
}

public void GUI () throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    
    
 
    
    music();
 

 name = JOptionPane.showInputDialog("Type In a username");

    screen.setSize(500,500);
    screen.setTitle("Clicking Game!");
    screen.getContentPane().setBackground(Color.BLACK); 
    screen.setVisible(true);
    screen.setResizable(false);
    screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    button.setBounds(192, 192, 116, 116);
    button.addActionListener(listener);
    button.setEnabled(false);
    button.setBorder(BorderFactory.createBevelBorder(1, Color.RED, Color.MAGENTA));
    button.setBackground(Color.BLACK);
    button.setVisible(true);
    screen.add(button);
    
    start.setText("Start");
    start.setVisible(true);
    start.setBounds(50, 50, 75, 50);
    start.setBorder(BorderFactory.createBevelBorder(1, new Color(0x1F51FF), new Color(0xc42ffe)));
    start.setForeground(new Color(0xFF3131));
    start.setBackground(Color.BLACK);
    start.setFocusPainted(false);
    start.setEnabled(true);
    start.addActionListener(go);
    screen.add(start);
 
    JLabel text1 = new JLabel();
    text1.setText("Click as fast as you can in 5 seconds!");
    screen.add(text1);
    text1.setBounds(100, 10, 300, 300);
    text1.setVerticalAlignment(JLabel.TOP);
    text1.setHorizontalAlignment(JLabel.CENTER);
    text1.setFont(new Font("Comic Sans",Font.BOLD,14));
    text1.setForeground(Color.CYAN);
   
    
    text2.setText("Clicks: " + num);
    screen.add(text2);
    text2.setBounds(125, 125, 250, 250);
    text2.setForeground(Color.MAGENTA);
   
   countdown.setText("Time Left: "  );
   countdown.setBounds(200, 200, 300, 300);
   countdown.setVisible(true);
   countdown.setForeground(new Color(0xFF10F0));
   screen.add(countdown);   
    }   

    

    public class Counter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            num++;
            text2.setText("Clicks: " + num);
            try {
                ClickAudio();
            } catch (UnsupportedAudioFileException e1) {
                
                e1.printStackTrace();
            } catch (IOException e1) {
                
                e1.printStackTrace();
            } catch (LineUnavailableException e1) {
                
                e1.printStackTrace();
            }

            
        }    
    }
    
    public void Timer() {
        ScheduledExecutorService TimeLeft  = Executors.newSingleThreadScheduledExecutor();
            
            Runnable task = () -> {{ countdown.setText("Time Left: " + (5 - p)); p++; if (p == 6){
                button.setEnabled(false);
            }   }};

            Runnable task5 = () -> {screen.dispose();
                NewWindow();
            };
            
          for (i = 0; i < 6; i++){
            TimeLeft.schedule(task, i, TimeUnit.SECONDS);
          }
          
          TimeLeft.schedule(task5, 7,TimeUnit.SECONDS);
          
     }
     
    public class Start implements ActionListener{
        ScheduledExecutorService MethodDelay = Executors.newSingleThreadScheduledExecutor();
        Runnable task3 = () -> {Timer();
        };
        Runnable task4 = () -> {button.setEnabled(true);
        };

        @Override
        public void actionPerformed(ActionEvent b) {
            if (b.getSource() == start){
                start.setEnabled(false);
                startTimer();
                MethodDelay.schedule(task3, 3, TimeUnit.SECONDS);
                MethodDelay.schedule(task4, 3, TimeUnit.SECONDS);
                   }
                
                
               
            }  
        }   

        public void startTimer() {
            ScheduledExecutorService StartButtonTimer = Executors.newSingleThreadScheduledExecutor();
                
            Runnable task2 = () ->  {{ start.setText("" + (3 - t)); t++; if (t > 3){
                start.setText("GO!");
                start.setForeground(new Color(0xFF3131));
            }
            }};
            for ( q = 0 ; q < 4; q++){
                StartButtonTimer.schedule(task2, q, TimeUnit.SECONDS);
              }
                }

public void NewWindow(){
    
    newScreen.setSize(500,500);
  //  newScreen.setResizable(false);
 
    newScreen.getContentPane().setLayout(new FlowLayout());
   // newScreen.setLocationRelativeTo(null);
    newScreen.setLayout(null);
    
    try {
        Leaderboard();
    } catch (IOException e) {
        
        e.printStackTrace();
    }
    
    JButton restartButton = new JButton();
    restartButton.setText("Restart Game!");
 //   restartButton.setPreferredSize(new Dimension(150,150));
    restartButton.setBounds(50, 50, 150, 150);
    restartButton.addActionListener(Restart);
    
    restartButton.setVisible(true);
    
    newScreen.add(restartButton);
    
    
 //   newScreen.getDefaultCloseOperation();



}


public class RestartProgram implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent c){
        screen.setVisible(true);
        newScreen.setVisible(false);
        t = 0;
        p = 0;
        num = 0;
        q = 0;
        i = 0;
        start.setEnabled(true);
        text2.setText("Clicks: " + num);
        

        
}
}
    
        
public void Leaderboard() throws IOException{

    readers.Reader();
    UnsortedScores.Reader2();

    System.out.println(name);
    System.out.println(namess);
    if (namess.contains(name)){
        

        int x = namess.indexOf(name);
         System.out.println(unsortedScores);
        int y = unsortedScores.get(x);
System.out.println("This gets here");
        
        if (num > y){
            

            test.Writer();
            
            scores.clear();
            namess.clear();
            unsortedScores.clear();
        }
        else{
            scores.clear();
            namess.clear();
            unsortedScores.clear();
            System.out.println("helloooooooo");
            System.out.println(scores);
        }

    }
      else{

        scores.clear();
    namess.clear();
    unsortedScores.clear();

    unsortedScores.add(num);
    namess.add(name);
    scores.add(num);
      }  
    
    
        
    System.out.println("unsortedScores after clear:  " + unsortedScores);
    
    
    
   
    System.out.println("Leaderboard");
    
     for (int i = 0; i < scores.size(); i++){
        System.out.println(scores.get(i));
        
      }
      
          try {
            fileWriter.NameWriter();
        } catch (IOException e) {
            System.out.println("popo");
            e.printStackTrace();
        }
      fileWriter.Writer();
      

      
    

        System.out.println(unsortedScores);

        System.out.println(namess);
        
        
Object[] columnNames = {"Top Scores", "Player"};
    

    
    

    Collections.sort(scores);
    Collections.reverse(scores);  

    Vector<Integer> vector = new Vector<Integer>(scores);
    Set<Integer> set = new HashSet<Integer> (); 
    set.addAll(vector);
    
   // System.out.print(set);

  //  System.out.println(vector);

    

      System.out.println("testing123");
       System.out.println("scores:" + scores);
       System.out.println(scores.get(0));
       System.out.println("unsortedScores:" +unsortedScores);
       int x =  unsortedScores.indexOf(scores.get(0));
         System.out.println(x);
       String xx = namess.get(x);
        System.out.println(xx);
System.out.println("testing123");


ArrayList<Integer> unsortedScores2 = new ArrayList<Integer>(unsortedScores);
ArrayList<String> namess2 = new ArrayList<String>(namess);
System.out.println("Unsorted Scores 2:"+ unsortedScores2);
System.out.println("Unsorted Names 2:"+ namess2);

for (int i = 0; i < 10; i++){
   data[i][0] = scores.get(i);
   data[i][1] = namess2.get(unsortedScores2.indexOf(scores.get(i)));         
   namess2.remove(unsortedScores2.indexOf(scores.get(i)));
     unsortedScores2.remove(unsortedScores2.indexOf(scores.get(i)));
   
}

unsortedScores2.clear();
namess2.clear();



System.out.println("testing123");
for (int i=0; i<data.length; i++){
     System.out.println("got here");
    System.out.println();
    for(int j=0; j<data[i].length; j++){
        System.out.println(data[i][j]+" ");
    }
}
   
   
    JTable table = new JTable(data,columnNames);


    table.getTableHeader().setBounds(200, 50, 150, 50);
    
   
    table.setBounds(200, 100, 150, 300);
    table.setVisible(true);

    newScreen.add(table.getTableHeader());
    newScreen.add(table);

    newScreen.setVisible(true);     
}

public class fileWriter {
    public static void Writer() {
        
        try {
            fileReader.Reader();
        } catch (IOException e) {
            System.out.println("pp2");
            e.printStackTrace();
        }
    
    try (FileWriter writer = new FileWriter("leader.txt")) {
    
        
        for (int score : scores){
            
            writer.write(score + "\n");

        }
    
        writer.close();
    } catch (IOException e) {
        System.out.println("pp");
        e.printStackTrace();
    }
}
    
    //
    
    public static void NameWriter() throws IOException {
        BufferedReader reader2;
        
            reader2 = new BufferedReader(new FileReader("\\Users\\giuse\\Documents\\steel hawks\\ClickGame\\names.txt"));
       
        String line;
        
        while ((line = reader2.readLine()) != null) {
             
         
             namess.add(line);
        }

            
            reader2.close();
            try (FileWriter writer2 = new FileWriter("names.txt")) {
       
        
        
        
                for (String name : namess){
                    
                    writer2.write(name + "\n");
        
                }
            
                writer2.close();
            } catch (IOException e) {
                System.out.println("pp");
                e.printStackTrace();
            }


//
    
}
}


class fileReader{
    
    public static void Reader() throws IOException {
          int lines;
        BufferedReader reader = new BufferedReader(new FileReader("leader.txt"));
        String line;
        
        while ((line = reader.readLine()) != null) {
            
            
            lines = Integer.parseInt(line);
             
            
             ClickGame.scores.add(lines);
             
             ClickGame.unsortedScores.add(lines);
             
             
}


      //  System.out.println(scores);

        reader.close();
    }
}

  public static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            
            File file = new File("Mario.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-15.0f); // Reduce volume by 10 decibels.
        
        clip.loop(Clip.LOOP_CONTINUOUSLY);
       
        clip.start();
     
        
    
            
           }
    
           public static void ClickAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
           File file = new File("\\Users\\giuse\\Downloads\\punch-gaming-sound-effect-hd_RzlG1GE.wav");
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
           Clip clip = AudioSystem.getClip();
           clip.open(audioStream);
           FloatControl gainControl = 
        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
           
    
           clip.start();
    
           }
        }


   
    
       
    

      




 

// goals 
// make it open up a new window to say how mmany clicks and to show the high scores. 
// then show a restart button so it can go again
        
        //labels 

        //make a dice roller
        //add audio
        //learn method ovveride 
        
    
       //make a choicein the start of the game if someone would like to save thier name 
        







