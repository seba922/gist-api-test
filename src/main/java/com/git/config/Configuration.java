package com.git.config;

import com.git.enums.Config;
import io.restassured.RestAssured;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static InputStream inputStream;
    public static String url;
    public static String accessToken;
    public static String gistId;

    static {
        inputStream = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        url = properties.getProperty(Config.URL.getValue());
        accessToken = properties.getProperty(Config.ACCESS_TOKEN.getValue());
        gistId = properties.getProperty(Config.GIST_ID.getValue());
        RestAssured.authentication = RestAssured.oauth2(accessToken);
    }
}
