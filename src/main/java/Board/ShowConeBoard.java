package Board;

import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowConeBoard extends JFrame {
    private JPanel contentIncluder;
    ArrayList<Player> players = new ArrayList<>();
    Board gameBoard;
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Player player5;
    Player player6;

    public ShowConeBoard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(652,672);
        setResizable(false);
        setLocationRelativeTo(null);
        contentIncluder = new JPanel();
        setContentPane(contentIncluder);
        contentIncluder.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(6, 6, 800, 800);
        contentIncluder.add(layeredPane);

        gameBoard = Board.getInstance(1, 2, 700, 700);
        gameBoard.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        layeredPane.add(gameBoard, new Integer(0));

        player1 = new Player(1, 1, 1, Color.RED);
        players.add(player1);
        player1.moveSquares( 0, player1.getPlayerNumber());
        layeredPane.add(player1, new Integer(1));

        player2 = new Player(2, 2, 2, Color.BLUE);
        players.add(player2);
        player2.moveSquares(0, player2.getPlayerNumber());
        layeredPane.add(player2, new Integer(1));

        player3 = new Player(3, 2, 2, Color.PINK);
        players.add(player3);
        player3.moveSquares(0, player3.getPlayerNumber());
        layeredPane.add(player3, new Integer(1));

        player4 = new Player(4, 2, 2, Color.CYAN);
        players.add(player4);
        player4.moveSquares(0, player4.getPlayerNumber());
        layeredPane.add(player4, new Integer(1));

        player5 = new Player(5, 2, 2, Color.YELLOW);
        players.add(player5);
        player5.moveSquares( 0, player5.getPlayerNumber());
        layeredPane.add(player5, new Integer(1));

        player6 = new Player( 6, 2, 2, Color.MAGENTA);
        players.add(player6);
        player6.moveSquares( 12, player6.getPlayerNumber());
        layeredPane.add(player6, new Integer(1));

    }

    public static void main(String[] args) {

        ShowConeBoard frame = new ShowConeBoard();
        frame.setVisible(true);

    }
}
