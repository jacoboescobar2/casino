package com.casino.app.models.dao;

import java.util.List;

import com.casino.app.models.entity.Number;

public interface INumberDao {
	
	public List<Number> findByRoulette(int id);
	
	public int createNumbersRoulette(int idRoulette);

}
