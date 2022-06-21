package Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends JPanel{
    private int playerNumber;
    private int position;
    private int budget;
    private Color coneColor;
    //Positionen der Grundstücke speichern --> nicht Namen --> mit Array, wo alle Felder, dann Namen bekommen
    private List<Integer> ownedPremises;

    JLabel lblPlayerNumber;
    private int currentSquareNumber = 0; // where player is currently located on (0 - 19). initially zero


    //Constructor
    public Player(int playerNumber, int position, int budget, Color color, List<Integer> ownedPremises) {
        this.playerNumber = playerNumber;
        this.position = position;
        this.budget = budget;
        this.ownedPremises = ownedPremises;
        this.setBackground(color);
        lblPlayerNumber = new JLabel(""+playerNumber);
        lblPlayerNumber.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        lblPlayerNumber.setForeground(Color.WHITE);
        this.add(lblPlayerNumber);
        this.setBounds(playerNumber*30, 33, 20, 28); // need to fix here for adjustable player numbers
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    //Positions on the board for every field when moving (Position == index of Locationfield)
    int[] xLocationsOfPlayer1 = {21, 121, 221, 321, 421, 521,
            535, 535, 535, 535, 535,
            421, 321, 221, 121, 21,
            20, 20, 20, 20};
    int[] yLocationsOfPlayer1 = {33, 33, 33, 33, 33, 33,
            133, 233, 333, 433, 533,
            543, 543, 543, 543, 543,
            433, 333, 233, 133};

    int[] xLocationsOfPlayer2 = {51, 151, 251, 351, 451, 551,
            560, 560, 560, 560, 560,
            451, 351, 251, 151, 51,
            45, 45, 45, 45};
    int[] yLocationsOfPlayer2 = {33, 33, 33, 33, 33, 33,
            133, 233, 333, 433, 533,
            543, 543, 543, 543, 543,
            433, 333, 233, 133};

    int[] xLocationsOfPlayer3 = {81, 181, 281, 381, 481, 581,
            585, 585, 585, 585, 585,
            481, 381, 281, 181, 81,
            70, 70, 70, 70};
    int[] yLocationsOfPlayer3 = {33, 33, 33, 33, 33, 33,
            133, 233, 333, 433, 533,
            543, 543, 543, 543, 543,
            433, 333, 233, 133};

    int[] xLocationsOfPlayer4 = {21, 121, 221, 321, 421, 521,
            535, 535, 535, 535, 535,
            421, 321, 221, 121, 21,
            20, 20, 20, 20};
    int[] yLocationsOfPlayer4 = {63, 63, 63, 63, 63, 63,
            163, 263, 363, 463, 563,
            573, 573, 573, 573, 573,
            463, 363, 263, 163};

    int[] xLocationsOfPlayer5 = {51, 151, 251, 351, 451, 551,
            560, 560, 560, 560, 560,
            451, 351, 251, 151, 51,
            45, 45, 45, 45};
    int[] yLocationsOfPlayer5 = {63, 63, 63, 63, 63, 63,
            163, 263, 363, 463, 563,
            573, 573, 573, 573, 573,
            463, 363, 263, 163};

    int[] xLocationsOfPlayer6 = {81, 181, 281, 381, 481, 581,
            585, 585, 585, 585, 585,
            481, 381, 281, 181, 81,
            70, 70, 70, 70};
    int[] yLocationsOfPlayer6 = {63, 63, 63, 63, 63, 63,
            163, 263, 363, 463, 563,
            573, 573, 573, 573, 573,
            463, 363, 263, 163};



    public void moveSquares(int dicesTotal, int playerNumber) {
        int targetSquare = (currentSquareNumber + dicesTotal) % 20;
        currentSquareNumber = targetSquare;

        switch (playerNumber){
            case 1 -> this.setLocation(xLocationsOfPlayer1[targetSquare], yLocationsOfPlayer1[targetSquare]);
            case 2 -> this.setLocation(xLocationsOfPlayer2[targetSquare], yLocationsOfPlayer2[targetSquare]);
            case 3 -> this.setLocation(xLocationsOfPlayer3[targetSquare], yLocationsOfPlayer3[targetSquare]);
            case 4 -> this.setLocation(xLocationsOfPlayer4[targetSquare], yLocationsOfPlayer4[targetSquare]);
            case 5 -> this.setLocation(xLocationsOfPlayer5[targetSquare], yLocationsOfPlayer5[targetSquare]);
            case 6 -> this.setLocation(xLocationsOfPlayer6[targetSquare], yLocationsOfPlayer6[targetSquare]);
        }
    }

    /*public Player(int playerNumber, int playerPosition, int budget, Color coneColor) {
        this.playerNumber = playerNumber;
        this.playerPosition = playerPosition;
        this.budget = budget;
        this.coneColor = coneColor;
    }*/

    @Override
    public String toString() {
        return "Player{" +
                "playerNumber=" + playerNumber +
                ", playerPosition=" + position +
                ", budget=" + budget +
                ", coneColor=" + coneColor +
                '}';
    }
}
