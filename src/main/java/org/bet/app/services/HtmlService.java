package org.bet.app.services;

import java.util.ArrayList;

import org.bet.app.entities.FootballMatchEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HtmlService {

	private static final Logger betLogger = LoggerFactory.getLogger(HtmlService.class);

	/**
	 * Obtenir le contenu de la page html cible.
	 * 
	 * @param url
	 *            : page cible
	 * @return : objet Elements rempli.
	 * @throws Exception
	 */
	public Elements getContentOfUrlPage(String url) throws Exception {
		betLogger.info("Récupération des données sources distantes...");
		Document doc = Jsoup.connect(url).get();
		return doc.select("tr");
	}

	/**
	 * Transformer les contenus de la page récupérés en Elements vers une liste de
	 * matchs.
	 * 
	 * @param rows
	 *            : objet Elements d'entrée alimenté depuis une page.
	 * @return : ArrayList contenait les objets de match.
	 */
	public ArrayList<FootballMatchEntity> getListFromPageContent(Elements rows) {
		ArrayList<FootballMatchEntity> matchList = new ArrayList<>();

		for (int i = 1; i < rows.size(); i++) {
			FootballMatchEntity match = new FootballMatchEntity();
			betLogger.info("Incrémentation.");
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

			
			betLogger.info(match.toString());

			matchList.add(match);

		}
		betLogger.info("Taille de la liste : " + matchList.size());

		return matchList;
	}

	public ArrayList<Integer> getResultOfOddsByClass(Elements rows, String odds, String result) {
		String value;
		ArrayList<Integer> oddsSuccessList = new ArrayList<>();

		for (Element row : rows) {

			Elements rowsFiltered = row.getElementsByClass(odds);

			for (Element rowFilt : rowsFiltered) {
				value = rowFilt.getElementsByClass(result).text();

				if (value.length() > 0)
					oddsSuccessList.add(Integer.parseInt(value));
			}
		}

		betLogger.info("Nombre de résultats avec succès : {}", oddsSuccessList.size());

		return oddsSuccessList;

	}

	public ArrayList<Integer> getOddsByClass(Elements rows, String odds) {
		String value;
		ArrayList<Integer> oddsList = new ArrayList<>();
		String sub1 = "";
		String sub2 = "";

		for (Element row : rows) {

			value = row.getElementsByClass(odds).text();

			if (value.length() > 0) {
				switch (value.length()) {
				case 2:
					oddsList.add(Integer.parseInt(value));
					break;
				case 5:
					sub1 = value.substring(3, 5);
					oddsList.add(Integer.parseInt(sub1));
					break;
				case 8:
					sub2 = value.substring(6, 8);
					oddsList.add(Integer.parseInt(sub2));
					break;
				default:
					break;
				}
			}
		}

		betLogger.info("Nombre d'odds totaux : {}", oddsList.size());

		return oddsList;

	}
}
