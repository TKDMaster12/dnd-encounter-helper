package com.dnd.tools.encounterhelper.ui;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PlayerInitativeModel {
    private Map<String, Integer> playerInitatives = new HashMap<>();

}
