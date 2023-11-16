package org.game.engine.manager.component.render;


import java.awt.Graphics2D;
import java.awt.Image;

public class ImageRenderer extends Renderer {
    private Image image;

    public ImageRenderer(Image image) { //could make it so that param is name of image instead
        super();
        this.image = image;
    }

    @Override
    public void render(Graphics2D g2d) {
        if (image != null) {
            g2d.drawImage(image, this.getGameObject().getPosition().x, 480 - this.getGameObject().getPosition().y, null); // Modify as needed for position, size, etc.
        }
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
