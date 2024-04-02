package org.example.telegrambot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.token}")
    private static String BOT_TOKEN;

    @Value("${telegram.bot.username}")
    private static String BOT_USERNAME;

    @Override
    public void onUpdateReceived(Update update) {
        // Здесь будет логика обработки сообщений
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public void sendMessageToChat(List<String> chatIds, String messageText) throws InterruptedException {

        for(String chatId : chatIds) {
            SendMessage message = new SendMessage();
            message.setText(messageText);
            message.setChatId(chatId);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
