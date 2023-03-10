package edu.bowdoin.csci.TicketManager.model.manager;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;
import java.util.ArrayList;
import java.util.List;

public class TicketList {
	
	
	
	public static List<Ticket> ticketList = new ArrayList<Ticket>();
	
	
	/**
<<<<<<< HEAD
	 * Constructor for TicketList that takes in no parameters.
=======
	 * Constructor for TicketList class
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public TicketList() {
		
	}
	
	/**
	 * Adds ticket to ticket list.
	 * Creates a ticket given the input parameters and adds it to the ticket list
	 *
	 */
	public int addTicket(TicketType type, String thing1, String thing2, Category category, Priority priority, String thing3) {
		
		Ticket newTicket = new Ticket(type, thing1, thing2, category, priority, thing3);
		
		ticketList.add(newTicket);
		return 0;
	}
	
	/**
<<<<<<< HEAD
	 * Adds lists of tickets to ticket list.
=======
	 * Adds each ticket in a given array of tickets to the ticket list
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void addTickets(List<Ticket> tickets) {
		
		if (tickets != null) {
			
			ticketList.addAll(tickets);
		}
		
	}
	
	/**
<<<<<<< HEAD
	 * Gets a list of tickets.
=======
	 * Returns the ticket list
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public List<Ticket> getTickets(){
		return ticketList;
	}
	
	/**
<<<<<<< HEAD
	 * Gets tickets from ticket list of inputed ticket type.
=======
	 * returns the tickets in the list that have a given type
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public List<Ticket> getTicketsByType(TicketType type){
		
		List<Ticket> ticketsOfType = new ArrayList<Ticket>();
		
		for (Ticket ticket: ticketList) {
			
			if (ticket.getTicketType() == type) {
				
				ticketsOfType.add(ticket);
			}
			
		}
		
		return ticketsOfType;
	}
	
	/**
<<<<<<< HEAD
	 * Gets ticket by ID number.
=======
	 * Returns the ticket in the list with the given id
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public Ticket getTicketById(int id) {
		
		for (Ticket ticket: ticketList) {
		
			if (ticket.getTicketId() == id) {
				return ticket;
			}
		}
		
		return null;
	}
	
	/**
<<<<<<< HEAD
	 * Executed command given command and int.
=======
	 * Executes the given command
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void executeCommand(int i, Command command) {
		
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Deletes ticket from list using ID number.
=======
	 * Removes the ticket in the list with the given id
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void deleteTicketById(int id) {
		
		if ((id > 0)) {
			
			for (Ticket ticket: ticketList) {
				
				if (ticket.getTicketId() == id) {
					ticketList.remove(ticket);
				}
			}
			
		}
		
//		for (Ticket ticket: tickets) {
//			
//			if (ticket.getTicketId() == id) {
//				tickets.remove(ticket);
//			}
//		}
		
		//System.out.println(ticketList);
		
		
		
	}

}
