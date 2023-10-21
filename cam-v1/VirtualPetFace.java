// NOTE:  you are not expected to understand the contents of this class
//   you will be expected, inside your own class, to make and instance of
//   this class and to call 2 methods on it.



////////////////////////////////////////////


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class VirtualPetFace extends JFrame implements ActionListener{

    private final int WIDTH = 800;
    private final int HEIGHT = 800;
    private ImagePanel imagePanel;
    private JTextPane textArea;
    private JTextPane textArea1;
    private ImagePanel side;
    private String base;
    private int loopslot = 0;
    private String[] files;
    private Image[] allPics;
    private ArrayList<Image> pics;
    public Timer timer;
    private JButton[] choices = new JButton[0];
    public int[] buttonStates = {0, 0, 0, 0, 0};
    public boolean buttonPressed = false;
    public int delay = 400;
    String[] words = {"A","B","C","D","E"};

    private static final String imageBase = "pet_images/";
    
    public static void main(String args[]) {
        VirtualPet newPet = new VirtualPet();   
        
    }
    
    public VirtualPetFace() {
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                    //createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't successfully complete");
        }
        
        init();
    }
    
    public void init() {
        String curDir = System.getProperty("user.dir");
        curDir += "/cam-v1";
        base = curDir + "/" + imageBase;
        pics = new ArrayList<Image>();
        timer = new Timer(delay, this);
        
        //timer.setInitialDelay(1000);

        getAllImages();
        
        setBackground();
        //setImage("angel");      
        //setMessage("Hello, and Welcome!");
    }
    
    public void createGUI() {
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WIDTH, HEIGHT));
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBackground(Color.white); 
          
        
        imagePanel = new ImagePanel();
        int width = 400;
        int height = 400;
        imagePanel.setPreferredSize(new Dimension(width, height));
        imagePanel.setMinimumSize(new Dimension(width, height));
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        this.add(imagePanel,c);
        
        
        textArea = new JTextPane();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(width, 2*height/3));
        scroll.setSize(new Dimension(width, 2*height/3));
        textArea.setPreferredSize(new Dimension(width, 2*height/3));
        textArea.setSize(new Dimension(width, 2*height/3));
        


        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        c.ipady = 20;
        contentPane.add(scroll, c);

        

        textArea.setSize(800,1600);  
        textArea.setLayout(null);  
        textArea.setVisible(true); 
        


        //b.setText("dfsakhdf");
    
        setLocationRelativeTo(null);
        setVisible(true);
        //toFront();
        setAlwaysOnTop(true);
        setAlwaysOnTop(false);
    }
    
    private void setBackground() {
        Image backImage = createImage(base+"background.png", "");
        Border bkgrnd = new CentredBackgroundBorder(backImage);
        ((JComponent) getContentPane()).setBorder(bkgrnd);
    }
    
    protected Image createImage(String path, String description) {
           return new ImageIcon(path, description).getImage();
    }

    public void setImage(String mood) {
        timer.stop();
        pics.clear();
        getImages(mood);
        timer.start(); 
    }

     public void actionPerformed(ActionEvent e) {
            loopslot++;

            if (loopslot >= pics.size()) {
                loopslot = 0;
            }

            imagePanel.repaint();

            if (loopslot == pics.size()) {
                timer.restart();
            }
        }

    public void clearButtons() {
        for (int i = 0; i < choices.length; i++) {
            textArea.remove(choices[i]);
        }
        repaint();
    }

    public void newButtonColumn(String[] names) {
        buttonStates = new int[names.length];
        buttonPressed = false;
        if (choices.length > 0)
        clearButtons();
        choices = new JButton[names.length];
        for (int i = 0; i < names.length; i++) {
            choices[i] = new JButton(names[i]);  
            choices[i].setBounds(100,80 + 67*i, 200,60);  
            choices[i].setVisible(true); 
            textArea.add(choices[i]);  
            choices[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    for (int i = 0; i < choices.length; i++)
                    if (e.getSource() == choices[i]) {
                        //System.out.println(buttonStates);
                        buttonStates[i] = 1;
                    }
                    buttonPressed = true;
                }
            });  
        }
        repaint();
    }

    public void newButtons(int amt) {
        buttonStates = new int[amt];
        buttonPressed = false;
        if (choices.length > 0)
        clearButtons();
        choices = new JButton[amt];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = new JButton(words[i]);  
            choices[i].setBounds(2 * (200/choices.length * i + 60/choices.length),200, 60,60);  
            choices[i].setVisible(true); 
            textArea.add(choices[i]);  
            choices[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    for (int i = 0; i < choices.length; i++)
                    if (e.getSource() == choices[i]) {
                        //System.out.println(i);
                        buttonStates[i] = 1;
                    }
                    buttonPressed = true;
                }
            });  
        }
        repaint();
    }

    public void getAllImages() {
        File dir = new File(base);   
        files  = dir.list();
        allPics = new Image[files.length];
        for (int i = 0; i < files.length; i++) {
            //System.err.println(files[i]);
            allPics[i]=createImage(base + files[i],"");
            
        }
        //System.err.println(pics.size());
    }       

    // public void clearText() {
    //     textArea.
    // }
        
        
    public void getImages(final String mood) {
    
        for (int i = 0; i < files.length; i++) {
            if (files[i].startsWith("pet_" + mood)) {
                pics.add(allPics[i]);
            }
        }
        //System.err.println(pics.size());
    }
    
    public void setMessage(String message) {
        String current = textArea.getText();
        for (int i = 0; i <= message.length(); i++) {
        textArea.setText(current + "\n" + message.substring(0, i));
        //textArea.select(current.length(), (current.length() + message.length() + 1));
        try {
            Thread.sleep(35);
            } catch (Exception e) {
                
            }
        }
    }

    public void setSpeakerMessage(String message, String speaker) {
        String current = textArea.getText();
        for (int i = 0; i <= message.length(); i++) {
        textArea.setText(current + "\n" + speaker + ": " + message.substring(0, i));
        //textArea.select(current.length(), (current.length() + message.length() + 1));
        try {
            Thread.sleep(35);
            } catch (Exception e) {
                
            }
        }
    }

    public void cameraShake(int len, int str) {
        Random rnd = new Random();
        int[] prevpos = {getLocation().x, getLocation().y};
        for (int i = 0; i <len; i++) {
            setLocation(getLocation().x + rnd.nextInt(str)*(Integer.signum(25 - rnd.nextInt(50))), getLocation().y + rnd.nextInt(50)*(Integer.signum(25 - rnd.nextInt(50))));
             try {
            Thread.sleep(25);
            } catch (Exception e) {
                
            }
            setLocation(prevpos[0], prevpos[1]);
        }
    }

    public void setInstantMessage(String message) {
        String current = textArea.getText();
        textArea.setText(current + "\n" + message);
        //textArea.select(current.length(), (current.length() + message.length() + 1));
    }

    public void clearMessage() {
        textArea.setText("");
    }
    
    
    public class ImagePanel extends JPanel {
        public ImagePanel( ) {
            super();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (pics.size() > 0) {
                g.drawImage(pics.get(loopslot), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        }

    }

    public class CentredBackgroundBorder implements Border {
        private final Image image;
     
        public CentredBackgroundBorder(Image image) {
            this.image = image;
        }
     
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g. drawImage(image, 0, 0, VirtualPetFace.this.getWidth(), VirtualPetFace.this.getHeight(),null);
        }
     
        public Insets getBorderInsets(Component c) {
            return new Insets(0,0,0,0);
        }
     
        public boolean isBorderOpaque() {
            return true;
        }
    }
}

 


