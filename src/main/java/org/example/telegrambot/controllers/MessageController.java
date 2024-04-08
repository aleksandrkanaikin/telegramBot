package org.example.telegrambot.controllers;

import org.example.telegrambot.configuration.TelegramBot;
import org.example.telegrambot.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private TelegramBot bot;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody Message message) throws InterruptedException {

        return bot.sendMessageToChat(message.getUsernames(), message.getText());
    }
}
