package org.qrbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramQRBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        // Process received updates (messages, commands, etc.)
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String messageText = update.getMessage().getText();

            // Echo the received message back to the user
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(messageText);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        // Return the bot's username
        return "PrettyQRbot";
    }

    @Override
    public String getBotToken() {
        // Return the bot's token obtained from BotFather
        return BotSettingsProvider.getToken();
    }
}
