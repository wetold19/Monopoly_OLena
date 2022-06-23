package Board;

import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameOver extends JDialog {

    public void initComponents(int loser) {
        setSize(500, 300);
        setModal(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(26, 27, 80));

        JLabel gameOver = new JLabel("GAME OVER");
        gameOver.setFont(new Font("Baskerville Old Face", Font.BOLD, 44));
        gameOver.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        gameOver.setForeground(new Color(239, 96, 226));
        gameOver.setHorizontalAlignment(JLabel.CENTER);

        JPanel winPanel = new JPanel(new GridLayout(2, 1));
        winPanel.setBackground(new Color(26, 27, 80));

        JLabel winLabel = new JLabel();
        winLabel.setText("Player " + loser + ": You lose!");
        winLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        winLabel.setForeground(new Color(255, 255, 255));
        winLabel.setHorizontalAlignment(JLabel.CENTER);
        winLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JButton button = new JButton("OK");
        button.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        button.addActionListener(this::onClickOK);

        winPanel.add(winLabel);
        winPanel.add(button);

        panel.add(gameOver, BorderLayout.CENTER);
        panel.add(winPanel, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }

    private void onClickOK(ActionEvent actionEvent) {
        System.exit(0);
    }

    public static void main(String[] args) {
        GameOver gameOver = new GameOver();
        gameOver.initComponents(1);
    }
}
