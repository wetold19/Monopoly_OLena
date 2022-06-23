package Board;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class Board extends JPanel {
    private static Board theInstance = null;
    private ArrayList<Field> allSquares = new ArrayList<>(); // array with all fields like "Wien"
    private ArrayList<Field> unbuyableSquares = new ArrayList<>(); // squares like "Go", "Gefängnis" etc...

    public ArrayList<Field> getUnbuyableSquares() {
        return unbuyableSquares;
    }

    public ArrayList<Field> getAllSquares() {
        return allSquares;
    }

    public static Board getInstance(int xCoord, int yCoord, int width, int height) {
        if (theInstance == null) {
            theInstance = new Board(xCoord, yCoord, width, height);
        }

        return theInstance;
    }

    public Field getSquareAtIndex(int position) {
        return allSquares.get(position);
    }


    private Board(int xCoord, int yCoord, int width, int height) {
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
                "Action",
                "Amsterdam",
                "Prison",
                "Barcelona",
                "Paris",
                "London",
                "Madrid",
                "Frei parken",
                "New York",
                "Action",
                "Rome",
                "Singapore",
                "Go to Prison",
                "Tokyo",
                "Dubai",
                "Seoul",
                "Bangkok"
        };


        // squares on the top
        Field field00 = new Field(0, 0, 6, 6, 100, 100, squareNames[0], 135);
        field00.setBorder(BorderFactory.createMatteBorder(2, 2, 1, 1, Color.BLACK));
        this.add(field00);
        allSquares.add(field00);
        unbuyableSquares.add(field00);

        Field field01 = new Field(310, 340, 106, 6, 100, 100, squareNames[1], 180);
        field01.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        this.add(field01);
        allSquares.add(field01);

        Field field02 = new Field(350, 215, 206, 6, 100, 100, squareNames[2], 180);
        field02.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        this.add(field02);
        allSquares.add(field02);

        Field field03 = new Field(0, 0, 306, 6, 100, 100, squareNames[3], 180);
        field03.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        this.add(field03);
        allSquares.add(field03);
        unbuyableSquares.add(field03);

        Field field04 = new Field(200, 200, 406, 6, 100, 100, squareNames[4], 180);
        field04.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        this.add(field04);
        allSquares.add(field04);

        Field field05 = new Field(0, 0, 506, 6, 100, 100, squareNames[5], -135);
        field05.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 2, Color.BLACK));
        this.add(field05);
        allSquares.add(field05);
        unbuyableSquares.add(field05);

        // squares on the right
        Field field06 = new Field(250, 210, 506, 106, 100, 100, squareNames[6], -90);
        field06.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.add(field06);
        allSquares.add(field06);

        Field field07 = new Field(380, 320, 506, 206, 100, 100, squareNames[7], -90);
        field07.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.add(field07);
        allSquares.add(field07);
        //unbuyableSquares.add(field07);

        Field field08 = new Field(350, 125, 506, 306, 100, 100, squareNames[8], -90);
        field08.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.add(field08);
        allSquares.add(field08);

        Field field09 = new Field(220, 115, 506, 406, 100, 100, squareNames[9], -90);
        field09.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.add(field09);
        allSquares.add(field09);

        Field field10 = new Field(0, 0,506, 506, 100, 100, squareNames[10], -45);
        field10.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK));
        this.add(field10);
        allSquares.add(field10);
        unbuyableSquares.add(field10);

        // squares on the bottom
        Field field11 = new Field(300, 130, 406, 506, 100, 100, squareNames[11], 0);
        field11.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        this.add(field11);
        allSquares.add(field11);

        Field field12 = new Field(0, 0, 306, 506, 100, 100, squareNames[12], 0);
        field12.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        this.add(field12);
        allSquares.add(field12);
        unbuyableSquares.add(field12);

        Field field13 = new Field(240, 110, 206, 506, 100, 100, squareNames[13], 0);
        field13.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        this.add(field13);
        allSquares.add(field13);

        Field field14 = new Field(310, 150, 106, 506, 100, 100, squareNames[14], 0);
        field14.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        this.add(field14);
        allSquares.add(field14);

        Field field15 = new Field(0, 0, 6, 506, 100, 100, squareNames[15], 45);
        field15.setBorder(BorderFactory.createMatteBorder(1, 2, 2, 1, Color.BLACK));
        this.add(field15);
        allSquares.add(field15);
        unbuyableSquares.add(field15);

        // squares on the left
        Field field16 = new Field(280, 125, 6, 406, 100, 100, squareNames[16], 90);
        field16.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.add(field16);
        allSquares.add(field16);

        Field field17 = new Field(300, 150, 6, 306, 100, 100, squareNames[17], 90);
        field17.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.add(field17);
        allSquares.add(field17);

        Field field18 = new Field(220, 130, 6, 206, 100, 100, squareNames[18], 90);
        field18.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.add(field18);
        allSquares.add(field18);
        //unbuyableSquares.add(field18);

        Field field19 = new Field(150, 110, 6, 106, 100, 100, squareNames[19], 90);
        field19.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.add(field19);
        allSquares.add(field19);


        JLabel lblMonopoly = new JLabel("Monopoly OLena") {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                AffineTransform aT = g2.getTransform();
                Shape oldshape = g2.getClip();
                double x = getWidth() / 2.0;
                double y = getHeight() / 2.0+50;
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