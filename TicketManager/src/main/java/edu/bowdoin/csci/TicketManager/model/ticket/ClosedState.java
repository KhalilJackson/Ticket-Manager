package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public class ClosedState implements TicketState{
	
	/**
	 * Constructor for the ClosedState class
	 *
	 */
	ClosedState(){
		
	}
	
	/**
	 * updates the state based on the given command
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
	 * returns the name of the state
	 *
	 */
	public String getStateName() {
		return "Closed";
	}
	
}
