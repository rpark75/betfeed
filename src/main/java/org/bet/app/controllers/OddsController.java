package org.bet.app.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bet.app.dao.StatsDAO;
import org.bet.app.services.OddsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OddsController {

	private static final Logger betLogger = LoggerFactory.getLogger(OddsController.class);
	
	@Autowired
	private OddsService oddsService;
	
	@Autowired
	private StatsDAO statsDao;
	
	@RequestMapping(value = "/commitOdd", method = RequestMethod.GET)
	public String commitOdd(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		String url = req.getParameter("url");
		String date = req.getParameter("date");
		
		oddsService.commitOdd(oddsService.getAllOddsList(url), oddsService.getAllSuccessOddsList(url), url, date);	
		
		return "testok";
	}
	
	@RequestMapping(value = "/odds", method = RequestMethod.GET)
	public String results(HttpServletRequest req, HttpServletResponse res) throws Exception{
		betLogger.info("Chargement de service odds..");
		ArrayList<ArrayList<Integer>> allSuccessOddsList = oddsService.getAllSuccessOddsList(req.getParameter("url"));
		ArrayList<ArrayList<Integer>> allOddsList = oddsService.getAllOddsList(req.getParameter("url"));
		
		
		req.setAttribute("successList", allSuccessOddsList);
		req.setAttribute("oddsList", allOddsList);
		req.setAttribute("ratiosList", oddsService.getRatio(allOddsList, allSuccessOddsList));
		
		betLogger.info("Fin de chargement.");
		return "results";
	}
	
	@RequestMapping(value = "/commitDetails", method = RequestMethod.GET)
	public String commitDetails(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		
		return "testok";
	}
}
