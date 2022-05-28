package Board;

import Player.Player;

import javax.swing.*;
import java.awt.*;

public class Adjustments {
    JFrame frame = new JFrame();
    Player player = new Player();

    String[] colours;
    Object[] colors;
    private int noPlayers;
    private int chosenBudget;

    public Object[] getColors() {
        return colors;
    }

    public void setColors(Object[] colors) {
        this.colors = colors;
    }

    public int getChosenBudget() {
        return chosenBudget;
    }

    public void setChosenBudget(int chosenBudget) {
        this.chosenBudget = chosenBudget;
    }

    private static Adjustments theInstance = null;

    public static Adjustments getInstance() {
        if (theInstance == null) {
            theInstance = new Adjustments();
        }

        return theInstance;
    }

    private Adjustments () {

    }

    public int getNoPlayers() {
        return noPlayers;
    }

    public void setNoPlayers(int noPlayers) {
        this.noPlayers = noPlayers;
    }

    public int setNumberOfPlayers() {
        Object[] playerPossibilities = {"2", "3", "4", "5", "6"};
        String s = null;
        while(s == null){
            s = (String) JOptionPane.showInputDialog(frame, "Choose number of players", "Number of Players",
                    JOptionPane.PLAIN_MESSAGE, null, playerPossibilities, "Players");
            //setNumberOfPlayers();
        }
        setNoPlayers(Integer.parseInt(s));
        return Integer.parseInt(s);
    }

    public Object[] setColourForCone(int noPlayers) {
        //Array für mögliche Farben
        String[] possibleColours = {"Blue", "Red", "Pink", "Yellow", "Violet", "Green", "Orange"};
        String[] colours = new String[noPlayers];

        //für jeden Spieler auswählen
        for (int i = 0; i < noPlayers; i++) {
            //wenn "Abbrechen" oder "Schließen" gedrückt wird, muss es erneut auftauchen
            while(colours[i] == null) {
                colours[i] = (String)JOptionPane.showInputDialog(frame, "Choose colour for the cone of Player " + (i+1), "Set Colour",
                        JOptionPane.PLAIN_MESSAGE, null, possibleColours, "");
            }

            //wenn eine Farbe gewählt wurde, muss sie aus dem Array mit den möglichen Farben gelöscht werden
            for (int j = 0; j < colours.length; j++) {
                for (int k = 0; k < possibleColours.length; k++) {
                    if (colours[j] == possibleColours[k]) {
                        for (int l = k; l < possibleColours.length-1; l++) {
                            possibleColours[l] = possibleColours[l+1];
                        }
                        possibleColours[possibleColours.length-1] = null;
                    }
                }
            }
        }

        //auf color array --> nur Farbnamen
        //jetzt werden die Farben so gespeichert, wie sie im Code gebraucht werden
        Object[] colors = new Object[noPlayers];
        for (int i = 0; i < colours.length; i++) {
            switch (colours[i]) {
                case "Blue" -> colors[i] = new Color(99, 187, 225);
                case "Red" -> colors[i] = new Color(227, 31, 31);
                case "Pink" -> colors[i] = new Color(255, 60, 145);
                case "Yellow" -> colors[i] = new Color(252, 205, 60);
                case "Violet" -> colors[i] = new Color(125, 41, 204);
                case "Green" -> colors[i] = new Color(34, 173, 30);
                case "Orange" -> colors[i] = new Color(255, 90, 39);
                default -> colors[i] = new Color(0, 0, 0);
            }
        }

        setColors(colors);
        return colors;
    }

    public int setBudget() {
        //Array mit möglichen Budgets
        String[] possibleBudgets = {"Standard (1,500 €)", "Beginner (2,000 €)", "Advanced (1,000 €)"};
        String s = null;
        //Budget auswählen
        while (s == null) {
            s = (String) JOptionPane.showInputDialog(frame, "Choose the Budget for every player ", "Set Budget",
                    JOptionPane.PLAIN_MESSAGE, null, possibleBudgets, "");
        }
        String[] budgetString = s.split(" ");

        //ausgewähltes Budget in Zahl umwandeln
        int budget;
        switch (budgetString[0]) {
            case "Standard" -> budget = 1500;
            case "Beginner" -> budget = 2000;
            case "Advanced" -> budget = 1000;
            default -> budget = 0;
        }

        setChosenBudget(budget);
        return budget;
    }

    public static void main(String[] args) {
        Adjustments adjustments = new Adjustments();
        int noPlayers = adjustments.setNumberOfPlayers();
        Object[] colors = adjustments.setColourForCone(noPlayers);
        for (int i = 0; i < colors.length; i++) {
            System.out.println("Player " + i + ": " + colors[i]);
        }
    }
}
