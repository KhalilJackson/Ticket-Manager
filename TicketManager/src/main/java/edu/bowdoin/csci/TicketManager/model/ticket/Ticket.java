package edu.bowdoin.csci.TicketManager.model.ticket;
import java.util.*;

import java.util.ArrayList;
import edu.bowdoin.csci.TicketManager.model.command.*;

public class Ticket {
	
	/**
	 * TO-DO
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
	 * TO-DO
	 *
	 */
	public enum Priority {

		URGENT,
		HIGH,
		MEDIUM,
		LOW;
	}
	
	/**
	 * TO-DO
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
	public Ticket(int ticketid, String state, String type, String subject, String caller, String category, String priority, String owner, ArrayList<String> codes, ArrayList<String> notes) {
		
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
