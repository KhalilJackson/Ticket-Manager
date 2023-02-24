package edu.bowdoin.csci.TicketManager.model.ticket;


import edu.bowdoin.csci.TicketManager.model.command.Command;

public class CanceledState implements TicketState{
	
	/**
	 * Constructor of CanceledState class without parameters.
	 *
	 */
	CanceledState(){
		
	}
	
	/**
	 * Updates state.
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
	 * Gets the name of the state, which is canceled in this case.
	 *
	 */
	public String getStateName() {
		return "Canceled";
	}

}
