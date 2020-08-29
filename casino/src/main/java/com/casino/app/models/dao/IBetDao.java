package com.casino.app.models.dao;

import java.util.List;

import com.casino.app.models.entity.Bet;

public interface IBetDao {

	public List<Bet> findAll();
	
	public List<Bet> findAllResultsByRou(int id);
	
	public int insertBet(Bet bet);
	
	public int deleteBetByIdUser(Bet bet);
}
