package edu.bowdoin.csci.TicketManager.model.ticket;
import java.util.*;

import java.util.ArrayList;
import edu.bowdoin.csci.TicketManager.model.command.*;

public class Ticket {
	
	/**
	 * Enums class that sets constants for categories.
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

	public static final String TT_REQUEST = null;
	public static final String TT_INCIDENT = null;
	public static final String C_INQUIRY = null;
	public static final String C_SOFTWARE = null;
	public static final String C_HARDWARE = null;
	public static final String C_NETWORK = null;
	public static final String C_DATABASE = null;
	public static final String P_URGENT = null;
	public static final String P_HIGH = null;
	public static final String P_MEDIUM = null;
	public static final String P_LOW = null;
	public static final String NEW_NAME = null;
	public static final String WORKING_NAME = null;
	public static final String FEEDBACK_NAME = null;
	public static final String RESOLVED_NAME = null;
	public static final String CLOSED_NAME = null;
	public static final String CANCELED_NAME = null;
	
	private static int counter;
	private static int ticketid;
	private static String subject;
	private static String caller;
	private static String owner;
	private static ArrayList<String> notes;
	
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
		
	}
	
	/**
	 * Constructs ticket using ID, state, type, subject, caller, category, priority, and owner.
	 *
	 */
	public Ticket(TicketType type, String subject, String caller, Category category, Priority priority, String owner) {
		
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
		return null;
	}
	
	/**
	 * Returns category.
	 *
	 */
	public String getCategory() {
		return null;
	}
	
	/**
	 * Returns feedback code.
	 *
	 */
	public String getFeedbackCode() {
		return null;
	}
	
	/**
	 * Returns notes.
	 *
	 */
	public String getNotes() {
		return null;
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
		return null;
	}
	
	/**
	 * Returns resolution code.
	 *
	 */
	public String getResolutionCode() {
		return null;
	}
	
	/**
	 * Returns state.
	 *
	 */
	public String getState() {
		return null;
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
		return ticketid;
	}
	
	/**
	 * Returns ticket type.
	 *
	 */
	public TicketType getTicketType() {
		return null;
	}
	
	/**
	 * Return ticket type string.
	 *
	 */
	public String getTicketTypeString() {
		return null;
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
		
	}
	
	/**
	 * Sets category.
	 *
	 */
	private void setCategory(String category) {
		
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
		
	}
	
	/**
	 * Sets priority.
	 *
	 */
	private void setPriority(String priority) {
		
	}
	
	/**
	 * Sets resolution code.
	 *
	 */
	private void setResolutionCode(String resolution) {
		
	}
	
	/**
	 * Sets state.
	 *
	 */
	private void setState(String state) {
		
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
		
	}
	
	/**
	 * To string method.
	 *
	 */
	public String toString() {
		return null;
	}
	
	/**
	 * Updates command.
	 *
	 */
	public void update(Command command) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
