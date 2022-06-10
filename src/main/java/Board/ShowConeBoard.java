package Board;

import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowConeBoard extends JFrame {
    private JPanel contentIncluder;
    private static ShowConeBoard instance;
    Adjustments adjustments = Adjustments.getInstance();
    ArrayList<Player> players = new ArrayList<>();
    Board gameBoard;
    Player player;
    Object colors[] = adjustments.getColors();

    public static ShowConeBoard getInstance(){
        if(instance == null){
            instance = new ShowConeBoard();
        }
        return instance;
    }
    private ShowConeBoard() {
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

        for(int i = 1; i < adjustments.getNoPlayers()+1; i++){
            player = new Player(i, 1, adjustments.getChosenBudget(), (Color) colors[i-1]);
            player.moveSquares( 0, player.getPlayerNumber());
            layeredPane.add(player, new Integer(1));
            players.add(i-1, player);
        }
    }
    //public void movePlayer(Player player, int totalDices){
        //player.moveSquares( totalDices, player.getPlayerNumber());
    //}

    public static void main(String[] args) {

        ShowConeBoard frame = new ShowConeBoard();
        frame.setVisible(true);

    }
}
