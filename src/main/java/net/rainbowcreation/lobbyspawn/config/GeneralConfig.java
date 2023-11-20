package net.rainbowcreation.lobbyspawn.config;


import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.rainbowcreation.lobbyspawn.utils.Reference;

@EventBusSubscriber(modid = Reference.MODID)
@Config(modid = Reference.MODID, name = Reference.NAME, category = "general")
public class GeneralConfig {
    public static Settings settings = new Settings();
    public static class Settings {
        @Comment({"Enable, if set to false this mod will not teleport any player"})
        public boolean ENABLE = false;

        @Comment({"Lobbyspawn Location x"})
        public double X = 0;

        @Comment({"Lobbyspawn Location y"})
        public double Y = 0;
        @Comment({"Lobbyspawn Location z"})
        public double Z = 0;
    }

    public static Bypass bypass = new Bypass();

    public static class Bypass {
        @Comment({"Playername with should not be teleported"})
        public String[] BYPASS_PLAYER = new String[] { "RainBowCreation", "VocanicZ" };
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MODID))
            ConfigManager.load(Reference.MODID, Config.Type.INSTANCE);
    }
}