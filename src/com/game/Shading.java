package com.game;

public enum Shading {
    LOWER(0), UPPER(1), SYMBOL(2);

    public final int val;

    private Shading(int v) {
        val = v;
    }
}
