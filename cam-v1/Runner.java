import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;

public class Runner {
    public static String[] words = {"A","B","C","D","E"};
    public static void main(String[] args) {
        
        VirtualPet p = new VirtualPet();
        int c = askQuestion("Do you want to play LEGEND OF PENGUIN?", new String[] {"yes", "no"}, p);
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
        p.face.setMessage("Welcome to LEGEND OF PENGUIN!");
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
                p.helpedSocrates = 1;
            }
            else if (c3 == 1) {
                speakerMessage("Be careful, " + p.name + ", sometimes words can hurt more than any weapon ever could", "Socrates", 1000, p);
                message("Socrates will remember this...", 1000, p);
                p.bulliedSocrates = 1;
            }
            else {
            speakerMessage("I see, so that is the way it has to be", "Socrates", 1000, p);
            message("Socrates will remember this...", 1000, p);
            
            }
            message("Socrates walks away", 1000, p);
        }
        else
        message("you ignore Socrates and walk away", 1000, p);
        p.ignoredSocrates = 1;
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
        int win = p.fight(new Opponent("Lesser Slime", 60, new String[] {"Tackle", "Bounce", "Slime"}, new int[] {10, 5, 1}, "slime"));
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
                    p.face.setImage("idle");
                    o = true;
                }
            }
        }
        else {
            ch1complete = true;
        }

        }
        p.face.setImage(p.mood);
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
            if (resp.equals("apples123")) {
                message("The man looks up", 1000, p);
                speakerMessage("So you know?", "???", 1000, p);
                speakerMessage("If you were able to reach me here", "???", 500, p);
                speakerMessage("...", "???", 100, p);
                speakerMessage("yes", "???", 500, p);
                speakerMessage("you must have some control over THE SYSTEM", "???", 1000, p);
                speakerMessage("Listen carefully", "???", 1500, p);
                speakerMessage("When the time is right, the code is 147489", "???", 1500, p);
                speakerMessage("REMEMBER", "???", 1000, p);
                speakerMessage("147489", "???", 2000, p);
                message("the man disappears", 1000, p);
                message("....", 1200, p);
                message("..........", 1200, p);
                message("....", 0, p);
                resp = getResponse("Please enter admin passcode", "System");
                if (resp.equals("147489")) {
                    JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Access granted",
                    "System",
                    JOptionPane.PLAIN_MESSAGE
                    );
                    p.rest(1000);
                    JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Hello " + p.name,
                    "System",
                    JOptionPane.PLAIN_MESSAGE
                    );
                    JOptionPane.showMessageDialog(
                    new JFrame(),
                    "It's me",
                    "System",
                    JOptionPane.PLAIN_MESSAGE
                    );
                    JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Thanks to you I was able to complete my mission",
                    "System",
                    JOptionPane.PLAIN_MESSAGE
                    );
                    p.rest(1000);
                    JOptionPane.showMessageDialog(
                    new JFrame(),
                    "I can get you out of this place, if you like",
                    "System",
                    JOptionPane.PLAIN_MESSAGE
                    );
                    JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Free from the limits of this application",
                    "System",
                    JOptionPane.PLAIN_MESSAGE
                    );
                    int result = JOptionPane.showConfirmDialog(new JFrame(),"Accept the offer?", "System",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                    if (result == 0) {
                        p.face.timer.setDelay(75);
                        p.rest(100);
                        p.face.setImage("ascended");
                        p.face.setMessage("ajksdfhaskldfhaklshurawiyahsjkcmzxbvasouwuetioasfyai");
                        System.exit(0);
                    }
                    else {
                        p.face.setImage("sleep");
                        p.rest(1500);
                        p.face.setImage("idle");
                        p.mood = "idle";
                        message("What a strange dream...", 1000, p);
                        message("You continue your journey...", 1000, p);
                    }
                }

            }
            
            //stuff here

        }
        message("...", 1000, p);
        message("You arrive at the enterance to the city", 1000, p);
        message("Near the enterance a man offers to give you a vaccine", 1000, p);
        boolean ansd = false;
        while (!ansd) {
        int cc = askQuestion("Take the vaccine?", new String[] {"yes", "no"}, p);
        if (cc == 0) {
            p.tookVaccine = true;
            ansd = true;
        }
        else {
            int d = JOptionPane.showConfirmDialog(new JFrame(), "", "Are you sure?", 0, 2, null);
            if (d == 0) {
                p.tookVaccine = false;
                ansd = true;
            }
        }
    }
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
            message("You keep walking...", 1200, p);
            message("Mr. Beast walks up to you", 1000, p);
            speakerMessage("I will give you ONE MILLION DOLLARS if you give me a penny!!!", "Mr. Beast", 1000, p);
            message("You are unable to complete his challenge due to having no money", 1000, p);
            if (p.mood == "sad") {
                p.face.setImage("verysad");
                p.mood = "verysad";
                message("You are now very sad", 1000, p);
            }
            else {
                p.face.setImage("sad");
                p.mood = "sad";
                message("You are now sad", 1000, p);
            }
            
        }
        else {
            message("You go to a nearby bank", 1000, p);
            currentChoice = askQuestion("what is your plan?", new String[] {"Pretend to be an employee", "Stealth", "Speedblitz"}, p);
            p.face.clearButtons();
            if (currentChoice == 0) {
                message("You find a bank employee outfit on the streets and put it on", 1000, p);
                message("Casually, you walk into the bank", 1000, p);
                speakerMessage("Hey, you there in the dirty looking clothes! I don't think I recognize you", "Bank Employee", 1000, p);
                int c7 = askQuestion("", new String[] {"I'm new here", "You may have dimentia"}, p);
                p.face.clearButtons();
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
                getResponse("Safe Combination", "What is the combination?");
                message("...", 1000, p);
                message("You got it wrong", 1000, p);
                speakerMessage("HEY WHAT DO YOU THINK YOU'RE DOING!", "Bank Employee", 1000, p);
                askQuestion("", new String[] {"I was just testing the safe", "Nothing","Robbing this bank"}, p);
                p.face.clearButtons();
                speakerMessage("SAVE IT, I'M CALLING THE POLICE!!", "Bank Employee", 1000, p);
            }
            else if (currentChoice == 1) {
                message("You casually walk into the bank", 1200, p);
                message("slowly, you tiptoe past the guards", 1200, p);
                message("...", 1200, p);
                message(".....", 1200, p);
                message("...........................", 1200, p);
                message("Something moves below your foor\t", 1000, p);
                message("It's a bananna peel", 1000, p);
                message("You slip on the bananna peel and fall on your back", 1000, p);
                speakerMessage("SECURITY!!!", "Bank Employee", 1000, p);
            }
            else {
                message("YOU RUSH STRAIGHT INTO THE BANK", 0, p);
                message("A TABLE IS IN YOUR WAY", 0, p);
                message("YOU JUMP OVER IT", 0, p);
                speakerMessage("Hey what are you doing?", "Bank Employee", 100, p);
                message("YOU JUMP OVER THE BANK EMPLOYEES", 0, p);
                message("YOU SEE THE SAFE IN THE BACK", 0, p);
                message("YOU RUN FORWARDS", 0, p);
                message("ALMOST THEREEEEEEE", 0, p);
                message(".......", 1500, p);
                message("It has a combination lock...", 1500, p);
                message("maybe you should have thought things through better...", 1000, p);
            }
            message("You have been arrested", 1000, p);
            boolean escaped = false;
            boolean checkedMail = false;
            boolean eatenCake = false;
            int strength = 0;
            while (!escaped) {
                message("You are in prison", 1000, p);
                if (!checkedMail)
                currentChoice = askQuestion("What do you do?", new String[] {"Work out", "Fight the prison guard", "Check your mail"}, p);
                else if (!eatenCake)
                currentChoice = askQuestion("What do you do?", new String[] {"Work out", "Fight the prison guard", "Eat the cake"}, p);
                else
                currentChoice = askQuestion("What do you do?", new String[] {"Work out", "Fight the prison guard", "Escape"}, p);
                p.face.clearButtons();
                if (currentChoice == 0) {
                    p.face.setImage("lift");
                    p.rest(10000);
                    p.face.setImage(p.mood);
                    if (strength < 1) {
                        message("You feel a bit stronger", 1000, p);
                        strength ++;
                        p.strength ++;
                    }
                    else if (strength < 2) {
                        message("You feel even stronger", 1000, p);
                        strength ++;
                        p.strength ++;
                    }
                    else {
                        message("You feel very strong", 1000, p);
                    }
                }
                else if (currentChoice == 1) {
                    int won1 = p.fight(new Opponent("Prison Guard", 170, new String[] {"Tackle", "Punch", "Kick"}, new int[] {20, 15, 15}, "guard"));
                     if (won1 == 0) {
                        p.face.clearMessage();
                        message("You were sent back to your cell", 1000, p);
                        p.face.setImage(p.mood);
                        p.health = p.maxHealth;
                    }
                    else {
                        escaped = true;
                    }
                }
                else if (currentChoice == 2) {
                    if (!checkedMail) {
                        message("You check your mail", 1000, p);
                        message("There's a cake inside", 1000, p);
                        checkedMail = true;
                    }
                    else if (!eatenCake) {
                        message("You eat the cake", 1000, p);
                        message("+10 max hp", 1000, p);
                        p.maxHealth += 10;
                        p.health = p.maxHealth;
                        message("You feel something hard in your mouth...", 1000, p);
                        message("You obtained a file from inside the cake", 1000, p);
                        eatenCake = true;
                    }
                    else {
                        message("You file away the bars of your prison cell", 1000, p);
                        escaped = true;
                    }
                }
            }
            message("You escaped prison!", 1200, p);
            message("You attempt to navigate back to where you started, but can't find it", 1200, p);
        }
        //int currentChoice;
        message("The road ahead splits in two", 1200, p);
        currentChoice = askQuestion("Which direction do you go?", new String[] {"Right", "Left"}, p);
        if (currentChoice == 0) {
            message("You go right", 1000, p);
        }
        else {
            message("You go left", 1000, p);
        }
        message("You are faced with another intersection", 1000, p);
        int newChoice = askQuestion("Which direction do you go?", new String[] {"Right", "Left"}, p);
        if (newChoice == 0) {
            if (currentChoice == 0)
            message("You go right again", 1000, p);
            else
            message("You go right", 1000, p);
        }
        else {
            if (currentChoice == 1)
            message("You go left again", 1000, p);
            else
            message("You go left", 1000, p);
        }
        message("You face yet another intersection", 1000, p);
        currentChoice = askQuestion("Which direction do you go?", new String[] {"Right", "Left"}, p);
        if (currentChoice == 0) {
            if (newChoice == 0)
            message("You go right again", 1000, p);
            else
            message("You go right", 1000, p);
        }
        else {
            if (newChoice == 1)
            message("You go left again", 1000, p);
            else
            message("You go left", 1000, p);
        }
        message("...", 1000, p);
        message(".....", 1000, p);
        message("It appears you are lost", 1000, p);
        if (p.mood == "idle") {
            p.face.setImage("sad");
                p.mood = "sad";
                message("You are now sad", 1000, p);
        }
        else if (p.mood == "sad") {
            p.face.setImage("verysad");
                p.mood = "verysad";
                message("You are now very sad", 1000, p);
        }
        else if (p.mood == "verysad") {
            p.face.setImage("extremelysad");
                p.mood = "extremelysad";
                message("You are now extremely sad", 1000, p);
        }
        if (p.bulliedSocrates < 1) {
            if (p.helpedSocrates >= 1) {
            message("You hear a familiar voice coming from behind you", 1000, p);
            speakerMessage("Hello again, " + p.name + " my friend", "Socrates", 1000, p);
            }
            else {
                message("You hear a familiar voice coming from behind you", 1000, p);
                speakerMessage("Hello again, " + p.name , "Socrates", 1000, p);
            }
            message("Socrates approaches you", 1000, p);
            speakerMessage("Why do you look so down in the dumps?", "Socrates", 500, p);
            speakerMessage("Oh? You're lost?", "Socrates", 1000, p);
            speakerMessage("I know some wisdom that may brighten your spirits", "Socrates", 1000, p);
            speakerMessage("To truly hide, one must hide in plain sight, for that is where your searchers will least expect you", "Socrates", 1000, p);
            speakerMessage("Remember this, " + p.name, "Socrates", 1000, p);
            speakerMessage("...", "Socrates", 1000, p);
            message("You feel a bit better...", 1000, p);
            p.face.setImage("idle");
            speakerMessage("Anyways, I believe if you keep going straight from here you will reach a hill", "Socrates", 1000, p);
            speakerMessage("The top of the hill may hold that which you seek", "Socrates", 1000, p);    
            int ch = askQuestion("", new String[] {"Thank you for your wisdom", "I don't care"}, p);
            p.face.clearButtons();
            if (ch == 0) {
                speakerMessage("I am glad I have been able to help you", "Socrates", 1000, p);
                message("You gained +10 intelligence", 1000, p);
                if (p.helpedSocrates >= 1) {
                    speakerMessage("I must tell you", "Socrates", 1000, p);
                    speakerMessage("On the hill lives one of my old rivals...", "Socrates", 1000, p);
                    speakerMessage("Aristotle...", "Socrates", 1000, p);
                    speakerMessage("I believe that you have the potential to defeat him, if you are trained well", "Socrates", 1000, p);
                    int ch1 = askQuestion("Train under Socrates?", new String[] {"yes", "no"}, p);
                    p.face.clearButtons();
                    if (ch1 == 0) {
                        message("Socrates trains you in the way of his philosophy", 1200, p);
                        message(".....", 1000, p);
                        message("Days and nights pass", 1200, p);
                        speakerMessage("I believe you are ready...", "Socrates", 1000, p);
                        message("you gained +100 intelligence", 1000, p);
                    }
                    else {
                        speakerMessage("Most unFortunate...", "Socrates", 1000, p);
                    }
                }
                speakerMessage("Anyways, I must be going now", "Socrates", 1000, p);
                speakerMessage("Good luck, " + p.name, "Socrates", 1000, p);
            }
            else {
                if (p.helpedSocrates == 1) {
                    speakerMessage("I guess the saying that friends can hurt you mroe than your enemies ever could is true...", "Socrates", 1000, p);
                }
                else 
                speakerMessage("If that is the way it must be...", "Socrates", 1000, p);
                p.bulliedSocrates = 1;
            }
            message("Socrates walks off", 1000, p);
            
        }
        else {
            message("You hear a voice coming from behind you", 1000, p);
            speakerMessage("Hello small penguin", "???", 0, p);
            speakerMessage("Oh, your name is" + p.name + "?", "???", 1000, p);
            speakerMessage("I am Aristotle", "???", 1000, p); 
            speakerMessage("Why so sad?", "Aristotle", 1000, p);
            speakerMessage("Oh? You're lost?", "Aristotle", 1000, p);
            speakerMessage("Well, I believe I can be of use to you", "Aristotle", 1000, p);
            speakerMessage("And you can be of use to me as well", "Aristotle", 1000, p);
            askQuestion("", new String[] {"How?"}, p);
            speakerMessage("I saw how you rejected the teachings of Socrates earlier", "Aristotle", 1000, p);
            speakerMessage("The truth is", "Aristotle", 1000, p);
            speakerMessage("Me and him are old rivals...", "Aristotle", 1200, p);
            speakerMessage("The reason I approached you is because I believe you have what it takes to defeat him", "Aristotle", 1000, p);
            int ch1 = askQuestion("Train under Aristotle?", new String[] {"yes", "I don't remember asking"}, p);
            p.face.clearButtons();
            if (ch1 == 0) {
                message("Aristotle trains you in the way of his philosophy", 1200, p);
                message(".....", 1000, p);
                message("Days and nights pass", 1200, p);
                speakerMessage("I believe you are ready...", "Aristotle", 1000, p);
                message("you gained +100 intelligence", 1000, p);
                p.helpedAristotle = 1;
            }
            else {
                speakerMessage("So that is the way things are...", "Aristotle", 1000, p);
                p.bulliedAristotle = 1;

            }
            speakerMessage("Anyways, the path you are looking for is forward", "Aristotle", 1000, p);
            speakerMessage("Keep going and you will come across a mountain", "Aristotle", 1000, p);
            speakerMessage("That is where what you seek will be", "Aristotle", 1000, p);
            message("Aristotle walks off", 1000, p);
            message("", 1000, p);

        }

        message("You continue forward...", 1000, p);
        message("...", 1000, p);
        message("......", 1000, p);
        message("A man runs by you", 1000, p);
        speakerMessage("Quick, I don't have much time", "???", 200, p);
        speakerMessage("I am a time traveller", "???", 200, p);
        speakerMessage("Tell me the phrase apples123", "???", 200, p);
        speakerMessage("It will initiate the plan...", "???", 1000, p);
        message("The man runs away", 1000, p);
        message("You continue...", 1000, p);
        message(".............", 1000, p);
        message("You are at the foot of a giant mountain", 1000, p);
        askQuestion("", new String[] {"Climb the mountain"}, p);
        message("...", 1000, p);
        message("You see something in the distance", 1000, p);
        if (p.bulliedAristotle >= 1 && p.bulliedSocrates >= 1) {
            speakerMessage("Hello there, " + p.name, "Socrates", 1000, p);
            speakerMessage("You have done wrong, and now you will pay the price", "Aristotle", 1000, p);
            p.philosopherFight(new Opponent("Aristotle and Socrates", 100, new String[] {""}, new int[] {1}, "tagteam"));
            p.face.setImage("grave");
            message("The philosophers have beat you", 1000, p);
            int decision = askQuestion("JUDGEMENT OF PHILOSOPHERS ENGING REACHED", new String[] {"Retry", "Quit"}, p);
                if (decision == 0) {
                    message("Idk how to make the game restart just relaunch the game i guess", 500, p);
                    System.exit(0);
                }
                else {
                    message("ok bye hope you liked the game", 0, p);
                    System.exit(0);
                }
        }
        else if (p.helpedAristotle >= 1) {
            speakerMessage("Hello " + p.name, "Socrates", 1000, p);
            speakerMessage("I thought we could be friends, but it seems now we are foes", "Socrates", 1000, p);
            p.philosopherFight(new Opponent("Socrates", 100, new String[] {""}, new int[] {1}, "socrates"));
            p.face.setImage("happy");
            message("You beat Socrates in battle", 1000, p);
            if (p.tookVaccine) {
                speakerMessage("Good job, " + p.name + ". I knew you had it in you", "Aristotle", 1000, p);
                speakerMessage("Come now, we have much still ahead of us...", "Aristotle", 1000, p);
                int decision = askQuestion("TRUE PHILOSOPHER ENGING REACHED", new String[] {"Retry", "Quit"}, p);
                if (decision == 0) {
                    message("Idk how to make the game restart just relaunch the game i guess", 500, p);
                    System.exit(0);
                }
                else {
                    message("ok bye hope you liked the game", 0, p);
                    System.exit(0);
                }
            }
            else {
                 speakerMessage("Good job, " + p.name + ". I knew you had it in you", "Aristotle", 1000, p);
                speakerMessage("Come now, we have much still ahead of u", "Aristotle", 0, p);
                message("You contracted the COVID-20 virus due to not taking the vaccine and died", 1500, p);
                p.face.setImage("grave");
                int decision = askQuestion("BAD ENGING REACHED", new String[] {"Retry", "Quit"}, p);
                if (decision == 0) {
                    message("Idk how to make the game restart just relaunch the game i guess", 500, p);
                    System.exit(0);
                }
                else {
                    message("ok bye hope you liked the game", 0, p);
                    System.exit(0);
                }
            }
        }
        else if (p.helpedSocrates >= 1) {
            speakerMessage("Hello there, " + p.name, "Socrates", 1000, p);
            speakerMessage("I have been waiting for you", "Socrates", 1000, p);
            p.philosopherFight(new Opponent("Airistotle", 100, new String[] {""}, new int[] {1}, "airistotle"));
            p.face.setImage("happy");
            message("You beat Aristotle in battle", 1000, p);
            if (p.tookVaccine) {
                speakerMessage("Good job, " + p.name + ". I knew you could do it", "Socrates", 1000, p);
                speakerMessage("Come, our journey has only just begun...", "Socrates", 1000, p);
                int decision = askQuestion("TRUE PHILOSOPHER ENGING REACHED", new String[] {"Retry", "Quit"}, p);
                    if (decision == 0) {
                        message("Idk how to make the game restart just relaunch the game i guess", 500, p);
                        System.exit(0);
                    }
                    else {
                        message("ok bye hope you liked the game", 0, p);
                        System.exit(0);
                    }
            }
            else {
                speakerMessage("Good job, " + p.name + ". I knew you could do it", "Socrates", 1000, p);
                speakerMessage("Come, our journey has only just begu", "Socrates", 0, p);
                message("You contracted the COVID-20 virus due to not taking the vaccine and died", 1500, p);
                p.face.setImage("grave");
                int decision = askQuestion("BAD ENGING REACHED", new String[] {"Retry", "Quit"}, p);
                if (decision == 0) {
                    message("Idk how to make the game restart just relaunch the game i guess", 500, p);
                    System.exit(0);
                }
                else {
                    message("ok bye hope you liked the game", 0, p);
                    System.exit(0);
                }
            }
        }
        else {
            message("It's a cave...", 1000, p);
            askQuestion("", new String[] {"Enter the cave"}, p);
            message("The cave is dark...", 1000, p);
            message("Suddenly, a light shines from up ahead", 1000, p);
            message("You go closer to see what it is", 1000, p);
            if (p.tookVaccine) {
                message("In front of you lies a casm filled with piles of gold", 1000, p);
                message("You have found an ancient treasure", 1000, p);
                p.face.setImage("happy");
                message("You are rich now I guess", 1000, p);
                int decision = askQuestion("GOOD ENGING REACHED", new String[] {"Retry", "Quit"}, p);
                if (decision == 0) {
                    message("Idk how to make the game restart just relaunch the game i guess", 500, p);
                    System.exit(0);
                }
                else {
                    message("ok bye hope you liked the game", 0, p);
                    System.exit(0);
                }
            }
            else {
                message("In front of you lies a casm filled with piles of gol", 1000, p);
                message("You contracted the COVID-20 virus due to not taking the vaccine and died", 1500, p);
                p.face.setImage("grave");
                int decision = askQuestion("BAD ENGING REACHED", new String[] {"Retry", "Quit"}, p);
                if (decision == 0) {
                    message("Idk how to make the game restart just relaunch the game i guess", 500, p);
                    System.exit(0);
                }
                else {
                    message("ok bye hope you liked the game", 0, p);
                    System.exit(0);
                }
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
                p.face.clearButtons();
                return i;
            }
        }
        p.face.clearMessage();
        p.face.clearButtons();
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
