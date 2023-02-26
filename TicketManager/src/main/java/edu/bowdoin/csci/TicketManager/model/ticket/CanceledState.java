package edu.bowdoin.csci.TicketManager.model.ticket;


import edu.bowdoin.csci.TicketManager.model.command.Command;

public class CanceledState implements TicketState{
	
	/**
<<<<<<< HEAD
	 * Constructor of CanceledState class without parameters.
=======
	 * Constructor for the canceled state class
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	CanceledState(){
		
	}
	
	/**
<<<<<<< HEAD
	 * Updates state.
=======
	 * changes the state based on the given command
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public void updateState(Command command) {
		
	}
	
	/**
<<<<<<< HEAD
	 * Gets the name of the state, which is canceled in this case.
=======
	 * returns the name of the state
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public String getStateName() {
		return "Canceled";
	}

}
