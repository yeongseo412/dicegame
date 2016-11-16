package kr.ac.hansung.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.WinningStatus;
import kr.ac.hansung.service.DicegameService;

@Controller
public class DicegameController {

	private DicegameService dicegameService = (DicegameService) DicegameService.getInstance();

	@RequestMapping("/dicegame")
	public String dicegame(HttpServletRequest request, Model model, HttpSession session) {

		String name = request.getParameter("name");
		session.setAttribute("playerName", name);
		
		return "dicegame";
	}

	@RequestMapping("/roll")
	public String roll(HttpServletRequest request, Model model) {
		String page;
		dicegameService.roll();

		model.addAttribute("currentCell1", dicegameService.getCurCellPos1());
		model.addAttribute("currentCell2", dicegameService.getCurCellPos2());
		
		model.addAttribute("faceValue1", dicegameService.getFaceValue1());
		model.addAttribute("faceValue2", dicegameService.getFaceValue2());
		
		if(dicegameService.getWs() != WinningStatus.NotYet)
			page = "result";
		else
			page = "dicegame";
		
		return page;
	}
}
