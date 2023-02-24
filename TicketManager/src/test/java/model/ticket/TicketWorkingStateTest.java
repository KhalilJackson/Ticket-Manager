package model.ticket;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.command.Command.FeedbackCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.ResolutionCode;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;

/**
 * Working State test
 *
 */
public class TicketWorkingStateTest {
	
	private Ticket ticket;

	/**
	 * Sets up the tests by creating Ticket.
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
			Assertions.fail("TicketWorkingStateTest.setUp() - Creating Ticket for testing failed");
		}
	}
	
	/**
	 * Tests transition WorkingA - FEEDBACK - AWAITING_CALLER
	 */
	@Test
	public void testUpdateWorkingToFeedackAwaitingCaller() {
		String scenario = "TicketWorkingStateTest.testUpdateWorkingToFeedackAwaitingCaller() - tests transition WorkingA\n" +
						"1. Check that newly created Ticket is New\n" +
						"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
						"3. Check that Ticket is Working and assigned to the given owner.\n" +
						"4. Issue a FEEDBACK Command with a AWAITING_CALLER on feedback code.\n" +
						"5. Check that Ticket is Feedback with the correct feedback code.\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.FEEDBACK, null, FeedbackCode.AWAITING_CALLER, null, null, "note 2");
			ticket.update(c2);
			
			Assertions.assertEquals(Ticket.FEEDBACK_NAME, ticket.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Awaiting Caller", ticket.getFeedbackCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", ticket.getNotes(), scenario + "failed check at step 5.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	
	/**
	 * Tests transition WorkingB - RESOLVE - COMPLETED
	 */
	@Test
	public void testUpdateWorkingToResolvedCompleted() {
		String scenario = "TicketWorkingStateTest.testUpdateWorkingToResolvedCompleted() - tests transition WorkingB\n" +
						"1. Check that newly created Request Ticket is New\n" +
						"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
						"3. Check that Ticket is Working and assigned to the given owner.\n" +
						"4. Issue a RESOLVE Command with a COMPLETED resolution code.\n" +
						"5. Check that Ticket is Resolved with the correct resolution code.\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.COMPLETED, null, "note 2");
			ticket.update(c2);
			
			Assertions.assertEquals(Ticket.RESOLVED_NAME, ticket.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Completed", ticket.getResolutionCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", ticket.getNotes(), scenario + "failed check at step 5.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	/**
	 * Tests transition WorkingB - RESOLVE - NOT COMPLETED
	 */
	@Test
	public void testUpdateWorkingToResolvedNotCompleted() {
		String scenario = "TicketWorkingStateTest.testUpdateWorkingToResolvedNotCompleted() - tests transition WorkingB\n" +
						"1. Check that newly created Request Ticket is New\n" +
						"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
						"3. Check that Ticket is Working and assigned to the given owner.\n" +
						"4. Issue a RESOLVE Command with a NOT_COMPLETED resolution code.\n" +
						"5. Check that Ticket is Resolved with the correct resolution code.\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.NOT_COMPLETED, null, "note 2");
			ticket.update(c2);
			
			Assertions.assertEquals(Ticket.RESOLVED_NAME, ticket.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Not Completed", ticket.getResolutionCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", ticket.getNotes(), scenario + "failed check at step 5.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	/**
	 * Tests transition WorkingB - RESOLVE - CallerClosed
	 */
	@Test
	public void testUpdateWorkingToResolvedCallerClosed() {
		String scenario = "TicketWorkingStateTest.testUpdateWorkingToResolvedCallerClosed() - tests transition WorkingB\n" +
						"1. Check that newly created Request Ticket is New\n" +
						"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
						"3. Check that Ticket is Working and assigned to the given owner.\n" +
						"4. Issue a RESOLVE Command with a CALLER_CLOSED resolution code.\n" +
						"5. Check that Ticket is Resolved with the correct resolution code.\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.CALLER_CLOSED, null, "note 2");
			ticket.update(c2);
			
			Assertions.assertEquals(Ticket.RESOLVED_NAME, ticket.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Caller Closed", ticket.getResolutionCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", ticket.getNotes(), scenario + "failed check at step 5.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	/**
	 * Tests transition WorkingB - ticket - RESOLVE - CallerClosed
	 */
	@Test
	public void testUpdateWorkingToResolvedticketCallerClosed() {
		String scenario = "TicketWorkingStateTest.testUpdateWorkingToResolvedticketCallerClosed() - tests transition WorkingB\n" +
						"1. Check that newly created ticket Ticket is New\n" +
						"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
						"3. Check that Ticket is Working and assigned to the given owner.\n" +
						"4. Issue a RESOLVE Command with a CALLER_CLOSED resolution code.\n" +
						"5. Check that Ticket is Resolved with the correct resolution code.\n";
		try {
			ticket = new Ticket(TicketType.INCIDENT, "Test ticket 1", "sesmith5", Category.DATABASE, Priority.URGENT, "a note");
			
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.CALLER_CLOSED, null, "note 2");
			ticket.update(c2);
			
			Assertions.assertEquals(Ticket.RESOLVED_NAME, ticket.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Caller Closed", ticket.getResolutionCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", ticket.getNotes(), scenario + "failed check at step 5.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	
	/**
	 * Test transition WorkingC - CANCEL - DUPLICATE
	 */
	@Test
	public void testUpdateWorkingToCanceledDuplicate() {
		String scenario = "TicketNewStateTest.testUpdateWorkingToCanceledDuplicate() - tests transition WorkingC\n" +
				"1. Check that newly created Ticket is New\n" +
				"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
				"3. Check that Ticket is Working and assigned to the given owner.\n" +
				"4. Issue a CANCEL Command with cancellation code DUPLICATE.\n" +
				"5. Check that Ticket is Canceled with correct cancellation code\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, "note 2");
			ticket.update(c2);
			
			Assertions.assertEquals(Ticket.CANCELED_NAME, ticket.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Duplicate", ticket.getCancellationCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", ticket.getNotes(), scenario + "failed check at step 5.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	/**
	 * Test transition WorkingC - CANCEL - INAPPROPRIATE
	 */
	@Test
	public void testUpdateWorkingToCanceledInappropriate() {
		String scenario = "TicketNewStateTest.testUpdateWorkingToCanceledInappropriate() - tests transition WorkingC\n" +
				"1. Check that newly created Ticket is New\n" +
				"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
				"3. Check that Ticket is Working and assigned to the given owner.\n" +
				"4. Issue a CANCEL Command with cancellation code INAPPROPRIATE.\n" +
				"5. Check that Ticket is Canceled with correct cancellation code\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.INAPPROPRIATE, "note 2");
			ticket.update(c2);
			
			Assertions.assertEquals(Ticket.CANCELED_NAME, ticket.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Inappropriate", ticket.getCancellationCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", ticket.getNotes(), scenario + "failed check at step 5.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}

	/**
	 * Tests invalid transitions out of the Working state.
	 */
	@Test
	public void testInvalidTransitionsFromWorkingConfirm() {
		String scenario = "Checking invalid transitions from the Working State - CONFIRM command. ";
		
		try {
			//Get to Working state
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Command c = new Command(CommandValue.CONFIRM, null, null, null, null, "note 2");
			ticket.update(c);
			Assertions.fail(scenario + "invalid command should throw an UnsupportedOperationException, but did not.");
		} catch (UnsupportedOperationException e) {
			Assertions.assertEquals(1, ticket.getTicketId(), scenario + "Ticket.getTicketId() - ticket after invalid command - incorrect id. ");
			Assertions.assertEquals(TicketType.REQUEST, ticket.getTicketType(), scenario + "Ticket.getTicketType() - ticket after invalid command - incorrect type. ");
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "Ticket.getState() - ticket after invalid command - incorrect state");
			Assertions.assertEquals("sesmith5", ticket.getCaller(), scenario + "Ticket.getCaller() - ticket after invalid command - incorrect caller");
			Assertions.assertEquals("Database", ticket.getCategory(), scenario + "Ticket.getCategoryString() - ticket after invalid command - incorrect category");
			Assertions.assertEquals("Urgent", ticket.getPriority(), scenario + "Ticket.getPriorityString() - ticket after invalid command - incorrect priority");
			Assertions.assertEquals("Test ticket 1", ticket.getSubject(), scenario + "Ticket.getName() - ticket after invalid command - incorrect name");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "Ticket.getOwner() - ticket after invalid command - incorrect owner");
			Assertions.assertNull(ticket.getFeedbackCode(), scenario + "Ticket.getFeedbackCode() - ticket after invalid  command - incorrect on hold reason - should be null");
			Assertions.assertNull(ticket.getResolutionCode(), scenario + "Ticket.getResolutionCode() - ticket after invalid command - incorrect resolution code - should be null");
			Assertions.assertNull(ticket.getCancellationCode(), scenario + "Ticket.getCancellationCode() - ticket after invalid command - incorrect cancellation code - should be null");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "Ticket.getNotes() - ticket after invalid command - incorrect notes");
		}
	}

}
