package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public class FeedbackState implements TicketState{
	
	/**
	 * Constructor that takes in no arguments.
	 *
	 */
	FeedbackState(){
		
	}
	
	/**
	 * Updates state.
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
	 * Return Feedback state name.
	 *
	 */
	public String getStateName() {
		return "Feedback";
	}

}
