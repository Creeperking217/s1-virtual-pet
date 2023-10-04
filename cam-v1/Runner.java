import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;

public class Runner {
    public static void main(String[] args) {
        VirtualPet p = new VirtualPet();
        p.feed();

        JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Your Message",
                    "Your Title",
                    JOptionPane.PLAIN_MESSAGE
                    );

        String s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "Your Message",
                    "Your Title",
                    JOptionPane.PLAIN_MESSAGE
                    );
    }
}
