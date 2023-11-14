package org.game.engine.manager;

import org.game.engine.manager.component.render.Renderer;
import org.game.engine.manager.gameobject.GameObject;
import org.game.engine.manager.component.render.ShapeRenderer;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the rendering of every game object in a scene.
 */
public class Graphics2DRenderingManager extends JComponent {

    private List<GameObject> gameObjects = new ArrayList<>();

    public Graphics2DRenderingManager() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        System.out.println(getWidth());
        System.out.println(getHeight());
        gameObjects.stream().forEach(gameObject -> {
            if (gameObject.hasComponent(Renderer.class))
                gameObject.getComponent(Renderer.class).render(g2d);
        });
    }

    /**
     * This should effectively just repaint every Renderer attached to active game objects in a scene.
     * @param gameObjects - Active game objects in the scene
     */
    public void update(List<GameObject> gameObjects) {
        // TODO: Eventually we should not render objects that are off screen.
        // Get list of renderers from gameObjects, sort by position.Z and paint.
        this.gameObjects = gameObjects;
//        gameObjects.sort(Comparator.comparingInt(GameObject::getZOrder));
        repaint();
    }
}
