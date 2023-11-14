package org.game.engine.manager.component.render;

import org.game.engine.manager.gameobject.GameObject;
import org.game.engine.manager.gameobject.Vector3;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Color;
import java.awt.geom.AffineTransform;

public class ShapeRenderer extends Renderer {

    private Color color;

    public ShapeRenderer(GameObject gameObject,  Color color) {
        super();
        this.color = color;
    }



    @Override
    public void render(Graphics2D g2d) {
        if (this.getGameObject() != null) {
            Vector3 position = this.getGameObject().getPosition();
//          AffineTransform originalTransform = g2d.getTransform();

            // Create a new transformation for this shape
//          AffineTransform transform = new AffineTransform();
//          transform.translate(position.x, position.y);
//          g2d.transform(transform);

            // Set the color and draw the shape RIGHT NOW IT'S A RECT
            g2d.setColor(color);
            g2d.fillRect(this.getGameObject().getPosition().x, 480 - this.getGameObject().getPosition().y,32, 32); // Or use g2d.draw(shape) for an outline

            // Restore the original transformation
//            g2d.setTransform(originalTransform);
        }
    }
}
