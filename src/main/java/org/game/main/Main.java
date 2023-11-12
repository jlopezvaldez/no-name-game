package org.game.main;

import org.game.engine.manager.GameManager;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args){
        final GameManager gameManager = GameManager.getInstance();
        gameManager.setDefaultScene(new TestScene());
        gameManager.startGame();
    }
}