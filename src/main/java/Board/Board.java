package Board;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Board extends JPanel {
    private ArrayList<Field> allSquares = new ArrayList<Field>(); // array with all fields like "Wien"
    private ArrayList<Field> unbuyableSquares = new ArrayList<Field>(); // squares like "Go", "Gefängnis" etc...

    public ArrayList<Field> getUnbuyableSquares() {
        return unbuyableSquares;
    }

    public ArrayList<Field> getAllSquares() {
        return allSquares;
    }

    public Field getSquareAtIndex(int position) {
        return allSquares.get(position);
    }


    public Board(int xCoord, int yCoord, int width, int height) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, 612, 612);
        this.setLayout(null);
        initializeSquares();
    }

    private void initializeSquares() {
        String[] squareNames = {
                "Go",
                "Vienna",
                "Berlin",
                "Chance",
                "Amsterdam",
                "Gefängnis",
                "Barcelona",
                "Paris",
                "London",
                "Madrid",
                "Frei parken",
                "New York",
                "Chance",
                "Rome",
                "Singapore",
                "Ins Gefängnis",
                "Tokyo",
                "Dubai",
                "Seoul",
                "Bangkok"
        };


        // squares on the top
        Field field00 = new Field(6, 6, 110, 110, squareNames[0], 135);
        field00.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field00);
        allSquares.add(field00);
        unbuyableSquares.add(field00);

        Field field01 = new Field(116, 6, 110, 110, squareNames[1], 180);
        field01.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field01);
        allSquares.add(field01);

        Field field02 = new Field(226, 6, 110, 110, squareNames[2], 180);
        field02.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field02);
        allSquares.add(field02);
        unbuyableSquares.add(field02);

        Field field03 = new Field(336, 6, 110, 110, squareNames[3], 180);
        field03.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field03);
        allSquares.add(field03);

        Field field04 = new Field(446, 6, 110, 110, squareNames[4], 180);
        field04.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field04);
        allSquares.add(field04);

        Field field05 = new Field(556, 6, 110, 110, squareNames[5], -135);
        field05.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field05);
        allSquares.add(field05);
        unbuyableSquares.add(field05);

        // squares on the right
        Field field06 = new Field(556, 116, 110, 110, squareNames[6], -90);
        field06.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field06);
        allSquares.add(field06);

        Field field07 = new Field(556, 226, 110, 110, squareNames[7], -90);
        field07.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field07);
        allSquares.add(field07);
        unbuyableSquares.add(field07);

        Field field08 = new Field(556, 336, 110, 110, squareNames[8], -90);
        field08.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field08);
        allSquares.add(field08);

        Field field09 = new Field(556, 446, 110, 110, squareNames[9], -90);
        field09.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field09);
        allSquares.add(field09);

        Field field10 = new Field(556, 556, 110, 110, squareNames[10], -45);
        field10.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field10);
        allSquares.add(field10);
        unbuyableSquares.add(field10);

        // squares on the bottom
        Field field11 = new Field(446, 556, 110, 110, squareNames[11], 0);
        field11.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field11);
        allSquares.add(field11);

        Field field12 = new Field(336, 556, 110, 110, squareNames[12], 0);
        field12.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field12);
        allSquares.add(field12);
        unbuyableSquares.add(field12);

        Field field13 = new Field(226, 556, 110, 110, squareNames[13], 0);
        field13.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field13);
        allSquares.add(field13);

        Field field14 = new Field(116, 556, 110, 110, squareNames[14], 0);
        field14.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field14);
        allSquares.add(field14);

        Field field15 = new Field(6, 556, 110, 110, squareNames[15], 45);
        field15.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field15);
        allSquares.add(field15);
        unbuyableSquares.add(field15);

        // squares on the left
        Field field16 = new Field(6, 446, 110, 110, squareNames[16], 90);
        field16.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field16);
        allSquares.add(field16);

        Field field17 = new Field(6, 336, 110, 110, squareNames[17], 90);
        field17.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field17);
        allSquares.add(field17);

        Field field18 = new Field(6, 226, 110, 110, squareNames[18], 90);
        field18.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field18);
        allSquares.add(field18);
        unbuyableSquares.add(field18);

        Field field19 = new Field(6, 116, 110, 110, squareNames[19], 90);
        field19.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(field19);
        allSquares.add(field19);

        // setting prices
        /*square01.setPrice(100);
        square03.setPrice(100);
        field04.setPrice(120);

        square06.setPrice(140);
        field08.setPrice(140);
        field09.setPrice(160);

        square11.setPrice(180);
        field13.setPrice(180);
        field14.setPrice(200);

        field16.setPrice(300);
        field17.setPrice(300);
        square19.setPrice(320);

        // setting rent prcies
        square01.setRentPrice(6);
        square03.setRentPrice(6);
        field04.setRentPrice(8);

        square06.setRentPrice(10);
        field08.setRentPrice(10);
        field09.setRentPrice(12);

        square11.setRentPrice(14);
        field13.setRentPrice(14);
        field14.setRentPrice(16);

        field16.setRentPrice(26);
        field17.setRentPrice(26);
        square19.setRentPrice(28);*/


        JLabel lblMonopoly = new JLabel("Monopoly OLena") {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                AffineTransform aT = g2.getTransform();
                Shape oldshape = g2.getClip();
                double x = getWidth() / 2.0;
                double y = getHeight() / 2.0;
                aT.rotate(Math.toRadians(-35), x, y);
                g2.setTransform(aT);
                g2.setClip(oldshape);
                super.paintComponent(g);
            }
        };
        lblMonopoly.setBackground(new Color(111, 226, 44));
        lblMonopoly.setForeground(new Color(149, 33, 148));
        lblMonopoly.setOpaque(true);
        lblMonopoly.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonopoly.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        lblMonopoly.setBounds(179, 277, 330/*263*/, 55);
        this.add(lblMonopoly);

    }

    public void printSquares() {
        for(int i = 0; i < allSquares.size(); i++){
            System.out.println(allSquares.get(i).getName());
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(685, 710);
        Board board = new Board(1, 2, 700, 700);
        board.setVisible(true);
        frame.getContentPane().add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        board.printSquares();
        System.out.println(board.getSquareAtIndex(0).getName());
    }
}

