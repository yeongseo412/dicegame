package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Score;
import kr.ac.hansung.service.ScoreService;

@Controller
public class ScoreController {

	private ScoreService scoreService;

	@Autowired
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	@RequestMapping("/score")
	public String showScore(Model model) {
		
		List<Score> score = scoreService.getCurrent();
		
		model.addAttribute("score", score);
		
		return "score";
	}
}
