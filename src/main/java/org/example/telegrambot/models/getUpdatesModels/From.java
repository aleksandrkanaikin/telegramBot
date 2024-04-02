package org.example.telegrambot.models.getUpdatesModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class From {
    public int id;
    public boolean is_bot;
    public String first_name;
    public String username;
    public String language_code;
}
