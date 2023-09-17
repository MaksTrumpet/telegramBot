package com.example.demonumber999.config;

import com.example.demonumber999.MySuperBot;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class BotConfig {

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.username}")
    private String botName;

    @SneakyThrows
    @Bean
    public MySuperBot mySuperBot() {
        DefaultBotOptions botOptions = new DefaultBotOptions();
        MySuperBot mySuperBot = new MySuperBot(botOptions,botToken, botName);

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(mySuperBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return mySuperBot;
    }
}
