package Others;

import BroadCast.AutoBroadcastSystem;
import BroadCast.Command;
import WorldChatterCore.Connectors.InterfaceConnectors.MainPluginConnector;
import WorldChatterCore.Systems.ColorSystem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public final class WorldCasterConfig {

    public static WorldCasterConfig INSTANCE;
    private Configuration worldcaster;
    private final File worldcasterFile;

    public WorldCasterConfig() {
        INSTANCE = this;

        final File dataFolder = new File("plugins/WorldChatter/Addons");

        if (dataFolder.mkdir()) {
            MainPluginConnector.INSTANCE.getWorldChatter().sendConsoleMessage(ColorSystem.BLUE + "[WorldCaster] " + ColorSystem.WHITE + "Created WorldCaster Folder!");
        }

        worldcasterFile = new File(dataFolder.getPath(), "WorldCaster.yml");
        new AutoBroadcastSystem();
        new Command();
        update();

    }

    public void update() {
        updateWorldCaster();
        AutoBroadcastSystem.INSTANCE.update();
        Command.INSTANCE.update();
    }


    public Configuration getWorldcaster() {
        return worldcaster;
    }
    
    
    private void updateWorldCaster() {
        if (!worldcasterFile.exists()) {
            createFile(worldcasterFile);
        }

        try {
            worldcaster = ConfigurationProvider.getProvider(YamlConfiguration.class).load(worldcasterFile);
        } catch (final IOException e) {
            MainPluginConnector.INSTANCE.getWorldChatter().sendConsoleMessage(ColorSystem.BLUE + "[WorldCaster] " + ColorSystem.RED + "Unable to load WorldCaster.yml in memory: " + e.getMessage());
        }
    }

    private void createFile(final File file) {
        final InputStream inputStream = getResourceAsStream(file.getName());

        if (inputStream != null) {
            try {
                Files.copy(inputStream, file.toPath());
                MainPluginConnector.INSTANCE.getWorldChatter().sendConsoleMessage(ColorSystem.BLUE + "[WorldCaster] " + ColorSystem.GREEN + file.getName() + " copied successfully.");
            } catch (final IOException e) {
                MainPluginConnector.INSTANCE.getWorldChatter().sendConsoleMessage(ColorSystem.BLUE + "[WorldCaster] " + ColorSystem.RED + "Failed to copy " + file.getName() + ": " + e.getMessage());
            } finally {
                try {
                    inputStream.close();
                } catch (final IOException e) {
                    MainPluginConnector.INSTANCE.getWorldChatter().sendConsoleMessage(ColorSystem.BLUE + "[WorldCaster] " + ColorSystem.RED + "Failed to close input stream: " + e.getMessage());
                }
            }
        } else {
            MainPluginConnector.INSTANCE.getWorldChatter().sendConsoleMessage(ColorSystem.BLUE + "[WorldCaster] " + ColorSystem.RED + "Unable to locate " + file.getName() + " in resources.");
        }
    }

    private InputStream getResourceAsStream(final String name) {
        return getClass().getClassLoader().getResourceAsStream(name);
    }
}

