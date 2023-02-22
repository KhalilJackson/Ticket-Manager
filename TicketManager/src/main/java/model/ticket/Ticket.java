package model.ticket;
import java.util.*;

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
	
	static public void IncrementCounter() {
		counter++;
	}
	
	static public void setCounter(int count) {
		counter = count;
	}
	
	public Ticket(int ticketid, String subject, String caller, String owner) {
		
	}
	
	public Ticket(TicketType type, String subject, String caller, Category category, Priority priority, String owner) {
		
	}
	
	public String getCaller() {
		return caller;
	}
	
	public String getCancellationCode() {
		return null;
	}
	
	public String getCategory() {
		return null;
	}
	
	public String getFeedbackCode() {
		return null;
	}
	
	public String getNotes() {
		return null;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getPriority() {
		return null;
	}
	
	public String getResolutionCode() {
		return null;
	}
	
	public String getState() {
		return null;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public int getTicketId() {
		return ticketid;
	}
	
	public TicketType getTicketType() {
		return null;
	}
	
	public String getTicketTypeString() {
		return null;
	}
	
	private void setCaller(String caller) {
		this.caller = caller;
	}
	
	private void setCancellationCode(String cc) {
		
	}
	
	private void setCategory(String category) {
		
	}
	
	private void setOwner(String owner) {
		this.owner = owner;
	}
	
	private void setFeedbackCode(String feedback) {
		
	}
	
	private void setPriority(String priority) {
		
	}
	
	private void setResolutionCode(String resolution) {
		
	}
	
	private void setState(String state) {
		
	}
	
	private void setSubject(String subject) {
		this.subject = subject;
	}
	
	private void setTicketType(String ticketType) {
		
	}
	
	public String toString() {
		return null;
	}
	
	public void update(Command command) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
