// Copyright (C) 2017 Snowflake Software Ltd. All rights reserved.
package com.tuhin.examples.techtest;

/**
 * The class representing an Airspace.
 */
public class Airspace {

    /** The bottom left coordinate of this airspace. */
    private final Coordinate bottomLeft;

    /** The top right coordinate of this airspace. */
    private final Coordinate topRight;

    /** Name of the Airspace to easily identify */
    private final String name;

    /**
     * Construct an Airspace.
     *
     * @param bottomLeft the bottom left coordinate of this airspace.
     * @param topRight   the top right coordinate of this airspace.
     * @param name  Name of this Airspace
     */
    public Airspace(final Coordinate bottomLeft, final Coordinate topRight, final String name) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.name = name;
    }

    /**
     * Gets the bottom left coordinate of this airspace.
     *
     * @return the bottom left.
     */
    public Coordinate getBottomLeft() {
        return bottomLeft;
    }

    /**
     * Gets the top right coordinate of this airspace.
     *
     * @return the top right.
     */
    public Coordinate getTopRight() {
        return topRight;
    }

    /**
     *  Gets the name of the airspace
     * @return
     */
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(name);
        sb.append("[").append(bottomLeft).append("-").append(topRight).append("]");
        return sb.toString();
    }
}
