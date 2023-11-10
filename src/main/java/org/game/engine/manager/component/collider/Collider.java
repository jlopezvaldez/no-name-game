package org.game.engine.manager.component.collider;

import org.game.engine.manager.component.Component;

import java.util.Optional;

/**
 * Basic rectangular collider with width and length.
 */
public class Collider extends Component {

    private int width;
    private int length;

    /**
     * Create a collider with the desired width and length.
     * @param width
     * @param length
     */
    public Collider(int width, int length) {
        super();
        this.width = width;
        this.length = length;
    }

    /**
     * See if there is a collision between the two objects. If there is then send collision events to both objects.
     * @param collider
     * @param collider2
     */
    public static void tryCollision(final Collider collider, final Collider collider2) {
        final Optional<Collision[]> collision = collider.doesCollide(collider2);

        if (collision.isPresent()) {
            collider.getGameObject().onCollision(collision.get()[0]);
            collider2.getGameObject().onCollision(collision.get()[1]);
        }
    }

    /**
     * Return a Collision if the two objects are colliding.
     * @param other - Collider to check against.
     * @return Optional that is empty when there was no collision, and contains an array of Collisions that contains.
     * <p><ul>
     *     <li>Collision containing other in index 0
     *     <li>Collision containing this in index 1
     * </ul></p>
     */
    private Optional<Collision[]> doesCollide(final Collider other) {
        // TODO: Add layers.

        final double halfWidthThis = this.getWidth() / 2.0;
        final double halfWidthOther = other.getWidth() / 2.0;
        final double halfLengthThis = this.getLength() / 2.0;
        final double halfLengthOther = other.getLength() / 2.0;

        // Is the x position of the right edge of other less than (to the left of)
        // the x position of the left edge of this?
        boolean otherLeft = this.getGlobalPosition().x - halfWidthThis < other.getGlobalPosition().x + halfWidthOther;
        // Is the x position of the left edge of other greater than (to the left of)
        // the x position of the right edge of this?
        boolean otherRight = this.getGlobalPosition().x + halfWidthThis > other.getGlobalPosition().x - halfWidthOther;
        // Is the y position of the top edge of other less than (to the left of)
        // the y position of the bottom edge of this?
        boolean otherUp = this.getGlobalPosition().y - halfLengthThis < other.getGlobalPosition().y + halfLengthOther;
        // Is the y position of the bottom edge of other greater than (to the left of)
        // the y position of the top edge of this?
        boolean otherDown = this.getGlobalPosition().y + halfLengthThis > other.getGlobalPosition().y - halfLengthOther;

        if (otherLeft && otherRight && otherUp && otherDown) {
            return Optional.of(new Collision[]{new Collision(other), new Collision(this)});
        }

        return Optional.empty();
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int setWidth() {
        return width;
    }

    public int setLength() {
        return length;
    }
}
