package com.casino.app.models.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.casino.app.models.dao.IUserDao;
import com.casino.app.models.entity.User;

@Repository
public class UserRepository implements IUserDao, RowMapper<User>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setMoney(rs.getDouble(3));
		return user;
	};
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setMoney(rs.getDouble("money"));
		return user;
	}
	
	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM users", rowMapper);
	}

	public User findById(int id) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM users WHERE id = ?", new Object[] { id }, new UserRepository());
	}
}
