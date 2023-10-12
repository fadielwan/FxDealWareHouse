package com.fadi.insightwarehouse.rest.controller;

import com.fadi.insightwarehouse.rest.controller.FxDealController;
import com.fadi.insightwarehouse.rest.dto.FxDealDTO;
import com.fadi.insightwarehouse.rest.service.FxDealService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.math.BigDecimal;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = FxDealController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@ActiveProfiles

public class FxDealControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FxDealService fxDealService;

	@Autowired
	private ObjectMapper objectMapper;

	private FxDealDTO fxDealSucessDTO;
	private FxDealDTO fxDealFailedDTO;

	@BeforeEach
	public void init() {
		fxDealSucessDTO = FxDealDTO.builder().id(1l).fromCurrencyISOCode("ASD").toCurrencyISOCode("FSF")
				.dealAmount(new BigDecimal("124567890.0987654321")).build();
		fxDealFailedDTO = FxDealDTO.builder().id(1l).fromCurrencyISOCode("ASD").toCurrencyISOCode("FSFF")
				.dealAmount(new BigDecimal("12450.0987")).build();

	}

	@Test
	public void PokemonController_CreateFxDeal_ReturnCreated() throws Exception {
		ResultActions response = mockMvc.perform(post("/api/fx-deal/create").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(fxDealSucessDTO)));
		response.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void PokemonController_CreateFxDeal_ReturnBadRequest() throws Exception {
		ResultActions response = mockMvc.perform(post("/api/fx-deal/create").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(fxDealFailedDTO)));
		response.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
