package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public class ClosedState implements TicketState{
	
	/**
	 * TO-DO
	 *
	 */
	ClosedState(){
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getStateName() {
		return "Closed";
	}
	
}
