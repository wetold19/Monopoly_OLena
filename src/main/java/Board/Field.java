package Board;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;

@Data
public class Field extends JPanel {

    int number;
    private String name;
    JLabel nameLabel;
    static int totalSquares = 0;
    private int price;
    private int rentPrice;
    private int purchasePrice;

    public Field(int purchasePrice, int rentPrice, int xCoord, int yCoord, int width, int height, String labelString, int rotationDegrees) {
        this.purchasePrice = purchasePrice;
        this.rentPrice = rentPrice;

        number = totalSquares;
        totalSquares++;
        setBorder(new LineBorder(new Color(0, 0, 0)));
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
        if(this.number == 1 || this.number == 2 || this.number == 4) {
            g.drawRect(0, this.getHeight()-20, this.getWidth(), 20);
            g.setColor(new Color(126, 239, 255));
            g.fillRect(0, this.getHeight()-20, this.getWidth(), 20);
        }
        if(this.number == 6 || this.number == 7 || this.number == 8 || this.number == 9) {
            g.drawRect(0, 0, 20, this.getHeight());
            g.setColor(Color.PINK);
            g.fillRect(0, 0, 20, this.getHeight());
        }
        if(this.number == 11 || this.number == 13 || this.number == 14) {
            g.drawRect(0, 0, this.getWidth(), 20);
            g.setColor(Color.ORANGE);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if(this.number == 16 || this.number == 17 || this.number == 18|| this.number == 19) {
            g.drawRect(this.getWidth()-20, 0, 20, this.getHeight());
            g.setColor(new Color(215, 181, 216));
            g.fillRect(this.getWidth()-20, 0, 20, this.getHeight());
        }

    }

}
