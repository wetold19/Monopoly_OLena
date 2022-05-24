package Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends JPanel{
    private int playerNumber;
    private int playerPosition;
    private int budget;
    //Positionen der Grundstücke speichern --> nicht Namen --> mit Array, wo alle Felder, dann Namen bekommen
    //und Anzahl der Häuser speichern
    private int[][] ownedPremises;
    private Color coneColor;

    JLabel lblPlayerNumber;

    public Player(int playerNumber, Color coneColor) {
        // TODO Auto-generated constructor stub
        this.playerNumber = playerNumber;
        this.setBackground(coneColor);
        lblPlayerNumber = new JLabel(""+playerNumber);
        lblPlayerNumber.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        lblPlayerNumber.setForeground(Color.WHITE);
        this.add(lblPlayerNumber);
        this.setBounds(playerNumber*30, 33, 20, 28); // need to fix here for adjustable player numbers
    }
}
