package com.faintful.casino.gamble_pay.controller;

import com.faintful.casino.gamble_pay.services.SlotsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

@Slf4j
@WebMvcTest(SlotsController.class)
public class SlotsControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private SlotsService slotsService;
    @TestConfiguration
    static class MockConfig {
        @Bean
        SlotsService slotsService() {
            return Mockito.mock(SlotsService.class);
        }
    }

    @Test
    void shouldReturnGameURIWhenValidRequestIsProvided() throws Exception {
        //Arrange
        MockHttpServletRequestBuilder mockGetRequest = MockMvcRequestBuilders.get(SlotsController.SLOTS_PATH + "/slots")
                .queryParam("userId", UUID.randomUUID().toString())
                .queryParam("gameName", "ClashOfClans12345")
                .queryParam("language", "ITALIAN")
                .queryParam("channelId", "FC")
                .queryParam("userIp", "135.80.248.0")
                .queryParam("countryCode", "IT")
                .queryParam("lobbyUrl", "http://lobby.url")
                .queryParam("cashierUrl", "http://cashier.url");

        given(slotsService.launch(any(), any(), any(), any(), any(), any(), any(), any())).willReturn("http://example.game/123");

        //Act
        ResultActions resultActions = mockMvc.perform(mockGetRequest)
                //Assert
                .andExpect(status().isOk())
                .andExpect(content().string("http://example.game/123"));

        //Log
        log.info(resultActions.andReturn().getResponse().getContentAsString());
    }
}
