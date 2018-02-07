package org.bet.app.services;

import org.bet.app.entities.FootballMatchEntity;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class FootballMatchService {

	private FootballMatchService(){};
	
	public void commitDetails(Document doc, String url){
		String[] urlSplits = url.split("\\.");
		String site = urlSplits[1];
		
		Elements rows = doc.select("tr");
		
		for(int i = 1; i<rows.size(); i++){
			FootballMatchEntity match = new FootballMatchEntity();
			System.out.println("Loop.");
			Element row = rows.get(i);
			Elements elements = row.getAllElements();
			
			match.setSite(site);
			match.setLeague(elements.get(1).text());
			match.setMatch(elements.get(6).text());
			match.setSort1(Integer.parseInt(elements.get(7).text()));
			match.setSortX(Integer.parseInt(elements.get(8).text()));
			match.setSort2(Integer.parseInt(elements.get(9).text()));
			match.setOdd1(Double.parseDouble(elements.get(12).text()));
			match.setOddX(Double.parseDouble(elements.get(13).text()));
			match.setOdd2(Double.parseDouble(elements.get(14).text()));
			match.setUnder50odd(Integer.parseInt(elements.get((elements.size()-3)).text()));
			match.setOver50odd(Integer.parseInt(elements.get((elements.size()-2)).text()));
			
			if(elements.get(10).text().contains("r")){
				match.setTipSuccess(true);
			} else {
				match.setTipSuccess(false);
			}
			
			if(elements.hasClass("uop")){
				match.setGoalsOdd(true);
			} else {
				match.setGoalsOdd(false); 
			}
					
			
			System.out.println("Valeur visée : "+elements.get(10));
			System.out.println(match);
		}
	}
}
