package RollTheDice;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DiceLabel extends JLabel implements Runnable{
    //Würfeln soll aussehen wie bei digitaler Uhrzeit

    private int value;

    public void setValue(int value) {
        this.value = value;
        repaint();
    }

    public int getValue(){
        return this.value;
    }

    public DiceLabel() {
        setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        //bessere Qualität --> nicht so verpixelt
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);

        //Segmente zeichnen
        g2.scale(getWidth() / 11.0, getHeight() / 18.0);

        for (int i : segmentsForValue[value]) {
            g2.setPaint(new Color(85, 179, 34));
            g2.fillPolygon(getXCoordsOfSegment(i), getYCoordsOfSegment(i), getXCoordsOfSegment(i).length);
            g2.setStroke(new BasicStroke(0.2f));
            //Abstand
            g2.setPaint(new Color(149, 33, 148));
            g2.drawPolygon(getXCoordsOfSegment(i), getYCoordsOfSegment(i), getXCoordsOfSegment(i).length);
        }
    }

    private static int[] getXCoordsOfSegment(int segment) {
        return switch (segment) {
            case 0, 3, 6 -> new int[] {2, 3, 8, 9, 8, 3};
            case 1, 2 -> new int[] {9, 10, 10, 9, 8, 8};
            case 4, 5 -> new int[] {2, 3, 3, 2, 1, 1};
            case 7, 8 -> new int[] {5, 7, 7, 5};
            default -> new int[] {};
        };
    }

    private static int[] getYCoordsOfSegment(int segment) {
        return switch (segment) {
            case 0 -> new int[] {2, 1, 1, 2, 3, 3};
            case 1, 5 -> new int[] {2, 3, 8, 9, 8, 3};
            case 6 -> new int[] {9, 8, 8, 9, 10, 10};
            case 2, 4 -> new int[] {9, 10, 15, 16, 15, 10};
            case 3 -> new int[] {16, 15, 15, 16, 17, 17};
            case 7 -> new int[] {5, 5, 7, 7};
            case 8 -> new int[] {11, 11, 13, 13};
            default -> new int[] {};
        };
    }

    private static int[][] segmentsForValue = {
            {0, 1, 2, 3, 4, 5},
            {1, 2},
            {0, 1, 6, 4, 3},
            {0, 1, 2, 6, 3},
            {5, 6, 1, 2},
            {0, 5, 6, 2, 3},
            {0, 5, 6, 4, 3, 2},
            {0, 1, 2},
            {0, 1, 2, 3, 4, 5, 6},
            {0, 1, 6, 5, 2, 3},
            {7, 8}
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 400);
        DiceLabel diceLabel = new DiceLabel();
        frame.getContentPane().add(diceLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        for (int i = 1; i < 7; i++) {
            diceLabel.setValue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        int min = 1;
        int max = 6;
        int randomNr;

        while (!Thread.interrupted()) {
            randomNr = (int)Math.floor(Math.random() * (max - min + 1) + min);
            setValue(randomNr);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
