package kr.ac.hansung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.ScoreDAO;
import kr.ac.hansung.model.Score;
import kr.ac.hansung.model.WinningStatus;

@Service
public class ResultService {

	ScoreDAO scoreDao;

	@Autowired
	public void setScoreDao(ScoreDAO scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	public boolean setScore(Score score, WinningStatus ws) {
		
		if(ws == WinningStatus.Player)
			score.setWin(score.getWin()+1);
		else if(ws == WinningStatus.Draw)
			score.setDraw(score.getDraw()+1);
		else
			score.setLose(score.getLose()+1);
		return scoreDao.update(score);
		
	}
	
}
