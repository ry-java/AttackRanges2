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
        // Shortbows
        ID_RANGES.put(841, 7);
        ID_RANGES.put(843, 7);
        ID_RANGES.put(849, 7);
        ID_RANGES.put(853, 7);
        ID_RANGES.put(857, 7);
        ID_RANGES.put(861, 7);
        ID_RANGES.put(12788, 7);

        // Longbows
        ID_RANGES.put(839, 7);
        ID_RANGES.put(845, 7);
        ID_RANGES.put(847, 7);
        ID_RANGES.put(851, 7);
        ID_RANGES.put(855, 7);
        ID_RANGES.put(859, 7);

        // Composite Bows
        ID_RANGES.put(10280, 7);
        ID_RANGES.put(4827, 7);
        ID_RANGES.put(10282, 7);
        ID_RANGES.put(10284, 7);

        // Special Bows
        ID_RANGES.put(9705, 7);
        ID_RANGES.put(23357, 7);
        ID_RANGES.put(22333, 7);
        ID_RANGES.put(11708, 7);
        ID_RANGES.put(4236, 7);
        ID_RANGES.put(2883, 7);
        ID_RANGES.put(6724, 7);
        ID_RANGES.put(22550, 7);
        ID_RANGES.put(11235, 7);
        ID_RANGES.put(12424, 7);

        // Crystal Bow
        ID_RANGES.put(4214, 7);
        //

        ID_RANGES.put(25865, 7);
        ID_RANGES.put(20997, 7);

        // Crossbows

/*        // Ballistae
        ID_RANGES.put(19478, 7);
        ID_RANGES.put(19481, 7);

        // Darts
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);

        // Throwing Knives
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);

        // Throwing Axes
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);

        // Chinchompas
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);
        ID_RANGES.put(9185, 7);*/
    }

    public int getID() {

        return (client.getLocalPlayer() != null ? client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.WEAPON) : 0);
    }

    public int getRange() {

        return (client.getVar(VarPlayer.ATTACK_STYLE) == 3 ? 2 * (ID_RANGES.get(getID()) + 2) : 2 * ID_RANGES.get(getID()));
        }

}
