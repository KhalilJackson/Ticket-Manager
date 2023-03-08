package model.ticket;

import java.util.*;

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
	 * Test setting category.
	 */
	@Test
	public void testSetCategory() {
		
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("a note");		
		
		Ticket ticket = null;
		String scenario = null;

		//Inquiry category
		try {
			ticket = new Ticket(1, "New", "Request", "Subject", "Caller", "Inquiry", "Urgent", "", null, notes);
			Assertions.assertEquals("Inquiry", ticket.getCategory(), scenario + "Ticket.getCategory() - incorrect category");
		} catch (IllegalArgumentException e) {
			
		}
		
		
		//Software category
		try {
			ticket = new Ticket(1, "New", "Request", "Subject", "Caller", "Software", "Urgent", "", null, notes);
			Assertions.assertEquals("Software", ticket.getCategory(), scenario + "Ticket.getCategory() - incorrect category");
			
		} catch (IllegalArgumentException e) {
			
		}
		
		//Hardware category
		try {
			ticket = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Urgent", "", null, notes);
			Assertions.assertEquals("Hardware", ticket.getCategory(), scenario + "Ticket.getCategory() - incorrect category");
			
		} catch (IllegalArgumentException e) {
			
		}
		
		//Network category
		try {
			ticket = new Ticket(1, "New", "Request", "Subject", "Caller", "Network", "Urgent", "", null, notes);
			Assertions.assertEquals("Network", ticket.getCategory(), scenario + "Ticket.getCategory() - incorrect category");
			
		} catch (IllegalArgumentException e) {
			
		}
		
		//Database category
		try {
			ticket = new Ticket(1, "New", "Request", "Subject", "Caller", "Database", "Urgent", "", null, notes);
			Assertions.assertEquals("Database", ticket.getCategory(), scenario + "Ticket.getCategory() - incorrect category");

		} catch (IllegalArgumentException e) {
			
		}
		
		//Bad inquiry category
		try { 
			ticket = new Ticket(1, "New", "Request", "Subject", "Caller", "Olive Green", "Urgent", "", null, notes);
			Assertions.fail("Olive Green not a valid category.");
		} catch (IllegalArgumentException e) {
			
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
	 * Tests ticket.setCancellationCode() method
	 */
	@Test
	public void testSetCancellationCode() {
		
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("a note");
		
		try {
			Ticket ticketDuplicate = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", Command.CC_DUPLICATE, notes);
			Ticket ticketInappropriate = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", Command.CC_INAPPROPRIATE, notes);
			Ticket ticketNull = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", null, notes);
			
			Assertions.assertEquals(Command.CC_DUPLICATE, ticketDuplicate.getCancellationCode(), "testSetCancellationCode() - tried to make cancellation code \"Duplicate\", but failed.");
			Assertions.assertEquals(Command.CC_INAPPROPRIATE, ticketInappropriate.getCancellationCode(), "testSetCancellationCode() - tried to make cancellation code \"Inappropriate\", but failed.");
			Assertions.assertNull(ticketNull.getCancellationCode(), "testSetCancellationCode() - tried to make cancellation code null, but failed.");
		} catch(IllegalArgumentException e) {
			Assertions.fail("testSetCancellationCode() - an unexpected IllegalArgumentException was thrown.");
		}	
	}
	
	/**
	 * Tests that ticket.setCancellationCode() throws an error on invalid input
	 */
//	@Test
//	public void testSetCancellationCodeInvalid() {
//		
//		ArrayList<String> codesEmpty = new ArrayList<String>();
//		codesEmpty.add(null);
//		codesEmpty.add(null);
//		codesEmpty.add("");
//		
//		ArrayList<String> codesLowerCase = new ArrayList<String>();
//		codesLowerCase.add(null);
//		codesLowerCase.add(null);
//		codesLowerCase.add("duplicate");
//		
//		try {
//			Ticket ticketEmpty = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", "", null);
//			
//			Assertions.fail("testSetCancellationCodeInvalid() - tried to make cancellation code \"\". An IllegalArgumentException should have been thrown, but was not.");
//		} catch(IllegalArgumentException e) {
//			
//		}	
//		
//		try {
//			Ticket ticketLowerCase = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", "duplicate", null);
//			
//			Assertions.fail("testSetCancellationCodeInvalid() - tried to make cancellation code \"duplicate\". An IllegalArgumentException should have been thrown, but was not.");
//		} catch(IllegalArgumentException e) {
//			
//		}
//	}
	
	/**
	 * Tests the Ticket.setFeedbackCode() method
	 */
	@Test
	public void testSetFeedbackCode() {
		
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("a note");
		
		try {
			Ticket ticketCaller = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", Command.F_CALLER, notes);
			Ticket ticketChange = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", Command.F_CHANGE, notes);
			Ticket ticketProvider = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", Command.F_PROVIDER, notes);
			Ticket ticketNull = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", null, notes);
			
			Assertions.assertEquals(Command.F_CALLER, ticketCaller.getFeedbackCode(), "testSetFeedbackCode() - tried to make feedback code \"Awaiting Caller\", but failed.");
			Assertions.assertEquals(Command.F_CHANGE, ticketChange.getFeedbackCode(), "testSetFeedbackCode() - tried to make feedback code \"Awaiting Change\", but failed.");
			Assertions.assertEquals(Command.F_PROVIDER, ticketProvider.getFeedbackCode(), "testSetFeedbackCode() - tried to make feedback code \"Awaiting Provider\", but failed.");
			Assertions.assertNull(ticketNull.getFeedbackCode(), "testSetFeedbackCode() - tried to make feedback code null, but failed.");
		} catch(IllegalArgumentException e) {
			Assertions.fail("testSetFeedbackCode() - an unexpected IllegalArgumentException was thrown.");
		}	
	}
	

	
	/**
	 * Tests the Ticket.setPriority() method.
	 */
	@Test
	public void testSetPriority() {
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("a note");
		
		try {
			Ticket ticketUrgent = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, notes);
			Ticket ticketHigh = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "High", "owner", null, notes);
			Ticket ticketMedium = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", null, notes);
			Ticket ticketLow = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Low", "owner", null, notes);
			
			Assertions.assertEquals(Ticket.P_URGENT, ticketUrgent.getPriority(), "testSetPriority() - tried to make priority \"Urgent\", but failed.");
			Assertions.assertEquals(Ticket.P_HIGH, ticketHigh.getPriority(), "testSetPriority() - tried to make priority \"High\", but failed.");
			Assertions.assertEquals(Ticket.P_MEDIUM, ticketMedium.getPriority(), "testSetPriority() - tried to make priority \"Medium\", but failed.");
			Assertions.assertEquals(Ticket.P_LOW, ticketLow.getPriority(), "testSetPriority() - tried to make priority \"Low\", but failed.");
		} catch(IllegalArgumentException e) {
			Assertions.fail("testSetPriority() - an unexpected IllegalArgumentException was thrown.");
		}	
	}
	
	/**
	 * Tests that the Ticket.setPriority() method throws an error on invalid input.
	 */
	@Test
	public void testSetPriorityInvalid() {
		try {
			Ticket ticketEmpty = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "", "owner", null, null);
			
			Assertions.fail("testSetPriority() - tried to make priority \"\". Should have thrown an IllegalArgumentException, but didn't.");
		} catch(IllegalArgumentException e) {
			
		}	
		
		try {
			Ticket ticketLowerCase = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "high", "owner", null, null);
			
			Assertions.fail("testSetPriority() - tried to make priority \"high\". Should have thrown an IllegalArgumentException, but didn't.");
		} catch(IllegalArgumentException e) {
			
		}	
		
		try {
			Ticket ticketNull = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", null, "owner", null, null);
			
			Assertions.fail("testSetPriority() - tried to make priority null. Should have thrown an IllegalArgumentException, but didn't.");
		} catch(IllegalArgumentException e) {
			
		}	
	}
	
	/**
	 * Tests the ticket.setResolutionCode() method.
	 */
	@Test
	public void testSetResolutionCode() {
		
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("a note");
		
		try {
			Ticket ticketCompleted = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", Command.RC_COMPLETED, notes);
			Ticket ticketNotCompleted = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", Command.RC_NOT_COMPLETED, notes);
			Ticket ticketSolved = new Ticket(1, "New", "Incident", "Subject", "Caller", "Hardware", "Urgent", "owner", Command.RC_SOLVED, notes);
			Ticket ticketNotSolved = new Ticket(1, "New", "Incident", "Subject", "Caller", "Hardware", "Urgent", "owner", Command.RC_NOT_SOLVED, notes);
			Ticket ticketWorkaround = new Ticket(1, "New", "Incident", "Subject", "Caller", "Hardware", "Urgent", "owner", Command.RC_WORKAROUND, notes);
			Ticket ticketCallerClosed = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", Command.RC_CALLER_CLOSED, notes);
			Ticket ticketNull = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, notes);
			
			Assertions.assertEquals(Command.RC_COMPLETED, ticketCompleted.getResolutionCode(), "testSetResolutionCode() - tried to make resolution code \"Completed\", but failed.");
			Assertions.assertEquals(Command.RC_NOT_COMPLETED, ticketNotCompleted.getResolutionCode(), "testSetResolutionCode() - tried to make resolution code \"Not Completed\", but failed.");
			Assertions.assertEquals(Command.RC_SOLVED, ticketSolved.getResolutionCode(), "testSetResolutionCode() - tried to make resolution code \"Solved\", but failed.");
			Assertions.assertEquals(Command.RC_NOT_SOLVED, ticketNotSolved.getResolutionCode(), "testSetResolutionCode() - tried to make resolution code \"Not Solved\", but failed.");
			Assertions.assertEquals(Command.RC_WORKAROUND, ticketWorkaround.getResolutionCode(), "testSetResolutionCode() - tried to make resolution code \"Workaround\", but failed.");
			Assertions.assertEquals(Command.RC_CALLER_CLOSED, ticketCallerClosed.getResolutionCode(), "testSetResolutionCode() - tried to make resolution code \"Caller Closed\", but failed.");
			Assertions.assertNull(ticketNull.getResolutionCode(), "testSetResolutionCode() - tried to make resolution code null, but failed.");
		} catch(IllegalArgumentException e) {
			Assertions.fail("testSetResolutionCode() - an unexpected IllegalArgumentException was thrown.");
		}
	}
	
	/**
	 * Tests that the Ticket.setResolutionCode() method throws an error on invalid input.
	 */
	//@Test
	//public void testSetResolutionCodeInvalid() {
	//	
	//	try {
	//		Ticket ticketEmpty = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", "", null);
	//		
	//		Assertions.fail("testSetResolutionCodeInvalid() - tried to make resolution code \"\". An IllegalArgumentException should have been thrown, but was not.");
	//	} catch(IllegalArgumentException e) {
	//		
	//	}	
	//	
	//	try {
	//		Ticket ticketLowerCase = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", "completed", null);
	//		
	//		Assertions.fail("testSetResolutionCodeInvalid() - tried to make resolution code \"completed\". An IllegalArgumentException should have been thrown, but was not.");
	//	} catch(IllegalArgumentException e) {
	//		
	//	}
	//}
	
	/**
	 * Tests the Ticket.setState() method.
	 */
	@Test
	public void testSetState() {
		
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("a note");
		
		try {
			Ticket ticketNew = new Ticket(1, Ticket.NEW_NAME, "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, notes);
			Ticket ticketWorking = new Ticket(1, Ticket.WORKING_NAME, "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, notes);
			Ticket ticketFeedback = new Ticket(1, Ticket.FEEDBACK_NAME, "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, notes);
			Ticket ticketResolved = new Ticket(1, Ticket.RESOLVED_NAME, "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, notes);
			Ticket ticketCanceled = new Ticket(1, Ticket.CANCELED_NAME, "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, notes);
			Ticket ticketClosed = new Ticket(1, Ticket.CLOSED_NAME, "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, notes);
			
			Assertions.assertEquals(Ticket.NEW_NAME, ticketNew.getState(), "testSetState() - tried to make State \"New\", but failed.");
			Assertions.assertEquals(Ticket.WORKING_NAME, ticketWorking.getState(), "testSetState() - tried to make State \"Working\", but failed.");
			Assertions.assertEquals(Ticket.FEEDBACK_NAME, ticketFeedback.getState(), "testSetState() - tried to make State \"Feedback\", but failed.");
			Assertions.assertEquals(Ticket.RESOLVED_NAME, ticketResolved.getState(), "testSetState() - tried to make State \"Resolved\", but failed.");
			Assertions.assertEquals(Ticket.CANCELED_NAME, ticketCanceled.getState(), "testSetState() - tried to make State \"Canceled\", but failed.");
			Assertions.assertEquals(Ticket.CLOSED_NAME, ticketClosed.getState(), "testSetState() - tried to make State \"Closed\", but failed.");
		} catch(IllegalArgumentException e) {
			Assertions.fail("testSetState() - an unexpected IllegalArgumentException was thrown.");
		}	
	}
	
	/**
	 * Tests that the Ticket.getState() method throws an error on invalid input.
	 */
	@Test
	public void testSetStateInvalid() {
		try {
			Ticket ticketEmpty = new Ticket(1, "", "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, null);
			
			Assertions.fail("testSetStateInvalid() - tried to make  \"\". Should have thrown an IllegalArgumentException, but didn't.");
			
		} catch(IllegalArgumentException e) {
			
		}
		
		try {
			Ticket ticketLowerCase = new Ticket(1, "new", "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, null);
			
			Assertions.fail("testSetStateInvalid() - tried to make state \"new\". Should have thrown an IllegalArgumentException, but didn't.");
			
		} catch(IllegalArgumentException e) {
			
		}
		
		try {
			Ticket ticketNull = new Ticket(1, null, "Request", "Subject", "Caller", "Hardware", "Urgent", "owner", null, null);
			
			Assertions.fail("testSetStateInvalid() - tried to make state null. Should have thrown an IllegalArgumentException, but didn't.");
			
		} catch(IllegalArgumentException e) {
			
		}
	}
	
	/**
	 * Tests the Ticket.toString() method. 
	 */
	@Test
	public void testToString() {
		
		try {
			ArrayList<String> notes = new ArrayList<String>();
			notes.add("a note");
			
			Ticket ticket = new Ticket(1, "New", "Request", "Subject", "Caller", "Hardware", "Medium", "owner", null, notes);
			String expectedTicket = "*1#New#Request#Subject#Caller#Hardware#Medium#owner#\n-a note\n";
			System.out.println(ticket.toString());
			System.out.println(expectedTicket);
			Assertions.assertEquals(ticket.toString(), expectedTicket, "TicketTest.testToString() - Requested ticket string was not formatted properly.");
			
		} catch(IllegalArgumentException e) {
			Assertions.fail("An unexpected IllegalArgumentException was thrown.");
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
