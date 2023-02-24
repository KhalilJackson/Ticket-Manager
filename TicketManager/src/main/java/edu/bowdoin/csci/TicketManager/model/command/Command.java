package edu.bowdoin.csci.TicketManager.model.command;


public class Command {
	
	/**
	 * Enumeration class of cancellation code constants.
	 *
	 */
	public enum CancellationCode {

		DUPLICATE,
		INAPPROPRIATE;

	}
	
	/**
	 * Enumeration class of command value constants.
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
	 * Enumeration class of feedback code constants.
	 *
	 */
	public enum FeedbackCode {

		AWAITING_CALLER,
		AWAITING_CHANGE,
		AWAITING_PROVIDER;
	}
	
	/**
	 * Enumeration class of resolution code constants.
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
	
	private String ownerID;
	private String note;
	
	/**
	 * Constructor creates and instance of the Command class using CommandValue, ResolutionCode, FeedbackCode, 
	 * CancellationCode, and two Strings.
	 *
	 */
	public Command(CommandValue cm, String str, FeedbackCode fc, ResolutionCode rc, CancellationCode cc, String two) {
		
		
	}
	
	/**
	 * Gets the command and takes.
	 *
	 */
	public CommandValue getCommand() {
		
		return null;
		
	}
	
	/**
	 * Gets the owner ID.
	 *
	 */
	public String getOwnerId() {
		
		return null;
	}
	
	/**
	 * Gets resolution code.
	 *
	 */
	public ResolutionCode getResolutionCode() {
		
		return null;
	}
	
	/**
	 * Gets note.
	 *
	 */
	public String getNote() {
		
		return null;
	}
	
	/**
	 * Gets feedback code.
	 *
	 */
	public FeedbackCode getFeedbackCode() {
		
		return null;
	}
	
	/**
	 * Gets cancellation code.
	 *
	 */
	public CancellationCode getCancellationCode() {
		
		return null;
	}
	

}
