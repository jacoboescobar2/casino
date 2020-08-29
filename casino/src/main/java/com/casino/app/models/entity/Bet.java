package com.casino.app.models.entity;

import java.util.Date;

public class Bet {
	private int id;
	private double bet;
	private int number;
	private String color;
	private Date date;
	private boolean win;
	private String colorResult;
	private int numberResult;
	private int userid;
	private int rouletteid;
	public Bet() {
		super();
	}
	public Bet(int id, double bet, int number, String color, Date date, boolean win, String colorResult,
			int numberResult, int userid, int rouletteid) {
		super();
		this.id = id;
		this.bet = bet;
		this.number = number;
		this.color = color;
		this.date = date;
		this.win = win;
		this.colorResult = colorResult;
		this.numberResult = numberResult;
		this.userid = userid;
		this.rouletteid = rouletteid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBet() {
		return bet;
	}
	public void setBet(double bet) {
		this.bet = bet;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	public String getColorResult() {
		return colorResult;
	}
	public void setColorResult(String colorResult) {
		this.colorResult = colorResult;
	}
	public int getNumberResult() {
		return numberResult;
	}
	public void setNumberResult(int numberResult) {
		this.numberResult = numberResult;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRouletteid() {
		return rouletteid;
	}
	public void setRouletteid(int rouletteid) {
		this.rouletteid = rouletteid;
	}
}
