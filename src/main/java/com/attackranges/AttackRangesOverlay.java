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
    private final AttackRangesCalc rangesCalc;
    private final Color fillArea;

    @Inject
    private AttackRangesOverlay(Client client, AttackRangesCalc rangesCalc) {
        this.client = client;
        this.rangesCalc = rangesCalc;
        fillArea = new Color(0, 0, 0, 35);
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPriority(OverlayPriority.MED);

    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (client.getLocalPlayer() != null) {
            WorldPoint playerPos = client.getLocalPlayer().getWorldLocation();
            int rangeInt = rangesCalc.getRange();
            LocalPoint localPoint = LocalPoint.fromWorld(client, playerPos);
            if (localPoint != null) {
                Polygon tileArea = Perspective.getCanvasTileAreaPoly(client, localPoint, rangeInt);
                renderTile(graphics, tileArea);
            }
        }
        return null;
    }

    private void renderTile(final Graphics2D graphics, Polygon tileArea) {
        final Point mousePos = client.getMouseCanvasPosition();
        OverlayUtil.renderHoverableArea(graphics, tileArea, mousePos, fillArea, JagexColors.CHAT_FC_TEXT_OPAQUE_BACKGROUND, JagexColors.TOOLTIP_BACKGROUND);
    }
}
