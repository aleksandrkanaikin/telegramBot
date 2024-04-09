package org.example.telegrambot.configuration;

import org.example.telegrambot.repository.UserRepository;
import org.example.telegrambot.service.UserService;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.token}")
    private String botToken;
    @Value("${telegram.bot.username}")
    private String botUsername;

    @Autowired
    private UserService userService;

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

    public ResponseEntity<String> sendMessageToChat(List<String> usernames, String messageText) throws InterruptedException {

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
                return new ResponseEntity(String.format("User with this username %s not found", username), HttpStatusCode.valueOf(404));
            }
        }

        return new ResponseEntity("Message send", HttpStatusCode.valueOf(200));
    }
}
