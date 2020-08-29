package com.casino.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casino.app.models.dao.IRouletteDao;
import com.casino.app.models.entity.Roulette;

@Service
public class RouletteServiceImpl implements IRouletteService {

	@Autowired
	private IRouletteDao rouletteDao;
	
	@Override
	public List<Roulette> findAll() {
		return rouletteDao.findAll();
	}

	@Override
	public int addRoulette() {
		return rouletteDao.addRoulette();
	}

	@Override
	public int openRoulette(Roulette rou) {
		return rouletteDao.openRoulette(rou);
	}

	@Override
	public int closeRoulette(Roulette rou) {
		return rouletteDao.closeRoulette(rou);
	}

	@Override
	public Roulette findById(int id) {
		return rouletteDao.findById(id);
	}
}
