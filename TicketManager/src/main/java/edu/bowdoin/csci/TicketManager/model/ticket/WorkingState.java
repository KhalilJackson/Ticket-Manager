package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public class WorkingState implements TicketState{
	
	/**
	 * Constructor that has no parameters.
	 *
	 */
	WorkingState(){
		
	}
	
	/**
	 * Updates state.
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
	 * Gets state name.
	 *
	 */
	public String getStateName() {
		return "Working";
	}

}
