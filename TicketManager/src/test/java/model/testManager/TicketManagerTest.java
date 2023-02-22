package edu.bowdoin.csci.TicketManager.model.manager;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.command.Command.FeedbackCode;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Category;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.Priority;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket.TicketType;

/**
 * Tests the TicketManager.
 *
 */
public class TicketManagerTest {
	private String subject = "Jenkins installation";
	private String caller = "sesmith5";
	private String note = "Install latest Jenkins system on 216 VMs";
	
	private String path = "test-files/";

	/**
	 * Compares the contents of the two files.  Returns true if the contents 
	 * are exactly the same. Returns false if the contents are not
	 * the same or if there are any errors while processing.
	 * 
	 * @param testInfo test information for error messages
	 * @param expectedFile the file with expected results
	 * @param actualFile the file with actual results
	 */
	private boolean compareFiles(String testInfo, String expectedFile, String actualFile) {
		try (Scanner expScanner = new Scanner(new File(expectedFile)); 
				Scanner actScanner = new Scanner(new File(actualFile)); ) {
			
			int i = 1;
			while (expScanner.hasNextLine()) {
				Assertions.assertEquals(expScanner.nextLine(), actScanner.nextLine(), testInfo + "\nAssertions.failure when comparing line " + i + " in expectedFile - " + expectedFile + " and actualFile - " + actualFile);
			}
			
			if (actScanner.hasNextLine()) {
				Assertions.fail(testInfo + "\nActual output file has more lines than in expected output file: expectedFile - " + expectedFile + " and actualFile - " + actualFile);
			}
			
			return true;
		} catch (FileNotFoundException e) {
			Assertions.fail(testInfo + "\nTicketManagerTest - cannot find files for test case:  expectedFile - " + expectedFile + " actualFile - " + actualFile);
		}
		return false;
	}
	
	/**
	 * Tests that files are saved properly.
	 */
	@Test
	public void testSaveTicketsToFile() {
		TicketManager model = TicketManager.getInstance();
		model.createNewTicketList();
		model.addTicketToList(TicketType.REQUEST, subject, caller, Category.SOFTWARE, Priority.URGENT, note);
		model.saveTicketsToFile(path + "act_ticket_new.txt");
		String testInfo = "TicketManagerTest.testSaveTicketsToFile() - added new ticket to new ticket list and compare with exp_ticket_new.txt";
		Assertions.assertTrue(compareFiles(testInfo, path + "exp_ticket_new.txt", path + "act_ticket_new.txt"), testInfo);
	}
	
	
	/**
	 * Test testGetTicketsAsArray
	 */
	@Test
	public void testGetTicketsForDisplay() {
		TicketManager model = TicketManager.getInstance();
		model.createNewTicketList();
		try {
			model.loadTicketsFromFile(path + "ticket1.txt");
			String [][] tickets = model.getTicketsForDisplay();
			Assertions.assertEquals(6, tickets.length, "TicketManagerTest.testGetTicketsForDisplay() - if load ticket1.txt, there should be 6 tickets");

			//id, ticket type, state, subject, category, priority
			int i = 1;
			Assertions.assertEquals("1", tickets[i - 1][0], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect id for ticket " + i);
			Assertions.assertEquals("Incident", tickets[i - 1][1], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect ticket type " + i);
			Assertions.assertEquals(Ticket.NEW_NAME, tickets[i - 1][2], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect state for ticket " + i);
			Assertions.assertEquals("GitHub down", tickets[i - 1][3], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect subject for ticket " + i);
			Assertions.assertEquals("Software", tickets[i - 1][4], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect category for ticket " + i);
			Assertions.assertEquals("Urgent", tickets[i - 1][5], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect priority for ticket " + i);
			
			i = 6;
			Assertions.assertEquals("6", tickets[i - 1][0], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect id for ticket " + i);
			Assertions.assertEquals("Request", tickets[i - 1][1], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect ticket type " + i);
			Assertions.assertEquals(Ticket.CANCELED_NAME, tickets[i - 1][2], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect state for ticket " + i);
			Assertions.assertEquals("Pizza", tickets[i - 1][3], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect subject for ticket " + i);
			Assertions.assertEquals("Inquiry", tickets[i - 1][4], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect category for ticket " + i);
			Assertions.assertEquals("Urgent", tickets[i - 1][5], "TicketManagerTest.testGetTicketsForDisplay() - load ticket1.txt - incorrect priority for ticket " + i);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Assertions.fail("TicketManagerTest.testGetTicketsAsArray() - couldn't load valid file ticket1.txt");
		} catch (ClassCastException e) {
			e.printStackTrace();
			Assertions.fail("TicketManagerTest.testGetTicketsAsArray() - ClassCastException when casting id to Integer, state name to String, or summary to String");
		}
	}
	
	/**
	 * Test executeCommand.
	 */
	@Test
	public void testExecuteCommand() {
		try {
			TicketManager model = TicketManager.getInstance();
			model.createNewTicketList();
			
			String mainScenario = "TicketManager.testExecuteCommand() - Load ticket1.txt\n";
			
			model.loadTicketsFromFile(path + "ticket1.txt");
				
			
			String [][] tickets = model.getTicketsForDisplay();
			Assertions.assertEquals(6, tickets.length, mainScenario + " - TicketList should contain six tickets after adding ticket1.txt");
			
			String scenario = mainScenario + "Ticket 1 - PROCESS commmand owned by \"owner\"\n";
			model.executeCommand(1, new Command(CommandValue.PROCESS, "owner", null, null, null, "note"));
			Ticket t1 = model.getTicketById(1);
			Assertions.assertEquals(1, t1.getTicketId(), scenario + "1 - Ticket's id is incorrect");
			Assertions.assertEquals(Ticket.WORKING_NAME, t1.getState(), scenario + "1 - Ticket's state is incorrect");
			Assertions.assertEquals("Incident", t1.getTicketTypeString(), scenario + "1 - Ticket's type is incorrect");
			Assertions.assertEquals("GitHub down", t1.getSubject(), scenario + "1 - Ticket's subject is incorrect");
			Assertions.assertEquals("sesmith5", t1.getCaller(), scenario + "1 - Ticket's caller is incorrect");
			Assertions.assertEquals("Software", t1.getCategory(), scenario + "1 - Ticket's category is incorrect");
			Assertions.assertEquals("Urgent", t1.getPriority(), scenario + "1 - Ticket's priority is incorrect");
			Assertions.assertEquals("owner", t1.getOwner(), scenario + "1 - Ticket's owner is incorrect");
			Assertions.assertEquals(null, t1.getFeedbackCode(), scenario + "1 - Ticket's feedback code is incorrect");
			Assertions.assertEquals(null, t1.getResolutionCode(), scenario + "1 - Ticket's resolution code is incorrect");
			Assertions.assertEquals(null, t1.getCancellationCode(), scenario + "1 - Ticket's cancelation code is incorrect");
			Assertions.assertEquals("-GitHub is not responding when I navigate to github.ncsu.edu\n-note\n", t1.getNotes(), scenario + "1 - Ticket's notes are incorrect");
			
			
			scenario = mainScenario + "Ticket 6 - FEEDBACK commmand\n";
			try {
				model.executeCommand(6, new Command(CommandValue.FEEDBACK, null, FeedbackCode.AWAITING_CALLER, null, null, "note"));
				Assertions.fail(scenario + "UnsupportedOperationException should be thrown when attempting to run a command on a Canceled ticket from TicketList.");
			} catch (UnsupportedOperationException e) {
				Ticket t6 = model.getTicketById(6);
				Assertions.assertEquals(6, t6.getTicketId(), scenario + "6 - Ticket's id is incorrect");
				Assertions.assertEquals(Ticket.CANCELED_NAME, t6.getState(), scenario + "6 - Ticket's state is incorrect");
				Assertions.assertEquals("Request", t6.getTicketTypeString(), scenario + "6 - Ticket's type is incorrect");
				Assertions.assertEquals("Pizza", t6.getSubject(), scenario + "6 - Ticket's subject is incorrect");
				Assertions.assertEquals("wpack", t6.getCaller(), scenario + "6 - Ticket's caller is incorrect");
				Assertions.assertEquals("Inquiry", t6.getCategory(), scenario + "6 - Ticket's category is incorrect");
				Assertions.assertEquals("Urgent", t6.getPriority(), scenario + "6 - Ticket's priority is incorrect");
				Assertions.assertEquals("", t6.getOwner(), scenario + "6 - Ticket's owner is incorrect");
				Assertions.assertEquals(null, t6.getFeedbackCode(), scenario + "6 - Ticket's feedback code is incorrect");
				Assertions.assertEquals(null, t6.getResolutionCode(), scenario + "6 - Ticket's resolution code is incorrect");
				Assertions.assertEquals("Inappropriate", t6.getCancellationCode(), scenario + "6 - Ticket's cancelation code is incorrect");
				Assertions.assertEquals("-Deliver a large pizza to EBII 1221!\n" + 
						"-No!\n", t6.getNotes(),
						scenario + "6 - Ticket's notes are incorrect");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail("TicketManagerTest.testExecuteCommand() - unexpected exception thrown");
		}
	}
	

}
