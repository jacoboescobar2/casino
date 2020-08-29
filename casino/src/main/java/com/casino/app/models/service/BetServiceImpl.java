package com.casino.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casino.app.models.dao.IBetDao;
import com.casino.app.models.entity.Bet;

@Service
public class BetServiceImpl implements IBetService{

	@Autowired
	private IBetDao betDao;
	
	@Override
	public List<Bet> findAll() {
		return betDao.findAll();
	}

	@Override
	public int insertBet(Bet bet) {
		return betDao.insertBet(bet);
	}

	@Override
	public List<Bet> findAllResultsByRou(int id) {
		return betDao.findAllResultsByRou(id);
	}

	@Override
	public int deleteBetByIdUser(Bet bet) {
		return betDao.deleteBetByIdUser(bet);
	}

}
