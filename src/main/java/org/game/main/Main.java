package org.game.main;

import org.game.component.GamePanel;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("No Name Platformer");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int delay = 1000 / 60;
        new Timer(delay, e -> gamePanel.updateGame()).start();
        //frame.pack();//sizes frame based on size of components
        frame.setVisible(true);
    }
}