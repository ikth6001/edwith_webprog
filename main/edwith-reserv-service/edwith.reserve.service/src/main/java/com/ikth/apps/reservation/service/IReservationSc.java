package com.ikth.apps.reservation.service;

import java.util.List;

import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.DisplayInfoResponse;
import com.ikth.apps.reservation.dto.ProductResponse;
import com.ikth.apps.reservation.dto.ReservationInfoResponse;
import com.ikth.apps.reservation.dto.ReservationParam;

public interface IReservationSc {
	
	List<Category> getAllCategories();
	
	ProductResponse getPromotionedProducts();
	
	ProductResponse getProducts(int categoryId, int start);
	
	DisplayInfoResponse getDisplayInfo(int displayInfoId);

	boolean reservation(ReservationParam reservationParam);
	
	ReservationInfoResponse getReservations(String reservationEmail);
}
