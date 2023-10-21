/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class VirtualPet {
    
    public int bulliedAristotle = 0;
    public int bulliedSocrates = 0;
    public VirtualPetFace face;
    public int hunger = 0; 
    public int tiredness = 0;
    public int health = 50;
    public int maxHealth = 50;
    public int strength = 0;
    
    int health1;
    public String name = "Penguin";
    boolean fighting = false;
    Item[] items = new Item[] {new Item(30, "Candy", 0)};
    public String mood = "idle"; 
    Random rand = new Random();
      // how hungry the pet is.
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("idle");
        face.setMessage("");
    }

    public int fight(Opponent opponent) { 
        face.timer.setDelay(100);
        face.timer.restart();
        face.setImage(opponent.spriteName);
        face.setMessage(opponent.name + " approaches...");
        
        
        //face.delay = 100;
        face.clearMessage();
        face.clearButtons();
        fighting = true;
        health1 = opponent.health;
        int choice = 0;
        face.setInstantMessage("HP: " + health + " / " + maxHealth);
        while (fighting){
            choice = 0;
            face.newButtonColumn(new String[] {"Fight", "Heal"});
            while (!face.buttonPressed) {
                rest(1);
            }
            for (int i = 0; i < face.buttonStates.length; i++) {
                if (face.buttonStates[i] == 1) {
                    //face.clearMessage();
                    choice = i;
                }
            }
            face.clearButtons();
            boolean usedItems = false;
            if (choice == 0) {
                //face.clearButtons();
                face.newButtonColumn(new String[] {"Spin-kick", "Tackle", "Bully"});
                int chose = 1;
                while (chose != 0) {
                while (!face.buttonPressed) {
                rest(1);
                }
                for (int i = 0; i < face.buttonStates.length; i++) {
                    if (face.buttonStates[i] == 1) {
                        //face.clearMessage();
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
                face.clearMessage();
                face.clearButtons();
                if (choice == 0) {
                    if (rand.nextInt(3) < 2) {
                        face.setImage("spinkick");
                        //face.timer.restart();
                        face.setMessage(name + " used " + "Spin-kick");
                        rest(100);
                        face.cameraShake(30, 10);
                        face.setImage(opponent.spriteName);
                        //face.timer.restart();
                        if (strength < 2)
                        damageOpponent(50, opponent);
                        else 
                        damageOpponent(75, opponent);
                        rest(100);
                        if ( health1 == 0) {
                            face.clearMessage();
                            face.setMessage(opponent.name + " has been defeated");
                            rest(100);
                            face.timer.setDelay(400);
                            return 1;
                        }
                    }
                    else
                    face.setMessage(name + " missed");
                }
                else if (choice == 1) {
                    face.setMessage(name + " used " + "Tackle");
                        rest(100);
                        face.cameraShake(20, 5);
                        if (strength < 2)
                        damageOpponent(20, opponent);
                        else 
                        damageOpponent(30, opponent);
                        rest(100);
                        if (health1 == 0) {
                            face.clearMessage();
                            face.setMessage(opponent.name + " has been defeated");
                            rest(100);
                            face.timer.setDelay(400);
                            return 1;
                        }
                }
                else {
                    face.setMessage(name + " used " + "Bully");
                        rest(100);
                        face.cameraShake(15, 2);
                        if (strength < 2)
                        damageOpponent(10, opponent);
                        else 
                        damageOpponent(15, opponent);
                        rest(100);
                        if (health1 == 0) {
                            face.clearMessage();
                            face.setMessage(opponent.name + " has been defeated");
                            rest(100);
                            face.timer.setDelay(400);
                            return 1;
                        }
                }
                rest(500);
                face.clearMessage();

                
                
            }
            
            else if (checkItems()){
                usedItems = true;
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
                damagePlayer(-items[choice].healAmt);
                items[choice].invAmt --;
                rest(500);
                face.clearMessage();
            }
            else {
                usedItems = true;
                face.setMessage("You have no items");
            }

            if (!usedItems) {
                int atk = rand.nextInt(opponent.attacks.length);
                face.setMessage(opponent.name + " used " + opponent.attacks[atk]);
                damagePlayer(opponent.attackDamages[atk]);
                rest(500);
                if (health == 0) {
                    face.clearMessage();
                    face.setMessage(name + " has been defeated :(");
                    rest(100);
                    face.timer.setDelay(400);
                    return 0;
                }
            }
            
            face.clearMessage();
            System.out.println(health1*100.0/opponent.health);
            if (health1*100.0/opponent.health <= 70 && health1*100.0/opponent.health >= 30) {
            face.setMessage(opponent.name + " is looking a bit tired");
            rest(500);
            face.clearMessage();
            }
            else if (health1*100.0/opponent.health <= 30) {
            face.setMessage(opponent.name + " is weak");
            rest(500);
            face.clearMessage();
            }
            face.setInstantMessage("HP: " + health + " / " + maxHealth);
        }
        face.timer.setDelay(400);
        return 0;
    }

    public void damageOpponent(int dmg, Opponent opponent) {
        health1 -= dmg;
        if (health1 < 0)
        health1 = 0;
    }

    public void damagePlayer(int dmg) {
        health -= dmg;
        if (health > maxHealth)
        health = maxHealth;
        if (health < 0)
        health = 0;
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

    public boolean checkItems() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].invAmt != 0) {
                return true;
            }
        }
        return false;
    }
    

} // end Virtual Pet
