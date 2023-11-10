package org.game.engine.manager;

import org.game.engine.manager.component.collider.Collider;
import org.game.engine.manager.gameobject.GameObject;

import java.util.List;
import java.util.stream.Collectors;

public class PhysicsManager {

    /**
     * This should check for collisions between any GameObject in the scene and deal with physics.
     * gameObjects - List of active game objects in the scene
     */
    public void update(List<GameObject> gameObjects) {
        List<Collider> colliders = gameObjects
                .stream()
                .filter(g -> g.hasComponent(Collider.class))
                .map(g -> g.getComponent(Collider.class))
                .collect(Collectors.toList());

        for (int i = 0; i < colliders.size(); i++) {
            for (int j = i + 1; j < colliders.size(); j++) {
                Collider.tryCollision(colliders.get(i), colliders.get(j));
            }
        }
    }
}
