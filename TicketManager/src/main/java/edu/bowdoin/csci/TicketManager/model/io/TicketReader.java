package edu.bowdoin.csci.TicketManager.model.io;

import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;

import java.util.ArrayList;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.File;
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
		
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		
		File ticketFile = new File(filePath);
		
		
		
		return tickets;
	}

}
