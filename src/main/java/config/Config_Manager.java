package config;

import enums.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Config_Manager
{

    // Properties object
    private static final Properties properties = new Properties();

    // Logger object
    private static final Logger logger = LogManager.getLogger(Config_Manager.class);

    // Config File Path
    private static final String path = "src/main/resources/config/config.properties";

    static {
        load_properties();
    }

    private static void load_properties()
    {

        try
        {
            FileInputStream config_file = new FileInputStream(path);
            properties.load(config_file);
            config_file.close();

            Environment env = Environment.valueOf(properties.getProperty("env").toUpperCase());

            String env_path = "src/main/resources/config/" + env.name().toLowerCase() + "-config.properties";

            FileInputStream enviroment_config_file = new FileInputStream(env_path);
            properties.load(enviroment_config_file);
            enviroment_config_file.close();

            logger.info("Configuration loaded for environment " + env);

        } catch (IOException e)
        {
            logger.error("Failed to load configuration. " + e);
            throw new RuntimeException("Configuration loading failed.");
        }

    }


    public static String get_property(String key)
    {
        return properties.getProperty(key);
    }

    public static String get_property(String key , String default_value)
    {
        String value = properties.getProperty(key, default_value);
        if (value == null || value.trim().isEmpty()) {
            return default_value; // Return the default value if empty
        }
        else
        {
            return value;
        }

        //return value;

    }

    public static Environment get_enviroment()
    {
        return Environment.valueOf(properties.getProperty("env").toUpperCase());
    }



}
