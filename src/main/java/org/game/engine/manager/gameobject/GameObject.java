package org.game.engine.manager.gameobject;

import org.game.engine.manager.component.Component;
import org.game.engine.manager.component.collider.Collision;

import java.util.HashMap;
import java.util.Map;

/**
 * A GameObject is an object in a game!
 */
public class GameObject {

    private boolean active;
    private Map<Class<? extends Component>, Component> components;
    private Vector3 position = Vector3.ZERO;


    public GameObject() {
        active = true;
        components = new HashMap<>();
    }
    /**
     * Add a component to this GameObject
     * @param type - Type of the component. Keep in mind a component can only be retrieved with the type it was added with.
     * @param instance - An instance of the given type.
     * @param <T> Subclass of Component
     */
    public <T extends Component> void addComponent(Class<T> type, T instance) {
        instance.setGameObject(this);
        components.put(type, instance);
    }

    public <T extends Component> T getComponent(Class<T> type) {
        return type.cast(components.get(type));
    }

    public void onCollision(final Collision collision) {
        this.components.values().forEach(o -> o.onCollision(collision));
    }

    /**
     * Called by the GameManager every frame, if the GameObject is in the active scene.
     */
    public final void update() {
        this.components.values().forEach(o -> o.update());
    }

    /**
     * Start is called upon scene load, regardless of if the object is active or not.
     */
    public void start() {
        this.components.values().forEach(o -> o.start());
    }

    /**
     * See if the object is active or not. Inactive objects do not have update() called.
     * @return
     */
    public boolean isActive() {
        return this.active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public Vector3 getPosition() {
        return this.position;
    }

    public void setPosition(final Vector3 position) {
        this.position = position;
    }

    public <T extends Component> boolean hasComponent(Class<T> type) {
        return components.containsKey(type);
    }

    public int getZOrder() {
       return position.z;
    }
}
