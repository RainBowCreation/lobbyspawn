package net.rainbowcreation.lobbyspawn.event;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.rainbowcreation.api.compatibles.lobbyspawn;
import net.rainbowcreation.lobbyspawn.Main;

@Mod.EventBusSubscriber
public class OnPlayerJoin {
    @SubscribeEvent
    public static void onJoin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        if (Loader.isModLoaded("RBCloginer"))
            return;
        if (!Main.apiSetting.ENABLE)
            return;
        lobbyspawn lobbyspawnapi = new lobbyspawn();
        lobbyspawnapi.onJoin(event.player);
    }
}