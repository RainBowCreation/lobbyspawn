package net.rainbowcreation.lobbyspawn;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.rainbowcreation.lobbyspawn.config.GeneralConfig;
import net.rainbowcreation.lobbyspawn.utils.IString;
import net.rainbowcreation.lobbyspawn.utils.Reference;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import static net.rainbowcreation.lobbyspawn.config.GeneralConfig.settings;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, serverSideOnly = true, acceptableRemoteVersions = "*")
public class Main
{
    private static Logger LOGGER;
    public static List<String> bypass;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
        if (!settings.ENABLE)
            return;
        bypass = Arrays.asList(GeneralConfig.bypass.BYPASS_PLAYER);
        for (String txt: Reference.HEADER)
            LOGGER.info(txt);
        LOGGER.info(IString.genHeader(Reference.NAME+":"+Reference.VERSION));
    }
}
