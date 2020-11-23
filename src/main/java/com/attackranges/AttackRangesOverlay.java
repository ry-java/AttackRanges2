package com.attackranges;


import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import java.awt.*;

class AttackRangesOverlay extends Overlay {

    private final Client client;
    private final AttackRangesCalc range;
    private int rangeInt;

    @Inject
    private AttackRangesOverlay(Client client, AttackRangesCalc range) {
        this.client = client;
        this.range = range;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPriority(OverlayPriority.MED);

    }


    @Override
    public Dimension render(Graphics2D graphics) {
        final WorldPoint playerPos = client.getLocalPlayer().getWorldLocation();
        rangeInt = range.getRange();
        final Polygon tilearea = Perspective.getCanvasTileAreaPoly(client, LocalPoint.fromWorld(client, playerPos), rangeInt);
        renderTile(graphics, tilearea);
        return null;
    }

    private void renderTile(final Graphics2D graphics, Polygon tilearea) {
        final Point mouseposition = client.getMouseCanvasPosition();
        final Color fillarea = new Color(0, 0, 0, 35);
        OverlayUtil.renderHoverableArea(graphics, tilearea, mouseposition, fillarea, JagexColors.MENU_TARGET, JagexColors.MENU_TARGET);
    }
}
