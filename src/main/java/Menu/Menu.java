package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Menu extends JDialog{
    Adjustments adjustments = new Adjustments();

    Container container = this.getContentPane();
    JLabel laHeadline = new JLabel();
    JButton btInstructions = new JButton();
    JButton btAdjustments = new JButton();
    JButton btDuration = new JButton();
    JButton btStartGame = new JButton();

    private String instructions = "";
    String line = "";
    private int numberOfPlayers = 0;
    private int budget = 0;
    private int duration;
    private String[] colours;


    public Menu() {
        initComponents();
    }

    public void initComponents(){
        //Basic stuff
        startPage();

        GridLayout layout = new GridLayout(4, 1);
        layout.setVgap(15);
        JPanel panel = new JPanel(layout);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setTitle("Menu");
        container.setLayout(new BorderLayout());

        //Create JLabel
        laHeadline.setText("Menu");
        laHeadline.setFont(new Font("Curier New", Font.BOLD, 40));
        laHeadline.setHorizontalAlignment((JLabel.CENTER));
        container.add(laHeadline, BorderLayout.NORTH);

        //Create Buttons
        btInstructions.setText("  Game Instructions  ");
        btInstructions.setBackground(Color.pink);
        btInstructions.setFont(new Font("Curier New", Font.PLAIN, 20));
        btInstructions.setBorder(BorderFactory.createLineBorder(new Color(142, 13, 18, 255), 3));
        //Show game insturctions
        btInstructions.addActionListener(e -> onShowInstructions());

        btAdjustments.setText("  Adjustments  ");
        btAdjustments.setBackground(Color.pink);
        btAdjustments.setFont(new Font("Curier New", Font.PLAIN, 20));
        btAdjustments.setBorder(BorderFactory.createLineBorder(new Color(142, 13, 18, 255), 3));
        btAdjustments.addActionListener(this::onDefineAdjustments);

        btDuration.setText("  Duration  ");
        btDuration.setBackground(Color.pink);
        btDuration.setFont(new Font("Curier New", Font.PLAIN, 20));
        btDuration.setBorder(BorderFactory.createLineBorder(new Color(142, 13, 18, 255), 3));
        btDuration.addActionListener(e -> {
            duration = setDuration();
            System.out.println("Duration: " + duration);
        });

        btStartGame.setText("  Start Game!  ");
        btStartGame.setBackground(Color.pink);
        btStartGame.setFont(new Font("Curier New", Font.PLAIN, 20));
        btStartGame.setBorder(BorderFactory.createLineBorder(new Color(142, 13, 18, 255), 3));
        btStartGame.addActionListener(e -> onStartGame());
        btStartGame.setEnabled(false);

        //Abst??nde zwischen den Bl??cken
        panel.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 15));

        //Define layout for panel
        panel.add(btInstructions);
        panel.add(btAdjustments);
        panel.add(btDuration);
        panel.add(btStartGame);

        container.add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    public void onShowInstructions(){
        try{
            String path = "src/main/resources/Instructions.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                String[] values = line.split(";");
                instructions += values[0] + "\n";
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Game Instructions: \n" + instructions);
    }

    public void onDefineAdjustments(ActionEvent e){
        //Number of players:
        numberOfPlayers = adjustments.setNumberOfPlayers();
        //choose colours for each player
        colours = adjustments.setColourForCone(numberOfPlayers);
        //choose starting budget (Standart, advances, beginner)
        budget = adjustments.setBudget();
        //Ausgabe der Werte
        System.out.println("Number of Players: " + numberOfPlayers);
        System.out.println("-------------------------------");

        for (int i = 0; i < colours.length; i++) {
            System.out.println("Player " + (i+1) + ": " + colours[i]);
        }
        System.out.println("-------------------------------");

        System.out.println("Budget: " + budget);

        //Start Game enablen
        btStartGame.setEnabled(true);


    }

    public int setDuration() {
        Object[] possibilities = {"30 minutes", "60 minutes", "90 minutes", "120 minutes"};
        String s = (String)JOptionPane.showInputDialog(container, "Choose duration for game:", "Set Duration",
                JOptionPane.PLAIN_MESSAGE, null, possibilities, "30 minutes");
        if(s != null){
            String[] minutesArray = s.split(" ");
            return Integer.parseInt(minutesArray[0]);
        }
        return 0;

    }

    public void onStartGame(){
        System.out.println("Start Game!!!");
    }

    //Pop Up with heading
    public void startPage() {
        setBackground(new Color(144, 73, 73));
        Panel panel = new Panel();

        //Create "Welcome to Monopoly"
        JLabel welcome = new JLabel("Welcome to Monopoly");
        welcome.setForeground(new Color(149, 33, 148));
        welcome.setFont(new Font("Arial", Font.BOLD, 32));
        panel.add(welcome);

        //Create "Olena"
        JLabel olena = new JLabel("Olena");
        olena.setForeground(new Color(85, 179, 34));
        olena.setFont(new Font("Blackadder ITC", Font.PLAIN, 28));
        panel.add(olena);

        //Create Button
        Object[] buttonName = {"START"};

        JOptionPane.showOptionDialog(container, panel, "Startpage", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonName, buttonName);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public int getBudget() {
        return budget;
    }
    public int getDuration() {
        return duration;
    }
    public String[] getColours() {
        return colours;
    }

}
