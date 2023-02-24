package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public interface TicketState {
	
	/**
	 * Updates state and gets state name.
	 *
	 */
	public void updateState(Command command);
	public String getStateName();
}
