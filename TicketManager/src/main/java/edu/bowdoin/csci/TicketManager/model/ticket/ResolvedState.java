package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public class ResolvedState implements TicketState{

	/**
	 * Constructor for the ResolvedState class
	 *
	 */
	ResolvedState(){
		
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
		return "Resolved";
	}

}
