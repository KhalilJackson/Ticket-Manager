package edu.bowdoin.csci.TicketManager.model.manager;

import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.command.Command;

/**
 * @author ewinters
 *
 */
public class TicketManager {
	
	
	/**
	 * Constructor for the ticket class
	 *
	 */
	private TicketManager() {
		
		
	}
	
	/**
	 * returns this instance of the TicketManager class
	 *
	 */
	public static TicketManager getInstance() {
		
		return null;
		
	}
	
	/**
	 * Writes an array of tickets to a file at the given path
	 *
	 */
	public void saveTicketsToFile(String thing) {
		
		
	}
	
	/**
	 * Creates an array of tickets given a file of tickets at the given path
	 *
	 */
	public void loadTicketsFromFile(String thing) {
		
		
	}
	
	/**
	 * Creates a new list of tickets
	 *
	 */
	public void createNewTicketList() {
		
		
	}
	
	/**
	 * Fetches tickets and ticket fields to display in the ui
	 *
	 */
	public String[][] getTicketsForDisplay() {
		
		return null;
	}

	/**
	 * Fetches tickets and ticket fields to display in the ui based on their type
	 *
	 */
	public String[][] getTicketsForDisplayByType(TicketType ticket) {
		
		return null;
	}
	
	/**
	 * returns the ticket with the given id
	 *
	 */
	public Ticket getTicketById(int id) {
		
		return null;
	}
	
	/**
	 * executes the given command
	 *
	 */
	public void executeCommand(int num, Command command) {
		
		
	}
	
	/**
	 * deletes the ticket in the ticket list with the given id
	 *
	 */
	public void deleteTicketById(int id) {
		
		
	}
	
	/**
	 * creates a ticket with the given fields and adds it to the ticket list
	 *
	 */
	public void addTicketToList(TicketType ticketType, String s1, String s2, Category cat, Priority p, String s3) {
		
	}
	
}
