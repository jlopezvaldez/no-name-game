package org.game.engine.manager;

import org.game.engine.manager.component.collider.Collider;
import org.game.engine.manager.gameobject.GameObject;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PhysicsManager {

    /**
     *Check for collisions between any GameObject using Sweep and Prune.
     */
    public void checkCollisions(List<GameObject> gameObjects) {
        List<Collider> colliders = gameObjects
                .stream()
                .filter(g -> g.hasComponent(Collider.class))
                .map(g -> g.getComponent(Collider.class))
                .collect(Collectors.toList());

        // Sort the colliders based on their minimum x-coordinate
        //not sure if getPosition should be global instead
        //colliders.sort(Comparator.comparingDouble(c -> c.getGameObject().getPosition().x - c.getWidth() / 2.0));

        colliders.sort(Comparator.comparingDouble(c -> c.getGlobalPosition().x - c.getWidth() / 2.0));

        //check for collisions
        for (int i = 0; i < colliders.size(); i++) {
            Collider current = colliders.get(i);

            for (int j = i +1; j < colliders.size(); j++) {
                Collider other = colliders.get(j);

                //Break inner loop if next collider is too far
                if (other.getGlobalPosition().x - other.getWidth() / 2.0 >
                    current.getGlobalPosition().x + current.getWidth() / 2.0) {
                    break;
                }

                if (doesOverlap(current, other)) {
                    Collider.tryCollision(current, other);
                }
            }
        }
    }

    private boolean doesOverlap(Collider a, Collider b) {
        //check for overlap along y
        return a.getGlobalPosition().y - a.getLength() / 2.0 < b.getGlobalPosition().y + b.getLength() / 2.0 &&
                a.getGlobalPosition().y + a.getLength() / 2.0 > b.getGlobalPosition().y - b.getLength() / 2.0;
    }


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
