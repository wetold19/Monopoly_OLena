package Board;

import RollTheDice.RollTheDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ContextMenu extends JDialog {
    private int currentPlayer = 1;
    private String currentPremise = "Graz";

    public ContextMenu() {
        initComponents();
    }

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
        JLabel infoText = new JLabel("Player: " + currentPlayer);
        infoText.setFont(new Font("Arial", Font.BOLD, 22));
        infoText.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        infoTextPanel.add(infoText);

        JLabel positionText = new JLabel("Premise: " + currentPremise);
        positionText.setFont(new Font("Arial", Font.PLAIN, 18));
        positionText.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        infoTextPanel.add(positionText);

        panel.add(infoTextPanel);

        //Mitte --> Buttons
        JPanel panelMiddle = new JPanel();
        panelMiddle.setLayout(new GridLayout(2, 4, 20, 20));

        JButton btRollDice = new JButton("Roll the Dice");
        btRollDice.setFont(new Font("Arial", Font.PLAIN, 18));
        btRollDice.setForeground(new Color(171, 45, 170));
        btRollDice.setBackground(new Color(112, 218, 55));
        btRollDice.addActionListener(this::onRollTheDice);
        panelMiddle.add(btRollDice);

        JButton btViewDetails = new JButton("View Premise Details");
        btViewDetails.setFont(new Font("Arial", Font.PLAIN, 18));
        btViewDetails.setForeground(new Color(27, 56, 148));
        btViewDetails.setBackground(new Color(46, 213, 192));
        btViewDetails.addActionListener(this::onViewDetails);
        panelMiddle.add(btViewDetails);

        JButton btBuy = new JButton("Buy");
        btBuy.setFont(new Font("Arial", Font.PLAIN, 18));
        btBuy.setForeground(new Color(11, 87, 8));
        btBuy.setBackground(new Color(97, 232, 103));
        btBuy.addActionListener(this::onBuy);
        panelMiddle.add(btBuy);

        JButton btPayRent = new JButton("Pay Rent");
        btPayRent.setFont(new Font("Arial", Font.PLAIN, 18));
        btPayRent.setForeground(new Color(148, 27, 27));
        btPayRent.setBackground(new Color(236, 86, 86));
        btPayRent.addActionListener(this::onPayRent);
        panelMiddle.add(btPayRent);

        panel.add(panelMiddle);

        //Finished
        JPanel finishedPanel = new JPanel();
        finishedPanel.setLayout(new GridLayout(2, 1));

        JLabel label = new JLabel();
        finishedPanel.add(label);

        JButton btFinished = new JButton("Finished");
        btFinished.setFont(new Font("Arial", Font.PLAIN, 18));
        btFinished.setForeground(new Color(213, 87, 48));
        btFinished.setBackground(new Color(234, 190, 106));
        btFinished.addActionListener(this::onFinished);

        finishedPanel.add(btFinished);

        panel.add(finishedPanel);

        //Gesamtes Panel hinzufügen
        add(panel);

        setResizable(false);
        setVisible(true);
    }

    private void onFinished(ActionEvent actionEvent) {
    }

    private void onPayRent(ActionEvent actionEvent) {
    }

    private void onBuy(ActionEvent actionEvent) {
    }

    private void onViewDetails(ActionEvent actionEvent) {
    }

    private void onRollTheDice(ActionEvent actionEvent) {
        RollTheDice rollTheDice = new RollTheDice();
        rollTheDice.printDiceNumbers();
        rollTheDice.setNewPositionOfPlayer();
        System.out.println("Is Pasch: " + rollTheDice.isPasch());
    }

    public static void main(String[] args) {
        ContextMenu contextMenu = new ContextMenu();
    }
}
