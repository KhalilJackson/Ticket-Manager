package model.ticket;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.ResolutionCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.FeedbackCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;

/**
 * TicketTest
 *
 */
public class TicketTest {

	/**
	 * Sets up the tests by initializing the counter
	 * @throws Exception if there's a problem during setup.
	 */
	@BeforeEach
	public void setUp() throws Exception {
		//Reset the Ticket counter at the beginning of every test.
		Ticket.setCounter(1);
	}
	
	/**
	 * Tests Ticket construction
	 */
	@Test
	public void testTicketConstruction() {
		Ticket ticketA = null;
		Ticket ticketB = null;
		
		//Attempt to create Tickets.
		try {
			ticketA = new Ticket(TicketType.REQUEST, "Request", "sesmith5", Category.DATABASE, Priority.URGENT, "a note");
			ticketB = new Ticket(TicketType.INCIDENT, "Incident", "jdyoung2", Category.SOFTWARE, Priority.MEDIUM, "a note");
		} catch (Exception e) {
			//If the setUp() has a problem the test should Assertions.fail.
			Assertions.fail("TicketTest.setUp() - Creating Tickets for testing failed");
			System.out.println(e.getMessage());
		}
		
		String scenario = "TicketTest.testTicketConstruction() verifies that the internal state of the Ticket is correct after creating: \nticketA = new Ticket(TicketType, REQUEST, \"sesmith5\", Category.DATABASE, Priority.URGENT, \"Request\", \"a note\") \nticketB = new Ticket(TicketType.INCIDENT, \"jdyoung2\", Category.SOFTWARE, Priority.MEDIUM, \"Incident\", \"a note\")";
		try {
			//Tests with 1st incident
			Assertions.assertEquals(1, ticketA.getTicketId(), scenario + "Ticket.getTicketId() - ticketA - incorrect id. Make sure Ticket.setCounter() is working.");
			Assertions.assertEquals(Ticket.NEW_NAME, ticketA.getState(), scenario + "Ticket.getState() - ticketA - incorrect state");
			Assertions.assertEquals("Request", ticketA.getTicketTypeString(), scenario + "Ticket.getTicketType() - ticketA - incorrect ticket type string");
			Assertions.assertEquals("Request", ticketA.getSubject(), scenario + "Ticket.getSubject() - ticketA - incorrect subject");
			Assertions.assertEquals("sesmith5", ticketA.getCaller(), scenario + "Ticket.getCaller() - ticketA - incorrect caller");
			Assertions.assertEquals("Database", ticketA.getCategory(), scenario + "Ticket.getCategory() - ticketA - incorrect category");
			Assertions.assertEquals("Urgent", ticketA.getPriority(), scenario + "Ticket.getPriority() - ticketA - incorrect priority");
			Assertions.assertEquals("", ticketA.getOwner(), scenario + "Ticket.getOwner() - ticketA - incorrect owner");
			Assertions.assertNull(ticketA.getFeedbackCode(), scenario + "Ticket.getFeedbackCode() - ticketA - incorrect feedback code - should be null");
			Assertions.assertNull(ticketA.getResolutionCode(), scenario + "Ticket.getResolutionCode() - ticketA - incorrect resolution code - should be null");
			Assertions.assertNull(ticketA.getCancellationCode(), scenario + "Ticket.getCancellationCode() - ticketA - incorrect cancellation code - should be null");
			Assertions.assertEquals("-a note\n", ticketA.getNotes(), scenario + "Ticket.getNotes() - ticketA - incorrect notes contents");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + "TicketTest.testTicketConstruction() - unexpected exception thrown constructing ticketA");
		}
		try {
			//Tests with 2nd incident
			Assertions.assertEquals(2, ticketB.getTicketId(), scenario + "Ticket.getTicketId() - ticketB - incorrect id. Make sure Ticket.setCounter() is working.");
			Assertions.assertEquals(Ticket.NEW_NAME, ticketB.getState(), scenario + "Ticket.getState() - ticketB - incorrect state");
			Assertions.assertEquals("Incident", ticketB.getTicketTypeString(), scenario + "Ticket.getTicketType() - ticketA - incorrect ticket type string");
			Assertions.assertEquals("Incident", ticketB.getSubject(), scenario + "Ticket.getSubject() - ticketB - incorrect subject");
			Assertions.assertEquals("jdyoung2", ticketB.getCaller(), scenario + "Ticket.getCaller() - ticketB - incorrect caller");
			Assertions.assertEquals("Software", ticketB.getCategory(), scenario + "Ticket.getCategory() - ticketB - incorrect category");
			Assertions.assertEquals("Medium", ticketB.getPriority(), scenario + "Ticket.getPriority() - ticketB - incorrect priority");
			Assertions.assertEquals("", ticketB.getOwner(), scenario + "Ticket.getOwner() - ticketB - incorrect owner");
			Assertions.assertNull(ticketB.getFeedbackCode(), scenario + "Ticket.getFeedbackCode() - ticketB - incorrect feedback code - should be null");
			Assertions.assertNull(ticketB.getResolutionCode(), scenario + "Ticket.getResolutionCode() - ticketB - incorrect resolution code - should be null");
			Assertions.assertNull(ticketB.getCancellationCode(), scenario + "Ticket.getCancellationCode() - ticketB - incorrect cancellation code - should be null");
			Assertions.assertEquals("-a note\n", ticketB.getNotes(), scenario + "Ticket.getNotes() - ticketB - incorrect notes contents");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + "TicketTest.testTicketConstruction() - unexpected exception thrown when constructing ticketB");
		}
	}
	
	/**
	 * Tests Ticket invalid construction
	 */
	@Test
	public void testTicketInvalidConstruction() {
		
		//TicketType
		Ticket ticket = null;
		try {
			ticket = new Ticket(null, "subject", "caller", Category.DATABASE, Priority.URGENT, "note");
			Assertions.fail("new Ticket(null, \"subject\", \"caller\", Category.DATABASE, Priority.URGENT, \"note\") should throw an IllegalArgumentExcepiton, but it does not.");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(ticket, "new Ticket(null, \"subject\", \"caller\", Category.DATABASE, Priority.URGENT, \"note\") should not have been constructed when given an invalid parameter, but it was.");
		}
		
		//Subject
		ticket = null;
		try {
			ticket = new Ticket(TicketType.INCIDENT, null, "caller", Category.DATABASE, Priority.URGENT, "note");
			Assertions.fail("new Ticket(TicketType.INCIDENT, null, \"caller\", Category.DATABASE, Priority.URGENT, \"note\") should throw an IllegalArgumentExcepiton, but it does not.");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(ticket, "new Ticket(TicketType.INCIDENT, null, \"caller\", Category.DATABASE, Priority.URGENT, \"note\") should not have been constructed when given an invalid parameter, but it was.");
		}
		
		//Caller
		ticket = null;

		try {
			ticket = new Ticket(TicketType.INCIDENT, "subject", "", Category.DATABASE, Priority.URGENT, "note");
			Assertions.fail("new Ticket(TicketType.INCIDENT, \"subject\", \"\", Category.DATABASE, Priority.URGENT, \"note\") should throw an IllegalArgumentExcepiton, but it does not.");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(ticket, "new Ticket(TicketType.INCIDENT, \"subject\", \"\", Category.DATABASE, Priority.URGENT, \"note\") should not have been constructed when given an invalid parameter, but it was.");
		}
		
		
		//Note
		ticket = null;
		try {
			ticket = new Ticket(TicketType.INCIDENT, "subject", "caller", Category.DATABASE, Priority.URGENT, null);
			Assertions.fail("new Ticket(TicketType.INCIDENT, \"subject\", \"caller\", Category.DATABASE, Priority.URGENT, null) should throw an IllegalArgumentExcepiton, but it does not.");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(ticket, "new Ticket(TicketType.INCIDENT, \"subject\", \"caller\", Category.DATABASE, Priority.URGENT, \"note\") should not have been constructed when given an invalid parameter, but it was.");
		}
		
	}
	
	
	/**
	 * Test constructor
	 */
	@Test
	public void testStringTicketConstruction() {
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("a note");
		
		Ticket ticket = null;
		String scenario = null;
		try {
			ticket = new Ticket(1, "New", "Request", "Subject", "Caller", "Inquiry", "Urgent", "", null, notes);
			scenario = "new Ticket(\"New\", \"Request\", \"Subject\", \"Caller\", \"Inquiry\", \"Urgent\", null, notes)";
			Assertions.assertEquals(1, ticket.getTicketId(), scenario + "Ticket.getTicketId() - incorrect id. Make sure Ticket.setCounter() is working.");
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "Ticket.getState() - incorrect state");
			Assertions.assertEquals("Request", ticket.getTicketTypeString(), scenario + "Ticket.getTicketType() - incorrect ticket type string");
			Assertions.assertEquals("Subject", ticket.getSubject(), scenario + "Ticket.getSubject() - incorrect subject");
			Assertions.assertEquals("Caller", ticket.getCaller(), scenario + "Ticket.getCaller() - incorrect caller");
			Assertions.assertEquals("Inquiry", ticket.getCategory(), scenario + "Ticket.getCategory() - incorrect category");
			Assertions.assertEquals("Urgent", ticket.getPriority(), scenario + "Ticket.getPriority() - incorrect priority");
			Assertions.assertEquals("", ticket.getOwner(), scenario + "Ticket.getOwner() - incorrect owner");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "Ticket.getFeedbackCode() - incorrect feedback code - should be null");
			Assertions.assertNull(ticket.getResolutionCode(), scenario + "Ticket.getResolutionCode() - incorrect resolution code - should be null");
			Assertions.assertNull(ticket.getCancellationCode(), scenario + "Ticket.getCancellationCode() - incorrect cancellation code - should be null");
			Assertions.assertEquals("-a note\n", ticket.getNotes(), scenario + "Ticket.getNotes() - incorrect notes contents");
		} catch (IllegalArgumentException e) {
			Assertions.fail(scenario + " should be constructed.  Instead an IllegalArgumentException was thrown. " + e.getMessage());
		}
		
		
	}
	
	/**
	 * Test setting counter
	 */
	@Test
	public void testSetCounter() {
		try {
			Ticket.setCounter(0);
			Assertions.fail("TicketTest - Ticket.setCount(0) should throw an IllegalArgumentException, but it did not.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals("Ticket id must be a value greater than 0.", e.getMessage());
		}
	}
	
	/**
	 * Ensures that update() method works properly
	 */
	//@Test
	//public void testUpdate() {
	//	try {
	//		Ticket ticket = new Ticket(TicketType.REQUEST, "Request", "sesmith5", Category.DATABASE, Priority.URGENT, "a note");
	//		Command command = new Command(CommandValue.CANCEL, "sesmith5", null, null, null, null);
	//		ticket.update(command);
	//		Assertions.assertEquals(ticket.getState(), )
	//	}
	//}

}
