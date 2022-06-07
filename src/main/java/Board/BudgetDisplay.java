package Board;

import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;

public class BudgetDisplay extends JDialog {
    Adjustments adjustments = Adjustments.getInstance();

    public BudgetDisplay() {
        initComponents();
    }
    private JLabel playerLabel = new JLabel();
    public void initComponents() {
        setTitle("Display");
        setSize(100, 200);
        setModal(false);
        setLocation(480, 165);

        int noPlayers = adjustments.getNoPlayers();
        int budget = adjustments.getChosenBudget();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(noPlayers, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int i = 0; i < noPlayers; i++) {
            playerLabel = new JLabel();

            if (i > 0) {
                playerLabel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
            }
            playerLabel.setText("Player " + (i + 1) + ": " + budget + " €");
            Color color = (Color) adjustments.getColors()[i];
            playerLabel.setForeground(color);
            //playerLabel.setText("Player " + i + ": " + playerList[i-1].getBudget() + "€");

            panel.add(playerLabel);
        }
        add(panel);

        setVisible(true);
    }
}
