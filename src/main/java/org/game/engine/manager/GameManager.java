package org.game.engine.manager;

import org.game.engine.manager.scene.Scene;
import org.game.engine.manager.scene.TestScene;

import javax.swing.*;

/**
 * GameManager ensures all child managers are executed each frame.
 */
public class GameManager {

    private static GameManager instance;

    private final Graphics2DRenderingManager renderingManager;
    private final PhysicsManager physicsManager;
    private final JFrame frame;

    private Scene activeScene;

    private final int TIMER_DELAY = 1000 / 60;

    /**
     * GameManager is a singleton so private constructor.
     */
    private GameManager() {
        frame = new JFrame("No Name Platformer");
        renderingManager = new Graphics2DRenderingManager();
        activeScene = new TestScene();
        physicsManager = new PhysicsManager();
    }

    /**
     * Set up the window and start the default scene. Start invoking update.
     */
    public void startGame() {
        frame.add(renderingManager);
        frame.setSize(1366,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();//sizes frame based on size of components
        frame.setVisible(true);
        startScene(activeScene);
        new Timer(TIMER_DELAY, e -> update()).start();
    }

    /**
     * Runs once every frame. Calls the update method on all managers then the active game objects in a scene.
     */
    public void update() {
        renderingManager.update(activeScene.getActiveGameObjects());
        physicsManager.update(activeScene.getActiveGameObjects());
        activeScene.getActiveGameObjects().forEach(g -> g.update());
    }

    /**
     * Cleanup the last scene, start the given scene and make it active.
     * @param scene - New scene to be started.
     */
    public void startScene(final Scene scene) {
        scene.cleanup();
        activeScene = scene;
        scene.start();
    }

    /**
     * Get the instance of GameManager.
     * @return
     */
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }

        return instance;
    }

    /**
     * Get the currently active scene.
     * @return
     */
    public Scene getActiveScene() {
        return activeScene;
    }
}
