package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public class ClosedState implements TicketState{
	
	/**
	 * Closed state constructor that takes in no arguments.
	 *
	 */
	ClosedState(){
		
	}
	
	/**
	 * Updates state.
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
	 * Returns closed state name.
	 *
	 */
	public String getStateName() {
		return "Closed";
	}
	
}
