package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public interface TicketState {
	
	/**
	 * TO-DO
	 *
	 */
	public void updateState(Command command);
	public String getStateName();
}
