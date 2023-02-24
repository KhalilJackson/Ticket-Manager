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
	 * Constructor for TicketList that takes in no parameters.
	 *
	 */
	public TicketList() {
		
	}
	
	/**
	 * Adds ticket to ticket list.
	 *
	 */
	public int addTicket(TicketType type, String thing1, String thing2, Category category, Priority priority, String thing3) {
		return 0;
	}
	
	/**
	 * Adds lists of tickets to ticket list.
	 *
	 */
	public void addTickets(List<Ticket> tickets) {
		
	}
	
	/**
	 * Gets a list of tickets.
	 *
	 */
	public List<Ticket> getTickets(){
		return null;
	}
	
	/**
	 * Gets tickets from ticket list of inputed ticket type.
	 *
	 */
	public List<Ticket> getTicketsByType(TicketType type){
		return null;
	}
	
	/**
	 * Gets ticket by ID number.
	 *
	 */
	public Ticket getTicketById(int id) {
		return null;
	}
	
	/**
	 * Executed command given command and int.
	 *
	 */
	public void executeCommand(int i, Command command) {
		
	}
	
	/**
	 * Deletes ticket from list using ID number.
	 *
	 */
	public void deleteTicketById(int id) {
		
	}

}
