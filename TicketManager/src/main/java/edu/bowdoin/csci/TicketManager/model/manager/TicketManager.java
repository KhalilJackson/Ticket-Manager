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
	 * TO-DO
	 *
	 */
	private TicketManager() {
		
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public static TicketManager getInstance() {
		
		return null;
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void saveTicketsToFile(String thing) {
		
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void loadTicketsFromFile(String thing) {
		
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void createNewTicketList() {
		
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String[][] getTicketsForDisplay() {
		
		return null;
	}

	/**
	 * TO-DO
	 *
	 */
	public String[][] getTicketsForDisplayByType(TicketType ticket) {
		
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public Ticket getTicketById(int id) {
		
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void executeCommand(int num, Command comm) {
		
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void deleteTicketById(int id) {
		
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void addTicketToList(TicketType ticketType, String s1, String s2, Category cat, Priority p, String s3) {
		
	}
	
}
