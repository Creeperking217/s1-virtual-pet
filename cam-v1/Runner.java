import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;

public class Runner {
    public static String[] words = {"A","B","C","D","E"};
    public static void main(String[] args) {
        
        VirtualPet p = new VirtualPet();
        int c = askQuestion("Do you want to play [GAME NAME]?", new String[] {"yes", "no"}, p);
        if (c == 1) {
            p.face.setMessage("bruh");
            System.exit(0);
        }
        p.face.clearButtons();
        p.face.clearMessage();
        p.face.setMessage("Nice");
        p.rest(500);
        p.face.clearMessage();
        p.face.setMessage("Please tell me what your name is");
        p.rest(100);
        p.name = getResponse("What is your name?", "Tell me");
        if (p.name == null) {
            p.name = getResponse("Bruh tell me", "Tell me rn");
            if (p.name == null) {
                p.name = getResponse("Pleassse?", "plssssssss");
                if (p.name == null) {
                    p.name = getResponse("Last chance", "Really man...");
                    if (p.name == null) {
                        p.face.clearMessage();
                        p.face.setMessage("fine them >:(");
                        System.exit(0);
                    }
                }
            }
        }
        p.face.clearMessage();
        p.face.setMessage("Hello, " + p.name + "!");
        p.rest(500);
        p.face.clearMessage();
        p.face.setMessage("Welcome to [GAME NAME]!");
        p.rest(500);
        p.face.clearMessage();
        p.face.setMessage("Your experience starts...");
        p.rest(750);
        p.face.clearMessage();
        p.face.setMessage("...");
        p.rest(600);
        p.face.clearMessage();
        p.face.setMessage("NOW");
        p.face.cameraShake(40, 50);
        p.face.setImage("idle");
        p.face.cameraShake(20, 50);
        
        
        // System.out.println(c);
        // p.face.clearButtons();
        // p.exercise();
        // p.rest(1000);
        // p.exercise();
        // p.exercise();
        
        //int outcome = p.fight();
    }

    public static int askQuestion(String q, String[] choices, VirtualPet p) {
        p.face.newButtons(choices.length);
        p.face.buttonStates = new int[choices.length];
        p.face.setMessage(q);
        for (int i = 0; i < choices.length; i++) {
            p.face.setMessage(words[i] + ". " + choices[i]);
        }
        while (!p.face.buttonPressed) {
            p.rest(1);
        }
        for (int i = 0; i < p.face.buttonStates.length; i++) {
            if (p.face.buttonStates[i] == 1) {
                p.face.clearMessage();
                return i;
            }
        }
        p.face.clearMessage();
        return 0;
    }

    public static String getResponse(String title, String question) {
        return (String)JOptionPane.showInputDialog(
                new JFrame(),
                title,
                question,
                JOptionPane.PLAIN_MESSAGE
                );
    }

    public static int chooseOptions(String q, String[] options) {
        return JOptionPane.showOptionDialog(new JFrame(), q, "petraiser.exe", 
                                                          0, 3, null, options, options[0]);
    }

    
}
