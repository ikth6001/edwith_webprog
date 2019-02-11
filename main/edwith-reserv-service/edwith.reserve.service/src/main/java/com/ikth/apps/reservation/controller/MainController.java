package com.ikth.apps.reservation.controller;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ikth.apps.reservation.dto.Comment;
import com.ikth.apps.reservation.dto.DisplayInfoResponse;
import com.ikth.apps.reservation.service.IReservationSc;

@Controller
public class MainController 
{
	private final static Logger logger= LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private IReservationSc reservationSc;
	
	@GetMapping(path="/")
	public String main(Locale locale) {
		logger.debug("requested locale [{}]", locale);
		return "main";
	}
	
	@GetMapping(path="/detail")
	public String detail(ModelMap model, @RequestParam("displayInfoId") int displayInfoId) {
		logger.debug("requested product id to show detail information is [{}]", displayInfoId);
		
		DisplayInfoResponse response= reservationSc.getDisplayInfo(displayInfoId);
		
		model.addAttribute("title", response.getDisplayInfo().getProductDescription());
		
		model.addAttribute("productContents", response.getDisplayInfo().getProductContent());
		model.addAttribute("eventContents", response.getDisplayInfo().getProductEvent());
		
		model.addAttribute("scoreImg", "img/score_sample.png");
		model.addAttribute("avgScore", response.getAverageScore());
		
		model.addAttribute("commentCnt", response.getComments().size());
		
		Comment fstComment= response.getComments().get(0);
		model.addAttribute("commentContents", fstComment.getComment());
		model.addAttribute("score", fstComment.getScore());
		model.addAttribute("userMail", fstComment.getReservationEmail());
		model.addAttribute("wDate", fstComment.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
		
		/**
		 * TODO
		 * 고정 정보로 jsp 변경
		 */
		model.addAttribute("reserveDetail", "예약 상세 정보");
		
		return "detail";
	}
	
	@GetMapping(path="/error")
	public String error(ModelMap model, @RequestParam("cause") String cause) {
		model.addAttribute("cause", cause);
		return "error";
	}
}