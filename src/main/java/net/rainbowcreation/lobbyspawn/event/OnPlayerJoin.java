package net.rainbowcreation.lobbyspawn.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.rainbowcreation.lobbyspawn.Main;
import static net.rainbowcreation.lobbyspawn.config.GeneralConfig.settings;

@Mod.EventBusSubscriber
public class OnPlayerJoin {
    @SubscribeEvent
    public static void onJoin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        if (!settings.ENABLE)
            return;
        EntityPlayer player = event.player;
        if (!Main.bypass.contains(player.getName())) {
            player.setPositionAndUpdate(settings.X, settings.Y, settings.Z);
        }
    }
}
