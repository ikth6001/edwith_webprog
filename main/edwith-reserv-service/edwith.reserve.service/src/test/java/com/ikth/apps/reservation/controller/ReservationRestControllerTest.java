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

import com.ikth.apps.reservation.configuration.IManualTestConfiguration;
import com.ikth.apps.reservation.configuration.ReservationTestConfiguration;

/**
 * 웹 어플리케이션 컨텍스트를 가져와서 테스트 하는 방법
 * 실제 웹 컨텍스트를 만들고 서비스, DAO 객체까지 동작 하므로 테스트에 시간이 꽤 걸린다.
 * 
 * -> Mock 오브젝트를 활용하는 것이 더 나을까? 중복된 설정으로 인해, 어플리케이션의 설정이 변경되면 테스트 설정도 변경되어야 한다.
 * 참고 : https://www.javacodegeeks.com/2013/07/unit-testing-of-spring-mvc-controllers-configuration-2.html
 * 
 * -> BeanPostProcessor에 대한 처리를 mockito에서 하는 방법을 모르겠음..
 * 일단 Test Configuration을 만들고 Service는 mock 객체로 만들어 보자. -> 안되네.. mock 객체 injection이 안되고 있음..
 * 
 * -> Service, Dao 계층은 Mock Object를 만들도록 Test Configuration에서 설정한 후 WebContext를 통해 컨트롤러를 생성하도록 설정함.
 * 이렇게 하면 실제 Bean validator가 컨트롤러 메소드 레벨에서 동작하여 응답 status를 테스트 하는 것이 가능하다.
 * 하지만 설정이 굉장히 더럽고 복잡해지네... 어떻게 해야 할지 좀 더 고민 해보자..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ReservationTestConfiguration.class)
@WebAppConfiguration
//@RunWith(MockitoJUnitRunner.class)
public class ReservationRestControllerTest implements IManualTestConfiguration
{
	@Autowired
	private WebApplicationContext context;
	
//	@Mock
//	private IReservationSc reservationSc;
	
//	@InjectMocks
//	private ReservationRestController controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc= MockMvcBuilders.webAppContextSetup(context)
								.build();
//		mockMvc= MockMvcBuilders.standaloneSetup(controller)
//								.setControllerAdvice(getControllerAdvice())
//								.setValidator(getValidator())
//								.build();
	}
	
	@Test
	public void doErrorBadRequestTest() throws Exception
	{
		mockMvc.perform(get("/api/products?categoryId=0&start=-1"))
			   .andExpect(status().isBadRequest());
	}
	
	@Test
	public void doOkStatusTest() throws Exception
	{
		mockMvc.perform(get("/api/products?categoryId=0&start=0"))
			   .andExpect(status().isOk());
	}
}
