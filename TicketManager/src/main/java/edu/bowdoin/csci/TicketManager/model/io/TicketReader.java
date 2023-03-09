package edu.bowdoin.csci.TicketManager.model.io;

import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;

import java.util.ArrayList;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TicketReader {
	
	/**
	 * TicketReader constructor
	 *
	 */
	public TicketReader() {
		
	}
	
	/**
	 * Takes in the ticket file and creates the array of tickets
	 *
	 */
	public static ArrayList<Ticket> readTicketFile(String filePath){
		
		//Each ticket in the file is stored in the ticket string, before being
		//added to the ticketStrings array once the next ticket in the file starts
		ArrayList<String> ticketStrings = new ArrayList<String>();
		String ticket = "";
		
		try {
			File ticketFile = new File(filePath);
			FileReader reader = new FileReader(ticketFile);
			int character = reader.read();
			
			while((character = reader.read()) != -1){
				ticket = ticket + character;
				
				//An asterisk denotes the start of a new ticket
				if(character == '*') {
					ticketStrings.add(ticket);
					ticket = "";
				}
			}
			
			//Last ticket does not end in an asterisk, so must be added to ticketStrings manually
			ticketStrings.add(ticket);
			
			reader.close();
			
			ArrayList<Ticket> tickets = new ArrayList<Ticket>();
			
			//Convert each ticket string to a ticket object then store it in an array.
			for(int i = 0; i < ticketStrings.size(); i++) {
				
				//'#' character separates different parameters, '\n-' separates different notes,
				//and '\n*' marks the end of the ticket
				String[] ticketElements = ticketStrings.get(i).split("#|(\n-)|(\n*)");
				
				ArrayList<String> notes = new ArrayList<String>();
				
				//A ticket has 8 parameters, so all elements past the 8th must be notes
				for(int j = 9; j < ticketElements.length; j++) {
					notes.add(ticketElements[j]);
				}
				
				Ticket nextTicket = new Ticket(Integer.parseInt(ticketElements[0]) , ticketElements[1], ticketElements[2], ticketElements[3], ticketElements[4], ticketElements[5], ticketElements[6], ticketElements[7], ticketElements[8], notes);
				
				tickets.add(nextTicket);
			}
			
			return tickets;
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("pancakes.");
			System.out.println(e.toString());
			return null;
		}
	}

}
