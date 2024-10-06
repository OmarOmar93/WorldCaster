package Others;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class ConfigurationProvider {

    private static final Map<Class<? extends ConfigurationProvider>, ConfigurationProvider> providers = new HashMap<>();

    static {
        try {
            providers.put(Others.YamlConfiguration.class, new Others.YamlConfiguration());
        } catch (NoClassDefFoundError ex) {
            // Ignore, no SnakeYAML
        }
    }

    public static ConfigurationProvider getProvider(Class<? extends ConfigurationProvider> provider) {
        return providers.get(provider);
    }

    /*------------------------------------------------------------------------*/
    public abstract void save(Others.Configuration config, File file) throws IOException;

    public abstract void save(Others.Configuration config, Writer writer);

    public abstract Others.Configuration load(File file) throws IOException;

    public abstract Others.Configuration load(File file, Others.Configuration defaults) throws IOException;

    public abstract Others.Configuration load(Reader reader);

    public abstract Others.Configuration load(Reader reader, Others.Configuration defaults);

    public abstract Others.Configuration load(InputStream is);

    public abstract Others.Configuration load(InputStream is, Others.Configuration defaults);

    public abstract Others.Configuration load(String string);

    public abstract Others.Configuration load(String string, Configuration defaults);
}