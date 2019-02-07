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
		/**
		 * TODO
		 * controller에 적용된 Hibernate Validator가 적용 안되고 있음 여기선..
		 * 추가적으로 controller가 사용하는 SC의 Autowiring도 현재 mock object가 적용되는데 실제 Spring bean이 적용되도록 하고싶음.
		 */
		mockMvc.perform(get("/api/products?categoryId=4&start=-1"))
			   .andExpect(status().isOk());
	}
}
