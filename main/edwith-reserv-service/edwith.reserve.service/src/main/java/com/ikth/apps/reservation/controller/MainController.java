package com.ikth.apps.reservation.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController 
{
	private final static Logger logger= LoggerFactory.getLogger(MainController.class);
	
	@GetMapping(path="/")
	public String main(Locale locale) {
		logger.debug("requested locale [{}]", locale);
		return "main";
	}
	
	@GetMapping(path="/detail")
	public String detail(ModelMap model, @RequestParam("productId") int productId) {
		logger.debug("requested product id to show detail information is [{}]", productId);
		
		model.addAttribute("title", "선택된 상품 제목");
		model.addAttribute("productContents", "상품 정보");
		
		model.addAttribute("eventContents", "이벤트 정보");
		
		model.addAttribute("avgScore", "3.5");
		model.addAttribute("commentCnt", "10");
		
		model.addAttribute("commentContents", "재미있었고 많은 것을 생각할 수 있는 공연이었습니다.");
		model.addAttribute("score", "4.0");
		model.addAttribute("userId", "ikth****");
		model.addAttribute("wDate", "2019.02.09");
		
		model.addAttribute("reserveDetail", "예약 상세 정보");
		
		return "detail";
	}
	
	@GetMapping(path="/error")
	public String error(ModelMap model, @RequestParam("cause") String cause) {
		model.addAttribute("cause", cause);
		return "error";
	}
}