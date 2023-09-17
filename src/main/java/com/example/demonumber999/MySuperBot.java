package com.example.demonumber999;


import lombok.extern.slf4j.Slf4j;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Slf4j
public class MySuperBot extends TelegramLongPollingBot {

    private final String TOKEN;
    private final String USERNAME;

    public MySuperBot(DefaultBotOptions options, String token, String username) {
        super(options);
        this.TOKEN = token;
        this.USERNAME = username;

    }


    public String getBotToken() {
        return TOKEN;
    }

    public String getBotUsername() {
        return USERNAME;
    }

    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();

            try {
                execute(new SendMessage(String.valueOf(chat_id), "Hi " + update.getMessage().getText()));
            } catch (TelegramApiException e) {
                log.error("Error sending message", e);
            }
        }
    }
}
