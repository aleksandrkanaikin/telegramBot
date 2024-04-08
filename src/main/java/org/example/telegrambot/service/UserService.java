package org.example.telegrambot.service;

import org.example.telegrambot.models.getUpdatesModels.Chat;
import org.example.telegrambot.models.getUpdatesModels.Result;
import org.example.telegrambot.models.getUpdatesModels.Root;
import org.example.telegrambot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    //@Autowired
    public RestTemplate restTemplate = new RestTemplate();

    @Value("${telegram.bot.token}")
    private String botToken;

    @Autowired
    private UserRepository userRepository;

    public void setUserChatId(){
        System.out.println(botToken);
        getAllBotUsers();
    }

    public void getAllBotUsers(){
        String request = String.format("https://api.telegram.org/bot%s/getUpdates", botToken);
        List<Root> rootList = restTemplate.getForObject(request, Result.class).getResult();
        for (Root root : rootList){
            Chat chat = root.message.chat;
            if(!userRepository.UserMap.containsKey(chat.username)){
                userRepository.UserMap.put(chat.username, String.valueOf(chat.id));
            }
        }
    }
}
