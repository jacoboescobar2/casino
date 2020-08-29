package com.casino.app.models.entity;

import java.util.Date;

public class Roulette {
	private int id;
	private boolean state;
	private Date open;
	private Date closed;
	public Roulette() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Date getOpen() {
		return open;
	}
	public void setOpen(Date open) {
		this.open = open;
	}
	public Date getClosed() {
		return closed;
	}
	public void setClosed(Date closed) {
		this.closed = closed;
	}
}
