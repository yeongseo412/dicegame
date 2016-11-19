package kr.ac.hansung.service;

import org.springframework.stereotype.Service;

@Service
public class ConfigureService {

	int[] map = new int[30];

	public ConfigureService(){
		init();
	}
	
	public void init(){
		for(int i=0; i<30; i++){
			map[i] = i;
		}
	}
	
	public int[] getMap() {
		return map;
	}

	public void setMap(int[] map){
		this.map = map;
	}
}
