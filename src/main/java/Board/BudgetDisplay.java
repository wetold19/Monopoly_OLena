package Board;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter
public class BudgetDisplay extends JDialog {
    Adjustments adjustments = Adjustments.getInstance();
    int budget = adjustments.getChosenBudget();
    int noPlayers = adjustments.getNoPlayers();
    private JLabel[] playerLabel = new JLabel[noPlayers];
    JPanel panel = new JPanel();
    //We need individual budgets for every player because of "Losgeld" etc.
    int[] allBudgets = new int[noPlayers];

    public BudgetDisplay() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Display");
        setSize(100, 200);
        setModal(false);
        setLocation(230, 180);
        panel.setLayout(new GridLayout(noPlayers, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int i = 0; i < noPlayers; i++) {
            playerLabel[i] = new JLabel();

            if (i > 0) {
                playerLabel[i].setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
            }
            playerLabel[i].setText("Player " + (i + 1) + ": " + budget + " €");
            allBudgets[i] = budget;
            Color color = (Color) adjustments.getColors()[i];
            playerLabel[i].setForeground(color);
            //playerLabel.setText("Player " + i + ": " + playerList[i-1].getBudget() + "€");

            panel.add(playerLabel[i]);
        }
        add(panel);

        setVisible(true);
    }

    public void updateDisplay(int playerNumber, int newbudget){
        panel.removeAll();
        panel.setLayout(new GridLayout(noPlayers, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int i = 0; i < noPlayers; i++) {
            playerLabel[i] = new JLabel();

            if (i > 0) {
                playerLabel[i].setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
            }
            if(i+1 == playerNumber){
                allBudgets[i] = newbudget;
                playerLabel[i].setText("Player " + (i + 1) + ": " + allBudgets[i] + " €");
            }
            else{
                playerLabel[i].setText("Player " + (i + 1) + ": " + allBudgets[i] + " €");
            }
            Color color = (Color) adjustments.getColors()[i];
            playerLabel[i].setForeground(color);
            //playerLabel.setText("Player " + i + ": " + playerList[i-1].getBudget() + "€");

            panel.add(playerLabel[i]);
        }
        add(panel);

        setVisible(true);
    }

    public int[] getAllBudgets() {
        return allBudgets;
    }

    public void setAllBudgets(int[] allBudgets) {
        this.allBudgets = allBudgets;
    }
}
