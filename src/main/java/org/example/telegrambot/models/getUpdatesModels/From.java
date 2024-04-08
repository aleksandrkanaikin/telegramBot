package org.example.telegrambot.models.getUpdatesModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class From {
    private Long id;
    private boolean is_bot;
    private String first_name;
    private String username;
    private String language_code;
}
