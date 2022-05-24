package Board;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Field extends JPanel {
    private String name;
    int totalSquares = 0;
    private int position;
    JLabel nameLabel;
    /*private int rentPrice;
    private int rentPrice1;
    private int rentPrice2;
    private int rentPrice3;
    private int rentPrice4;*/

    @Override
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Field (int xCoord, int yCoord, int width, int height, String labelString, int rotationDegrees){
        position = totalSquares;
        totalSquares++;
        //setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, width, height);
        name = labelString;
        this.setLayout(null);

        //Rotate the name based on which side of the board it is located
        if(rotationDegrees == 0) {
            //If it is not rotated
            nameLabel = new JLabel(labelString);
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setBounds(0,-5,this.getWidth(),this.getHeight());
            nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(nameLabel);
        } else {
            // rotating a Jlabel
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

            //Check how you rotate your field
            if(rotationDegrees == 90) {
                nameLabel.setBounds(20, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == -90) {
                nameLabel.setBounds(-10, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == 180) {
                nameLabel.setBounds(0,  10, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == 135 || rotationDegrees == -135 || rotationDegrees == -45 || rotationDegrees == 45) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

            this.add(nameLabel);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        if(this.position == 1 || this.position == 3 || this.position == 4) {
            g.drawRect(0, this.getHeight()-50, this.getWidth(), 50);
            g.setColor(new Color(192, 240, 255));
            g.fillRect(0, this.getHeight()-50, this.getWidth(), 50);
        }
        if(this.position == 6 || this.position == 8 || this.position == 9) {
            g.drawRect(0, 0, 50, this.getHeight());
            g.setColor(new Color(184, 255, 160));
            g.fillRect(0, 0, 50, this.getHeight());
        }
        if(this.position == 11 || this.position == 13 || this.position == 14) {
            g.drawRect(0, 0, this.getWidth(), 50);
            g.setColor(new Color( 255, 64, 0));
            g.fillRect(0, 0, this.getWidth(), 50);
        }
        if(this.position == 16 || this.position == 17 || this.position == 19) {
            g.drawRect(this.getWidth()-50, 0, 50, this.getHeight());
            g.setColor(new Color(255, 128, 240));
            g.fillRect(this.getWidth()-50, 0, 50, this.getHeight());
        }

    }

    public void setPosition(int position) {
        this.position = position;
        repaint();
    }

    public Field() {
        setBorder(new LineBorder(Color.BLACK, 3));
        //setBackground(new Color(11, 31, 61));
        setOpaque(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        Field field = new Field(300, 400, frame.getWidth()+60, 350, "Wien", 90);
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
