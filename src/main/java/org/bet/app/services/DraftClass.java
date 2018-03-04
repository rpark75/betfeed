package org.bet.app.services;

import java.util.ArrayList;

import org.bet.app.entities.FootballMatchEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DraftClass {

	private static final Logger betLogger = LoggerFactory.getLogger(DraftClass.class);

	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.connect("http://www.prosoccer.gr/en/2017/10/soccer-predictions-2017-10-17.html").get();
		Elements rows = doc.select("tr");
		ArrayList<FootballMatchEntity> matchList = new ArrayList<>();
		
		for (int i = 1; i < rows.size(); i++) {
			FootballMatchEntity match = new FootballMatchEntity();
			System.out.println("Loop.");
			Element row = rows.get(i);
			Elements elements = row.getAllElements();

			match.setLeague(elements.get(1).text());
			match.setMatch(elements.get(6).text());
			match.setSort1(Integer.parseInt(elements.get(7).text()));
			match.setSortX(Integer.parseInt(elements.get(8).text()));
			match.setSort2(Integer.parseInt(elements.get(9).text()));
			match.setOdd1(Double.parseDouble(elements.get(12).text()));
			match.setOddX(Double.parseDouble(elements.get(13).text()));
			match.setOdd2(Double.parseDouble(elements.get(14).text()));
			match.setUnder50odd(Integer.parseInt(elements.get((elements.size() - 3)).text()));
			match.setOver50odd(Integer.parseInt(elements.get((elements.size() - 2)).text()));

			if (elements.get(10).text().contains("r")) {
				match.setTipSuccess(true);
			} else {
				match.setTipSuccess(false);
			}

			if (elements.hasClass("uop")) {
				match.setGoalsOdd(true);
			} else {
				match.setGoalsOdd(false);
			}

			System.out.println("Valeur visée : " + elements.get(10));
			System.out.println(match);
			
			matchList.add(match);
			
		}
		System.out.println("Taille de la liste : " + matchList.size());
		
		for(FootballMatchEntity matchTest : matchList) {
			System.out.println("Liste java 8 loop.");
			System.out.println(matchTest);
		}
	}

}
