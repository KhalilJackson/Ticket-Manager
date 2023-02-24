package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public interface TicketState {
	
	/**
	 * updates the state based on the given command
	 *
	 */
	public void updateState(Command command);
	
	/**
	 * returns the name of the state
	 * @return
	 */
	public String getStateName();
}
