package kr.ac.hansung.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Score;
import kr.ac.hansung.model.WinningStatus;
import kr.ac.hansung.service.ConfigureService;
import kr.ac.hansung.service.DicegameService;
import kr.ac.hansung.service.ResultService;
import kr.ac.hansung.service.ScoreService;

@Controller
public class DicegameController {

	Score player;
	
	private DicegameService dicegameService;
	private ScoreService scoreService;
	private ResultService resultService;
	private ConfigureService configureService;
	
	@Autowired
	public void setConfigureService(ConfigureService configureService) {
		this.configureService = configureService;
	}
	@Autowired
	public void setDicegameService(DicegameService dicegameService) {
		this.dicegameService = dicegameService;
		
		dicegameService.setMap(configureService.getMap());
	}
	@Autowired
	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}
	@Autowired
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	

	@RequestMapping("/dicegame")
	public String dicegame(HttpServletRequest request, Model model, HttpSession session) {
		
		String name = request.getParameter("name");
		
		if(scoreService.searchPlayer(name) == null){
			player = new Score(name, 0, 0, 0);
			scoreService.insert(player);
		}
		else {
			player = scoreService.searchPlayer(name);
		}
		
		session.setAttribute("playerName", name);
		
		return "dicegame";
	}
	
	@RequestMapping("/roll")
	public String roll(HttpServletRequest request, Model model) {
		String page;
		dicegameService.roll();

		if(dicegameService.getWs() == WinningStatus.NotYet){
			model.addAttribute("currentCell1", dicegameService.getCurCellPos1());
			model.addAttribute("currentCell2", dicegameService.getCurCellPos2());
			
			model.addAttribute("faceValue1", dicegameService.getFaceValue1());
			model.addAttribute("faceValue2", dicegameService.getFaceValue2());
			
			page = "dicegame";
		}
		else {
			WinningStatus ws;
			
			ws = dicegameService.getWs();
			resultService.setScore(player, ws);
			
			configureService.init();
			
			model.addAttribute("message", dicegameService.getResultMessage(ws));
			page = "result";
		}
		
		return page;
	}
}
