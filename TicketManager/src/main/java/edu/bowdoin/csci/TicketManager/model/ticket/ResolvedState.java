package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public class ResolvedState implements TicketState{

	/**
	 * Constructor that takes in no parameters.
	 *
	 */
	ResolvedState(){
		
	}
	
	/**
	 * Updates state.
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
	 * Returns Resolved state name.
	 *
	 */
	public String getStateName() {
		return "Resolved";
	}

}
