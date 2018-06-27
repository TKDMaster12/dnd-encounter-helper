package com.dnd.tools.encounterhelper.util;

import java.util.Random;

public class Die {
    private final int sides;

    public Die(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return new Random().nextInt(sides) + 1;
    }
}
