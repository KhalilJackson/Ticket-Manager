package edu.bowdoin.csci.TicketManager.model.command;


public class Command {
	
	/**
	 * Enumeration class of cancellation code constants
	 *
	 */
	public enum CancellationCode {

		DUPLICATE,
		INAPPROPRIATE;

	}
	
	/**
	 * Enumeration class of command value constants
	 *
	 */
	public enum CommandValue {
		PROCESS,
		FEEDBACK,
		RESOLVE,
		CONFIRM,
		REOPEN,
		CANCEL;
	}
	
	/**
	 * Enumeration class of feedback code constants
	 *
	 */
	public enum FeedbackCode {

		AWAITING_CALLER,
		AWAITING_CHANGE,
		AWAITING_PROVIDER;
	}
	
	/**
	 * Enumeration class of resolution code constants
	 *
	 */
	public enum ResolutionCode {

		COMPLETED,
		NOT_COMPLETED,
		SOLVED,
		WORKAROUND,
		NOT_SOLVED,
		CALLER_CLOSED;
	}
	
	public static final String F_CALLER = null;
	public static final String F_CHANGE = null;
	public static final String F_PROVIDER = null;
	
	public static final String RC_COMPLETED = null;
	public static final String RC_NOT_COMPLETED = null;
	public static final String RC_SOLVED = null;
	public static final String RC_NOT_SOLVED = null;
	public static final String RC_WORKAROUND = null;
	public static final String RC_CALLER_CLOSED = null;
	
	public static final String CC_DUPLICATE = null;
	public static final String CC_INNAPPROPRIATE = null;
	
	private String ownerId;
	private String note;
	
	private CancellationCode cancellationCode;
	private CommandValue c;
	private FeedbackCode feedbackCode;
	private ResolutionCode resolutionCode;
	
	
	/**
	 * Command class constructor
	 *
	 */
	public Command(CommandValue command, String owner, FeedbackCode feedback_code, ResolutionCode resolution_code, CancellationCode cancellation_code, String note) {
		
		//Check that command is not null before setting
		if(command == null) {
			throw new IllegalArgumentException();
		}
		this.c = command;
				
		//A PROCESS Command cannot have an empty or null ownerID
		if(command.equals(CommandValue.PROCESS) && (owner == null || owner.equals(""))) {
			throw new IllegalArgumentException();
		}
		this.ownerId = owner;
		
		//note cannot be empty or null if CommandValue is FEEDBACK, CONFIRM, or REOPEN
		if(note == "" || note == null) {
			switch(command) {
			case FEEDBACK:
				throw new IllegalArgumentException();
			
			case CONFIRM:
				throw new IllegalArgumentException();
				
			case REOPEN:
				throw new IllegalArgumentException();
			
			default:
				break;
				
			}
		}
		this.note = note;
		
		//A FEEDBACK Command cannot have a null feedbackCode
		if(command.equals(CommandValue.FEEDBACK) && feedback_code == null) {
			throw new IllegalArgumentException();
		}
		this.feedbackCode = feedback_code;
		
		//A RESOLVE command cannot have a null resolutionCode
		if(command.equals(CommandValue.RESOLVE) && resolution_code == null) {
			throw new IllegalArgumentException();
		}
		this.resolutionCode = resolution_code;
		
		this.cancellationCode = cancellation_code;
		
	}
	
	/**
	 * Gets the command value
	 *
	 */
	public CommandValue getCommand() {
		
		return this.c;
		
	}
	
	/**
	 * Gets the owner id
	 *
	 */
	public String getOwnerId() {
		
		return this.ownerId;
	}
	
	/**
	 * gets the resolution code
	 *
	 */
	public ResolutionCode getResolutionCode() {
		
		return this.resolutionCode;
	}
	
	/**
	 * Gets the ticket notes
	 *
	 */
	public String getNote() {
		
		return this.note;
	}
	
	/**
	 * Gets the feedback code
	 *
	 */
	public FeedbackCode getFeedbackCode() {
		
		return this.feedbackCode;
	}
	
	/**
	 * Gets the cancellation code
	 *
	 */
	public CancellationCode getCancellationCode() {
		
		return this.cancellationCode;
	}
	

}
