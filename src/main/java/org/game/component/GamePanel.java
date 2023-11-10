package org.game.component;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JComponent {
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,getWidth(), getHeight());

        //Render game here using g2d;

    }

    public void updateGame() {
        //update game state
        //positions, collisions


        repaint();
    }

}
