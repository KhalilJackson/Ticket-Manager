package edu.bowdoin.csci.TicketManager.model.io;

import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.File;
import java.io.FileNotFoundException;
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
			char character = (char)reader.read();
			
			while((character = (char)reader.read()) != (char)-1){
				if(character == '\r') {
					continue;
				}
				
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
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Unable to load file.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		
		//Convert each ticket string to a ticket object then store it in an array.
		for(int i = 0; i < ticketStrings.size(); i++) {
			
			//'#' character separates different parameters, '\n-' separates different notes,
			//and '\n*' marks the end of the ticket
			
			ArrayList<String> ticketElements = new ArrayList<String>(); 
			char currentChar;
			
			String currString = "";
			
			for(int j = 0; j < ticketStrings.get(i).length(); j++) {
				
				currentChar = ticketStrings.get(i).charAt(j);
				
				if(currentChar == '#') {
					ticketElements.add(currString);
					currString = "";
					continue;
				}
				
				else if(currentChar == '\n' && j != ticketStrings.get(i).length() - 1) {
					
					boolean hyphen = ticketStrings.get(i).charAt(j+1) == '-';
					boolean asterisk = ticketStrings.get(i).charAt(j+1) == '*';
					if(hyphen) {
						ticketElements.add(currString);
						currString = "";
						j += 1;
						continue;
					}
					else if(asterisk) {
						j += 1;
						continue;
					}
				}
				
				currString = currString + currentChar;
				
			}
			
			ticketElements.add(currString);
			
			ArrayList<String> notes = new ArrayList<String>();
			
			//A ticket has 8 parameters, so all elements past the 8th must be notes
			for(int j = 9; j < ticketElements.size(); j++) {
				notes.add(ticketElements.get(j));
			}
			
			String lastNote = notes.get(notes.size() - 1);
			
			try {
				Ticket nextTicket = new Ticket(Integer.parseInt(ticketElements.get(0)), 
						ticketElements.get(1), 
						ticketElements.get(2), 
						ticketElements.get(3), 
						ticketElements.get(4), 
						ticketElements.get(5), 
						ticketElements.get(6), 
						ticketElements.get(7), 
						ticketElements.get(8), 
						notes);

						tickets.add(nextTicket);
			}catch(IllegalArgumentException e) {
				throw new IllegalArgumentException("Unable to load file.");
			}
		}
		
		Ticket.setCounter(1);
		
		return tickets;
	}

}
