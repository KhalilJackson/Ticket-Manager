package model.ticket;

public interface TicketState {
	
	public void updateState(Command);
	public String getStateName();
}
