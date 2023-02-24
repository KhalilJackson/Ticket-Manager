package model.manager;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.io.TicketReader;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;

import edu.bowdoin.csci.TicketManager.model.manager.*;

/**
 * Tests the TicketList class.
 *
 */
public class TicketListTest {
	
	private TicketList list;
	private String note = "note 0";
	
	private String path = "test-files/";
	
	/**
	 * Creates an empty ticket.
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		list = new TicketList();
	}

	/**
	 * Tests that the empty list is correct.
	 */
	@Test
	public void testEmptyList() {
		try {
			List<Ticket> l1 = list.getTickets();
			Assertions.assertTrue(l1.isEmpty(), "TicketListTest.testEmptyList() - TicketList should start empty");
			
			Ticket b1 = list.getTicketById(1);
			Assertions.assertNull(b1, "TicketListTest.testEmptyList() - If TicketList is empty, getTicketById(0) should return null");
			
			list.executeCommand(0, new Command(CommandValue.CONFIRM, null, null, null, null, note));
			Ticket b2 = list.getTicketById(1);
			Assertions.assertNull(b2, "TicketListTest.testEmptyList() - If TicketList is empty, attempting to execute a Command should result in no change");
			
			list.deleteTicketById(1);
			List<Ticket> l3 = list.getTickets();
			Assertions.assertTrue(l3.isEmpty(), "TicketListTest.testEmptyList() - If TicketList is empty, attempting to delete a ticket should result in no change");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail("TicketListTest.testEmptyList() - unexpected exception");
		}
	}


	
	/**
	 * test executeCommand.
	 */
	@Test
	public void testExecuteCommand() {
		try {
			List<Ticket> l1 = list.getTickets();
			Assertions.assertTrue(l1.isEmpty(), "TicketListTest.testExecuteCommand() - TicketList should start empty");
			
			list.addTickets(TicketReader.readTicketFile(path + "ticket1.txt"));
			
			String mainScenario = "TicketListTest.testExecuteCommand() - Load ticket1.txt\n";
			
			l1 = list.getTickets();
			Assertions.assertEquals(6, l1.size(), "TicketListTest.testExecuteCommand() - TicketList should contain six tickets after adding ticket1.txt");
			
			String scenario = mainScenario + "Ticket 1 - CANCEL commmand DUPLICATE\n";
			list.executeCommand(1, new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, "note"));
			Ticket t1 = list.getTicketById(1);
			Assertions.assertEquals(1, t1.getTicketId(), scenario + "1 - Ticket's id is incorrect");
			Assertions.assertEquals(Ticket.CANCELED_NAME, t1.getState(), scenario + "1 - Ticket's state is incorrect");
			Assertions.assertEquals("Incident", t1.getTicketTypeString(), scenario + "1 - Ticket's type is incorrect");
			Assertions.assertEquals("GitHub down", t1.getSubject(), scenario + "1 - Ticket's subject is incorrect");
			Assertions.assertEquals("sesmith5", t1.getCaller(), scenario + "1 - Ticket's caller is incorrect");
			Assertions.assertEquals("Software", t1.getCategory(), scenario + "1 - Ticket's category is incorrect");
			Assertions.assertEquals("Urgent", t1.getPriority(), scenario + "1 - Ticket's priority is incorrect");
			Assertions.assertEquals("", t1.getOwner(), scenario + "1 - Ticket's owner is incorrect");
			Assertions.assertEquals(null, t1.getFeedbackCode(), scenario + "1 - Ticket's feedback code is incorrect");
			Assertions.assertEquals(null, t1.getResolutionCode(), scenario + "1 - Ticket's resolution code is incorrect");
			Assertions.assertEquals("Duplicate", t1.getCancellationCode(), scenario + "1 - Ticket's cancelation code is incorrect");
			Assertions.assertEquals("-GitHub is not responding when I navigate to github.ncsu.edu\n-note\n", t1.getNotes(), scenario + "1 - Ticket's notes are incorrect");

		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail("TicketListTest.testExecuteCommand() - unexpected exception thrown");
		}
	}
	
	/**
	 * Test deleteTicketById.
	 */
	@Test
	public void testDeleteTicketById() {
		try {
			List<Ticket> l1 = list.getTickets();
			Assertions.assertTrue(l1.isEmpty(), "TicketListTest.testDeleteTicketById() - TicketList should start empty");
			
			list.addTickets(TicketReader.readTicketFile(path + "ticket1.txt"));
			
			l1 = list.getTickets();
			Assertions.assertEquals(6, l1.size(), "TicketListTest.testDeleteTicketById() - TicketList should contain six tickets after adding ticket1.txt");
			
			list.deleteTicketById(-1);
			l1 = list.getTickets();
			Assertions.assertEquals(6, l1.size(), "TicketListTest.testDeleteTicketById() - TicketList should contain six tickets attempting to delete a ticket with invalid id (negative)");
			
		} catch (Exception e) {
			Assertions.fail("TicketListTest.testDeleteTicketById() - unexpected exception thrown" + e);
		}
	}
}
