package edu.bowdoin.csci.TicketManager.model.manager;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;
import java.util.ArrayList;
import java.util.List;

public class TicketList {
	
	/**
	 * Constructor for TicketList class
	 *
	 */
	public TicketList() {
		
	}
	
	/**
	 * Creates a ticket given the input parameters and adds it to the ticket list
	 *
	 */
	public int addTicket(TicketType type, String thing1, String thing2, Category category, Priority priority, String thing3) {
		return 0;
	}
	
	/**
	 * Adds each ticket in a given array of tickets to the ticket list
	 *
	 */
	public void addTickets(List<Ticket> tickets) {
		
	}
	
	/**
	 * Returns the ticket list
	 *
	 */
	public List<Ticket> getTickets(){
		return null;
	}
	
	/**
	 * returns the tickets in the list that have a given type
	 *
	 */
	public List<Ticket> getTicketsByType(TicketType type){
		return null;
	}
	
	/**
	 * Returns the ticket in the list with the given id
	 *
	 */
	public Ticket getTicketById(int id) {
		return null;
	}
	
	/**
	 * Executes the given command
	 *
	 */
	public void executeCommand(int i, Command command) {
		
	}
	
	/**
	 * Removes the ticket in the list with the given id
	 *
	 */
	public void deleteTicketById(int id) {
		
	}

}
