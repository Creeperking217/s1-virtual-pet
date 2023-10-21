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
        p.face.clearMessage();
        p.face.setImage("sleepy");
        p.face.cameraShake(20, 50);
        p.rest(2000);
        p.face.setImage("idle");
        p.rest(1000);
        message("...", 500, p);
        message("It appear you have woken up as a penguin", 1000, p);
        message("You are surrounded by a large forest", 1000, p);
        message("A path stretches forwards in front of you", 1000, p);
        askQuestion("", new String[] {"Follow the path"}, p);
        p.face.clearButtons();
        message("You follow the path", 1000, p);
        message("...", 1000, p);
        int c1 = askQuestion("There appears to be a fork in the road   ", new String[] {"Go right", "Go left"}, p);
        p.face.clearButtons();
        if (c1 == 0) 
        message("You go right around the fork", 1500, p);
        else
        message("You go left around the fork", 1500, p);
        message("walking down the road, you notice someone approaching you", 1000, p);
        message("???: Hello little peng-", 0, p);
        speakerMessage("Oh? " + "Your name is " + p.name + "?", "???", 1000, p);
        speakerMessage("And you're lost?", "???", 1000, p);
        speakerMessage("Well I am Socrates, one of the great philosophers of Greece", "???", 1000, p);
        speakerMessage("I may be able to asist you with some of my wisdom", "Socrates", 1000, p);
        int c2 = askQuestion("", new String[] {"Listen to Socrates' wisdom", "ignore"}, p);
        p.face.clearButtons();
        if (c2 == 0) {
            speakerMessage("Courage is the first of human qualities because it is the quality that which guarantees the others", "Socrates", 1500, p);
            int c3 = askQuestion("", new String[] {"I didn't know that", "Ok but who asked", "you're copying Aristotle"}, p);
            p.face.clearButtons();
            if (c3 == 0) {
                message("You gained +10 intelligence", 1500, p);
                speakerMessage("I also must warn you", "Socrates", 500, p);
                speakerMessage("A dangerous creature lives nearby", "Socrates", 1000, p);
                speakerMessage("I would be careful if I were you...", "Socrates", 1500, p);
            }
            else if (c3 == 1) {
                speakerMessage("Be careful, " + p.name + ", sometimes words can hurt more than any weapon ever could", "Socrates", 1000, p);
                message("Socrates will remember this...", 1000, p);
            }
            else {
            speakerMessage("I see, so that is the way it has to be", "Socrates", 1000, p);
            message("Socrates will remember this...", 1000, p);
            }
            message("Socrates walks away", 1000, p);
        }
        else
        message("you ignore Socrates and walk away", 1000, p);
        boolean ch1complete = false;
        while(!ch1complete){

        message("Continuing along the path, you see something in the distance", 1000, p);
        message("It's a piece of candy", 1000, p);
        message("It looks very good...", 1000, p);
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
        int win = p.fight(new Opponent("Lesser Slime", 60, new String[] {"Tackle", "Bounce", "Slime"}, new int[] {100, 50, 100}, "slime"));
        if (win == 0) {
            p.face.clearMessage();
            p.face.setImage("dead");
            message("You died", 1000, p);
            boolean o = false;
            while (!o) {
                int r1 = askQuestion("Continue?", new String[] {"yes", "no"}, p); 
                if (r1 == 1) {
                    int r = JOptionPane.showConfirmDialog(new JFrame(), "You will lose all of your progress", "Are you sure?", 0, 2, null);
                    if (r == 0) {
                        System.exit(0);
                    }
                }
                else {
                    o = true;
                }
            }
        }
        else {
            ch1complete = true;
        }

        }
        message("You gain +1 candy!", 1000, p);
        p.items[0].invAmt ++;
        message("Continuing your hike down the path, you notice trees beginning to clear", 1000, p);
        message("Gradually, the path grows wider and turns into a road", 1000, p);
        message("The outline of a city comes into view...", 1200, p);
        message("You make your way towards it", 1500, p);
        message("...", 1500, p);
        message("A man is walking in the opposite direction down the road", 1000, p);
        message("He looks like he's in a hurry", 1000, p);
        int c5 = askQuestion("", new String[] {"ignore him", "tell him something"}, p);
        p.face.clearButtons();
        if (c5 == 0) {
            message("he walks by you and you continue onward", 1000, p);
        }
        else {
            String resp = getResponse("", "What do you tell the man?");
            p.face.clearButtons();
            
        }
        message("...", 1000, p);
        message("You arrive at the enterance to the city", 1000, p);
        message("The streets extending out in front of you are lined with stores, and you realize they could offer you valuable information", 1000, p);
        message("You go up to one that appears to be selling maps and ask for one", 1000, p);
        speakerMessage("That will be $0.25", "Store Clerk", 1000, p);
        message("...", 1500, p);
        message("You realize you have no money...", 1000, p);
        int currentChoice = askQuestion("", new String[] {"Be a good simeritan and look for some on the streets", "Rob a bank"}, p);
        p.face.clearButtons();
        if (currentChoice == 0) {
            message("Wrong choice", 0, p);
            message("You keep walking through the city", 1200, p);
            message("you see a shop selling more maps for $0.01", 1000, p);
            message("You see another shop selling cookies", 1000, p);
            message("They are on sale: 100 for $0.50", 1000, p);
            if (p.mood != "sad") {
                p.face.setImage("sad");
                message("You are sad", 1000, p);
            }
            message("You keep walking...", 1200, p);
            message("Mr. Beast walks up to you", 1000, p);
            speakerMessage("I will give you ONE MILLION DOLLARS if you give me a penny!!!", "Mr. Beast", 1000, p);
            message("You are unable to complete his challenge due to having no money", 1000, p);
            p.face.setImage("verysad");
            p.mood = "verysad";
            message("You are now extremely sad", 1000, p);
        }
        else {
            message("You go to a nearby bank", 1000, p);
            currentChoice = askQuestion("what is your plan?", new String[] {"Pretend to be an employee", "Stealth", "Speedblitz"}, p);
            if (currentChoice == 0) {
                message("You find a bank employee outfit on the streets and put it on", 1000, p);
                message("Casually, you walk into the bank", 1000, p);
                speakerMessage("Hey, you there in the dirty looking clothes! I don't think I recognize you", "Bank Employee", 1000, p);
                int c7 = askQuestion("", new String[] {"I'm new here", "You may have dimentia"}, p);
                if (c7 == 0) {
                    speakerMessage("Oh, that explains it!", "Bank Employee", 1000, p);
                    speakerMessage("Well don't mind me, Carry on", "Bank Employee", 1000, p);
                }
                else {
                    speakerMessage("Oh", "Bank Employee", 1000, p);
                    speakerMessage("...", "Bank Employee", 1000, p);
                    speakerMessage("I'm going to see a doctor", "Bank Employee", 1000, p);
                }
                message("You continue towards the safe at the end of the bank", 1500, p);
                message("...", 1000, p);
                message("You reach it", 1000, p);
                message("Unfortunately, you don't know the safe combination", 1000, p);
                askQuestion("", new String[] {"Guess"}, p);
                p.face.clearButtons();
                
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
