package org.game.engine.manager.gameobject;

public class Vector3 {

    public final static Vector3 ZERO = new Vector3(0, 0, 0);

    public final static Vector3 RIGHT = new Vector3(1, 0, 0);
    public final static Vector3 LEFT = new Vector3(-1, 0, 0);
    public final static Vector3 UP = new Vector3(0, 1, 0);
    public final static Vector3 DOWN = new Vector3(0, -1, 0);
    public final static Vector3 FORWARD = new Vector3(0, 0, 1);
    public final static Vector3 BACK = new Vector3(0, 0, -1);

    public final int x;
    public final int y;
    public final int z;

    public Vector3(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 withX(final int x) {
        return new Vector3(x, this.y, this.z);
    }

    public Vector3 withY(final int y) {
        return new Vector3(this.x, y, this.z);
    }

    public Vector3 withZ(final int z) {
        return new Vector3(this.x, this.y, z);
    }

    public Vector3 add(final Vector3 other) {
        return new Vector3(x + other.x, y + other.y, z + other.z);
    }

    public Vector3 subtract(final Vector3 other) {
        return new Vector3(x - other.x, y - other.y, z - other.z);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}
