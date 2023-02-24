package model.ticket;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.command.Command.ResolutionCode;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;

/**
 * Reopened state test
 *
 */
public class TicketCanceledStateTest {
	
	private Ticket ticket;

	/**
	 * Sets up the tests by creating two Tickets.
	 * @throws Exception if there's a problem during setup.
	 */
	@BeforeEach
	public void setUp() throws Exception {
		//Reset the Ticket counter at the beginning of every test.
		Ticket.setCounter(1);
		//Attempt to create Ticket.
		try {
			ticket = new Ticket(TicketType.REQUEST, "Test ticket 1", "sesmith5", Category.DATABASE, Priority.URGENT, "a note");
		} catch (Exception e) {
			//If the setUp() has a problem the test should Assertions.fail.
			Assertions.fail("TicketCanceledStateTest.setUp() - Creating Ticket for testing failed");
		}
	}
	
	/**
	 * Tests invalid transitions out of the Cancel state.
	 */
	@Test
	public void testInvalidTransitionsFromCancelProcess() {
		String scenario = "Checking invalid transitions from the Cancel State - PROCESS command. ";
		
		try {
			//Get to cancel
			Command c1 = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, "note 1");
			ticket.update(c1);
			
			Command c = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c);
			Assertions.fail(scenario + "invalid command should throw an UnsupportedOperationException, but did not.");
		} catch (UnsupportedOperationException e) {
			Assertions.assertEquals(1, ticket.getTicketId(), scenario + "Ticket.getTicketId() - ticket after invalid command - incorrect id. ");
			Assertions.assertEquals(Ticket.CANCELED_NAME, ticket.getState(), scenario + "Ticket.getState() - ticket after invalid command - incorrect state");
			Assertions.assertEquals("sesmith5", ticket.getCaller(), scenario + "Ticket.getCaller() - ticket after invalid command - incorrect caller");
			Assertions.assertEquals("Database", ticket.getCategory(), scenario + "Ticket.getCategoryString() - ticket after invalid command - incorrect category");
			Assertions.assertEquals("Urgent", ticket.getPriority(), scenario + "Ticket.getPriorityString() - ticket after invalid command - incorrect priority");
			Assertions.assertEquals("Test ticket 1", ticket.getSubject(), scenario + "Ticket.getName() - ticket after invalid command - incorrect name");
			Assertions.assertEquals("", ticket.getOwner(), scenario + "Ticket.getOwner() - ticket after invalid command - incorrect owner");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "Ticket.getOnHoldReason() - ticket after invalid  command - incorrect on hold reason - should be null");
			Assertions.assertNull(ticket.getResolutionCode(), scenario + "Ticket.getResolutionCode() - ticket after invalid command - incorrect resolution code - should be null");
			Assertions.assertEquals("Duplicate", ticket.getCancellationCode(), scenario + "Ticket.getCancellationCode() - ticket after invalid command - incorrect cancellation code");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "Ticket.getNotes() - ticket after invalid command - incorrect notes");
		}
	}
	
	
	/**
	 * Tests invalid transitions out of the Cancel state.
	 */
	@Test
	public void testInvalidTransitionsFromCancelResolve() {
		String scenario = "Checking invalid transitions from the Cancel State - RESOLVE command. ";
		
		try {
			//Get to cancel
			Command c1 = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, "note 1");
			ticket.update(c1);
			
			Command c = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.CALLER_CLOSED, null, "note 1");
			ticket.update(c);
			Assertions.fail(scenario + "invalid command should throw an UnsupportedOperationException, but did not.");
		} catch (UnsupportedOperationException e) {
			Assertions.assertEquals(1, ticket.getTicketId(), scenario + "Ticket.getTicketId() - ticket after invalid command - incorrect id. ");
			Assertions.assertEquals(Ticket.CANCELED_NAME, ticket.getState(), scenario + "Ticket.getState() - ticket after invalid command - incorrect state");
			Assertions.assertEquals("sesmith5", ticket.getCaller(), scenario + "Ticket.getCaller() - ticket after invalid command - incorrect caller");
			Assertions.assertEquals("Database", ticket.getCategory(), scenario + "Ticket.getCategoryString() - ticket after invalid command - incorrect category");
			Assertions.assertEquals("Urgent", ticket.getPriority(), scenario + "Ticket.getPriorityString() - ticket after invalid command - incorrect priority");
			Assertions.assertEquals("Test ticket 1", ticket.getSubject(), scenario + "Ticket.getName() - ticket after invalid command - incorrect name");
			Assertions.assertEquals("", ticket.getOwner(), scenario + "Ticket.getOwner() - ticket after invalid command - incorrect owner");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "Ticket.getOnHoldReason() - ticket after invalid  command - incorrect on hold reason - should be null");
			Assertions.assertNull(ticket.getResolutionCode(), scenario + "Ticket.getResolutionCode() - ticket after invalid command - incorrect resolution code - should be null");
			Assertions.assertEquals("Duplicate", ticket.getCancellationCode(), scenario + "Ticket.getCancellationCode() - ticket after invalid command - incorrect cancellation code");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "Ticket.getNotes() - ticket after invalid command - incorrect notes");
		}
	}
	

	
	/**
	 * Tests invalid transitions out of the Cancel state.
	 */
	@Test
	public void testInvalidTransitionsFromCancelConfirm() {
		String scenario = "Checking invalid transitions from the Cancel State - CONFIRM command. ";
		
		try {
			//Get to cancel
			Command c1 = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, "note 1");
			ticket.update(c1);
			
			Command c = new Command(CommandValue.CONFIRM, null, null, null, null, "note 1");
			ticket.update(c);
			Assertions.fail(scenario + "invalid command should throw an UnsupportedOperationException, but did not.");
		} catch (UnsupportedOperationException e) {
			Assertions.assertEquals(1, ticket.getTicketId(), scenario + "Ticket.getTicketId() - ticket after invalid command - incorrect id. ");
			Assertions.assertEquals(Ticket.CANCELED_NAME, ticket.getState(), scenario + "Ticket.getState() - ticket after invalid command - incorrect state");
			Assertions.assertEquals("sesmith5", ticket.getCaller(), scenario + "Ticket.getCaller() - ticket after invalid command - incorrect caller");
			Assertions.assertEquals("Database", ticket.getCategory(), scenario + "Ticket.getCategoryString() - ticket after invalid command - incorrect category");
			Assertions.assertEquals("Urgent", ticket.getPriority(), scenario + "Ticket.getPriorityString() - ticket after invalid command - incorrect priority");
			Assertions.assertEquals("Test ticket 1", ticket.getSubject(), scenario + "Ticket.getName() - ticket after invalid command - incorrect name");
			Assertions.assertEquals("", ticket.getOwner(), scenario + "Ticket.getOwner() - ticket after invalid command - incorrect owner");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "Ticket.getOnHoldReason() - ticket after invalid  command - incorrect on hold reason - should be null");
			Assertions.assertNull(ticket.getResolutionCode(), scenario + "Ticket.getResolutionCode() - ticket after invalid command - incorrect resolution code - should be null");
			Assertions.assertEquals("Duplicate", ticket.getCancellationCode(), scenario + "Ticket.getCancellationCode() - ticket after invalid command - incorrect cancellation code");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "Ticket.getNotes() - ticket after invalid command - incorrect notes");
		}
	}
	


}