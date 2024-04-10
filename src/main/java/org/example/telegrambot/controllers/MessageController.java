package org.example.telegrambot.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.telegrambot.configuration.TelegramBot;
import org.example.telegrambot.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/message")
    @Tag(name = "MessageController",
            description = "Контроллер работы с сообщениями от бота")
    public class MessageController {
        @Autowired
        private TelegramBot bot;

        @Operation(summary = "Отпрака сообщения",
                description = "Позволяет отправить сообщение заданным пользователям")
        @PostMapping("/sendMessage")
        public ResponseEntity<String> sendMessage(@RequestBody @Parameter(description = "Модель отпраки сообщения")
                                                      Message message) throws InterruptedException {

            return bot.sendMessageToChat(message.getUsernamesList(), message.getText());
        }
    }
