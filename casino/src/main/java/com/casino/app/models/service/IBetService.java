package com.casino.app.models.service;

import java.util.List;

import com.casino.app.models.entity.Bet;

public interface IBetService {
	
	public List<Bet> findAll();
	
	public List<Bet> findAllResultsByRou(int id);
	
	public int insertBet(Bet bet);

	public int deleteBetByIdUser(Bet bet);
}
