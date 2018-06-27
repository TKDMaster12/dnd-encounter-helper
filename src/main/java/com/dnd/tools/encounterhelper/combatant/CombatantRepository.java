package com.dnd.tools.encounterhelper.combatant;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CombatantRepository extends PagingAndSortingRepository<Combatant, String> {
    @Transactional
    @Modifying
    @Query("update Combatant c SET c.currentInitiative = ?2 WHERE c.name = ?1")
    void setCombatantInitative(String name, int currentInitiative);

    @Transactional
    @Modifying
    @Query("update Combatant c SET c.currentHp = ?2 WHERE c.name = ?1")
    void setCombatantHp(String name, int currentHp);
}
