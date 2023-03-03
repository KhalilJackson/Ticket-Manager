package model.ticket;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;

/**
 * Tests the Ticket class
 */
public class TicketNewStateTest {
	
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
			ticket = new Ticket(TicketType.INCIDENT, "Test ticket 1", "sesmith5", Category.DATABASE, Priority.URGENT, "a note");
		} catch (Exception e) {
			//If the setUp() has a problem the test should Assertions.fail.
			Assertions.fail("TicketNewStateTest.setUp() - Creating a Ticket for testing failed");
		}
	}

	/**
	 * Tests transition NewA - PROCESS
	 */
	@Test
	public void testUpdateNewToWorking() {
		String scenario = "TicketNewStateTest.testUpdateNewToWorking() - tests transition NewA\n" +
						"1. Check that newly created Ticket is New\n" +
						"2. Issue a PROCESS Command and assign owner \"owner\".\n" +
						"3. Check that Ticket is Working and assigned to the given owner.\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.PROCESS, "owner", null, null, null, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.WORKING_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("owner", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
	}
	
	/**
	 * Test transition NewB - CANCEL - DUPLICATE
	 */
	@Test
	public void testUpdateNewToCanceledDuplicate() {
		String scenario = "TicketNewStateTest.testUpdateNewToCanceledDuplicate() - tests transition NewB\n" +
				"1. Check that newly created Ticket is New\n" +
				"2. Issue a CANCEL Command with cancellation code DUPLICATE.\n" +
				"3. Check that Ticket is Canceled with correct cancellation code\n";
		try {
			Assertions.assertEquals(Ticket.NEW_NAME, ticket.getState(), scenario + "failed check at step 1.");
			
			Command c1 = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, "note 1");
			ticket.update(c1);
			
			Assertions.assertEquals(Ticket.CANCELED_NAME, ticket.getState(), scenario + "failed check at step 3.");
			Assertions.assertEquals("", ticket.getOwner(), scenario + "failed check at step 3.");
			Assertions.assertEquals("Duplicate", ticket.getCancellationCode(), scenario + "failed check at step 3.");
			Assertions.assertEquals("-a note\n-note 1\n", ticket.getNotes(), scenario + "failed check at step 3.");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(scenario + " - unexpected exception thrown - likely when creating a Command or updating the state");
		}
		
	}
	
	
	
}
