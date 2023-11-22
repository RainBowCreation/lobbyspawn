package net.rainbowcreation.lobbyspawn.compatibles;

import net.minecraft.entity.player.EntityPlayer;
import net.rainbowcreation.lobbyspawn.Main;

import static net.rainbowcreation.lobbyspawn.config.GeneralConfig.settings;

public class API implements lobbyspawnAPI{
    @Override
    public void onJoin(EntityPlayer player) {
        if (!settings.ENABLE)
            return;
        if (!Main.bypass.contains(player.getName())) {
            player.setPositionAndUpdate(settings.X, settings.Y, settings.Z);
        }
    }
}
