package org.game.engine.manager.component.render;

import org.game.engine.manager.gameobject.GameObject;

import java.awt.Graphics2D;
import java.awt.Image;

public class ImageRenderer extends Renderer {
    private Image image;

    public ImageRenderer(Image image) {
        super();
        this.image = image;
    }

    @Override
    public void render(Graphics2D g2d) {
        if (image != null) {
            int x = (int) this.getGameObject().getPosition().x;
            int y = (int) this.getGameObject().getPosition().y;
            g2d.drawImage(image, x, 480 - y, null); // Modify as needed for position, size, etc.
        }
    }
}
