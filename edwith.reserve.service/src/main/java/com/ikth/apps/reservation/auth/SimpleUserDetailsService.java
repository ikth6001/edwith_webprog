package com.ikth.apps.reservation.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ikth.apps.reservation.dao.ReservationDao;

@Component
public class SimpleUserDetailsService implements UserDetailsService
{
	@Autowired
	private ReservationDao reservationDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		UserDetails user= reservationDao.getUserById(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		} else {
			return user;
		}
	}
}
