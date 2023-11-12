package org.qrbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        BotSession botSession = new DefaultBotSession();
        botSession.setToken(BotSettingsProvider.getTokenPath());
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(new TelegramQRBot());
            System.out.println("Bot has started successfully!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
