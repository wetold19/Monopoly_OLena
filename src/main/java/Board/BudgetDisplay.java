package Board;

import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;

public class BudgetDisplay extends JDialog {
    Adjustments adjustments = Adjustments.getInstance();

    public BudgetDisplay() {
        initComponents();
    }
    private JLabel[] playerLabel;
    public void initComponents() {
        setTitle("Display");
        setSize(100, 200);
        setModal(false);
        setLocation(480, 165);

        int noPlayers = adjustments.getNoPlayers();
        int budget = adjustments.getChosenBudget();

        playerLabel = new JLabel[noPlayers];

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(noPlayers, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int i = 0; i < noPlayers; i++) {
            playerLabel[i] = new JLabel();

            if (i > 0) {
                playerLabel[i].setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
            }
            playerLabel[i].setText("Player " + (i + 1) + ": " + budget + " €");
            Color color = (Color) adjustments.getColors()[i];
            playerLabel[i].setForeground(color);
            //playerLabel.setText("Player " + i + ": " + playerList[i-1].getBudget() + "€");

            panel.add(playerLabel[i]);
        }
        add(panel);

        setVisible(true);
    }
}
