/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VirtualPet {
    
    public VirtualPetFace face;
    public int hunger = 0; 
    public int tiredness = 0;
      // how hungry the pet is.
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("blank");
        face.setMessage("");
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
