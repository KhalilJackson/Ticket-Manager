package model.ticket;
import java.util.*;
import java.util.ArrayList;

public class Ticket {

	public static final String TT_REQUEST;
	public static final String TT_INCIDENT;
	public static final String C_INQUIRY;
	public static final String C_SOFTWARE;
	public static final String C_HARDWARE;
	public static final String C_NETWORK;
	public static final String C_DATABASE;
	public static final String P_URGENT;
	public static final String P_HIGH;
	public static final String P_MEDIUM;
	public static final String P_LOW;
	public static final String NEW_NAME;
	public static final String WORKING_NAME;
	public static final String FEEDBACK_NAME;
	public static final String RESOLVED_NAME;
	public static final String CLOSED_NAME;
	public static final String CANCELED_NAME;
	
	private static int counter;
	private static int ticketid;
	private static String subject;
	private static String caller;
	private static String owner;
	private static ArrayList<String> notes;
	
	/**
	 * TO-DO
	 *
	 */
	static public void IncrementCounter() {
		counter++;
	}
	
	/**
	 * TO-DO
	 *
	 */
	static public void setCounter(int count) {
		counter = count;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public Ticket(int ticketid, String subject, String caller, String owner) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public Ticket(TicketType type, String subject, String caller, Category category, Priority priority, String owner) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getCaller() {
		return caller;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getCancellationCode() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getCategory() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getFeedbackCode() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getNotes() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getPriority() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getResolutionCode() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getState() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public int getTicketId() {
		return ticketid;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public TicketType getTicketType() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String getTicketTypeString() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setCaller(String caller) {
		this.caller = caller;
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setCancellationCode(String cc) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setCategory(String category) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setFeedbackCode(String feedback) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setPriority(String priority) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setResolutionCode(String resolution) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setState(String state) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * TO-DO
	 *
	 */
	private void setTicketType(String ticketType) {
		
	}
	
	/**
	 * TO-DO
	 *
	 */
	public String toString() {
		return null;
	}
	
	/**
	 * TO-DO
	 *
	 */
	public void update(Command command) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
