package com.casino.app.models.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.casino.app.models.entity.Number;

public enum NumberRouletteEnum {

	ROULETTE0(0,"Verde"),
	ROULETTE1(1,"Rojo"),
	ROULETTE2(2,"Negro"),
	ROULETTE3(3,"Rojo"),
	ROULETTE4(4,"Negro"),
	ROULETTE5(5,"Rojo"),
	ROULETTE6(6,"Negro"),
	ROULETTE7(7,"Rojo"),
	ROULETTE8(8,"Negro"),
	ROULETTE9(9,"Rojo"),
	ROULETTE10(10,"Negro"),
	ROULETTE11(11,"Negro"),
	ROULETTE12(12,"Rojo"),
	ROULETTE13(13,"Negro"),
	ROULETTE14(14,"Rojo"),
	ROULETTE15(15,"Negro"),
	ROULETTE16(16,"Rojo"),
	ROULETTE17(17,"Negro"),
	ROULETTE18(18,"Rojo"),
	ROULETTE19(19,"Rojo"),
	ROULETTE20(20,"Negro"),
	ROULETTE21(21,"Rojo"),
	ROULETTE22(22,"Negro"),
	ROULETTE23(23,"Rojo"),
	ROULETTE24(24,"Negro"),
	ROULETTE25(25,"Rojo"),
	ROULETTE26(26,"Negro"),
	ROULETTE27(27,"Rojo"),
	ROULETTE28(28,"Negro"),
	ROULETTE29(29,"Negro"),
	ROULETTE30(30,"Rojo"),
	ROULETTE31(31,"Negro"),
	ROULETTE32(32,"Rojo"),
	ROULETTE33(33,"Negro"),
	ROULETTE34(34,"Rojo"),
	ROULETTE35(35,"Negro"),
	ROULETTE36(36,"Rojo");
	
	private int value;
	private String color;
    private NumberRouletteEnum(int value, String color) {
		this.value = value;
		this.color = color;
	}
	public String getColor() {
		return color;
	}
    public int getValue() {
        return value;
    }
	public static List<Number> createListValues(){
    	List<Number> list = new ArrayList<>();
    	for (NumberRouletteEnum obj : NumberRouletteEnum.values()) { 
    	    Number numb = new Number();
    	    numb.setNumber(obj.getValue());
    	    numb.setColor(obj.getColor());
    	    list.add(numb);
    	}
    	return list;
    }
	public static NumberRouletteEnum ramdomEnum() {
		return NumberRouletteEnum.values()[new Random().nextInt(NumberRouletteEnum.values().length)];
	}
}
