package com.ccicraft.maths;

public class Vector2D {
    // Constructor
    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Variables
    public float x, y;

    // Operators Overload
    public Vector2D multiply(float i) {
        return new Vector2D(x*i, y*i);
    }

    public Vector2D multiply(int i) {
        return new Vector2D(x*i, y*i);
    }
}
