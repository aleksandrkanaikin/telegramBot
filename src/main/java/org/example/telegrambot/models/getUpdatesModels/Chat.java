package org.example.telegrambot.models.getUpdatesModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chat {
    private Long id;
    private String first_name;
    private String username;
    private String type;
}
