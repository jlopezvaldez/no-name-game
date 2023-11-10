package org.game.engine.manager.scene;

import org.game.engine.manager.gameobject.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Scene {

    private List<GameObject> gameObjects;

    /**
     * Try to avoid overriding this. If overridden make sure it is called.
     * Prefer to put any startup logic in start().
     */
    public Scene() {
        gameObjects = new ArrayList<>();
    }

    /**
     * Called after the scene has been instantiated and set as active.
     */
    public void start() {
    }

    /**
     * Get all game objects in the scene (active or inactive) as an unmodifiable list.
     * Note that elements are NOT copies.
     * @return
     */
    public List<GameObject> getGameObjects() {
        return List.copyOf(gameObjects);
    }

    /**
     * Get all game objects in the scene that are active as an unmodifiable list.
     * Note that elements are NOT copies.
     * @return
     */
    public List<GameObject> getActiveGameObjects() {
        return List.copyOf(gameObjects.stream().filter(g -> g.isActive()).collect(Collectors.toList()));
    }

    /**
     * Add a GameObject to this scene.
     * @param gameObject
     */
    public void addGameObject(final GameObject gameObject) {
        gameObjects.add(gameObject);
        gameObject.start();
    }

    /**
     * Remove a GameObject from this scene.
     * @param gameObject
     */
    public void removeGameObject(GameObject gameObject) {
        gameObject.setActive(false);
        gameObjects.remove(gameObject);
    }

    public void cleanup() {}
}
