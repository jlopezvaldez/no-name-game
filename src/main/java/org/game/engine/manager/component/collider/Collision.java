package org.game.engine.manager.component.collider;

import java.util.List;

/**
 * Contains the data of a collision.
 */
public class Collision {

    private final Collider other;

    public Collision(final Collider other) {
        this.other = other;
    }

    /**
     * Get the collider of the colliding GameObject.
     * @return
     */
    public Collider getOther() {
        return other;
    }
}
