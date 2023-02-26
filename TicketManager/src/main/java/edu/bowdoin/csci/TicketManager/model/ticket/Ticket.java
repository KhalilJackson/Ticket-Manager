package edu.bowdoin.csci.TicketManager.model.ticket;
import java.util.*;

import java.util.ArrayList;
import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.ResolutionCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.FeedbackCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;

import edu.bowdoin.csci.TicketManager.model.ticket.NewState;
import edu.bowdoin.csci.TicketManager.model.ticket.WorkingState;
import edu.bowdoin.csci.TicketManager.model.ticket.ResolvedState;
import edu.bowdoin.csci.TicketManager.model.ticket.FeedbackState;
import edu.bowdoin.csci.TicketManager.model.ticket.ClosedState;
import edu.bowdoin.csci.TicketManager.model.ticket.CanceledState;

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
	
	private static int counter;
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
	private NewState newState;
	private WorkingState workingState;
	private ResolvedState resolvedState;
	private FeedbackState feedbackState;
	private ClosedState closedState;
	private CanceledState canceledState;
	
	
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
	static public void setCounter(int count) {
		counter = count;
	}
	
	/**
	 * Constructs ticket using ID, state, type, subject, caller, category, priority, owner, codes, and notes.
	 *
	 */
	public Ticket(int ticketid, String state, String type, String subject, String caller, String category, String priority, String owner, ArrayList<String> codes, ArrayList<String> notes) {
		
		this.ticketId = ticketid;
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
			throw new IllegalArgumentException();
		}
		
		this.notes = notes;
	}
	
	/**
<<<<<<< HEAD
	 * Constructs ticket using ID, state, type, subject, caller, category, priority, and owner.
=======
	 * Constructs ticket using type, subject, caller, category, priority, and owner.
>>>>>>> branch 'main' of https://github.com/bowdoin-csci2335-spring2023/project1-07.git
	 *
	 */
	public Ticket(TicketType type, String subject, String caller, Category category, Priority priority, String owner) {
		this.ticketId = 1;
		this.setState("New");
		this.ticketType = type;
		this.setSubject(subject);
		this.setCaller(caller);
		this.category = category;
		this.priority = priority;
		this.setOwner(owner);
		this.notes = null;
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
			notesString = "-" + notes.get(i) + "\n";
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
		    	
		    case Command.CC_INAPPROPRIATE:
		    	this.cancellationCode = CancellationCode.INAPPROPRIATE;
		    	
		    default:
		    	throw new IllegalArgumentException();
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
	    	
	        case C_SOFTWARE:
	    	    this.category = Category.SOFTWARE;
	    	
	        case C_HARDWARE:
	    	    this.category = Category.HARDWARE;
	    
	        case C_NETWORK:
	    	    this.category = Category.NETWORK;
	    
	        case C_DATABASE:
	    	    this.category = Category.DATABASE;
	    	
	        default:
	    	    throw new IllegalArgumentException();
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
		    	
		    case Command.F_CHANGE:
		    	this.feedbackCode = FeedbackCode.AWAITING_CHANGE;
		    	
		    case Command.F_PROVIDER:
		    	this.feedbackCode = FeedbackCode.AWAITING_PROVIDER;
		    	
		    default:
		    	throw new IllegalArgumentException();
		    
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
		    	
		    case P_HIGH:
		    	this.priority = Priority.HIGH;
		    	
		    case P_MEDIUM:
		    	this.priority = Priority.MEDIUM;
		    	
		    case P_LOW:
		    	this.priority = Priority.LOW;
		    	
		    default:
		    	throw new IllegalArgumentException();
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
		    	
		    case Command.RC_NOT_COMPLETED:
		    	this.resolutionCode = ResolutionCode.NOT_COMPLETED;
		    	
		    case Command.RC_SOLVED:
		    	this.resolutionCode = ResolutionCode.SOLVED;
		    	
		    case Command.RC_NOT_SOLVED:
		    	this.resolutionCode = ResolutionCode.NOT_SOLVED;
		    	
		    case Command.RC_WORKAROUND:
		    	this.resolutionCode = ResolutionCode.WORKAROUND;
		    	
		    case Command.RC_CALLER_CLOSED:
		    	this.resolutionCode = ResolutionCode.CALLER_CLOSED;
		    	
		    default:
		    	throw new IllegalArgumentException();
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
		    	
		    case WORKING_NAME:
		    	this.state = this.workingState;
		    	
		    case FEEDBACK_NAME:
		    	this.state = this.feedbackState;
		    	
		    case RESOLVED_NAME:
		    	this.state = this.resolvedState;
		    	
		    case CLOSED_NAME:
		    	this.state = this.closedState;
		    	
		    case CANCELED_NAME:
		    	this.state = this.canceledState;
		    	
		    default:
		    	throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Sets subject.
	 *
	 */
	private void setSubject(String subject) {
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
		    	
		    case TT_INCIDENT:
		    	this.ticketType = TicketType.INCIDENT;
		    	
		    default:
		    	throw new IllegalArgumentException();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
