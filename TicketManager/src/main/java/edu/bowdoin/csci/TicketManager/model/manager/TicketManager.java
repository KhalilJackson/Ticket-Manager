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
	 * Constructor for TicketManager that takes no parameters.
	 *
	 */
	private TicketManager() {
		
		
	}
	
	/**
	 * Gets instance of TicketManager.
	 *
	 */
	public static TicketManager getInstance() {
		
		return null;
		
	}
	
	/**
	 * Svaes ticket to file from String input.
	 *
	 */
	public void saveTicketsToFile(String thing) {
		
		
	}
	
	/**
	 * Loads ticket from file using inputted string.
	 *
	 */
	public void loadTicketsFromFile(String thing) {
		
		
	}
	
	/**
	 * Creates new ticket list and takes no parameters.
	 *
	 */
	public void createNewTicketList() {
		
		
	}
	
	/**
	 * Returns 2d String array of tickets.
	 *
	 */
	public String[][] getTicketsForDisplay() {
		
		return null;
	}

	/**
	 * Returns 2d String array of tickets by display type.
	 *
	 */
	public String[][] getTicketsForDisplayByType(TicketType ticket) {
		
		return null;
	}
	
	/**
	 * Returns ticket from list by ID number.
	 *
	 */
	public Ticket getTicketById(int id) {
		
		return null;
	}
	
	/**
	 * Executes given command.
	 *
	 */
	public void executeCommand(int num, Command comm) {
		
		
	}
	
	/**
	 * Deletes ticket by ID number.
	 *
	 */
	public void deleteTicketById(int id) {
		
		
	}
	
	/**
	 * Adds ticket to ticket list.
	 *
	 */
	public void addTicketToList(TicketType ticketType, String s1, String s2, Category cat, Priority p, String s3) {
		
	}
	
}
