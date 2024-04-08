package org.example.telegrambot.configuration;

import org.example.telegrambot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    //@Value("${telegram.bot.token}")
    private final String botToken = "6831716015:AAFPPKn7KFLzqcIrad9AdPI3kqho5EC3iNc";
    @Autowired
    UserService userService;

   // @Value("${telegram.bot.username}")
    private final String botUsername = "task_Telegram_bot";

    @Override
    public void onUpdateReceived(Update update) {
        // Здесь будет логика обработки сообщений
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void sendMessageToChat(List<String> chatIds, String messageText) throws InterruptedException {
        System.out.println(botToken);
        System.out.println(botUsername);
        for (String chatId : chatIds) {
            SendMessage message = new SendMessage();
            message.setText(messageText);
            message.setChatId(chatId);
            try {
                execute(message);
                userService.setUserChatId();
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
