package net.rainbowcreation.lobbyspawn;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.rainbowcreation.api.API;
import net.rainbowcreation.api.utils.IString;
import net.rainbowcreation.lobbyspawn.utils.Reference;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import static net.rainbowcreation.lobbyspawn.config.GeneralConfig.settings;
import static net.rainbowcreation.lobbyspawn.config.GeneralConfig.bypass;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, serverSideOnly = true, acceptableRemoteVersions = "*")
public class Main
{
    private static Logger LOGGER;
    public static final API api= API.getInstance();
    public static net.rainbowcreation.api.config.GeneralConfig.Settings apiSetting = api.setting();
    public static net.rainbowcreation.api.config.GeneralConfig.Bypass apiBypass = api.bypass();
    public static List<String> bypassList;
    public static IString iString = new IString();
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
        api.setLogger(LOGGER);
        apiSetting.ENABLE = settings.ENABLE;
        if (!apiSetting.ENABLE) {
            return;
        }
        apiSetting.X = settings.X;
        apiSetting.Y = settings.Y;
        apiSetting.Z = settings.Z;
        apiBypass.BYPASS_PLAYER = bypass.BYPASS_PLAYER;
        iString.header(Reference.NAME+":"+Reference.VERSION);
        bypassList = Arrays.asList(apiBypass.BYPASS_PLAYER);
    }
}
