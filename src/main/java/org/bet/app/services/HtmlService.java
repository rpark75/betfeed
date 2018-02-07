package org.bet.app.services;

import java.util.ArrayList;

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
	
	public Elements getContent(String url) throws Exception {
		betLogger.info("Récupération des données sources distantes..."); 
		Document doc = Jsoup.connect(url).get();
		return doc.select("tr");
	}

	public ArrayList<Integer> getResultOfOddsByClass(Elements rows, String odds, String result){
		String value;
		ArrayList<Integer> oddsSuccessList = new ArrayList<>();
		
		for (Element row : rows) {

			Elements rowsFiltered = row.getElementsByClass(odds);

			for (Element rowFilt : rowsFiltered){
				value = rowFilt.getElementsByClass(result).text();
				
				if(value.length()>0)
				oddsSuccessList.add(Integer.parseInt(value));
			}
		}
		
		betLogger.info("Nombre de résultats avec succès : {}",oddsSuccessList.size());
		
		return oddsSuccessList;
		
	}
	
	public ArrayList<Integer> getOddsByClass(Elements rows, String odds){
		String value;
		ArrayList<Integer> oddsList = new ArrayList<>();
		String sub1 = "";
		String sub2 = "";
		
		for (Element row : rows) {

			value = row.getElementsByClass(odds).text();
			
			if(value.length()>0){
				switch(value.length()){
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
		
		betLogger.info("Nombre d'odds totaux : {}",oddsList.size());
		
		return oddsList;
		
	}
}
