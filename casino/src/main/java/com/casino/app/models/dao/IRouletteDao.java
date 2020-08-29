package com.casino.app.models.dao;

import java.util.List;

import com.casino.app.models.entity.Roulette;

public interface IRouletteDao {

	public List<Roulette> findAll();
	
	public Roulette findById(int id);
	
	public int addRoulette();
	
	public int openRoulette(Roulette rou);
	
	public int closeRoulette(Roulette rou);
	
}
