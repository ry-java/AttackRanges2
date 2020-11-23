package com.attackranges;

import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;


@PluginDescriptor(
        name = "Attack Ranges",
        description = "Creates an overlay at your maximum attack range",
        tags = {"range", "overlay"},
        enabledByDefault = false
)

public class AttackRangesPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private AttackRangesOverlay overlay;

    @Override
    protected void startUp() throws Exception {

        overlayManager.add(overlay);

    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlay);
    }

}
