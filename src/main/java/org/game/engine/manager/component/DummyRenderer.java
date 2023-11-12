package org.game.engine.manager.component;

import java.awt.*;

public class DummyRenderer extends Component{

    public void render(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect(this.getGameObject().getPosition().x, 480 - this.getGameObject().getPosition().y , 32, 32);
    }
}
