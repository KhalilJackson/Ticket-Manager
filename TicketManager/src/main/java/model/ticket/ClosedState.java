package model.ticket;

public class ClosedState implements TicketState{
	
	ClosedState(){
		
	}
	
	public void updateState(Command) {
		
	}
	
	public String getStateName() {
		return "Closed";
	}
}
