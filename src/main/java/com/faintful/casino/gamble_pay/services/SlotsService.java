package com.faintful.casino.gamble_pay.services;

import com.faintful.casino.gamble_pay.model.ChannelId;

import java.net.URL;
import java.util.Locale;
import java.util.UUID;

public interface SlotsService {

    String launch(UUID userId, String gameName, Locale language, ChannelId channelId, String userIp, Locale countryCode, URL lobbyUrl, URL cashierUrl);
}
