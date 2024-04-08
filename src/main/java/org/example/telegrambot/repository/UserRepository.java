package org.example.telegrambot.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {

    public Map<String, String> UserMap = new HashMap<String, String>();
}
