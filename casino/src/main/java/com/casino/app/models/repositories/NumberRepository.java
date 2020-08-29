package com.casino.app.models.repositories;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.casino.app.models.dao.INumberDao;
import com.casino.app.models.entity.Number;
import com.casino.app.models.enums.NumberRouletteEnum;

@Repository
public class NumberRepository implements INumberDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private RowMapper<Number> rowMapper = (ResultSet rs, int rowNum) -> {
		Number num = new Number();
		num.setId(rs.getInt(1));
		num.setNumber(rs.getInt(2));
		num.setColor(rs.getString(3));
		num.setReouletteid(rs.getInt(4));
		
		return num;
	};
	
	public List<Number> findByRoulette(int id) {
		return jdbcTemplate.query("SELECT * FROM numbers WHERE rouletteid = ?", new Object[]{id}, rowMapper);
	}
	
	public int createNumbersRoulette(int idRoulette) {
		int result = 1;
		List<Number> lst = NumberRouletteEnum.createListValues();
		for (int i = 0; i < lst.size(); i++) {
			result = jdbcTemplate.update(
				    	"INSERT INTO numbers (number, color, rouletteid) VALUES (?, ?, ?)",
				    		lst.get(i).getNumber(), lst.get(i).getColor(), idRoulette);
		}
		
		return result;
	}
}
