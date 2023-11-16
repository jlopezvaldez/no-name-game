package org.game.main;

import org.game.engine.manager.component.collider.Collider;
import org.game.engine.manager.component.render.Renderer;
import org.game.engine.manager.gameobject.GameObject;
import org.game.engine.manager.gameobject.Vector3;
import org.game.engine.manager.component.render.ShapeRenderer;
import org.game.engine.manager.scene.Scene;

import javax.swing.*;
import java.awt.*;

public class TestScene extends Scene {

    @Override
    public void start() {
        GameObject object = new GameObject();

        Image image = new ImageIcon(getClass().getClassLoader().getResource("plane.png")).getImage();

        object.addComponent(Collider.class, new Collider(5, 5));
        object.addComponent(Renderer.class, new ShapeRenderer(Color.BLUE) {
        });
        object.addComponent(Player.class, new Player());

        GameObject object2 = new GameObject();
        object2.addComponent(Collider.class, new Collider(5, 5));
        object2.setPosition(Vector3.ZERO);
        object.setPosition(new Vector3(2, 0, 0));
        this.addGameObject(object);
        this.addGameObject(object2);
    }
}
