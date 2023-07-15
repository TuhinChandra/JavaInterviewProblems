// Copyright (C) 2017 Snowflake Software Ltd. All rights reserved.
package com.tuhin.examples.techtest;

/**
 * The class representing a coordinate (x, y).
 */
public class Coordinate {

    /** The X component of this coordinate (can have values -180 to +180). */
    private double x;

    /** The Y component of this coordinate (can have values -90 to +90). */
    private double y;

    /**
     * Construct a coordinate.
     *
     * @param x the X component of this coordinate (can have values -180 to +180).
     * @param y the Y component of this coordinate (can have values -90 to +90).
     */
    public Coordinate(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate() {
    }

    /**
     * Gets the X component of this coordinate (can have values -180 to +180).
     *
     * @return the x.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y component of this coordinate (can have values -90 to +90).
     *
     * @return the y.
     */
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("(");
        sb.append(x).append(",").append(y);
        sb.append(")");
        return sb.toString();
    }
}
