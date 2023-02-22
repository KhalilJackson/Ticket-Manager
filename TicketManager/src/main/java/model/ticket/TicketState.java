package model.ticket;
import model.command.*;

public interface TicketState {
	
	/**
	 * TO-DO
	 *
	 */
	public void updateState(Command);
	public String getStateName();
}
