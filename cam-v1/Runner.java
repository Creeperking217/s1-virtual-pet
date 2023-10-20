import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;

public class Runner {
    public static String[] words = {"A","B","C","D","E"};
    public static void main(String[] args) {
        
        VirtualPet p = new VirtualPet();
        // int c = askQuestion("Do you want to play [GAME NAME]?", new String[] {"yes", "no"}, p);
        // if (c == 1) {
        //     p.face.setMessage("bruh");
        //     System.exit(0);
        // }
        // p.face.clearButtons();
        // p.face.clearMessage();
        // p.face.setMessage("Nice");
        // p.rest(500);
        // p.face.clearMessage();
        // p.face.setMessage("Please tell me what your name is");
        // p.rest(100);
        // p.name = getResponse("What is your name?", "Tell me");
        // if (p.name == null) {
        //     p.name = getResponse("Bruh tell me", "Tell me rn");
        //     if (p.name == null) {
        //         p.name = getResponse("Pleassse?", "plssssssss");
        //         if (p.name == null) {
        //             p.name = getResponse("Last chance", "Really man...");
        //             if (p.name == null) {
        //                 p.face.clearMessage();
        //                 p.face.setMessage("fine them >:(");
        //                 System.exit(0);
        //             }
        //         }
        //     }
        // }
        // p.face.clearMessage();
        // p.face.setMessage("Hello, " + p.name + "!");
        // p.rest(500);
        // p.face.clearMessage();
        // p.face.setMessage("Welcome to [GAME NAME]!");
        // p.rest(500);
        // p.face.clearMessage();
        // p.face.setMessage("Your experience starts...");
        // p.rest(750);
        // p.face.clearMessage();
        // p.face.setMessage("...");
        // p.rest(600);
        // p.face.clearMessage();
        // p.face.setMessage("NOW");
        // p.face.cameraShake(40, 50);
        // p.face.clearMessage();
        // p.face.setImage("sleepy");
        // p.face.cameraShake(20, 50);
        // p.rest(2000);
        // p.face.setImage("idle");
        // p.rest(1000);
        // message("...", 500, p);
        // message("It appear you have woken up as a penguin", 1000, p);
        // message("You are surrounded by a large forest", 1000, p);
        // message("A path stretches forwards in front of you", 1000, p);
        // askQuestion("", new String[] {"Follow the path"}, p);
        // p.face.clearButtons();
        // message("You follow the path", 1000, p);
        // message("...", 1000, p);
        // int c1 = askQuestion("There appears to be a fork in the road   ", new String[] {"Go right", "Go left"}, p);
        // p.face.clearButtons();
        // if (c1 == 0) 
        // message("You go right around the fork", 1500, p);
        // else
        // message("You go left around the fork", 1500, p);
        // message("walking down the road, you notice someone approaching you", 1000, p);
        // message("???: Hello little peng-", 0, p);
        // speakerMessage("Oh? " + "Your name is " + p.name + "?", "???", 1000, p);
        // speakerMessage("And you're lost?", "???", 1000, p);
        // speakerMessage("Well I am Socrates, one of the great philosophers of Greece", "???", 1000, p);
        // speakerMessage("I may be able to asist you with some of my wisdom", "Socrates", 1000, p);
        // int c2 = askQuestion("", new String[] {"Listen to Socrates' wisdom", "ignore"}, p);
        // p.face.clearButtons();
        // if (c2 == 0) {
        //     speakerMessage("Courage is the first of human qualities because it is the quality that which guarantees the others", "Socrates", 1500, p);
        //     int c3 = askQuestion("", new String[] {"I didn't know that", "Ok but who asked", "you're copying Aristotle"}, p);
        //     p.face.clearButtons();
        //     if (c3 == 0) {
        //         message("You gained +10 intelligence", 1500, p);
        //         speakerMessage("I also must warn you", "Socrates", 500, p);
        //         speakerMessage("A dangerous creature lives nearby", "Socrates", 1000, p);
        //         speakerMessage("I would be careful if I were you...", "Socrates", 1500, p);
        //     }
        //     else if (c3 == 1) {
        //         speakerMessage("Be careful, " + p.name + ", sometimes words can hurt more than any weapon ever could", "Socrates", 1000, p);
        //         message("Socrates will remember this...", 1000, p);
        //     }
        //     else {
        //     speakerMessage("I see, so that is the way it has to be", "Socrates", 1000, p);
        //     message("Socrates will remember this...", 1000, p);
        //     }
        //     message("Socrates walks away", 1000, p);
        // }
        // else
        // message("you ignore Socrates and walk away", 1000, p);
        boolean ch1complete = false;
        while(!ch1complete){

        // message("Continuing along the path, you see something in the distance", 1000, p);
        // message("It's a piece of candy", 1000, p);
        // message("It looks very good...", 1000, p);
        boolean ansd = false;
        while (!ansd) {
            int c4 = askQuestion("Take the piece of candy?", new String[] {"yes", "no"}, p);
            p.face.clearButtons();
            if (c4 == 0) {
                ansd = true;
                message("You reach down to grab the cand-", 0, p);
                p.face.cameraShake(50, 50);
                message("ROAOHSDKAJHFHK", 1000, p);
                message("A slime jumps out of the bushes in front of you!", 500, p);


            }
            else {
                int r = JOptionPane.showConfirmDialog(new JFrame(), "You'll be very sad if you don't take the candy", "Are you sure?", 0, 2, null);
                if (r == 0)
                {
                    ansd = true;
                    p.face.setImage("sad");
                    p.mood = "sad";
                    p.face.timer.restart();
                    message("You don't get any candy and are sad ;(", 1000, p);
                    message("You continue walking down the path", 1000, p);
                    message("You hear a rustling noi-", 0, p);
                    p.face.cameraShake(50, 50);
                    message("ROAOHSDKAJHFHK", 1000, p);
                    message("A slime jumps out of the bushes in front of you!", 500, p);
                }
            }
        }
        int win = p.fight(new Opponent("Lesser Slime", 60, new String[] {"Tackle", "Bounce", "Slime"}, new int[] {100, 500, 100}, "slime"));
        if (win == 0) {
            p.face.setImage("dead");
        }

        }


        


        
        // System.out.println(c);
        // p.face.clearButtons();
        // p.exercise();
        // p.rest(1000);
        // p.exercise();
        // p.exercise();
        
        //int outcome = p.fight();
    }

    public static void message(String message, int waitTime, VirtualPet p) {
        p.face.setMessage(message);
        p.rest(waitTime);
        p.face.clearMessage();
    }

    public static void speakerMessage(String message, String speaker, int waitTime, VirtualPet p) {
        p.face.setSpeakerMessage(message, speaker);
        p.rest(waitTime);
        p.face.clearMessage();
    }

    public static int askQuestion(String q, String[] choices, VirtualPet p) {
        p.face.newButtons(choices.length);
        p.face.buttonStates = new int[choices.length];
        if (q!= "")
        p.face.setMessage(q);
        for (int i = 0; i < choices.length; i++) {
            p.face.setInstantMessage(words[i] + ". " + choices[i]);
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
