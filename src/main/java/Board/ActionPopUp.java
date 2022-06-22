package Board;
import lombok.Getter;
import lombok.ToString;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Getter
public class ActionPopUp extends JDialog {
    JPanel panel = new JPanel();
    private String[] actions = new String[] {"You have won 100€ at a Crossword puzzle Competition.", " Go to the GO field.",
            "Go to the field before GO.", "The bank pays you 50€.", "Plant flowers on your premises for 200€.",
            "Penalty for driving too fast 300€.", "Go to jail.", "Pay each player 50€.", "You buy a hamburger, pay 30€."};
    Random random = new Random();
    private int action;

    public ActionPopUp() {
        initComponents();
    }

    public void initComponents(){
        JDialog jDialog = new JDialog();
        jDialog.setTitle("Action Card");
        jDialog.setSize(400, 200);
        jDialog.setModal(false);
        jDialog.setLocationRelativeTo(null);
        panel.setLayout(new GridLayout(2, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            JLabel heading = new JLabel("Action card");
            heading.setFont(new Font("Curier New", Font.BOLD, 20));
            heading.setBorder(BorderFactory.createLineBorder(new Color(111, 226, 44), 2));
            heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);
        action = random.nextInt(8);
        action = 1;
            JLabel actionText = new JLabel(actions[action]);
            actionText.setFont(new Font("Curier New", Font.PLAIN, 15));
            actionText.setHorizontalAlignment(JLabel.CENTER);
        panel.add(actionText);
        jDialog.add(panel);
        jDialog.setResizable(false);
        jDialog.setVisible(true);
    }

    public static void main(String[] args) {
        new ActionPopUp();
    }
}
