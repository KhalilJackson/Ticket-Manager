package edu.bowdoin.csci.TicketManager.model.io;

import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	public static void writeTicketFile(String filePath, ArrayList<Ticket> tickets) {
		
		String ticketsString = "";
		
		if(tickets != null) {
			
			for(int i = 0; i < tickets.size() - 1; i++) {
				ticketsString = ticketsString + tickets.get(i).toString();
			}
			
			if(tickets.size() > 0) {
				//The last ticket should not have \n at the end, so it is added separately:
				String lastString = tickets.get(tickets.size() - 1).toString();
				ticketsString = ticketsString + tickets.get(tickets.size() - 1).toString();
				
				//Remove new line character at end:
				ticketsString = ticketsString.substring(0, ticketsString.length() - 1);
				//System.out.println((int)lastString.charAt(lastString.length() - 1));
				//System.out.println((int)ticketsString.charAt(ticketsString.length() - 1));
			}
		}
		
		
		//Write the tickets to the given file; catch an exception in case the file path is wrong
		try {
			
			File ticketFile = new File(filePath);
			
			//Create a new file and write to it. If file already exists, throw an error.
			if(ticketFile.createNewFile()) {
				FileWriter writer = new FileWriter(ticketFile);
				writer.write(ticketsString);
				writer.close();
			}
			else {
				throw new IllegalArgumentException();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Unable to save file.");
		}
		
	}
	
}
