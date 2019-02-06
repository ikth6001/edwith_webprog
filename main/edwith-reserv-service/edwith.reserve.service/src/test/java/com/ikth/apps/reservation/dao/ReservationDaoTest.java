package com.ikth.apps.reservation.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ikth.apps.reservation.configuration.DataAccessObjectConfiguration;
import com.ikth.apps.reservation.dto.Category;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ DataAccessObjectConfiguration.class })
public class ReservationDaoTest extends TestCase 
{
	@Autowired
	private ReservationDao reservationDao;
	
	@Test
	public void testGetAllCategories()
	{
		List<Category> categories= reservationDao.getAllCategories();
		assertTrue("category를 정상적으로 조회", categories.size() > 0);
	}

}
