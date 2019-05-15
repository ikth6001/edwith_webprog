package com.ikth.apps.reservation.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ikth.apps.reservation.configuration.DataAccessObjectConfiguration;
import com.ikth.apps.reservation.configuration.ServiceLayerConfiguration;
import com.ikth.apps.reservation.dto.Product;
import com.ikth.apps.reservation.dto.ProductResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ ServiceLayerConfiguration.class
								, DataAccessObjectConfiguration.class })
public class ReservationScTest 
{
	@Autowired
	private ReservationSc reservationSc;

	@Test
	public void test() 
	{
		ProductResponse response= reservationSc.getPromotionedProducts();
		List<Product> items= response.getItems();
		
		assertTrue("totalCount 정보 정상 조회", response.getTotalCount() > 0);
		assertTrue("프로모션 아이템 목록 정상 조회", items.size() > 0);
	}

}
