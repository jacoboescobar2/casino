package com.casino.app.controllers;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casino.app.models.entity.Roulette;
import com.casino.app.models.entity.User;
import com.casino.app.models.enums.NumberRouletteEnum;
import com.casino.app.models.entity.Bet;
import com.casino.app.models.entity.Number;
import com.casino.app.models.service.IBetService;
import com.casino.app.models.service.INumberService;
import com.casino.app.models.service.IRouletteService;
import com.casino.app.models.service.IUserService;

@Controller
@SessionAttributes("user")
public class BoardController {

	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(BoardController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRouletteService rouletteService;
	
	@Autowired
	private IBetService betService;
	
	@Autowired
	private INumberService numberService;

	private int idRoulette;
	private int idRouletteOpen;
	private int stateCreateNumber;
	
	@GetMapping("/")
	public String seeBoard(Model model) {
		Bet bet = new Bet();
		User user = userService.findById(1);
		model.addAttribute("user", user);
		model.addAttribute("bet", bet);
		List<Roulette> roulettes = rouletteService.findAll();
		List<Number> lst = NumberRouletteEnum.createListValues();
		if (model.getAttribute("idRoulette") != null) {
            model.addAttribute("idRoulette", idRoulette);
            model.addAttribute("alertClass","alert-success");
        }
		if(model.getAttribute("idRouletteOpen") != null){
			model.addAttribute("idRouletteOpen",idRouletteOpen);
		}
		model.addAttribute("title", "Ruletas");
		model.addAttribute("roulettes", roulettes);
		model.addAttribute("lstnumber",lst);
		return "index";
	}
	
	@GetMapping("/new-roulette")
	public String newRoulette(Model model,  RedirectAttributes attrs) {
		idRoulette = rouletteService.addRoulette();
		stateCreateNumber = numberService.createNumbersRoulette(idRoulette);
		attrs.addFlashAttribute("idRoulette", idRoulette);
		attrs.addFlashAttribute("stateCreateNumber", stateCreateNumber);
		return "redirect:/";
	}

	@GetMapping("/openRoulette/{idRoulette}")
	public String openRouletes(@PathVariable(value= "idRoulette") int id, @ModelAttribute("user") User user, Model model, RedirectAttributes attrs) {
		Date date = new Date();
		Roulette rou = new Roulette();
		rou.setId(id);
		rou.setOpen(date);
		idRouletteOpen = rouletteService.openRoulette(rou);
		if(idRouletteOpen == 1) {
			idRouletteOpen = id;
			attrs.addFlashAttribute("idRouletteOpen", idRouletteOpen);
		}
		Bet bet = new Bet();
		bet.setUserid(user.getId());
		LOGGER.info("user.getId() " + user.getId());
		bet.setRouletteid(id);
		betService.deleteBetByIdUser(bet);
		return "redirect:/";
	}
	
	@GetMapping("/closeRoulette/{idRoulette}")
	public String closeRouletes(@PathVariable(value= "idRoulette") int id,Model model, RedirectAttributes attrs) {
		Roulette rou = new Roulette();
		Date close = new Date();
		rou.setClosed(close);
		rou.setState(false);
		rou.setId(id);
		rouletteService.closeRoulette(rou);
		Roulette roufind = rouletteService.findById(id);
		List<Bet> betsResults = betService.findAllResultsByRou(roufind.getId());
		model.addAttribute("betsResults", betsResults);
		model.addAttribute("rouletteid", id);
		return "result";
	}
	
	@PostMapping("/bet/{idRoulette}")
	public String makeBet(@ModelAttribute("bet") Bet bet, @PathVariable(value= "idRoulette") int id, @ModelAttribute("user") User user, Model model, SessionStatus status, RedirectAttributes attrs) {
		boolean resultColor = false;
		boolean resultNumber = false;
		Bet newBet = new Bet();
		newBet.setRouletteid(id);
		newBet.setUserid(user.getId());
		Date date = new Date();
		newBet.setDate(date);
		newBet.setBet(bet.getBet());
		NumberRouletteEnum value = NumberRouletteEnum.ramdomEnum();
		newBet.setColorResult(value.getColor());
		newBet.setNumberResult(value.getValue());
		if(!bet.getColor().equals("empty")) {
			resultColor = bet.getColor().equals(value.getColor());
			newBet.setWin(resultColor);
			newBet.setNumber(-1);
			newBet.setColor(bet.getColor());
			betService.insertBet(newBet);
		}
		if(bet.getNumber() > -1) {
			resultNumber = bet.getNumber() == value.getValue();
			newBet.setWin(resultNumber);
			newBet.setColor(null);
			newBet.setNumber(bet.getNumber());
			betService.insertBet(newBet);
		}
		return "redirect:/";
	}
}
