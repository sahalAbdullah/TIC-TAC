package newtictactoe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GUIBoard implements ActionListener {

    Board board = new Board();
   
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn = true;

    public GUIBoard() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setTitle("TIC TAC TOE");
        frame.setVisible(true);

        textField.setBackground(new Color(50, 50, 50));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        textField.setText("PlayerTurns");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUIBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < 9; i++) {

            textField.setText("0 Turns");
            if (ae.getSource() == buttons[i]) {

                if (player1_turn) {
                    if ("".equals(buttons[i].getText())) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("0");
                        board.placeMovePlayer(i, 2);
                        player1_turn = false;
                        textField.setText("X turn");
                        check();
                        AIturns(player1_turn);
                    }
                }
            }
        }
    }

    public void AIturns(boolean turn) {
        if (turn == false) {
            board.minimax(0, Board.Player_X);

            int j = board.isValidAIMove(board.computerMove);
            buttons[j].setForeground(new Color(0, 0, 255));
            buttons[j].setText("X");
            board.placeMovePlayer(j, 1);
            player1_turn = true;
            check();
            textField.setText("0 turn");
        }
    }

    public void check() {
        if (board.hasPlayerWon(1)) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            JOptionPane.showMessageDialog(null, "AI WINS!😁😁 You Lose😢😢😢", "Display Message", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (board.hasPlayerWon(2)) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
           JOptionPane.showMessageDialog(null, "YOU WINS!😁😁 ,AI LOOSE😢😢😢", "Display Message", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (board.getAvailableCells().isEmpty()) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            JOptionPane.showMessageDialog(null, "DRAW 😊😊", "Display Message", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
}
