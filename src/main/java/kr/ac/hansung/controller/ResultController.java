package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.WinningStatus;
import kr.ac.hansung.service.DicegameService;

@Controller
public class ResultController {

	@RequestMapping("/result")
	public String result(Model model) {
		DicegameService dicegameService = (DicegameService) DicegameService.getInstance();
		
		WinningStatus result = dicegameService.getWs();
		String message="test";
		
		if(result == WinningStatus.Draw)
			message = "Draw!";
		else if(result == WinningStatus.Player)
			message = "Win!";
		else
			message = "Lose!";
		
		model.addAttribute("message", message);
		
		return "result";
	}
	
}
