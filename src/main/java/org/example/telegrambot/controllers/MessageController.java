package org.example.telegrambot.controllers;

import org.example.telegrambot.configuration.TelegramBot;
import org.example.telegrambot.models.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody Message message) throws InterruptedException {

        TelegramBot bot = new TelegramBot();
        bot.sendMessageToChat(message.getChatIdList(), message.getText());
        return "Message sent";
    }
}
