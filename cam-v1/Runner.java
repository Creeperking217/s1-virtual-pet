import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;

public class Runner {
    public static String[] words = {"A","B","C","D","E"};
    public static void main(String[] args) {
        
        VirtualPet p = new VirtualPet();
        
        //p.face.newButtonColumn(new String[] {"a", "b", "c"});
        p.fight(new Opponent("slime", 50, new String[] {"slime", "tackle", "bounce"}, null));
        p.face.clearMessage();
        p.exercise();
        p.rest(1000);
        p.exercise();
        p.rest(1000);
        p.exercise();
        p.rest(1000);
        p.exercise();
        p.face.clearMessage();
        
        // int c = askQuestion("what do you choose", new String[] {"jfdklajflkadkj;fa", "me", "ok"}, p);
        // System.out.println(c);
        // p.face.clearButtons();
        // p.exercise();
        // p.rest(1000);
        // p.exercise();
        // p.exercise();
        
        //int outcome = p.fight();
    }

    public static int askQuestion(String q, String[] choices, VirtualPet p) {
        p.face.newButtons(3);
        p.face.buttonStates = new int[choices.length];
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

    public String getResponse(String title, String question) {
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
