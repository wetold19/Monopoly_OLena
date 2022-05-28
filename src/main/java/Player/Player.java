package Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player{
    private int playerNumber;
    private int playerPosition;
    private int budget;
    private Color coneColor;
    //Positionen der Grundstücke speichern --> nicht Namen --> mit Array, wo alle Felder, dann Namen bekommen
    //und Anzahl der Häuser speichern
    private int[][] ownedPremises;


    public Player(int playerNumber, int playerPosition, int budget, Color coneColor) {
        this.playerNumber = playerNumber;
        this.playerPosition = playerPosition;
        this.budget = budget;
        this.coneColor = coneColor;
    }
}
