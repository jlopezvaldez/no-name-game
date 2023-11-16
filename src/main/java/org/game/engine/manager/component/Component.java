package org.game.engine.manager.component;

import org.game.engine.manager.component.collider.Collision;
import org.game.engine.manager.gameobject.GameObject;
import org.game.engine.manager.gameobject.Vector3;

/**
 * Components are attached to GameObjects. User scripts will extend Component.
 */
public abstract class Component {

    private GameObject gameObject;
    private Vector3 localPosition;

    public Component() {
        this.localPosition = Vector3.ZERO;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(final GameObject gameObject) {
        this.gameObject = gameObject;
    }

    /**
     * Get position relative to the GameObject which the component is attached to.
     */
    public Vector3 getLocalPosition() {
        return localPosition;
    }

    /**
     * Get global position.
     * @return
     */
    public Vector3 getGlobalPosition() {
        if (gameObject != null) {
            return gameObject.getPosition().add(localPosition);
        }

        return localPosition;
    }

    /**
     * Run by the game manager once a frame.
     */
    public void update() {}

    /**
     * Run by the game manager at the beginning of a scene or upon being added to a GameObject.
     */
    public void start() {}

    /**
     * Set position relative to the GameObject which the component is attached to.
     *
     * @param position - Offset from GameObject's global position
     */
    public void setLocalPosition(Vector3 position) {
        localPosition = position;
    }

    /**
     * Set global position.
     *
     * @param position - Global position
     */
    public void setGlobalPosition(final Vector3 position) {
        if(gameObject != null) {
            localPosition = gameObject.getPosition().subtract(position);

        } else {
            localPosition = position;
        }
    }

    public void onCollision(final Collision collision) {}
}
