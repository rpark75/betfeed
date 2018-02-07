package org.bet.app.services;

import java.util.ArrayList;

public class LibraryService {

	public static ArrayList<String> getTypesFromSite(String site){
		ArrayList<String> typesList = new ArrayList<>();
		
		switch(site) {
			case "prosoccer":
				typesList.add("pu1");
				typesList.add("pu2");
				typesList.add("pu3");
				typesList.add("pu4");
				typesList.add("pu5");
				typesList.add("pu6");
				break;
			default:
				break;
		}
		
		return typesList;
	}
	
}
