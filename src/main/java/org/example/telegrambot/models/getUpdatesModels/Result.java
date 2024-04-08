package org.example.telegrambot.models.getUpdatesModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
    private boolean ok;
    private List<Root> result;
}
