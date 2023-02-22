package model.ticket;

public interface TicketState {
	
	/**
	 * TO-DO
	 *
	 */
	public void updateState(Command);
	public String getStateName();
}
