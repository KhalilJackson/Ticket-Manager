package model.command;

public class Command {
	
	public static final String F_CALLER;
	public static final String F_CHANGE;
	public static final String F_PROVIDER;
	
	public static final String RC_COMPLETED;
	public static final String RC_NOT_COMPLETED;
	public static final String RC_SOLVED;
	public static final String RC_NOT_SOLVED;
	public static final String RC_WORKAROUND;
	public static final String RC_CALLER_CLOSED;
	
	public static final String CC_DUPLICATE;
	public static final String CC_INNAPPROPRIATE;
	
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