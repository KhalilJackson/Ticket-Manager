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
	 * TO-DO
	 *
	 */
	public TicketList() {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public int addTicket(TicketType type, String thing1, String thing2, Category category, Priority priority, String thing3) {
		return 0;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void addTickets(List<Ticket> tickets) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public List<Ticket> getTickets(){
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public List<Ticket> getTicketsByType(TicketType type){
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
	public void executeCommand(int i, Command command) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void deleteTicketById(int id) {
		
	}

}
