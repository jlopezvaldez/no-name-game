package org.game.engine.manager;

import org.game.engine.manager.gameobject.GameObject;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.List;

/**
 * Handles the rendering of every game object in a scene.
 */
public class Graphics2DRenderingManager extends JComponent {

    public Graphics2DRenderingManager() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0,getWidth(), getHeight());
    }

    /**
     * This should effectively just repaint every Renderer attached to active game objects in a scene.
     * @param gameObjects - Active game objects in the scene
     */
    public void update(List<GameObject> gameObjects) {
        // TODO: Eventually we should not render objects that are off screen.
        // Get list of renderers from gameObjects, sort by position.Z and paint.
        repaint();
    }
}
