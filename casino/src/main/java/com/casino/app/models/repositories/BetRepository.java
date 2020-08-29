package com.casino.app.models.repositories;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.casino.app.models.dao.IBetDao;
import com.casino.app.models.entity.Bet;

@Repository
public class BetRepository implements IBetDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	private RowMapper<Bet> rowMapper = (ResultSet rs, int rowNum) -> {
		Bet bet = new Bet();
		bet.setId(rs.getInt(1));
		bet.setBet(rs.getDouble(2));
		bet.setNumber(rs.getInt(3));
		bet.setColor(rs.getString(4));
		bet.setDate(rs.getDate(5));
		bet.setWin(rs.getBoolean(6));
		bet.setColorResult(rs.getString(7));
		bet.setNumberResult(rs.getInt(8));
		bet.setUserid(rs.getInt(9));
		bet.setRouletteid(rs.getInt(10));

		return bet;
	};

	public List<Bet> findAll() {
		return jdbcTemplate.query("SELECT * FROM bets", rowMapper);
	}

	public List<Bet> findAllResultsByRou(int id) {
		return jdbcTemplate.query("SELECT * FROM bets WHERE rouletteid = ?",
				new Object[] { id }, rowMapper);
	}

	public int insertBet(Bet bet) {
		return jdbcTemplate.update(
				"INSERT INTO bets (bet,number,color,date,win,colorresult,numberresult,userid,rouletteid) VALUES (?,?,?,?,?,?,?,?,?)",
				bet.getBet(), bet.getNumber(), bet.getColor(), bet.getDate(), bet.isWin(), bet.getColorResult(),
				bet.getNumberResult(), bet.getUserid(), bet.getRouletteid());
	}

	public int deleteBetByIdUser(Bet bet) {
		return jdbcTemplate.update("DELETE FROM bets WHERE rouletteid = ? AND userid = ?", bet.getRouletteid(), bet.getUserid());
	}
	
}
