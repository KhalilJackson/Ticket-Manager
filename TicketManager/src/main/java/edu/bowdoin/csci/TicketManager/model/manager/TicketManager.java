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
<<<<<<< HEAD
	 * Constructor for TicketManager that takes no parameters.
=======
	 * Constructor for the ticket class
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	private TicketManager() {
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Gets instance of TicketManager.
=======
	 * returns this instance of the TicketManager class
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public static TicketManager getInstance() {
		
		return null;
		
	}
	
	/**
<<<<<<< HEAD
	 * Svaes ticket to file from String input.
=======
	 * Writes an array of tickets to a file at the given path
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void saveTicketsToFile(String thing) {
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Loads ticket from file using inputted string.
=======
	 * Creates an array of tickets given a file of tickets at the given path
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void loadTicketsFromFile(String thing) {
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Creates new ticket list and takes no parameters.
=======
	 * Creates a new list of tickets
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void createNewTicketList() {
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Returns 2d String array of tickets.
=======
	 * Fetches tickets and ticket fields to display in the ui
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public String[][] getTicketsForDisplay() {
		
		return null;
	}

	/**
<<<<<<< HEAD
	 * Returns 2d String array of tickets by display type.
=======
	 * Fetches tickets and ticket fields to display in the ui based on their type
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public String[][] getTicketsForDisplayByType(TicketType ticket) {
		
		return null;
	}
	
	/**
<<<<<<< HEAD
	 * Returns ticket from list by ID number.
=======
	 * returns the ticket with the given id
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public Ticket getTicketById(int id) {
		
		return null;
	}
	
	/**
<<<<<<< HEAD
	 * Executes given command.
=======
	 * executes the given command
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void executeCommand(int num, Command command) {
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Deletes ticket by ID number.
=======
	 * deletes the ticket in the ticket list with the given id
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void deleteTicketById(int id) {
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Adds ticket to ticket list.
=======
	 * creates a ticket with the given fields and adds it to the ticket list
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void addTicketToList(TicketType ticketType, String s1, String s2, Category cat, Priority p, String s3) {
		
	}
	
}
