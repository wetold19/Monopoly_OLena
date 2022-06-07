package RollTheDice;

import Player.Player;

import javax.swing.*;
import java.awt.*;

public class RollTheDice {
    private int[] diceNumbers;

    public RollTheDice() {
        DicePanel panel = new DicePanel();
        this.diceNumbers = panel.getDiceNumbers();
    }

    public int getDiceNumber () {
        int diceNumber = diceNumbers[0] + diceNumbers[1];
        System.out.println("DiceNumber: " + diceNumber);
        return diceNumber;
    }

    public boolean isPasch() {
        return diceNumbers[0] == diceNumbers[1];
    }

    public void printDiceNumbers() {
        System.out.println(diceNumbers[0] + " - " + diceNumbers[1]);
    }

    public static void main(String[] args) {
        RollTheDice rollTheDice = new RollTheDice();
        rollTheDice.printDiceNumbers();
        rollTheDice.getDiceNumber();
        System.out.println("Is Pasch: " + rollTheDice.isPasch());
    }
}
