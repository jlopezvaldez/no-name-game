package org.game.main;

import org.game.engine.manager.component.DummyRenderer;
import org.game.engine.manager.component.collider.Collider;
import org.game.engine.manager.gameobject.GameObject;
import org.game.engine.manager.gameobject.Vector3;
import org.game.engine.manager.scene.Scene;

public class TestScene extends Scene {

    @Override
    public void start() {
        GameObject object = new GameObject();

        object.addComponent(Collider.class, new Collider(5, 5));
        object.addComponent(DummyRenderer.class, new DummyRenderer());
        object.addComponent(Player.class, new Player());

        GameObject object2 = new GameObject();
        object2.addComponent(Collider.class, new Collider(5, 5));
        object2.setPosition(Vector3.ZERO);
        object.setPosition(new Vector3(2, 0, 0));
        this.addGameObject(object);
        this.addGameObject(object2);
    }
}
