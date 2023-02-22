package edu.bowdoin.csci.TicketManager.model.ticket;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.command.Command.FeedbackCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.ResolutionCode;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;

/**
 * Feedback state test
 *
 */
public class TicketFeedbackStateTest {
	
	private Ticket incident;

	/**
	 * Sets up the tests by creating  Ticket.
	 * @throws Exception if there's a problem during setup.
	 */
	@BeforeEach
	public void setUp() throws Exception {
		//Reset the Ticket counter at the beginning of every test.
		Ticket.setCounter(1);
		//Attempt to create Ticket.
		try {
			incident = new Ticket(TicketType.INCIDENT, "Test ticket 1", "sesmith5", Category.DATABASE, Priority.URGENT, "a note");
		} catch (Exception e) {
			//If the setUp() has a problem the test should Assertions.fail.
			Assertions.fail("TicketFeedbackStateTest.setUp() - Creating Ticket for testing failed");
		}
	}
	
	
	/**
	 * Test transition FeedbackA - AWAITING_PROVIDER
	 */
	@Test
	public void testUpdateFeedbackToWorkingAwaitingProvider() {
		String scenario = "TicketFeedbackStateTest.testUpdateFeedbackToWorkingAwaitingProvider() - tests transition FeedbackA\n" +
				"1. Check that newly created Ticket is New\n" +
				"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
				"3. Check that Ticket is Working and assigned to the given owner.\n" +
				"4. Issue a FEEDBACK Command with a AWAITING_PROVIDER feedback code.\n" +
				"5. Check that Ticket is Feedback with the correct feedback code.\n" +
				"6. Issue a REOPEN Command.\n" +
				"7. Check that Ticket is Working with correct information.\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, incident.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			incident.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, incident.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", incident.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", incident.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.FEEDBACK, null, FeedbackCode.AWAITING_PROVIDER, null, null, "note 2");
			incident.update(c2);
			
			Assertions.assertEquals(Ticket.FEEDBACK_NAME, incident.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", incident.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Awaiting Provider", incident.getFeedbackCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", incident.getNotes(), scenario + "failed check at step 5.");
			
			Command c3 = new Command(CommandValue.REOPEN, null, null, null, null, "note 3");
			incident.update(c3);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, incident.getState(), scenario + "failed check at step 7.");
			Assertions.assertEquals("owner", incident.getOwner(), scenario + "failed check at step 7.");
			Assertions.assertNull(incident.getFeedbackCode(), scenario + "failed check at step 7.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n-note 3\n", incident.getNotes(), scenario + "failed check at step 7.");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	/**
	 * Test transition FeedbackB - AWAITING_CALLER
	 */
	@Test
	public void testUpdateFeedbackToResolvedTicketAwaitingCallerSolved() {
		String scenario = "TicketFeedbackStateTest.testUpdateFeedbackToResolvedTicketAwaitingCallerSolved() - tests transition FeedbackB\n" +
				"1. Check that newly created Ticket is New\n" +
				"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
				"3. Check that Ticket is Working and assigned to the given owner.\n" +
				"4. Issue a FEEDBACK Command with a AWAITING_CALLER feedback code.\n" +
				"5. Check that Ticket is Feedback with the correct feedback code.\n" +
				"6. Issue a RESOLVE Command with SOLVED resolution code.\n" +
				"7. Check that Ticket is Resolved with correct information.\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, incident.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			incident.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, incident.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", incident.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", incident.getNotes(), scenario + "failed check at step 3.");
			
			Command c2 = new Command(CommandValue.FEEDBACK, null, FeedbackCode.AWAITING_CALLER, null, null, "note 2");
			incident.update(c2);
			
			Assertions.assertEquals(Ticket.FEEDBACK_NAME, incident.getState(), scenario + "failed check at step 5.");
			Assertions.assertEquals("owner", incident.getOwner(), scenario + "failed check at step 5.");
			Assertions.assertEquals("Awaiting Caller", incident.getFeedbackCode(), scenario + "failed check at step 5.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", incident.getNotes(), scenario + "failed check at step 5.");
			
			Command c3 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.SOLVED, null, "note 3");
			incident.update(c3);
			
			Assertions.assertEquals(Ticket.RESOLVED_NAME, incident.getState(), scenario + "failed check at step 7.");
			Assertions.assertEquals("owner", incident.getOwner(), scenario + "failed check at step 7.");
			Assertions.assertNull(incident.getFeedbackCode(), scenario + "failed check at step 7.");
			Assertions.assertEquals("Solved", incident.getResolutionCode(), scenario + "failed check at step 7.");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n-note 3\n", incident.getNotes(), scenario + "failed check at step 7.");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	
	
	
	/**
	 * Tests invalid transitions out of the Feedback state.
	 */
	@Test
	public void testInvalidTransitionsFromFeedbackConfirm() {
		String scenario = "Checking invalid transitions from the Feedback State - CONFIRM command. ";
		
		try {
			//Get to Feedback state
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			incident.update(c1);
			
			Command c2 = new Command(CommandValue.FEEDBACK, null, FeedbackCode.AWAITING_CALLER, null, null, "note 2");
			incident.update(c2);
			
			//Invalid command
			Command c = new Command(CommandValue.CONFIRM, null, null, null, null, "note 3");
			incident.update(c);
			Assertions.fail(scenario + "invalid command should throw an UnsupportedOperationException, but did not.");
		} catch (UnsupportedOperationException e) {
			Assertions.assertEquals(1, incident.getTicketId(), scenario + "Ticket.getTicketId() - ticket after invalid command - incorrect id. ");
			Assertions.assertEquals("Incident", incident.getTicketTypeString(), scenario + "Ticket.getTickeType() - ticket after invalid command - incorrect ticket type");
			Assertions.assertEquals(Ticket.FEEDBACK_NAME, incident.getState(), scenario + "Ticket.getState() - ticket after invalid command - incorrect state");
			Assertions.assertEquals("sesmith5", incident.getCaller(), scenario + "Ticket.getCaller() - ticket after invalid command - incorrect caller");
			Assertions.assertEquals("Database", incident.getCategory(), scenario + "Ticket.getCategoryString() - ticket after invalid command - incorrect category");
			Assertions.assertEquals("Urgent", incident.getPriority(), scenario + "Ticket.getPriorityString() - ticket after invalid command - incorrect priority");
			Assertions.assertEquals("Test ticket 1", incident.getSubject(), scenario + "Ticket.getName() - ticket after invalid command - incorrect name");
			Assertions.assertEquals("owner", incident.getOwner(), scenario + "Ticket.getOwner() - ticket after invalid command - incorrect owner");
			Assertions.assertEquals("Awaiting Caller", incident.getFeedbackCode(), scenario + "Ticket.getFeedbackCode() - ticket after invalid  command - incorrect feedback code");
			Assertions.assertNull(incident.getResolutionCode(), scenario + "Ticket.getResolutionCode() - ticket after invalid command - incorrect resolution code - should be null");
			Assertions.assertNull(incident.getCancellationCode(), scenario + "Ticket.getCancellationCode() - ticket after invalid command - incorrect cancellation code - should be null");
			Assertions.assertEquals("-a note\n-note 1\n-note 2\n", incident.getNotes(), scenario + "Ticket.getNotes() - ticket after invalid command - incorrect notes");
		}
	}

}
