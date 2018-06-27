package com.dnd.tools.encounterhelper.combatant;

import com.dnd.tools.encounterhelper.combatant.Combatant;
import com.dnd.tools.encounterhelper.util.Die;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

public class InitativeHelper {
    private static Die die = new Die(20);

    public static List<Combatant> sortByInitative(List<Combatant> combatants) {
        return combatants.stream()
                .sorted(
                        //Highest Initative roll
                        comparing(Combatant::getCurrentInitiative, reverseOrder())
                                // Second compare on highest Initiative Bonus
                                .thenComparing(comparing(Combatant::getInitativeBonus, reverseOrder()))
                                // Third compare by players before npcs
                                .thenComparing(comparing(Combatant::isNpc))
                )
                .collect(Collectors.toList());
    }

    public static int rollInitative(Combatant combatant) {
        return die.roll() + combatant.getInitativeBonus();
    }
}
