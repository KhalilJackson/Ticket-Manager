package edu.bowdoin.csci.TicketManager.model.ticket;
import java.util.*;

import java.util.ArrayList;
import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.ResolutionCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.FeedbackCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;

public class Ticket {
	
	/**
	 * Enums class that sets constants for categories. Testing push ...
	 *
	 */
	public enum Category {

		INQUIRY,
		SOFTWARE,
		HARDWARE,
		NETWORK,
		DATABASE;
	}
	
	/**
	 * Enums class that sets constant for priority.
	 *
	 */
	public enum Priority {

		URGENT,
		HIGH,
		MEDIUM,
		LOW;
	}
	
	/**
	 * Enums class that sets constant for ticket type.
	 *
	 */
	public enum TicketType {

		REQUEST,
		INCIDENT;
	}

	public static final String TT_REQUEST = "Request";
	public static final String TT_INCIDENT = "Incident";
	public static final String C_INQUIRY = "Inquiry";
	public static final String C_SOFTWARE = "Software";
	public static final String C_HARDWARE = "Hardware";
	public static final String C_NETWORK = "Network";
	public static final String C_DATABASE = "Database";
	public static final String P_URGENT = "Urgent";
	public static final String P_HIGH = "High";
	public static final String P_MEDIUM = "Medium";
	public static final String P_LOW = "Low";
	public static final String NEW_NAME = "New";
	public static final String WORKING_NAME = "Working";
	public static final String FEEDBACK_NAME = "Feedback";
	public static final String RESOLVED_NAME = "Resolved";
	public static final String CLOSED_NAME = "Closed";
	public static final String CANCELED_NAME = "Canceled";
	
	private static int counter = 1;
	private int ticketId;
	private String subject;
	private String caller;
	private String owner;
	private ArrayList<String> notes;
	
	private ResolutionCode resolutionCode;
	private FeedbackCode feedbackCode;
	private CancellationCode cancellationCode;
	private Category category;
	private Priority priority;
	private TicketType ticketType;
	
	private TicketState state;
	private NewState newState = new NewState();
	private WorkingState workingState = new WorkingState();
	private ResolvedState resolvedState = new ResolvedState();
	private FeedbackState feedbackState = new FeedbackState();
	private ClosedState closedState = new ClosedState();
	private CanceledState canceledState = new CanceledState();
	
	
	/**
	 * Increments counter by one.
	 *
	 */
	static public void IncrementCounter() {
		counter++;
	}
	
	/**
	 * Sets counter to count.
	 *
	 */
	static public void setCounter(int ticketid) {
		
		if(ticketid < 1) {
			throw new IllegalArgumentException("Ticket id must be a value greater than 0.");
		}
		
		counter = ticketid;
	}
	
	/**
	 * Constructs ticket using ID, state, type, subject, caller, category, priority, owner, codes, and notes.
	 *
	 */
	public Ticket(int ticketid, String state, String type, String subject, String caller, String category, String priority, String owner, ArrayList<String> codes, ArrayList<String> notes) {
		
		setCounter(ticketid);
		this.ticketId = counter;
		this.setState(state);
		this.setTicketType(type);
		this.setSubject(subject);
		this.setCaller(caller);
		this.setCategory(category);
		this.setPriority(priority);
		this.setOwner(owner);
		
		if(codes == null) {
			this.resolutionCode = null;
			this.feedbackCode = null;
			this.cancellationCode = null;
		} else if(codes.size() == 3) {
			this.setResolutionCode(codes.get(0));
			this.setFeedbackCode(codes.get(1));
			this.setCancellationCode(codes.get(2));
		} else {
			throw new IllegalArgumentException("Bad Codes");
		}
		
		this.notes = notes;
		
		IncrementCounter();
	}
	
	/**
<<<<<<< HEAD
	 * Constructs ticket using ID, state, type, subject, caller, category, priority, and owner.
=======
	 * Constructs ticket using type, subject, caller, category, priority, and owner.
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public Ticket(TicketType type, String subject, String caller, Category category, Priority priority, String notes) {
		this.ticketId = counter;
		this.setState("New");
		
		if(type == null) {
			throw new IllegalArgumentException();
		}
		this.ticketType = type;
		
		this.setSubject(subject);
		this.setCaller(caller);
		this.category = category;
		this.priority = priority;
		this.setOwner("");
		
		if(notes == null) {
			throw new IllegalArgumentException();
		}
		
		ArrayList<String> arrayNotes = new ArrayList<String>();
		arrayNotes.add(notes);
		this.notes = arrayNotes;
		
		IncrementCounter();
	}
	
	/**
	 * Returns caller.
	 *
	 */
	public String getCaller() {
		return caller;
	}
	
	/**
	 * Returns cancellation code.
	 *
	 */
	public String getCancellationCode() {
		
		if(this.cancellationCode == null) {
			return null;
		}
		
		switch(this.cancellationCode) {
		    case DUPLICATE:
		    	return Command.CC_DUPLICATE;
		    	
		    case INAPPROPRIATE:
		    	return Command.CC_INAPPROPRIATE;
		    	
		    default:
		    	return null;
		}
	}
	
	/**
	 * Returns category.
	 *
	 */
	public String getCategory() {
		
		if(this.category == null) {
			return null;
		}
		
		switch(this.category) {
		   case INQUIRY:
			   return C_INQUIRY;
			   
		   case SOFTWARE:
			   return C_SOFTWARE;
			   
		   case HARDWARE:
			   return C_HARDWARE;
			   
		   case NETWORK:
			   return C_NETWORK;
			   
		   case DATABASE:
			   return C_DATABASE;
			   
		   default:
			   return null;
		}
	}
	
	/**
	 * Returns feedback code.
	 *
	 */
	public String getFeedbackCode() {
		
		if(this.feedbackCode == null) {
			return null;
		}
		
		switch(this.feedbackCode) {
		   case AWAITING_CALLER:
			   return Command.F_CALLER;
			   
		   case AWAITING_CHANGE:
			   return Command.F_CHANGE;
			   
		   case AWAITING_PROVIDER:
			   return Command.F_PROVIDER;
			   
		   default:
			   return null;
		}
	}

	/**
	 * Returns notes.
	 *
	 */
	public String getNotes() {
		String notesString = "";
		for(int i = 0; i < notes.size(); i++) {
			notesString = notesString + "-" + notes.get(i) + "\n";
		}
		return notesString;
	}
	
	/**
	 * Returns owner.
	 *
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Returns priority.
	 *
	 */
	public String getPriority() {
		
		if(this.priority == null) {
			return null;
		}
		
		switch(this.priority) {
		    case URGENT:
		    	return P_URGENT;
		    	
		    case HIGH:
		    	return P_HIGH;
		    	
		    case MEDIUM:
		    	return P_MEDIUM;
		    	
		    case LOW:
		    	return P_LOW;
		    	
		    default:
		    	return null;
		}
	}
	
	/**
	 * Returns resolution code.
	 *
	 */
	public String getResolutionCode() {
		
		if(this.resolutionCode == null) {
			return null;
		}
		
		switch(this.resolutionCode) {
		    case COMPLETED:
		    	return Command.RC_COMPLETED;
		    	
		    case NOT_COMPLETED:
		    	return Command.RC_NOT_COMPLETED;
		    	
		    case SOLVED:
		    	return Command.RC_SOLVED;
		    	
		    case NOT_SOLVED:
		    	return Command.RC_NOT_SOLVED;
		    	
		    case WORKAROUND:
		    	return Command.RC_WORKAROUND;
		    	
		    case CALLER_CLOSED:
		    	return Command.RC_CALLER_CLOSED;
		    	
		    default:
		    	return null;
		}
	}
	
	/**
	 * Returns state.
	 *
	 */
	public String getState() {
		return this.state.getStateName();
	}
	
	/**
	 * Returns subject.
	 *
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Returns ticket ID.
	 *
	 */
	public int getTicketId() {
		return ticketId;
	}
	
	/**
	 * Returns ticket type.
	 *
	 */
	public TicketType getTicketType() {
		return this.ticketType;
	}
	
	/**
	 * Return ticket type string.
	 *
	 */
	public String getTicketTypeString() {
		
		if(this.ticketType == null) {
			return null;
		}
		
		switch(this.ticketType) {
		
		    case REQUEST:
		    	return TT_REQUEST;
		    	
		    case INCIDENT:
		    	return TT_INCIDENT;
		    	
		    default:
		    	return null;
		}
	}
	
	/**
	 * Sets caller.
	 *
	 */
	private void setCaller(String caller) {
		
		if(caller == null || caller == "") {
			throw new IllegalArgumentException();
		}
		
		this.caller = caller;
	}
	
	/**
	 * Sets cancellation code.
	 *
	 */
	private void setCancellationCode(String cc) {
		
		//A cancellation code should either be "Duplicate" or "Inappropriate." 
		//Any other input will return an error
		switch(cc) {
		    case Command.CC_DUPLICATE:
		    	this.cancellationCode = CancellationCode.DUPLICATE;
		    	break;
		    	
		    case Command.CC_INAPPROPRIATE:
		    	this.cancellationCode = CancellationCode.INAPPROPRIATE;
		    	break;
		    	
		    default:
		    	throw new IllegalArgumentException("Bad Cancellation Code");
		}
	}
	
	/**
	 * Sets category.
	 *
	 */
	private void setCategory(String category) {
		switch(category) {
	        case C_INQUIRY:
	    	    this.category = Category.INQUIRY;
	    	    break;
	    	
	        case C_SOFTWARE:
	    	    this.category = Category.SOFTWARE;
	    	    break;
	    	
	        case C_HARDWARE:
	    	    this.category = Category.HARDWARE;
	    	    break;
	    
	        case C_NETWORK:
	    	    this.category = Category.NETWORK;
	    	    break;
	    
	        case C_DATABASE:
	    	    this.category = Category.DATABASE;
	    	    break;
	    	
	        default:
	    	    throw new IllegalArgumentException("Bad Category");
	    }
	}
	
	/**
	 * Sets owner.
	 *
	 */
	private void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * Sets feedback code.
	 *
	 */
	private void setFeedbackCode(String feedback) {
		switch(feedback) {
		    case Command.F_CALLER:
		    	this.feedbackCode = FeedbackCode.AWAITING_CALLER;
		    	break;
		    	
		    case Command.F_CHANGE:
		    	this.feedbackCode = FeedbackCode.AWAITING_CHANGE;
		    	break;
		    	
		    case Command.F_PROVIDER:
		    	this.feedbackCode = FeedbackCode.AWAITING_PROVIDER;
		    	break;
		    	
		    default:
		    	throw new IllegalArgumentException("Bad owner");
		    
		}
		
	}
	
	/**
	 * Sets priority.
	 *
	 */
	private void setPriority(String priority) {
		switch(priority) {
		    case P_URGENT:
		    	this.priority = Priority.URGENT;
		    	break;
		    	
		    case P_HIGH:
		    	this.priority = Priority.HIGH;
		    	break;
		    	
		    case P_MEDIUM:
		    	this.priority = Priority.MEDIUM;
		    	break;
		    	
		    case P_LOW:
		    	this.priority = Priority.LOW;
		    	break;
		    	
		    default:
		    	throw new IllegalArgumentException("Bad priority");
		}
	}
	
	/**
	 * Sets resolution code.
	 *
	 */
	private void setResolutionCode(String resolution) {
		
		switch(resolution) {
		    case Command.RC_COMPLETED:
		    	this.resolutionCode = ResolutionCode.COMPLETED;
		    	break;
		    	
		    case Command.RC_NOT_COMPLETED:
		    	this.resolutionCode = ResolutionCode.NOT_COMPLETED;
		    	break;
		    	
		    case Command.RC_SOLVED:
		    	this.resolutionCode = ResolutionCode.SOLVED;
		    	break;
		    	
		    case Command.RC_NOT_SOLVED:
		    	this.resolutionCode = ResolutionCode.NOT_SOLVED;
		    	break;
		    	
		    case Command.RC_WORKAROUND:
		    	this.resolutionCode = ResolutionCode.WORKAROUND;
		    	break;
		    	
		    case Command.RC_CALLER_CLOSED:
		    	this.resolutionCode = ResolutionCode.CALLER_CLOSED;
		    	break;
		    	
		    default:
		    	throw new IllegalArgumentException("Bad Resolution Code");
		}
	}
	
	/**
	 * Sets state.
	 *
	 */
	private void setState(String state) {
		switch(state) {
		    case NEW_NAME:
		    	this.state = this.newState;
		    	break;
		    	
		    case WORKING_NAME:
		    	this.state = this.workingState;
		    	break;
		    	
		    case FEEDBACK_NAME:
		    	this.state = this.feedbackState;
		    	break;
		    	
		    case RESOLVED_NAME:
		    	this.state = this.resolvedState;
		    	break;
		    	
		    case CLOSED_NAME:
		    	this.state = this.closedState;
		    	break;
		    	
		    case CANCELED_NAME:
		    	this.state = this.canceledState;
		    	break;
		    	
		    default:
		    	throw new IllegalArgumentException("Bad state");
		}
	}
	
	/**
	 * Sets subject.
	 *
	 */
	private void setSubject(String subject) {
		
		if(subject == null || subject == "") {
			throw new IllegalArgumentException();
		}
		
		this.subject = subject;
	}
	
	/**
	 * Sets ticket type.
	 *
	 */
	private void setTicketType(String ticketType) {
		switch(ticketType) {
		    case TT_REQUEST:
		    	this.ticketType = TicketType.REQUEST;
		    	break;
		    	
		    case TT_INCIDENT:
		    	this.ticketType = TicketType.INCIDENT;
		    	break;
		    	
		    default:
		    	throw new IllegalArgumentException("Bad ticket type");
		}
	}
	
	/**
	 * To string method.
	 *
	 */
	public String toString() {
		return "*" + String.valueOf(ticketId) + "#" + this.getState() + "#" + this.getTicketTypeString() + 
				"#" + this.getSubject() + "#" + this.getCaller() + "#" + this.getCategory() + "#" + 
				this.getPriority() + "#" + this.getOwner() + "#" + this.getResolutionCode();
	}
	
	/**
	 * Updates command.
	 *
	 */
	public void update(Command command) {
		this.state.updateState(command);
	}
	
	
	//Ticket state classes for FSM:

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
	
	public class NewState implements TicketState{
		
		/**
		 * Constructor for the NewState class
		 *
		 */
		NewState(){
			
		}
		
		/**
		 * updates the state based on the given command
		 *
		 */
		public void updateState(Command command) {
			
		}
		
		/**
		 * returns the name of the state
		 *
		 */
		public String getStateName() {
			return "New";
		}

	}
	
	public class WorkingState implements TicketState{
		
		/**
		 * Constructor for the WorkingState class
		 *
		 */
		WorkingState(){
			
		}
		
		/**
		 * updates the state based on the given command
		 *
		 */
		public void updateState(Command command) {
			
		}
		
		/**
		 * returns the name of the state
		 *
		 */
		public String getStateName() {
			return "Working";
		}

	}

	public class FeedbackState implements TicketState{
		
		/**
		 * Constructor for the FeedbackState class
		 *
		 */
		FeedbackState(){
			
		}
		
		/**
		 * updates the state based on the given command
		 *
		 */
		public void updateState(Command command) {
			
		}
		
		/**
		 * returns the name of the state
		 *
		 */
		public String getStateName() {
			return "Feedback";
		}

	}
	
	public class ResolvedState implements TicketState{

		/**
		 * Constructor for the ResolvedState class
		 *
		 */
		ResolvedState(){
			
		}
		
		/**
		 * updates the state based on the given command
		 *
		 */
		public void updateState(Command command) {
			
		}
		
		/**
		 * returns the name of the state
		 *
		 */
		public String getStateName() {
			return "Resolved";
		}

	}

	public class ClosedState implements TicketState{
		
		/**
		 * Constructor for the ClosedState class
		 *
		 */
		ClosedState(){
			
		}
		
		/**
		 * updates the state based on the given command
		 *
		 */
		public void updateState(Command command) {
			
		}
		
		/**
		 * returns the name of the state
		 *
		 */
		public String getStateName() {
			return "Closed";
		}
		
	}
	
	public class CanceledState implements TicketState{
		
		/**
		 * Constructor for the canceled state class
		 *
		 */
		CanceledState(){
			
		}
		
		/**
		 * changes the state based on the given command
		 *
		 */
		public void updateState(Command command) {
			
		}
		
		/**
		 * returns the name of the state
		 *
		 */
		public String getStateName() {
			return "Canceled";
		}

	}
	
}
