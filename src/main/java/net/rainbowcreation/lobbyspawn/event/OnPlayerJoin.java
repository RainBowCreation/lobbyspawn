package net.rainbowcreation.lobbyspawn.event;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.rainbowcreation.lobbyspawn.Main;

import static net.rainbowcreation.lobbyspawn.config.GeneralConfig.settings;

@Mod.EventBusSubscriber
public class OnPlayerJoin {
    @SubscribeEvent
    public static void onJoin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        if (Loader.isModLoaded("RBCloginer"))
            return;
        if (!settings.ENABLE)
            return;
        Main.API.onJoin(event.player);
    }
}