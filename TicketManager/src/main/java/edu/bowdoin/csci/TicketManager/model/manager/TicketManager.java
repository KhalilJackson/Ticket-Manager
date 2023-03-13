package edu.bowdoin.csci.TicketManager.model.manager;

import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;

import java.util.ArrayList;
import java.util.List;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.io.TicketReader;
import edu.bowdoin.csci.TicketManager.model.io.TicketWriter;

/**
 * @author ewinters
 *
 */
public class TicketManager {
	
	private TicketList ticketList = new TicketList();
	private static TicketManager singleton = new TicketManager();
	
	/**
	 * Constructor for TicketManager that takes no parameters.
	 *
	 */
	private TicketManager() {
		
		
	}
	
	/**
	 * Gets instance of TicketManager.
	 * returns this instance of the TicketManager class
	 */
	public static TicketManager getInstance() {
		
		return singleton;
		
	}
	
	/**
	 * Writes an array of tickets to a file at the given path
	 */
	public void saveTicketsToFile(String filePath) {
		
		TicketWriter.writeTicketFile(filePath, ticketList.ticketList);
		
	}
	
	/**
	 * Creates an array of tickets given a file of tickets at the given path
	 *
	 */
	public void loadTicketsFromFile(String thing) {
		
		ticketList.ticketList = TicketReader.readTicketFile(thing);
	}
	
	/**
	 * Creates a new list of tickets
	 *
	 */
	public void createNewTicketList() {
		
		ticketList = new TicketList();
		
	}
	
	/**
	 * Fetches tickets and ticket fields to display in the ui
	 *
	 */
	public String[][] getTicketsForDisplay() {
		
		//index 0 id, index 1 type, index 2 state name, index 3 subject, index 4 cate, index 5 priotity
		
		String[][] display = new String[ticketList.ticketList.size()][6];
		
		int i = 0;
		
		
		//Iterate through the 
		for (Ticket ticket: ticketList.ticketList) {
			
			if (i < ticketList.ticketList.size()) {
				display[i][0] = Integer.toString(ticket.getTicketId());
				display[i][1] = ticket.getTicketTypeString();
				display[i][2] = ticket.getState();
				display[i][3] = ticket.getSubject();
				display[i][4] = ticket.getCategory();
				display[i][5] = ticket.getPriority();
				
				i++;
			}
			
			
		}
		
		return display;
	}

	/**
	 * Fetches tickets and ticket fields to display in the ui based on their type
	 *
	 */
	public String[][] getTicketsForDisplayByType(TicketType typeTicket) {
		
		return null;
	}
	
	/**
	 * returns the ticket with the given id
	 *
	 */
	public Ticket getTicketById(int id) {
		
		//Call get ticket by ID function from TicketList
		return ticketList.getTicketById(id);
	}
	
	/**
	 * executes the given command
	 *
	 */
	public void executeCommand(int num, Command command) {
		
		ticketList.executeCommand(num, command);
		
	}
	
	/**
	 * deletes the ticket in the ticket list with the given id
	 *
	 */
	public void deleteTicketById(int id) {
		
		//Call delete ticket function from TicketList
		ticketList.deleteTicketById(id);
		
	}
	
	/**
	 * creates a ticket with the given fields and adds it to the ticket list
	 *
	 */
	public void addTicketToList(TicketType ticketType, String s1, String s2, Category cat, Priority p, String s3) {
		
		//Ticket newTicket = new Ticket(ticketType, s2, s2, cat, p, s3);
		
		ticketList.addTicket(ticketType, s1, s2, cat, p, s3);
		
	}
	
}
