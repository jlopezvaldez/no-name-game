package org.game.main;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        init();
    }

    private void init() {
        setTitle("no name platformer");
        setSize(1366,768);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    public static void main(String[] args){
        Main main = new Main();
        main.setVisible(true);
    }
}