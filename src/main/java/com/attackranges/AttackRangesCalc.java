package com.attackranges;

import net.runelite.api.Client;
import net.runelite.api.VarPlayer;
import net.runelite.api.kit.KitType;

import javax.inject.Inject;
import java.util.HashMap;

public class AttackRangesCalc {

    @Inject
    private Client client;
    private static final HashMap<Integer, Integer> ID_RANGES = new HashMap<>();
    static {
        //Crossbows
//        TODO FINISH CROSSBOW IDS
//        TODO FINISH SHORTBOW IDS
//        TODO FINISH LONGBOW IDS
//        TODO FINISH KNIFE/DART IDS
//        TODO FINISH OUTLIERS
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(8880, 7);
        ID_RANGES.put(21012, 7);
        ID_RANGES.put(21902, 7);

        //Karils
        ID_RANGES.put(11785, 8);
        ID_RANGES.put(4934, 8);
        ID_RANGES.put(4935, 8);
        ID_RANGES.put(4936, 8);
        ID_RANGES.put(4937, 8);
    }

    public int getID() {

        return (client.getLocalPlayer() != null ? client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.WEAPON) : 0);
    }

    public int getRange() {

        return (client.getVar(VarPlayer.ATTACK_STYLE) == 3 ? 2 * (ID_RANGES.get(getID()) + 2) : 2 * ID_RANGES.get(getID()));
        }

}
