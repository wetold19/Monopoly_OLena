package Board;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;

@Data
public class Field extends JPanel {
    //private int number;
    private String name;
    int position;
    private int purchasePrice;
    private int rentPrice;
    //zusätzliche Preise für Häuser --> später
    int totalSquares = 0;
    JLabel nameLabel;

    public Field(int purchasePrice, int rentPrice, int xCoord, int yCoord, int width, int height, String labelString, int rotationDegrees) {
        this.purchasePrice = purchasePrice;
        this.rentPrice = rentPrice;

        position = totalSquares;
        totalSquares++;
        setBounds(xCoord, yCoord, width, height);
        name = labelString;
        this.setLayout(null);

        if(rotationDegrees == 0) {
            nameLabel = new JLabel(labelString);
            nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setBounds(0,20,this.getWidth(),20);
            this.add(nameLabel);
        } else {
            // rotating a Jlabel: https://www.daniweb.com/programming/software-development/threads/390060/rotate-jlabel-or-image-in-label

            nameLabel = new JLabel(labelString) {
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    AffineTransform aT = g2.getTransform();
                    Shape oldshape = g2.getClip();
                    double x = getWidth()/2.0;
                    double y = getHeight()/2.0;
                    aT.rotate(Math.toRadians(rotationDegrees), x, y);
                    g2.setTransform(aT);
                    g2.setClip(oldshape);
                    super.paintComponent(g);
                }
            };
            if(rotationDegrees == 90) {
                nameLabel.setBounds(20, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == -90) {
                nameLabel.setBounds(-10, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == 180) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == 135 || rotationDegrees == -135 || rotationDegrees == -45 || rotationDegrees == 45) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

            this.add(nameLabel);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.position == 1 || this.position == 2 || this.position == 4) {
            g.drawRect(0, this.getHeight()-20, this.getWidth(), 20);
            g.setColor(Color.BLUE);
            g.fillRect(0, this.getHeight()-20, this.getWidth(), 20);
        }
        if(this.position == 6 || this.position == 7 || this.position == 8 || this.position == 9) {
            g.drawRect(0, 0, 20, this.getHeight());
            g.setColor(Color.PINK);
            g.fillRect(0, 0, 20, this.getHeight());
        }
        if(this.position == 11 || this.position == 13 || this.position == 14) {
            g.drawRect(0, 0, this.getWidth(), 20);
            g.setColor(Color.ORANGE);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if(this.position == 16 || this.position == 17 || this.position == 18|| this.position == 19) {
            g.drawRect(this.getWidth()-20, 0, 20, this.getHeight());
            g.setColor(Color.GREEN);
            g.fillRect(this.getWidth()-20, 0, 20, this.getHeight());
        }

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        Field field = new Field(0, 0, 300, 400, frame.getWidth()+60, 350, "Wien", 90);
        //Board.Field field = new Board.Field(300, 400, 200, 350, "Wien", -90);
        //Board.Field field = new Board.Field(300, 400, 280, 140, "Wien", 0);
        //Board.Field field = new Board.Field(400, 300, 280, frame.getHeight()+150, "Wien", 180);

        //Board.Field field = new Board.Field();
        field.setPosition(13);
        frame.getContentPane().add(field);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
