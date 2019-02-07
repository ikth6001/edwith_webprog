package com.ikth.apps.reservation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ikth.apps.reservation.configuration.TestConfiguration;

/**
 * 웹 어플리케이션 컨텍스트를 가져와서 테스트 하는 방법
 * 실제 웹 컨텍스트를 만들고 서비스, DAO 객체까지 동작 하므로 테스트에 시간이 꽤 걸린다.
 * 
 * -> Mock 오브젝트를 활용하는 것이 더 나을수도 있다.
 * 참고 : https://www.javacodegeeks.com/2013/07/unit-testing-of-spring-mvc-controllers-configuration-2.html
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class)
@WebAppConfiguration
public class ReservationRestControllerTest
{
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void doTest() throws Exception
	{
		mockMvc.perform(get("/api/products?categoryId=0&start=0"))
			   .andExpect(status().isOk());
	}
}
