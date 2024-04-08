package org.example.telegrambot.models.getUpdatesModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageUpdates {
    private Long message_id;
    private From from;
    private Chat chat;
    private Long date;
    private String text;
    private ArrayList<Entity> entities;
}
