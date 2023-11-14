package org.game.engine.manager.component.render;


import org.game.engine.manager.component.Component;
import org.game.engine.manager.gameobject.GameObject;

import java.awt.*;

public abstract class Renderer extends Component {

    // Abstract method that must be implemented by subclasses
    public abstract void render(Graphics2D g2d);
}
