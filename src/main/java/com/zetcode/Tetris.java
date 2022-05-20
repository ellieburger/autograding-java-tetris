package com.zetcode;

import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame {

    private JLabel statusbar;
    private Board board;

    public Tetris() {
        initUI();
    }

    private void initUI() {
        statusbar = new JLabel(" 0");
        statusbar.setFont(new Font("Serif", Font.PLAIN, 32));
        add(statusbar, BorderLayout.NORTH);

        board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JLabel getStatusBar() {
        return statusbar;
    }

    public void dropDown() {
        board.dropDown();
    }

    public boolean isGameOver() {
        return false;
    }

    public void restart() {
        board.start();
        statusbar.setText("");
    }

    public int getLinesRemoved() {
        return board.getLinesRemoved();
    }

    public boolean move(int x_val) {
        return board.tryMove(board.getCurPiece(), board.curX  + x_val, board.curY);
    }

    public boolean rotate(boolean clockwise) {
        Shape piece;
        if (clockwise)
            piece = board.getCurPiece().rotateLeft();
        else
            piece = board.getCurPiece().rotateRight();
        return board.tryMove(piece, board.curX, board.curY);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Tetris game = new Tetris();
            game.setVisible(true);
        });
    }
}