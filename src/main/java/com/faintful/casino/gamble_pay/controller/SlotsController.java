package com.faintful.casino.gamble_pay.controller;

import com.faintful.casino.gamble_pay.model.ChannelId;
import com.faintful.casino.gamble_pay.services.SlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping(SlotsController.SLOTS_PATH)
public class SlotsController {
    @Autowired
    SlotsService slotsService;
    public static final String SLOTS_PATH = "/gamblepay";

    @GetMapping("/slots")
    String launch(
            @RequestParam UUID userId,
            @RequestParam String gameName,
            @RequestParam Locale language,
            @RequestParam ChannelId channelId,
            @RequestParam String userIp,
            @RequestParam Locale countryCode,
            @RequestParam URL lobbyUrl,
            @RequestParam URL cashierUrl
    ) {
        return slotsService.launch(userId, gameName, language, channelId, userIp, countryCode, lobbyUrl, cashierUrl);
    }

}
