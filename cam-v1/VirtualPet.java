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
    public static String[] words = {"A","B","C","D","E"};
    public int bulliedSocrates = 0;
    public int helpedSocrates = 0;
    public int helpedAristotle = 0;
    public int ignoredSocrates = 0;
    public VirtualPetFace face;
    public int hunger = 0; 
    public int tiredness = 0;
    public int health = 50;
    public int maxHealth = 50;
    public int strength = 0;
    public boolean tookVaccine = false;
    public String[] aristotleQuotes = new String[] {"Knowing yourself is the beginning of all wisdom", "Patience is bitter, but its fruit is sweet", "It is during our darkest moments that we must focus to see the light", "Virtue lies in our power, and similarly so does vice; because where it is in our power to act, it is also in our power not to act", "The wise man does not expose himself needlessly to danger, since there are few things for which he cares sufficiently; but he is willing, in great crises to give even his life-knowing that under certain conditions it is not worthwhile to live", "Excellence is never an accident. It is always the result of high intention, sincere effort, and intelligent execution; it represents the wise choice of many alternatives - choice, not chance, determines your destiny"};
    public String[] socratesQuotes = new String[] {"A system of morality which is based on relative emotional values is a mere illusion, a thoroughly vulgar conception which has nothing sound in it and nothing true", "Nature has given us two ears, two eyes, and but one tongue-to the end that we should hear and see more than we speak", "The only good is knowledge and the only evil is ignorance", "False words are not only evil in themselves, but they infect the soul with evil.", "The beginning of wisdom is a definition of terms"};
    public String[] deepQuotes = new String[] {"For every minute you are angry, you lose 60 seconds of happiness", "Go the extra mile, there's no one on it", "Go the extra mile, there's no one on it", "The average men consume. The wise create", "It is easier to build strong children than to repair broken men", "Doubt is an uncomfortable condition, but certainty is a ridiculous one", "Maybe you are searching among the branches, for what only appears in the roots", "I cannot teach anybody anything. I can only make them think", "They are not only idle who do nothing, but they are idle also who might be better employed"};
    
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
        face.setImage("white");
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
                        face.setImage("tackle");
                        face.setMessage(name + " used " + "Tackle");
                        //face.timer.setDelay(75);
                        
                        rest(250);
                        face.cameraShake(30, 5);
                        face.timer.setDelay(100);
                        face.setImage(opponent.spriteName);
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
                        face.timer.stop();
                        face.timer.setDelay(150);
                        face.timer.start(); 
                        face.setImage("bully");
                        rest(100);
                        face.cameraShake(30, 10);
                        face.setImage(opponent.spriteName);
                        face.timer.stop();
                        face.timer.setDelay(100);
                        face.timer.start(); 
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

    public int philosopherFight(Opponent opponent) { 
        maxHealth = 200;
        health = maxHealth;
        health1 = opponent.health;
        int exLives = 1;
        face.timer.setDelay(400);
        face.timer.restart();
        face.setImage(opponent.spriteName);
        if (bulliedAristotle > 0 && bulliedSocrates> 0) {
            face.setMessage(opponent.name + " Approach");
            maxHealth = 60;
            health = maxHealth;
        }
        else {
            face.setMessage(opponent.name + " Approaches");
            maxHealth = 200;
            health = maxHealth;
        }
        
        
        //face.delay = 100;
        face.clearMessage();
        face.clearButtons();
        fighting = true;
        health1 = opponent.health;
        int choice = 0;
        face.setInstantMessage("Intelligence: " + health + " / " + maxHealth);
        while (fighting){
            choice = 0;
            face.newButtonColumn(new String[] {"Philosophise"});
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
                face.newButtons(3);
            face.buttonStates = new int[3];
            for (int i = 0; i < 3; i++) {
                face.setInstantMessage(this.words[i] + ". " + deepQuotes[rand.nextInt(deepQuotes.length)]);
            }
            while (!face.buttonPressed) {
                rest(1);
            }
            face.clearMessage();
            face.clearButtons();

                face.setMessage("You philosophise");
                damageOpponent(20, opponent);
                rest(1000);
                face.clearMessage();
                if (health1 == 0) {
                            face.clearMessage();
                            face.setMessage("You have defeated " + opponent.name);
                            rest(100);
                            face.timer.setDelay(400);
                            return 1;
                        }
                    }
                
            
                int atk1 = rand.nextInt(socratesQuotes.length);
                int atk2 = rand.nextInt(aristotleQuotes.length);
                if (helpedAristotle > 0) {
                    face.setMessage("Socrates" + ": " + socratesQuotes[atk1]);
                    damagePlayer(50);
                }
                else if (helpedSocrates > 0) {
                    face.setMessage("Aristotle" + ": " + aristotleQuotes[atk2]);
                    damagePlayer(50);
                }
                else {
                    face.setMessage("Socrates" + ": " + socratesQuotes[atk1]);
                    rest(1000);
                    face.clearMessage();
                    face.setMessage("Aristotle" + ": " + aristotleQuotes[atk1]);
                    damagePlayer(50);
                    //rest(1000);
                }
                
                rest(1000);
                face.clearMessage();
                if (health == 0 && exLives == 1) {
                    health = 1;
                }   
                if (health == 0) {
                    health = 1;
                    face.clearMessage();
                    face.setMessage(name + " has been defeated :(");
                    rest(100);
                    face.timer.setDelay(400);
                    return 0;
                }
            if (health1*100.0/opponent.health <= 70 && health1*100.0/opponent.health >= 30) {
            if (bulliedAristotle > 0 && bulliedSocrates > 0)
            face.setMessage(opponent.name + " are looking a bit tired");
            else
            face.setMessage(opponent.name + " is looking a bit tired");
            rest(500);
            face.clearMessage();
            }
            else if (health1*100.0/opponent.health <= 30) {
            if (bulliedAristotle > 0 && bulliedSocrates > 0)
            face.setMessage(opponent.name + " are weak");
            else
            face.setMessage(opponent.name + " is weak");
            rest(500);
            face.clearMessage();
            }
            face.setInstantMessage("Intelligence: " + health + " / " + maxHealth);
        face.timer.setDelay(400);
        }
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
