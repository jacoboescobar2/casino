package com.casino.app.models.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.casino.app.models.dao.IRouletteDao;
import com.casino.app.models.entity.Roulette;

@Repository
public class RouletteRepository implements IRouletteDao, RowMapper<Roulette> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private RowMapper<Roulette> rowMapper = (ResultSet rs, int rowNum) -> {
		Roulette rou = new Roulette();
		rou.setId(rs.getInt(1));
		rou.setState(rs.getBoolean(2));
		rou.setOpen(rs.getDate(3));
		rou.setClosed(rs.getDate(4));
		return rou;
	};
	
	@Override
	public Roulette mapRow(ResultSet rs, int rowNum) throws SQLException {
		Roulette rou = new Roulette();
		rou.setId(rs.getInt("id"));
		rou.setState(rs.getBoolean("state"));
		rou.setOpen(rs.getDate("open"));
		rou.setClosed(rs.getDate("closed"));
		return rou;
	}

	public List<Roulette> findAll() {
		return jdbcTemplate.query("SELECT * FROM roulettes", rowMapper);
	}
	
	public Roulette findById(int id) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM roulettes WHERE id = ?", new Object[] { id }, new RouletteRepository());
	}

	@Override
	public int addRoulette() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert
		    .withTableName("roulettes")
		    .usingGeneratedKeyColumns("id");
		SqlParameterSource params = new MapSqlParameterSource()
		    .addValue("state", "false");
		Number number = simpleJdbcInsert.executeAndReturnKey(params); 

		return (int) number;
	}
	
	public int openRoulette(Roulette rou) {
		return  jdbcTemplate.update("UPDATE roulettes SET open = ?, state=true WHERE id = ?", rou.getOpen(), rou.getId());
	}
	
	public int closeRoulette(Roulette rou) {
		return jdbcTemplate.update("UPDATE roulettes SET closed = ?, state=false WHERE id = ?", rou.getClosed(), rou.getId());
	}

}
