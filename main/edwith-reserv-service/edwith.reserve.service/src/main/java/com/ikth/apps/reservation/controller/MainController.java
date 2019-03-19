package com.ikth.apps.reservation.controller;

import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String main(
			HttpServletRequest req, HttpServletResponse res,
			ModelMap model, Principal principal) {
		if(principal == null) {
			logger.debug("no login session is detected");
			model.addAttribute("loginReqUrl", "loginView");
			model.addAttribute("logInOut", "로그인");
		} else {
			final String name= principal.getName();
			logger.debug("login user name is [{}]", name);
			model.addAttribute("loginReqUrl", "userLogout");
			model.addAttribute("logInOut", "로그아웃");
			model.addAttribute("userName", name);
		}
		
		return "main";
	}
	
	@GetMapping(path="/detail")
	public String detail(ModelMap model, @RequestParam("displayInfoId") int displayInfoId) {
		logger.debug("requested product id to show detail information is [{}]", displayInfoId);
		
		DisplayInfoResponse response= reservationSc.getDisplayInfo(displayInfoId);
		
		model.addAttribute("title", response.getDisplayInfo().getProductDescription());
		model.addAttribute("imgCount", response.getProductImages().size());
		
		model.addAttribute("productContents", response.getDisplayInfo().getProductContent());
		model.addAttribute("eventContents", response.getDisplayInfo().getProductEvent());
		
		model.addAttribute("scoreImg", "img/score_sample.png"); /** TODO */
		model.addAttribute("avgScore", response.getAverageScore());
		
		model.addAttribute("commentCnt", response.getComments().size());
		
		List<Comment> comments= response.getComments();
		
		if(comments.size() > 0) {
			Comment fstComment= comments.get(0);
			model.addAttribute("commentContents", fstComment.getComment());
			model.addAttribute("score", fstComment.getScore());
			model.addAttribute("userMail", fstComment.getReservationEmail());
			model.addAttribute("wDate", fstComment.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
		}
		
		model.addAttribute("displayInfoId", displayInfoId);
		
		return "detail";
	}
	
	@GetMapping(path="/reservation")
	public String doReservation()
	{
		/**
		 * TODO
		 */
		return "main";
	}
	
	@GetMapping(path="/comments")
	public String comments(ModelMap model, @RequestParam("displayInfoId") int displayInfoId) {
		logger.debug("requested product id to show detail information is [{}]", displayInfoId);
		
		DisplayInfoResponse response= reservationSc.getDisplayInfo(displayInfoId);
		List<Comment> comments= response.getComments();
		
		model.addAttribute("scoreImg", "img/score_sample.png");
		model.addAttribute("avgScore", response.getAverageScore());
		model.addAttribute("commentCnt", response.getComments().size());
		model.addAttribute("comments", comments);
		
		return "comments";
	}
	
//	@GetMapping(path="/error")
//	public String error(ModelMap model, @RequestParam("cause") String cause) {
//		model.addAttribute("cause", cause);
//		return "error";
//	}
}