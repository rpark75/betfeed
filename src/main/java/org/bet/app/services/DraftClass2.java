package org.bet.app.services;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

public class DraftClass2 {

	/*
	 * public static void main(String[] args) throws Exception {
	 * System.out.println("Lancement.");
	 * 
	 * final String username = "cleoinquiries@gmail.com"; final String password
	 * = "musemuse91";
	 * 
	 * Properties props = new Properties(); props.put("mail.smtp.auth", "true");
	 * props.put("mail.smtp.starttls.enable", "true");
	 * props.put("mail.smtp.host", "smtp.gmail.com");
	 * props.put("mail.smtp.port", "587");
	 * 
	 * Session session = Session.getInstance(props, new
	 * javax.mail.Authenticator() { protected PasswordAuthentication
	 * getPasswordAuthentication() { return new PasswordAuthentication(username,
	 * password); } });
	 * 
	 * try {
	 * 
	 * Message message = new MimeMessage(session); message.setFrom(new
	 * InternetAddress("cleoinquiries@gmail.com"));
	 * message.setRecipients(Message.RecipientType.TO,
	 * InternetAddress.parse("samai7524@gmail.com"));
	 * message.setSubject("Testing Subject");
	 * message.setText("Dear Mail Crawler," +
	 * "\n\n No spam to my email, please!");
	 * 
	 * Transport.send(message);
	 * 
	 * System.out.println("Done");
	 * 
	 * } catch (MessagingException e) { throw new RuntimeException(e); } }
	 */
/*
 * SCRIPT MAISON CLEO pour RECUPT AUTO COMMANDES + BL
 */
	public static void main(String[] args) throws Exception {
		System.out.println("Lancement.");
		Session session = Session.getDefaultInstance(new Properties());
		Store store = session.getStore("imaps");
		store.connect("imap.googlemail.com", 993, "cleoinquiries@gmail.com", "musemuse91");
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		// Fetch unseen messages from inbox folder
		Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

		// Sort messages from recent to oldest
		Arrays.sort(messages, (m1, m2) -> {
			try {
				return m2.getSentDate().compareTo(m1.getSentDate());
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		});

		for (Message message : messages) {
			if(message.getSubject().toLowerCase(Locale.FRANCE).contains("vous venez de recevoir")){
			System.out.println("sendDate: " + message.getSentDate() + " subject:" + message.getSubject());
			}
		}
		
		<<<<<<<<<<<<//////////////////////////////////////A RAJOUTER POUR LE FILTRE SUR LES DATES
		SearchTerm term = null;

		Calendar cal = null;
		cal = Calendar.getInstance();
		Date minDate = new Date(cal.getTimeInMillis());   //get today date

		cal.add(Calendar.DAY_OF_MONTH, 1);                //add 1 day
		Date maxDate = new Date(cal.getTimeInMillis());   //get tomorrow date
		ReceivedDateTerm minDateTerm = new ReceivedDateTerm(ComparisonTerm.GE, minDate);
		ReceivedDateTerm maxDateTerm = new ReceivedDateTerm(ComparisonTerm.LE, maxDate);

		term = new AndTerm(term, minDateTerm);            //concat the search terms
		term = new AndTerm(term, maxDateTerm);

		Message messages[] = folderInbox.search(term);    //search on the imap server
	}

}
