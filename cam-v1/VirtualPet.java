/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VirtualPet {
    
    public VirtualPetFace face;
    public int hunger = 0; 
    public int tiredness = 0;
    public int health = 50;
    String name = "Penguin";
    boolean fighting = false;
    Item[] items = new Item[] {new Item(20, "Candy", 5)};
    Random rand = new Random();
      // how hungry the pet is.
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("happy");
        face.setMessage("");
    }

    public int fight(Opponent opponent) {
        fighting = true;
        int choice = 0;
        while (fighting){
            choice = 0;
            face.newButtonColumn(new String[] {"Fight", "Heal"});
            while (!face.buttonPressed) {
                rest(1);
            }
            for (int i = 0; i < face.buttonStates.length; i++) {
                if (face.buttonStates[i] == 1) {
                    face.clearMessage();
                    choice = i;
                }
            }
            if (choice == 0) {
                face.newButtonColumn(new String[] {"Spin-kick", "Tackle", "Bully"});
                int chose = 1;
                while (chose != 0) {
                while (!face.buttonPressed) {
                rest(1);
                }
                for (int i = 0; i < face.buttonStates.length; i++) {
                    if (face.buttonStates[i] == 1) {
                        face.clearMessage();
                        choice = i;
                    }
                }
                if (choice == 0) {
                    chose = JOptionPane.showConfirmDialog(new JFrame(),
                    "does 50 damage but has a chance to miss", "Do you want to use Spin-kick?",
                    JOptionPane.YES_NO_OPTION);
                }
                else if (choice == 1) {
                    chose = JOptionPane.showConfirmDialog(new JFrame(),
                    "does 20 damage", "Do you want to use Tackle?",
                    JOptionPane.YES_NO_OPTION);
                }
                else {
                    chose = JOptionPane.showConfirmDialog(new JFrame(),
                    "Lowers the opponents stats", "Do you want to use Bully?",
                    JOptionPane.YES_NO_OPTION);
                }
                face.buttonPressed = false;
                }
                face.clearButtons();
                if (choice == 0) {
                    if (rand.nextInt(3) < 2)
                    face.setMessage(name + " used " + "Spin-kick");
                    else
                    face.setMessage(name + " missed");
                }
                else if (choice == 1) {
                    face.setMessage(name + " used " + "Tackle");
                }
                else {
                    face.setMessage(name + " used " + "Bully");
                }
                rest(500);
                face.clearMessage();
                
            }
            else {
                int chose = 1;
                String[] itemNames = new String[items.length];
                for (int i = 0; i < items.length; i++) {
                    if (items[i].invAmt != 0)
                    itemNames[i] = items[i].name + " x " + items[i].invAmt;
                }
                face.newButtonColumn(itemNames);

                while (chose != 0)
                {
                while (!face.buttonPressed) {
                rest(1);
                }
                for (int i = 0; i < face.buttonStates.length; i++) {
                    if (face.buttonStates[i] == 1) {
                        face.clearMessage();
                        choice = i;
                    }
                }
                chose = JOptionPane.showConfirmDialog(new JFrame(),
                    "Will heal " + items[choice].healAmt + "hp", "Use " + items[choice].name + "?",
                    JOptionPane.YES_NO_OPTION);
                    face.buttonPressed = false;
                
                }
                face.buttonPressed = false;
                face.clearButtons();
                face.setMessage(name + " healed " + items[choice].healAmt + "hp");
                items[choice].invAmt --;
                rest(500);
                face.clearMessage();
            }
            face.setMessage(opponent.name + " used " + opponent.attacks[rand.nextInt(opponent.attacks.length)]);
            rest(500);
            face.clearMessage();
        }
        
        return 0;
    }
    
    public void feed() {
        if (hunger > 10) {
            hunger = hunger - 10;
        } else {
            hunger = 0;
        }
        face.setMessage("Yum, thanks");
        face.setImage("normal");
    }
    
    public void exercise() {
        hunger = hunger + 3;
        face.setMessage("1, 2, 3, jump.  Whew.");
        tiredness -= 10;
        if (tiredness > 5)
        face.setImage("tired");
    }
    
    public void sleep() {
        
        hunger = hunger + 1;
        face.setImage("asleep");
    }

    public void rest(int ms) {
        try {
        Thread.sleep(ms);
        } catch (Exception e) {
            
        }
    }
    public void AVATalk(String msg) {
        JOptionPane.showMessageDialog(
                    new JFrame(),
                    msg,
                    "A.V.A.",
                    JOptionPane.PLAIN_MESSAGE
                    );
    }
    

} // end Virtual Pet
