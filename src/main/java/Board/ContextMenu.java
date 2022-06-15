package Board;

import Player.Player;
import RollTheDice.RollTheDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ContextMenu extends JDialog {
    /*Adjustments adjustments = Adjustments.getInstance();
    //ShowConeBoard showConeBoard = ShowConeBoard.getInstance();
    Board board = Board.getInstance(1, 2, 700, 700);
    private int currentPlayer = 1;
    private String currentPremise = "Graz";
    private int lastPlayer = adjustments.getNoPlayers();
    private Object[] colors = adjustments.getColors();
    private int chosenBudget = adjustments.getChosenBudget();
    //Liste für alle Mitspieler
    private List<Player> players = new ArrayList<>();
    //alle Felder
    private ArrayList<Field> allSquares = board.getAllSquares();
    private ArrayList<Field> unbuyableSquares = board.getUnbuyableSquares();


    public ContextMenu() {
        initComponents();

        for (int i = 0; i < lastPlayer; i++) {
            players.add(new Player(i+1, 0, chosenBudget, (Color) colors[i]));
        }

        printList();
    }

    private JLabel infoText = new JLabel("Player: " + currentPlayer);
    private JLabel positionText = new JLabel("Premise: " + currentPremise);
    private JButton btRollDice = new JButton("Roll the Dice");
    private JButton btViewDetails = new JButton("View Premise Details");
    private JButton btBuy = new JButton("Buy");
    JButton btPayRent = new JButton("Pay Rent");
    JButton btFinished = new JButton("Finished");

    public void initComponents() {
        setTitle("Context Menu");
        setSize(500, 600);
        setModal(false);
        setLocation(1300, 165);
        setBackground(new Color(84, 192, 188));

        //Panel für alle
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //infoText und Details
        JPanel infoTextPanel = new JPanel();
        infoTextPanel.setLayout(new GridLayout(1, 2));

        //ToDo: Spieler noch in Kegelfarbe!!!
        infoText.setFont(new Font("Arial", Font.BOLD, 22));
        infoText.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        Color color = (Color) colors[currentPlayer-1];
        infoText.setForeground(color);
        infoTextPanel.add(infoText);

        positionText.setFont(new Font("Arial", Font.PLAIN, 18));
        positionText.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        infoTextPanel.add(positionText);

        panel.add(infoTextPanel);

        //Mitte --> Buttons
        JPanel panelMiddle = new JPanel();
        panelMiddle.setLayout(new GridLayout(2, 4, 20, 20));

        btRollDice.setFont(new Font("Arial", Font.PLAIN, 18));
        btRollDice.setForeground(new Color(171, 45, 170));
        btRollDice.setBackground(new Color(112, 218, 55));
        btRollDice.addActionListener(this::onRollTheDice);
        panelMiddle.add(btRollDice);

        btViewDetails.setFont(new Font("Arial", Font.PLAIN, 18));
        btViewDetails.setForeground(new Color(27, 56, 148));
        btViewDetails.setBackground(new Color(46, 213, 192));
        btViewDetails.addActionListener(this::onViewDetails);
        btViewDetails.setEnabled(false);
        panelMiddle.add(btViewDetails);

        btBuy.setFont(new Font("Arial", Font.PLAIN, 18));
        btBuy.setForeground(new Color(11, 87, 8));
        btBuy.setBackground(new Color(97, 232, 103));
        btBuy.addActionListener(this::onBuy);
        btBuy.setEnabled(false);
        panelMiddle.add(btBuy);

        btPayRent.setFont(new Font("Arial", Font.PLAIN, 18));
        btPayRent.setForeground(new Color(148, 27, 27));
        btPayRent.setBackground(new Color(236, 86, 86));
        btPayRent.addActionListener(this::onPayRent);
        btPayRent.setEnabled(false);
        panelMiddle.add(btPayRent);

        panel.add(panelMiddle);

        //Finished
        JPanel finishedPanel = new JPanel();
        finishedPanel.setLayout(new GridLayout(2, 1));

        JLabel label = new JLabel();
        finishedPanel.add(label);

        btFinished.setFont(new Font("Arial", Font.PLAIN, 18));
        btFinished.setForeground(new Color(213, 87, 48));
        btFinished.setBackground(new Color(234, 190, 106));
        btFinished.addActionListener(this::onFinished);
        btFinished.setEnabled(false);
        finishedPanel.add(btFinished);

        panel.add(finishedPanel);

        //Gesamtes Panel hinzufügen
        add(panel);

        //setResizable(false);
        setVisible(true);
    }

    public void initComponentsViewDetails() {
        JDialog jDialog = new JDialog();
        jDialog.setTitle("Premise Details");
        jDialog.setSize(400, 200);
        jDialog.setModal(false);
        jDialog.setLocation(1300, 165);
        jDialog.setBackground(new Color(46, 213, 192));

        int playerPosition = players.get(currentPlayer-1).getPosition();

        //Gesamtpanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String fieldName = allSquares.get(playerPosition-1).getName();
        JLabel fieldLabel = new JLabel();
        fieldLabel.setText(fieldName + ":");
        fieldLabel.setForeground(new Color(27, 56, 148));
        fieldLabel.setFont(new Font("Curier New", Font.BOLD, 20));
        fieldLabel.setBorder(BorderFactory.createLineBorder(new Color(27, 56, 148), 2));
        fieldLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(fieldLabel, BorderLayout.NORTH);

        if (unbuyableSquares.contains(allSquares.get(playerPosition))) {
            JLabel unbuyableFieldLabel = new JLabel();
            unbuyableFieldLabel.setText("Unbuyable Field!");
            panel.add(unbuyableFieldLabel);
        }else {
            JLabel purchaseLabel = new JLabel();
            int purchasePrice = allSquares.get(playerPosition).getPurchasePrice();
            purchaseLabel.setText("Purchasing Price: " + purchasePrice + " €");
            //purchaseLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(purchaseLabel);

            JLabel rentLabel = new JLabel();
            int rentPrice = allSquares.get(playerPosition).getRentPrice();
            rentLabel.setText("Rent Price: " + rentPrice + " €");
            //rentLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(rentLabel);
        }

        jDialog.add(panel);
        jDialog.setResizable(false);
        jDialog.setVisible(true);
    }

    public void printList() {
        for (int i = 0; i < allSquares.size(); i++) {
            System.out.println(allSquares.get(i));
        }
        System.out.println("-----------------");
        for (int i = 0; i < unbuyableSquares.size(); i++) {
            System.out.println(unbuyableSquares.get(i));
        }
    }

    private void onFinished(ActionEvent actionEvent) {
        System.out.println("Finished: next Player");
        if (currentPlayer == lastPlayer) {
            currentPlayer = 1;
        }else{
            currentPlayer++;
        }
        infoText.setText("Player: " + currentPlayer);
        infoText.setForeground((Color) colors[currentPlayer-1]);

        btRollDice.setEnabled(true);
        btViewDetails.setEnabled(false);
        btBuy.setEnabled(false);
        btPayRent.setEnabled(false);
        btFinished.setEnabled(false);
    }

    private void onPayRent(ActionEvent actionEvent) {
        System.out.println("Pay Rent");
        //ToDo: nachschauen und Preis bezahlen lassen --> mit MessageDialog zeigen wie viel
    }

    private boolean isPayRent() {
        //ToDo: überprüfen, ob Grundstück einem Mitspieler gehört
        btFinished.setEnabled(true);

        return false;
    }

    private void onBuy(ActionEvent actionEvent) {
        System.out.println("Buy");
        //ToDo: überprüfen, ob genug Geld vorhanden und kaufen bzw. Fehlermeldung, wenn zu wenig Geld
    }

    private boolean isBuy() {
        //ToDo: überprüfen, ob man Grundstück kaufen kann

        return true;
    }

    private void onViewDetails(ActionEvent actionEvent) {
        initComponentsViewDetails();
    }

    public void onRollTheDice(ActionEvent actionEvent) {
        RollTheDice rollTheDice = new RollTheDice();
        rollTheDice.printDiceNumbers();
        System.out.println("Is Pasch: " + rollTheDice.isPasch());

        //neue Position von Spieler setzen
        int diceNumber = rollTheDice.getDiceNumber();
        int newPosition = players.get(currentPlayer-1).getPosition() + diceNumber - 1;
        players.get(currentPlayer-1).setPosition(newPosition);
        //showConeBoard.movePlayer(players.get(currentPlayer-1), 3);
        //players.get(currentPlayer-1).moveSquares(newPosition, currentPlayer);
        //System.out.println("player moved");
        System.out.println("Player " + currentPlayer + ": " + players.get(currentPlayer-1).getPosition());


        btRollDice.setEnabled(false);
        btViewDetails.setEnabled(true);

        if (isPayRent()) {
            btPayRent.setEnabled(true);
        }else {
            btFinished.setEnabled(true);
        }

        if (isBuy()) {
            btBuy.setEnabled(true);
        }
    }*/
}