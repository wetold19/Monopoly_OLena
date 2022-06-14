package Board;

import Player.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShowConeBoard extends JFrame {
    private final JPanel contentIncluder;
    private static ShowConeBoard instance;
    Adjustments adjustments = Adjustments.getInstance();
    ArrayList<Player> players = new ArrayList<>();
    Board gameBoard;
    Player player;
    Object[] colors = adjustments.getColors();

    //ShowConeBoard showConeBoard = ShowConeBoard.getInstance();
    Board board = Board.getInstance(1, 2, 700, 700);
    private int currentPlayer = 1;
    private String currentPremise = "Graz";
    private int lastPlayer = adjustments.getNoPlayers();
    private int chosenBudget = adjustments.getChosenBudget();
    //alle Felder
    private ArrayList<Field> allSquares = board.getAllSquares();
    private ArrayList<Field> unbuyableSquares = board.getUnbuyableSquares();


    private JLabel infoText = new JLabel("Player: " + currentPlayer);
    private JLabel positionText = new JLabel("Premise: " + currentPremise);
    private JButton btRollDice = new JButton("Roll the Dice");
    private JButton btViewDetails = new JButton("View Premise Details");
    private JButton btBuy = new JButton("Buy");
    JButton btPayRent = new JButton("Pay Rent");
    JButton btFinished = new JButton("Finished");


    public static ShowConeBoard getInstance(){
        if(instance == null){
            instance = new ShowConeBoard();
        }
        return instance;
    }
    private ShowConeBoard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1150,672);
        //setResizable(false);
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

        initContextMenu();

    }

    public void initContextMenu(){
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        rightPanel.setBounds(634, 150, 460, 300);
        rightPanel.setLayout(new GridLayout(3, 1));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JPanel infoTextPanel = new JPanel();
        infoTextPanel.setBackground(Color.getColor(String.valueOf(rightPanel)));
        infoTextPanel.setLayout(new GridLayout(1, 2));

        infoText.setFont(new Font("Arial", Font.BOLD, 22));
        infoText.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        //Color color = (Color) colors[currentPlayer - 1];
        //infoText.setForeground(color);
        infoTextPanel.add(infoText);

        positionText.setFont(new Font("Arial", Font.PLAIN, 18));
        positionText.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        infoTextPanel.add(positionText);
        rightPanel.add(infoTextPanel);

        //Mitte --> Buttons
        JPanel panelMiddle = new JPanel();
        panelMiddle.setLayout(new GridLayout(2, 4, 20, 20));

        btRollDice.setFont(new Font("Arial", Font.PLAIN, 18));
        btRollDice.setForeground(new Color(171, 45, 170));
        btRollDice.setBackground(new Color(112, 218, 55));
        //btRollDice.addActionListener(this::onRollTheDice);
        panelMiddle.add(btRollDice);

        btViewDetails.setFont(new Font("Arial", Font.PLAIN, 18));
        btViewDetails.setForeground(new Color(27, 56, 148));
        btViewDetails.setBackground(new Color(46, 213, 192));
        //btViewDetails.addActionListener(this::onViewDetails);
        btViewDetails.setEnabled(false);
        panelMiddle.add(btViewDetails);

        btBuy.setFont(new Font("Arial", Font.PLAIN, 18));
        btBuy.setForeground(new Color(11, 87, 8));
        btBuy.setBackground(new Color(97, 232, 103));
        //btBuy.addActionListener(this::onBuy);
        btBuy.setEnabled(false);
        panelMiddle.add(btBuy);

        btPayRent.setFont(new Font("Arial", Font.PLAIN, 18));
        btPayRent.setForeground(new Color(148, 27, 27));
        btPayRent.setBackground(new Color(236, 86, 86));
        //btPayRent.addActionListener(this::onPayRent);
        btPayRent.setEnabled(false);
        panelMiddle.add(btPayRent);
        panelMiddle.setBackground(Color.getColor(String.valueOf(rightPanel)));
        rightPanel.add(panelMiddle);
        System.out.println("Hello Lena");

        //Finished
        JPanel finishedPanel = new JPanel();
        finishedPanel.setLayout(new GridLayout(2, 1));

        JLabel label = new JLabel();
        finishedPanel.add(label);

        btFinished.setFont(new Font("Arial", Font.PLAIN, 18));
        btFinished.setForeground(new Color(213, 87, 48));
        btFinished.setBackground(new Color(234, 190, 106));
        //btFinished.addActionListener(this::onFinished);
        btFinished.setEnabled(false);
        finishedPanel.add(btFinished);
        finishedPanel.setBackground(Color.getColor(String.valueOf(rightPanel)));
        rightPanel.add(finishedPanel);

        contentIncluder.add(rightPanel);
    }
    //public void movePlayer(Player player, int totalDices){
        //player.moveSquares( totalDices, player.getPlayerNumber());
    //}

    public static void main(String[] args) {

        ShowConeBoard frame = new ShowConeBoard();
        frame.setVisible(true);

    }
}
