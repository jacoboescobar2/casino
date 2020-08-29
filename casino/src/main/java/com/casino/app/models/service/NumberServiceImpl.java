package com.casino.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casino.app.models.dao.INumberDao;
import com.casino.app.models.entity.Number;

@Service
public class NumberServiceImpl implements INumberService{

	@Autowired
	private INumberDao numberDao;
	
	@Override
	public List<Number> findByRoulette(int id) {
		return numberDao.findByRoulette(id);
	}
	@Override
	public int createNumbersRoulette(int idRoulette) {
		return numberDao.createNumbersRoulette(idRoulette);
	}

}
