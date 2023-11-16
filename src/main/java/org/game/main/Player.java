package org.game.main;

import org.game.engine.manager.KeyState;
import org.game.engine.manager.component.Component;
import org.game.engine.manager.component.collider.Collision;
import org.game.engine.manager.gameobject.Vector3;

import java.awt.event.KeyEvent;

public class Player extends Component {

    @Override
    public void update() {
        if (KeyState.getStatus(KeyEvent.VK_W) == KeyState.KeyStatus.PRESSED) {
            this.getGameObject().setPosition(this.getGameObject().getPosition().add(Vector3.UP));
        }

        if (KeyState.getStatus(KeyEvent.VK_A) == KeyState.KeyStatus.PRESSED) {
            this.getGameObject().setPosition(this.getGameObject().getPosition().add(Vector3.LEFT));
        }

        if (KeyState.getStatus(KeyEvent.VK_S) == KeyState.KeyStatus.PRESSED) {
            this.getGameObject().setPosition(this.getGameObject().getPosition().add(Vector3.DOWN));
        }

        if (KeyState.getStatus(KeyEvent.VK_D) == KeyState.KeyStatus.PRESSED) {
            this.getGameObject().setPosition(this.getGameObject().getPosition().add(Vector3.RIGHT));
        }
    }

    @Override
    public void onCollision(final Collision collision) {
        System.out.println("I hit: " + collision.getOther());
    }
}
