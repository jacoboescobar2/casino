package com.casino.app.models.entity;

public class Number {
	private int id;
	private int number;
	private String color;
	private int reouletteid;
	public Number() {
		super();
	}
	public Number(int id, int number, String color, int reouletteid) {
		super();
		this.id = id;
		this.number = number;
		this.color = color;
		this.reouletteid = reouletteid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getReouletteid() {
		return reouletteid;
	}
	public void setReouletteid(int reouletteid) {
		this.reouletteid = reouletteid;
	}
}
