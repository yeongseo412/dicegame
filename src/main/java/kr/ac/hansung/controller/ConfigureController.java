package kr.ac.hansung.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.service.ConfigureService;


@Controller
public class ConfigureController {
	
	private ConfigureService configureService;
	
	@Autowired
	public void setConfiguresService(ConfigureService configuresService) {
		this.configureService = configuresService;
	}

	@RequestMapping("/configure")
	public String configure(HttpServletRequest request, Model model){
		
		int[] map;
		int before, after;
		
		map = configureService.getMap();
		
		try{
		before = Integer.parseInt(request.getParameter("cell"));
		after = Integer.parseInt(request.getParameter("newCell"));
		
		map[before] = after;
		}
		catch(Exception e) {
			return null;
		}
		
		configureService.setMap(map);
		
		model.addAttribute("map", map);
		
		return "configure";
	}
}
