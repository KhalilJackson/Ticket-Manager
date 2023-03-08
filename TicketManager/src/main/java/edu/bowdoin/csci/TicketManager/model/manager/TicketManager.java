package edu.bowdoin.csci.TicketManager.model.manager;

import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;

import java.util.ArrayList;
import java.util.List;

import edu.bowdoin.csci.TicketManager.model.command.Command;

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
		
		ticketList = new TicketList();
		
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
		
		ticketList.addTicket(ticketType, s2, s2, cat, p, s3);
		
	}
	
}
