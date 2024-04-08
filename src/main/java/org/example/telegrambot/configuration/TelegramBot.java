package org.example.telegrambot.configuration;

import org.example.telegrambot.repository.UserRepository;
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

    @Value("${telegram.bot.token}")
    private String botToken; // = "6831716015:AAFPPKn7KFLzqcIrad9AdPI3kqho5EC3iNc";

    @Value("${telegram.bot.username}")
    private String botUsername; //= "task_Telegram_bot";

    @Autowired
    private UserService userService; // = new UserService();

    @Autowired
    private UserRepository userRepository;

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

    public String sendMessageToChat(List<String> usernames, String messageText) throws InterruptedException {
        System.out.println(botToken);
        System.out.println(botUsername);
        userService.setUserChatId();
        for (String username : usernames) {
            if(userRepository.UserMap.containsKey(username)){
                SendMessage message = new SendMessage();
                message.setText(messageText);
                message.setChatId(userRepository.UserMap.get(username));
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else {
                return String.format("User with this username %s not found", username);
            }
        }

        return "Message send";
    }
}
