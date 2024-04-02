package org.example.telegrambot.models.getUpdatesModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageUpdates {
    public int message_id;
    public From from;
    public Chat chat;
    public int date;
    public String text;
    public ArrayList<Entity> entities;
}
