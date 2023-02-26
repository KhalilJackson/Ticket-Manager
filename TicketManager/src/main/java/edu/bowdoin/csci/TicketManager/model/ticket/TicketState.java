package edu.bowdoin.csci.TicketManager.model.ticket;

import edu.bowdoin.csci.TicketManager.model.command.Command;

public interface TicketState {
	
	/**
<<<<<<< HEAD
	 * Updates state and gets state name.
=======
	 * updates the state based on the given command
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void updateState(Command command);
	
	/**
	 * returns the name of the state
	 * @return
	 */
	public String getStateName();
}
