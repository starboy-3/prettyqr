package org.qrbot;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class BotSettingsProvider {
    public static String getTokenPath() {
        Map<String, String> environmentMap = System.getenv();
        String environment = environmentMap.getOrDefault("ENVIRONMENT", "");

        if (environment.equalsIgnoreCase("production")) {
            return "";
        } else {
            return "/Users/akosimov/qrbot_token";
        }
    };

    public static String getToken() {
        String tokenPath = getTokenPath();
        try (BufferedReader reader = new BufferedReader(new FileReader(tokenPath))) {
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}