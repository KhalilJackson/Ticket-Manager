package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public class NewState implements TicketState{
	
	/**
	 * Constructor that takes in no parameters.
	 *
	 */
	NewState(){
		
	}
	
	/**
	 * Updates state.
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
	 * Returns New state name.
	 *
	 */
	public String getStateName() {
		return "New";
	}

}
