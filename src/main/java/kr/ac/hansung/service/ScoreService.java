package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.ScoreDAO;
import kr.ac.hansung.model.Score;

@Service
public class ScoreService {

	private ScoreDAO scoreDao;

	@Autowired
	public void setScoreDao(ScoreDAO scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	public List<Score> getCurrent() {
		return scoreDao.getScores();
	}
}
