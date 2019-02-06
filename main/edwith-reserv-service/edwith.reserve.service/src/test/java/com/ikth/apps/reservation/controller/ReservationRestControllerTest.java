package com.ikth.apps.reservation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ikth.apps.reservation.service.ReservationSc;

@RunWith(MockitoJUnitRunner.class)
public class ReservationRestControllerTest {
	
	@Mock
	private ReservationSc reservationSc;
	
	@InjectMocks
	private ReservationRestControllerImpl controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void doTest() throws Exception
	{
		mockMvc.perform(get("/api/products?categoryId=4&start=-1"))
			   .andExpect(status().isOk());
	}
}
