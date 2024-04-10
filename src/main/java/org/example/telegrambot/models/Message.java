package org.example.telegrambot.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Сущность сообщения")
public class Message {
    @Schema(description = "Текст сообщения", example = "Привет")
    private String text;
    @Schema(description = "Имена пользователей которым нужно отправить текст сообщения",
            example = "[\"username1\", \n\"username2\"]")
    private List<String> usernamesList;
}
