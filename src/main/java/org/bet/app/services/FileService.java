package org.bet.app.services;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.bet.app.entities.FootballMatchEntity;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	private static final String CSV_SEPARATOR = ";";
	
	/**
	 * Permet d'écrire la liste de matchs dans un fichier csv.
	 * @param match : 
	 * @throws Exception
	 */
	public void writeToCSV(ArrayList<FootballMatchEntity> matchList) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("C:/Users/RPARK-ADVANCED/Documents/MC/Projets java/test.csv"), "UTF-8"));

		for(FootballMatchEntity match : matchList) {
		
		StringBuffer activeLine = new StringBuffer();

		activeLine.append(match.getId());
		activeLine.append(CSV_SEPARATOR);
		activeLine.append(match.getMatch());
		activeLine.append(CSV_SEPARATOR);
		activeLine.append(match.getLeague());
		activeLine.append(CSV_SEPARATOR);
		activeLine.append(match.getOdd1());
		bw.write(activeLine.toString());
		bw.newLine();
		
		}
		
		bw.flush();
		bw.close();
	}
	
}
