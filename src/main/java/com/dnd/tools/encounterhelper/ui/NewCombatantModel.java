package com.dnd.tools.encounterhelper.ui;

import lombok.Data;

@Data
public class NewCombatantModel {

    private String name;
    private int armourClass;
    private int maxHp;
    private int initativeBonus;
    private boolean npc;
}
