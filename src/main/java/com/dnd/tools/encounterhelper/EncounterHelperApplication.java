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
                    19,
                    42,
                    6,
                    false
            );
            joe.setCurrentInitiative(15);

            List<Combatant> templateNpcs = NpcCreator.createTemplatedNpc(4, "npcTemplate", 13, 8, 6, 2, 3);
            repository.saveAll(Arrays.asList(bob, joe));
            repository.saveAll(templateNpcs);
        };
    }
}
