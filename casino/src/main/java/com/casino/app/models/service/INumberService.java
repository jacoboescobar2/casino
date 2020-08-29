package com.casino.app.models.service;

import java.util.List;

import com.casino.app.models.entity.Number;

public interface INumberService {

	public List<Number> findByRoulette(int id);
	
	public int createNumbersRoulette(int idRoulette);
}
