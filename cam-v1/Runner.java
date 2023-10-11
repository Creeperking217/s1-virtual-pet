import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;

public class Runner {
    public static void main(String[] args) {
        VirtualPet p = new VirtualPet();
        p.face.clearMessage();
        p.exercise();
        p.rest(1000);
        p.exercise();
        p.rest(1000);
        p.exercise();
        p.rest(1000);
        p.exercise();
        p.face.clearMessage();

        p.exercise();
        // //p.rest(2000);
        
        // JOptionPane.showMessageDialog(
        //             new JFrame(),
        //             "Hello!",
        //             "???",
        //             JOptionPane.PLAIN_MESSAGE
        //             );
        
        // //VirtualPet p1 = new VirtualPet();
        // //p.rest(2000);
        // JOptionPane.showMessageDialog(
        //             new JFrame(),
        //             "Here is your pet!",
        //             "???",
        //             JOptionPane.PLAIN_MESSAGE
        //             );
        // VirtualPet p = new VirtualPet();
        // p.face.setImage("normal");
        // p.rest(1000);
        // String[] options = {"Bob", "Kyle", "Other"};
        // int selection = JOptionPane.showOptionDialog(new JFrame(), "Select your pet's name:", "Get started!", 
        //                                                   0, 3, null, options, options[0]);
        // String petName;
        // if (selection == 0) {
        //     petName = "Bob";
        // }
        // else if (selection == 1) {
        //     petName = "Kyle";
        // }
        // else if (selection == 2) {
        //     petName = (String)JOptionPane.showInputDialog(
        //         new JFrame(),
        //         "",
        //         "Choose a name ",
        //         JOptionPane.PLAIN_MESSAGE
        //         );
        // }
        // else {
        //     JOptionPane.showMessageDialog(
        //             new JFrame(),
        //             "bruh",
        //             "bruh",
        //             JOptionPane.WARNING_MESSAGE
        //             );
        //             petName = "";
        // }
        // //String petName = getResponse()
        
        // String[] s = {"make them exercise", "feed them", "put them to sleep...", "idk u ask me", "bruh"};
        // int choice = chooseOptions(petName + " is tired", s);
        // System.exit(1);
        
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
