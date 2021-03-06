package tsp.slimebot.util;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Properties;

/**
 * Build information
 *
 * @author Silent
 */
public class BuildProperties {

    private String author;
    private int number;
    private String version;
    private String slimefun;
    private String spigot;
    private String compiled;

    /**
     * Construct {@link BuildProperties} from the given plugin.
     *
     * @param plugin Plugin
     */
    public BuildProperties(JavaPlugin plugin) {
        Properties properties = new Properties();
        try {
            properties.load(plugin.getResource("build.properties"));
            author = properties.getProperty("author", "unknown");
            number = Integer.parseInt(properties.getProperty("number", "0"));
            version = properties.getProperty("version", "unknown");
            slimefun = properties.getProperty("slimefun", "unknown");
            spigot = properties.getProperty("spigot", "unknown");
            compiled = properties.getProperty("compiled", "unknown");
        } catch (IOException ex) {
            Log.debug("Failed to load build properties!");
            Log.debug(ex);
        }
    }

    /**
     * Retrieve the author of this build.
     *
     * @return Build author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieve the build number.
     *
     * @return Build number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Retrieve the version this build is from.
     *
     * @return Version representing this build
     */
    public String getVersion() {
        return version;
    }

    /**
     * Retrieve the slimefun version this build is for.
     *
     * @return The slimefun version
     */
    public String getSlimefun() {
        return slimefun;
    }

    /**
     * Retrieve the spigot version this build is for.
     *
     * @return The spigot version
     */
    public String getSpigot() {
        return spigot;
    }

    /**
     * Retrieve the date this build was compiled.
     *
     * @return Build compile date
     */
    public String getCompiled() {
        return compiled;
    }

}
