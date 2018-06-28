package com.dnd.tools.encounterhelper.ui;

import lombok.Data;

@Data
public class NewVariableStatNpcModel {

    private String name;
    private int armourClass;
    private int hitDie;
    private int level;
    private int conMod;
    private int initativeBonus;
    private int numberOfEnemies;
}
