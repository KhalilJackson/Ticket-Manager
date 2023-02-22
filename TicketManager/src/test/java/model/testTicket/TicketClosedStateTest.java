package edu.bowdoin.csci.TicketManager.model.ticket;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.command.Command.ResolutionCode;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;

/**
 * Closed state test
 *
 */
public class TicketClosedStateTest {
	
	private Ticket ticket1;
	private Ticket ticket2;

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
			ticket1 = new Ticket(TicketType.INCIDENT, "Test ticket 1", "sesmith5", Category.DATABASE, Priority.URGENT, "a note");
			ticket2 = new Ticket(TicketType.REQUEST, "Test ticket 1", "sesmith5", Category.DATABASE, Priority.URGENT, "a note");
		} catch (Exception e) {
			//If the setUp() has a problem the test should Assertions.fail.
			Assertions.fail("TicketClosedStateTest.setUp() - Creating Ticket for testing failed");
		}
	}
	
		
	/**
	 * Tests transition ClosedA - REOPEN 
	 * Request
	 */
	@Test
	public void testUpdateClosedToWorkingRequest() {
		String scenario = "TicketClosedStateTest.testUpdateClosedToWorkingRequest() - tests transition ClosedA\n" +
				"1. Check that newly created Ticket is New\n" +
				"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
				"3. Check that Ticket is In Progress and assigned to the given owner.\n" +
				"4. Issue a RESOLVE Command with a NOT_COMPLETED resolution code.\n" +
				"5. Check that Ticket is Resolved with the correct resolution code.\n" +
				"6. Issue a CONFIRM Command.\n" +
				"7. Check that Ticket is Closed with the correct information" +
				"8. Issue a REOPEN Command.\n" +
				"9. Check that Ticket is Working with the correct information";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket2.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket2.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket2.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket2.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket2.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.NOT_COMPLETED, null, "note 2");
			ticket2.update(c2);
			
			Assertions.assertEquals(Ticket.RESOLVED_NAME, ticket2.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", ticket2.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertNull(ticket1.getFeedbackCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Not Completed", ticket2.getResolutionCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", ticket2.getNotes(), scenario + "failed check at step 5.");
			
			Command c3 = new Command(CommandValue.CONFIRM, null, null, null, null, "note 3");
			ticket2.update(c3);
			
			Assertions.assertEquals(Ticket.CLOSED_NAME, ticket2.getState(), scenario + "failed check at step 7.");
			Assertions.assertEquals("owner", ticket2.getOwner(), scenario + "failed check at step 7.");
			Assertions.assertEquals(null, ticket2.getFeedbackCode(), scenario + "failed check at step 7.");
			Assertions.assertEquals("Not Completed", ticket2.getResolutionCode(), scenario + "failed check at step 7.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n-note 3\n", ticket2.getNotes(), scenario + "failed check at step 7.");
			
			Command c4 = new Command(CommandValue.REOPEN, null, null, null, null, "note 4");
			ticket2.update(c4);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket2.getState(), scenario + "failed check at step 9.");
			Assertions.assertEquals("owner", ticket2.getOwner(), scenario + "failed check at step 9.");
			Assertions.assertEquals(null, ticket2.getFeedbackCode(), scenario + "failed check at step 9.");
			Assertions.assertEquals(null, ticket2.getResolutionCode(), scenario + "failed check at step 9.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n-note 3\n-note 4\n", ticket2.getNotes(), scenario + "failed check at step 9.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	/**
	 * Tests invalid transitions out of the Closed state.
	 */
	@Test
	public void testInvalidTransitionsFromClosedConfirm() {
		String scenario = "Checking invalid transitions from the Closed State. ";
		
		//Get to Closed State
		Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
		ticket1.update(c1);
		Command c2 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.SOLVED, null, "note 2");
		ticket1.update(c2);
		Command c3 = new Command(CommandValue.CONFIRM, null, null, null, null, "note 3");
		ticket1.update(c3);
		
		//Resolve Command
		try {
			Command c = new Command(CommandValue.CONFIRM, null, null, null, null, "note 4");
			ticket1.update(c);
			Assertions.fail(scenario + "CONFIRM");
		} catch (UnsupportedOperationException e) {
			Assertions.assertEquals(Ticket.CLOSED_NAME, ticket1.getState(), scenario + "CONFIRM command threw an UnsupportedOperationException, but a field in the ticket was improperly updated.");
			Assertions.assertEquals("owner", ticket1.getOwner(), scenario + "CONFIRM command threw an UnsupportedOperationException, but a field in the ticket was improperly updated.");
			Assertions.assertEquals("Solved", ticket1.getResolutionCode(), scenario + "CONFIRM command threw an UnsupportedOperationException, but a field in the ticket was improperly updated.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n-note 3\n", ticket1.getNotes(), scenario + "CONFIRM command threw an UnsupportedOperationException, but a field in the ticket was improperly updated.");
		}
	}
	
	/**
	 * Tests invalid transitions out of the Closed state.
	 */
	@Test
	public void testInvalidTransitionsFromClosedCancel() {
		String scenario = "Checking invalid transitions from the Closed State. ";
		
		//Get to Closed State
		Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
		ticket1.update(c1);
		Command c2 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.SOLVED, null, "note 2");
		ticket1.update(c2);
		Command c3 = new Command(CommandValue.CONFIRM, null, null, null, null, "note 3");
		ticket1.update(c3);
		
		//Resolve Command
		try {
			Command c = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, "note 4");
			ticket1.update(c);
			Assertions.fail(scenario + "CANCEL");
		} catch (UnsupportedOperationException e) {
			Assertions.assertEquals(Ticket.CLOSED_NAME, ticket1.getState(), scenario + "CANCEL command threw an UnsupportedOperationException, but a field in the ticket was improperly updated.");
			Assertions.assertEquals("owner", ticket1.getOwner(), scenario + "CANCEL command threw an UnsupportedOperationException, but a field in the ticket was improperly updated.");
			Assertions.assertEquals("Solved", ticket1.getResolutionCode(), scenario + "CANCEL command threw an UnsupportedOperationException, but a field in the ticket was improperly updated.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n-note 3\n", ticket1.getNotes(), scenario + "CANCEL command threw an UnsupportedOperationException, but a field in the ticket was improperly updated.");
		}
	}
}
