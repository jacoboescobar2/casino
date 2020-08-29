package com.casino.app.models.service;

import java.util.List;

import com.casino.app.models.entity.Roulette;

public interface IRouletteService {

	public List<Roulette> findAll();
	
	public Roulette findById(int id);
	
	public int addRoulette();
	
	public int openRoulette(Roulette rou);
	
	public int closeRoulette(Roulette rou);
}
