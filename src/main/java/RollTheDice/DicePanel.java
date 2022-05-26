package RollTheDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DicePanel extends JDialog{
    private DiceLabel[] diceLabels = new DiceLabel[2];
    public DicePanel() {
        initComponents();
    }
    public void initComponents() {
        setTitle("Roll the Dice");
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(1, 2));
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1, 2));

        //First Dice
        diceLabels[0] = new DiceLabel();
        panelNorth.add(diceLabels[0]);

        //Second Dice
        diceLabels[1] = new DiceLabel();
        panelNorth.add(diceLabels[1]);

        //Start und Stop Buttons
        btStart = new JButton("Start");
        btStart.setFont(font);
        btStart.addActionListener(this::onStartClick);
        panelSouth.add(btStart);

        btStop = new JButton("Stop");
        btStop.setFont(font);
        btStop.addActionListener(this::onStopClick);
        panelSouth.add(btStop);

        panel.add(panelNorth);
        panel.add(panelSouth, BorderLayout.SOUTH);

        add(panel);

        setResizable(false);
        setVisible(true);
    }

    DiceLabel diceLabel = new DiceLabel();
    private Thread firstDiceThread;
    private Thread secondDiceThread;

    private void onStartClick(ActionEvent actionEvent) {
        if (firstDiceThread == null || !firstDiceThread.isAlive()) {
            firstDiceThread = new Thread(diceLabels[0]);
            firstDiceThread.start();
        }

        if (secondDiceThread == null || !secondDiceThread.isAlive()) {
            secondDiceThread = new Thread(diceLabels[1]);
            secondDiceThread.start();
        }
    }

    private int[] diceNumbers = new int[2];

    public int[] getDiceNumbers() {
        return diceNumbers;
    }

    private void onStopClick(ActionEvent actionEvent) {
        if (firstDiceThread != null && firstDiceThread.isAlive()) {
            firstDiceThread.interrupt();
        }

        if (secondDiceThread != null && secondDiceThread.isAlive()) {
            secondDiceThread.interrupt();
        }

        diceNumbers[0] = diceLabels[0].getValue();
        diceNumbers[1] = diceLabels[1].getValue();

        //dispose();
    }

    public static void main(String[] args) {
        DicePanel panel = new DicePanel();
    }


    private JButton btStart;
    private JButton btStop;
    private Font font = new Font("Verdana", Font.BOLD + Font.ITALIC, 36);
}
