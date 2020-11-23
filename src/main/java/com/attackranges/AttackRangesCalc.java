package com.attackranges;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.PlayerComposition;
import net.runelite.api.VarPlayer;
import net.runelite.api.kit.KitType;

import javax.inject.Inject;
import java.util.HashMap;

public class AttackRangesCalc {

    @Inject
    private Client client;

    private static final HashMap<Integer, Integer> idRange = new HashMap<>();

    static {
        //Crossbows
        idRange.put(9185, 7);
        idRange.put(8880, 7);
        idRange.put(21012, 7);
        idRange.put(21902, 7);

        //Karils
        idRange.put(11785, 8);
        idRange.put(4934, 8);
        idRange.put(4935, 8);
        idRange.put(4936, 8);
        idRange.put(4937, 8);
    }

    public int getID() {
        Player player = client.getLocalPlayer();
        PlayerComposition playerComp = player.getPlayerComposition();
        int itemID = playerComp.getEquipmentId(KitType.WEAPON);
        System.out.println("We did this btw, itemID:" + itemID);
        return itemID;
    }

    public int getRange() {

        int attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);
        if (attackStyleVarbit == 3) {
            return 2 * (idRange.get(getID()) + 2);
        }
        return 2 * idRange.get(getID());
    }

}
