package org.example.telegrambot.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.telegrambot.configuration.TelegramBot;
import org.example.telegrambot.models.Message;
import org.example.telegrambot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
    @RequestMapping("/api/message")
    @Tag(name = "MessageController",
            description = "Контроллер работы с сообщениями от бота")
    public class MessageController {
        @Autowired
        private TelegramBot bot;
        @Autowired
        UserService userService;

        @Operation(summary = "Отпрака сообщения",
                description = "Позволяет отправить сообщение заданным пользователям")
        @PostMapping("/sendMessage")
        public ResponseEntity<String> sendMessage(@RequestBody @Parameter(description = "Модель отпраки сообщения")
                                                      Message message) throws InterruptedException {

            return bot.sendMessageToChat(message.getUsernamesList(), message.getText());
        }

        @GetMapping
        @Operation(summary = "Получает пользователей которые активировали бота")
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "OK ",
                        content = @Content(
                                examples = @ExampleObject(
                                        value = "{\"username1\": \"chatId1\", \"username2\": \"chatId2\"}"
                                )
                        )
                )
        })
        public ResponseEntity<Map<String, String>> getMessages() {
            System.out.println("Response");
            return new ResponseEntity<>(userService.getUsers(), HttpStatusCode.valueOf(200));
        }
    }
