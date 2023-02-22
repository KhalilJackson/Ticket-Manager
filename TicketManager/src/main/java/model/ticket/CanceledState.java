package model.ticket;

public class CanceledState implements TicketState{
	
	CanceledState(){
		
	}
	
	public void updateState(Command) {
		
	}
	
	public String getStateName() {
		return "Canceled";
	}

}
