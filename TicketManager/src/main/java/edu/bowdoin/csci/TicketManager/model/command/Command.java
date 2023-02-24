package edu.bowdoin.csci.TicketManager.model.command;

public class Command {
	
	/**
	 * TO-DO
	 *
	 */
	public enum CancellationCode {

		DUPLICATE,
		INAPPROPRIATE;

	}
	
	/**
	 * TO-DO
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
	 * TO-DO
	 *
	 */
	public enum FeedbackCode {

		AWAITING_CALLER,
		AWAITING_CHANGE,
		AWAITING_PROVIDER;
	}
	
	/**
	 * TO-DO
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
	 * TO-DO
	 *
	 */
	public Command(CommandValue cm, String str, FeedbackCode fc, ResolutionCode rc, CancellationCode cc, String two) {
		
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public CommandValue getCommand() {
		
		return null;
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getOwnerId() {
		
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public ResolutionCode getResolutionCode() {
		
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getNote() {
		
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public FeedbackCode getFeedbackCode() {
		
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public CancellationCode getCancellationCode() {
		
		return null;
	}
	

}
