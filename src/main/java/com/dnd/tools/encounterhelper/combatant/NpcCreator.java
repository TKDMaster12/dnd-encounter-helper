package com.dnd.tools.encounterhelper.combatant;

import com.dnd.tools.encounterhelper.util.Die;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NpcCreator {

    public static Combatant createNpo(String name, int armourClass, int maxHp, int initativeBonus) {
        return new Combatant(name, armourClass, maxHp, initativeBonus, true);
    }

    public static Combatant createNpo(String name, int armourClass, int hitDie, int level, int conMod, int initativeBonus) {
        return new Combatant(name, armourClass, getHp(hitDie, level, conMod), initativeBonus, true);
    }

    public static List<Combatant> createTemplatedNpc(int count, String name, int armourClass, int maxHp, int initativeBonus) {
        return IntStream.range(1, count + 1)
                .mapToObj(enemyNumber -> new Combatant(
                        name + "#" + enemyNumber,
                        armourClass,
                        maxHp,
                        initativeBonus,
                        true
                ))
                .collect(Collectors.toList());
    }

    public static List<Combatant> createTemplatedNpc(int count, String name, int armourClass, int hitDie, int level, int conMod, int initativeBonus) {
        return IntStream.range(1, count + 1)
                .mapToObj(enemyNumber -> new Combatant(
                        name + "#" + enemyNumber,
                        armourClass,
                        getHp(hitDie, level, conMod),
                        initativeBonus,
                        true
                ))
                .collect(Collectors.toList());
    }

    private static int getHp(int hitDie, int level, int conMod) {
        Die die = new Die(hitDie);
        int dieSum = 0;
        for (int i = 0; i < level; i++) {
            dieSum += die.roll();
        }
        return conMod * level + dieSum;
    }
}
