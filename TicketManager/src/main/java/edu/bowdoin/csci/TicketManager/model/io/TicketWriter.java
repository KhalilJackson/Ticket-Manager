package edu.bowdoin.csci.TicketManager.model.io;
import java.util.ArrayList;

import java.io.FileWriter;

import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;

public class TicketWriter {

	/**
	 * Constructor for TicketWriter() that takes no parameters. 
	 *
	 */
	public TicketWriter() {
		
	}
	
	/**
	 * Writes a ticket file given an array of valid tickets
	 *
	 */
	public void writeTicketFile(String filePath, ArrayList<Ticket> tickets) {
		
		String ticketsString = "";
		
		for(int i = 0; i < tickets.size() - 1; i++) {
			ticketsString = ticketsString + tickets.get(i).toString() + "\n";
		}
		
		ticketsString = ticketsString + tickets.get(tickets.size() - 1);
		
		try {
		
			FileWriter writer = new FileWriter(filePath);
			writer.write(ticketsString);
			writer.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
