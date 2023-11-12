package org.game.engine.manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyState implements KeyListener {

    private static Map<Integer, KeyStatus> keyEvents = new HashMap<>();
    private static KeyState instance;
    private KeyState() {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keyEvents.put(e.getKeyCode(), KeyStatus.PRESSED);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyEvents.put(e.getKeyCode(), KeyStatus.RELEASED);
    }

    public static KeyState getInstance() {
        if (instance == null) {
            instance = new KeyState();
        }

        return instance;
    }
    public enum KeyStatus {
        PRESSED, RELEASED
    }

    public static KeyStatus getStatus(int keyCode) {
        return keyEvents.containsKey(keyCode) ? keyEvents.get(keyCode) : KeyStatus.RELEASED;
    }
}
