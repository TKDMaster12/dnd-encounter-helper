package com.dnd.tools.encounterhelper.combatant;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity

public class Combatant {
    @Id
    private String name;
    private int armourClass;
    private int maxHp;
    private int initativeBonus;
    private boolean npc;

    private int currentInitiative;
    private int currentHp;

    protected Combatant() {}

    public Combatant(String name, int armourClass, int maxHp, int initativeBonus, boolean npc) {
        this.name = name;
        this.armourClass = armourClass;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.initativeBonus = initativeBonus;
        this.npc = npc;
        this.currentInitiative = 0;
    }
}
