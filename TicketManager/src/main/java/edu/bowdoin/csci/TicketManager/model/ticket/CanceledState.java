package edu.bowdoin.csci.TicketManager.model.ticket;


import edu.bowdoin.csci.TicketManager.model.command.Command;

public class CanceledState implements TicketState{
	
	/**
	 * TO-DO
	 *
	 */
	CanceledState(){
		
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
		return "Canceled";
	}

}
