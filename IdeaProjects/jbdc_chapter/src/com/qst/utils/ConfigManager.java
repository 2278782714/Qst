package com.qst.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author Qin Zhenli
 * @Date 2022/3/16 8:49
 */
public class ConfigManager {
    private static ConfigManager configManager;
    private static Properties properties;

    public ConfigManager(){
        String configfile="database.properties";
        properties=new Properties();
        InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(configfile);
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ConfigManager getInstance(){
        if (configManager==null){
            configManager=new ConfigManager();
        }
        return configManager;
    }
    public String getString(String key){
        return properties.getProperty(key);
    }
}
