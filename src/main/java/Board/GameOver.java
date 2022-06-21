package Board;

import Player.Player;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JDialog {

    public void initComponents(int loser, int winner) {
        setSize(500, 300);
        setModal(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(26, 27, 80));

        JLabel gameOver = new JLabel("GAME OVER");
        gameOver.setFont(new Font("Baskerville Old Face", Font.BOLD, 44));
        gameOver.setForeground(new Color(239, 96, 226));
        gameOver.setHorizontalAlignment(JLabel.CENTER);

        JLabel winLose = new JLabel();
        if (winner == -1) {
            winLose.setText("Player " + loser + ": You lose!    " +
                    "Winner Undecided!");
        }else {
            winLose.setText("Player " + loser + ": You lose!    " +
                    "Player " + winner + ": You win!");
        }
        winLose.setFont(new Font("Arial", Font.PLAIN, 18));
        winLose.setForeground(new Color(255, 255, 255));
        winLose.setHorizontalAlignment(JLabel.CENTER);
        winLose.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        panel.add(gameOver, BorderLayout.CENTER);
        panel.add(winLose, BorderLayout.SOUTH);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        GameOver gameOver = new GameOver();
        gameOver.initComponents(1, 2);
    }
}
