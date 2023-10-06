import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;

public class Runner {
    public static void main(String[] args) {
        VirtualPet p = new VirtualPet();
        p.rest(2000);
        
        JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Hello!",
                    "???",
                    JOptionPane.PLAIN_MESSAGE
                    );
        JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Welcome to PetRaiser!",
                    "???",
                    JOptionPane.PLAIN_MESSAGE
                    );
        JOptionPane.showMessageDialog(
                    new JFrame(),
                    "My name is A.V.A., or AI Virtual Assistant",
                    "???",
                    JOptionPane.PLAIN_MESSAGE
                    );
        p.AVATalk("Here is your pet");
        p.face.setImage("normal");
        p.rest(1000);
        String[] options = {"Bob", "Kyle", "Other"};
        int selection = JOptionPane.showOptionDialog(new JFrame(), "Select your pet's name:", "Get started!", 
                                                          0, 3, null, options, options[0]);
        String petName;
        if (selection == 0) {
            petName = "Bob";
        }
        else if (selection == 1) {
            petName = "Kyle";
        }
        else if (selection == 2)
        {
            petName = (String)JOptionPane.showInputDialog(
                new JFrame(),
                "",
                "Choose a name ",
                JOptionPane.PLAIN_MESSAGE
                );
        }
        //String petName = getResponse()
        
                    
        JOptionPane.showMessageDialog(new JFrame(), "asjkfhksdjfaksdfjlashfskldjfaslfjdhfaf", "Terms and Conditions", JOptionPane.PLAIN_MESSAGE);
        
    }

    public String getResponse(String title, String question) {
        return (String)JOptionPane.showInputDialog(
                new JFrame(),
                title,
                question,
                JOptionPane.PLAIN_MESSAGE
                );
    }

    
}
