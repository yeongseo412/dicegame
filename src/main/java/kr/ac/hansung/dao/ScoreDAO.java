package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Score;

@Repository
public class ScoreDAO {
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "Select count(*) from score";
		
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}
	
	// 플레이어 이름으로 스코어 찾기
	public Score getScore(String name) {
		String sqlStatement = "select * from score where name = ?";
		
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{name}, new RowMapper<Score>(){

			@Override
			public Score mapRow(ResultSet rs, int rowNumber) throws SQLException {

				Score score = new Score();
				
				score.setName(rs.getString("name"));
				score.setWin(rs.getInt("win"));
				score.setDraw(rs.getInt("draw"));
				score.setLose(rs.getInt("lose"));
				
				return score;
			}
		});
	}
	
	// 스코어 전체
	public List<Score> getScores() {
		String sqlStatement = "select * from score";
		
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Score>(){

			@Override
			public Score mapRow(ResultSet rs, int rowNumber) throws SQLException {

				Score score = new Score();
				
				score.setName(rs.getString("name"));
				score.setWin(rs.getInt("win"));
				score.setDraw(rs.getInt("draw"));
				score.setLose(rs.getInt("lose"));
				
				return score;
			}
		});
	}
	
	public boolean insert(Score score) {
		String name = score.getName();
		int win = score.getWin();
		int draw = score.getDraw();
		int lose = score.getLose();
		
		String sqlStatement = "insert into score (name, win, draw, lose) values (?,?,?,?)";
		
		return jdbcTemplateObject.update(sqlStatement, new Object[]{name, win, draw, lose}) == 1;
	}
	
	public boolean update(Score score) {
		String name = score.getName();
		int win = score.getWin();
		int draw = score.getDraw();
		int lose = score.getLose();
		
		String sqlStatement = "update score set win=?, draw=?, lose=? where name=?";
		
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{win, draw, lose, name}) == 1);
	}
	
	public boolean delete(String name) {
		String sqlStatement = "delete from score where name=?";
		
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{name}) == 1);
	}
}
