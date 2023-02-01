package com.ccicraft.maths;

public class Vector2D {
    // Constructor
    public Vector2D(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    // Variables
    public Double x, y;

    // Methods
    public double computeAngle(Vector2D v) {
        Double deltaX = this.x - v.x;
        Double deltaY = this.y - v.y;
        return Math.atan2(deltaY, deltaX);
    }

    public double computeDistance(Vector2D v) {
        Double deltaX = this.x - v.x;
        Double deltaY = this.y - v.y;
        return Math.sqrt(deltaY * deltaY + deltaX * deltaX);
    }

    // Operators Overload
    public Vector2D multiply(Double i) {
        return new Vector2D(x*i, y*i);
    }

    public Vector2D multiply(int i) {
        return new Vector2D(x*i, y*i);
    }
}
