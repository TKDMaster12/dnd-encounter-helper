package com.dnd.tools.encounterhelper;

import com.dnd.tools.encounterhelper.combatant.Combatant;
import com.dnd.tools.encounterhelper.combatant.CombatantRepository;
import com.dnd.tools.encounterhelper.combatant.NpcCreator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EncounterHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncounterHelperApplication.class, args);
    }

    @Bean
    public CommandLineRunner testDataLoad(CombatantRepository repository) {
        return (args) -> {

            Combatant bob = new Combatant(
                    "player-Bob",
                    17,
                    38,
                    0,
                    false
            );
            bob.setCurrentInitiative(18);

            Combatant joe = new Combatant(
                    "player-joe",
                    17,
                    38,
                    0,
                    false
            );
            joe.setCurrentInitiative(15);


            Combatant matt = new Combatant(
                    "player-matt",
                    17,
                    38,
                    0,
                    false
            );
            matt.setCurrentInitiative(10);
            matt.setInitativeBonus(0);

            Combatant phil = new Combatant(
                    "player-phil",
                    17,
                    38,
                    1,
                    false
            );
            phil.setCurrentInitiative(10);


            Combatant npc1 = new Combatant(
                    "npc1",
                    17,
                    38,
                    0,
                    true
            );
            npc1.setCurrentInitiative(10);

            Combatant npc2 = new Combatant(
                    "npc2",
                    17,
                    38,
                    1,
                    true
            );
            npc2.setCurrentInitiative(10);

            List<Combatant> templateNpcs = NpcCreator.createTemplatedNpc(10, "npcTemplate", 13, 8, 6, 2, 3);
            repository.saveAll(Arrays.asList(bob, joe, matt, phil, npc1, npc2));
            repository.saveAll(templateNpcs);
        };
    }
}
