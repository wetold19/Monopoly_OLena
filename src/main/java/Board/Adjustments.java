package Board;

import javax.swing.*;

public class Adjustments {
    JFrame frame = new JFrame();

    public int setNumberOfPlayers() {
        Object[] playerPossibilities = {"2", "3", "4", "5", "6"};
        String s = null;
        while(s == null){
            s = (String) JOptionPane.showInputDialog(frame, "Choose number of players", "Number of Players",
                    JOptionPane.PLAIN_MESSAGE, null, playerPossibilities, "Players");
            //setNumberOfPlayers();
        }
        return Integer.parseInt(s);
    }

    public String[] setColourForCone(int noPlayers) {
        //Array für die Farben, die ausgewählt wurden
        String[] colours = new String[noPlayers];
        //Array für mögliche Farben
        String[] possibleColours = {"Blue", "Red", "Pink", "Yellow", "Black", "Green", "Orange"};

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

        return colours;
    }

    public int setBudget() {
        //Array mit möglichen Budgets
        String[] possibleBudgets = {"Standard (1,500 €)", "Beginner (2,000 €)", "Advanced (1,000 €)"};
        String s = null;
        //Budget auswählen
        while( s == null){
             s = (String)JOptionPane.showInputDialog(frame, "Choose the Budget for every player ", "Set Budget",
                    JOptionPane.PLAIN_MESSAGE, null, possibleBudgets, "");
        }
        String[] budgetString = s.split(" ");

        //ausgewähltes Budget in Zahl umwandeln
        int budget;
        switch(budgetString[0]) {
            case "Standard" -> budget = 1500;
            case "Beginner" -> budget = 2000;
            case "Advanced" -> budget = 1000;
            default -> budget = 0;
        }

        return budget;
    }


    public static void main(String[] args) {
        Adjustments adjustments = new Adjustments();

        int noPlayers = adjustments.setNumberOfPlayers();
        System.out.println("Number of Players: " + noPlayers);

        System.out.println("-------------------------------");

        String[] colours = adjustments.setColourForCone(noPlayers);
        for (int i = 0; i < colours.length; i++) {
            System.out.println("Player " + (i+1) + ": " + colours[i]);
        }

        System.out.println("-------------------------------");

        System.out.println("Budget: " + adjustments.setBudget());
    }
}
