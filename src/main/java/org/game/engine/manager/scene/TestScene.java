package org.game.engine.manager.scene;

import org.game.engine.manager.component.collider.Collider;
import org.game.engine.manager.gameobject.GameObject;
import org.game.engine.manager.gameobject.Vector3;

public class TestScene extends Scene {

    @Override
    public void start() {
        GameObject object = new GameObject();

        GameObject object2 = new GameObject();

        object.addComponent(Collider.class, new Collider(5, 5));
        object2.addComponent(Collider.class, new Collider(5, 5));
        object2.setPosition(Vector3.ZERO);
        object.setPosition(new Vector3(2, 0, 0));
        this.addGameObject(object);
        this.addGameObject(object2);
    }
}
