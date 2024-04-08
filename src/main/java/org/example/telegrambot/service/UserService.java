package org.example.telegrambot.service;

import org.example.telegrambot.models.getUpdatesModels.Root;
import org.example.telegrambot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    private final String botToken = "xxxxxxxxxxxxxxxxxxxxxxxxx";
    @Autowired
    private UserRepository userRepository;

    public void setUserChatId(){
        getAllBotUsers();
    }

    private void getAllBotUsers(){
        String request = String.format("https://api.telegram.org/bot%s/getUpdates",botToken);
        System.out.println(restTemplate.getForObject(request, Root.class).getMessage().getFrom());
    }
}
