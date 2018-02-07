package org.bet.app.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import org.bet.app.dao.OddsDAO;
import org.bet.app.entities.FootballMatchEntity;
import org.bet.app.entities.OddsEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OddsService {

	private static final Logger betLogger = LoggerFactory.getLogger(OddsService.class);
	
	@Autowired
	private HtmlService htmlService;
	
	@Autowired
	private OddsDAO oddsDAO;

	public ArrayList<ArrayList<Integer>> getAllSuccessOddsList(String url) throws Exception {
		ArrayList<ArrayList<Integer>> allOddsList = new ArrayList<>();

		Elements doc = htmlService.getContent(url);
		allOddsList.add(htmlService.getResultOfOddsByClass(doc, "pu1", "q"));
		allOddsList.add(htmlService.getResultOfOddsByClass(doc, "pu2", "q"));
		allOddsList.add(htmlService.getResultOfOddsByClass(doc, "pu3", "q"));

		ArrayList<Integer> pu4qList = htmlService.getResultOfOddsByClass(doc, "pu4", "q");
		for (int odd : htmlService.getResultOfOddsByClass(doc, "pu4", "w")) {
			pu4qList.add(odd);
		}

		allOddsList.add(pu4qList);

		allOddsList.add(htmlService.getResultOfOddsByClass(doc, "pu5", "w"));
		allOddsList.add(htmlService.getResultOfOddsByClass(doc, "pu6", "w"));

		return allOddsList;
	}

	public ArrayList<ArrayList<Integer>> getAllOddsList(String url) throws Exception {
		ArrayList<ArrayList<Integer>> allOddsList = new ArrayList<>();

		Elements doc = htmlService.getContent(url);
		allOddsList.add(htmlService.getOddsByClass(doc, "pu1"));
		allOddsList.add(htmlService.getOddsByClass(doc, "pu2"));
		allOddsList.add(htmlService.getOddsByClass(doc, "pu3"));
		allOddsList.add(htmlService.getOddsByClass(doc, "pu4"));
		allOddsList.add(htmlService.getOddsByClass(doc, "pu5"));
		allOddsList.add(htmlService.getOddsByClass(doc, "pu6"));

		return allOddsList;
	}

	public ArrayList<Number> getRatio(ArrayList<ArrayList<Integer>> oddsList,
			ArrayList<ArrayList<Integer>> successList) {

		ArrayList<Number> ratiosList = new ArrayList<>();

		for (int i = 0; i < oddsList.size(); i++) {
			if (!oddsList.get(i).isEmpty()) {
				ratiosList.add((double) successList.get(i).size() / (double) oddsList.get(i).size());
			} else {
				ratiosList.add(0);
			}
		}

		return ratiosList;

	}
	
	public void commitOdd(ArrayList<ArrayList<Integer>> allOddsList, ArrayList<ArrayList<Integer>> allSuccessList,
			String url, String date) throws Exception{
		String[] urlSplits = url.split("\\.");
		String site = urlSplits[1];
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		for(int i=0; i<allOddsList.size(); i++){
			OddsEntity odd = new OddsEntity();
			odd.setOdds(allOddsList.get(i));
			odd.setResult(allSuccessList.get(i));
			odd.setSite(site);
			odd.setType(LibraryService.getTypesFromSite(site).get(i)); 
			odd.setRatio(getRatio(allOddsList, allSuccessList).get(i));
			odd.setDate(new Date(sdf.parse(date).getTime()));
			odd.setMajDate(new Date(Calendar.getInstance(Locale.FRANCE).getTime().getTime()));
			
			betLogger.info("Ajout de l'index {} sur {}...",i,(allOddsList.size()-1));
			oddsDAO.add(odd);
			
		}
		
		betLogger.info("Fin de l'ajout en base.");
	}
	
	
}
