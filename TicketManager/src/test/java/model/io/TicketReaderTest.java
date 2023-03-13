package model.io;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.io.TicketReader;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;

import edu.bowdoin.csci.TicketManager.model.manager.*;

public class TicketReaderTest {
	
	/**
	 * Tests that reading a ticket file with an invalid file path returns an error
	 */
	@Test
	public void testReadTicketFilePath() {
		
		try {
			ArrayList<Ticket> badTicket = TicketReader.readTicketFile("test-files/badPath");
			Assertions.fail("TicketReaderTest.testReadTicketFilePath() - Input an invalid path to the readTicket() method and got an error, as expected.");
		}catch(Exception e) {
			//Error expected, carry on.
		}
		
	}
	
	/**
	 * Tests that a Ticket produce by readTicketFile() has fields matching those of the input
	 */
	@Test
	public void testReadTicketFileOutput() {
		
		ArrayList<Ticket> expected_tickets = new ArrayList<Ticket>();
		ArrayList<String> notes = new ArrayList<String>();
		
		//Test on 'ticket1.txt' file
		try {
			
			ArrayList<Ticket> ticket_1 = TicketReader.readTicketFile("test-files/ticket1.txt");
			
			//Create the tickets manually to compare against
			notes.add("GitHub is not responding when I navigate to github.ncsu.edu");
			expected_tickets.add(new Ticket(1, "New", "Incident", "GitHub down", "sesmith5", "Software", "Urgent", "", null, notes));
			
			notes = new ArrayList<String>(Arrays.asList("Create a workshop account for access to a GitHub repo",
														"Assigned to ccgurley.",
														"How long is the account needed for?",
														"Until November 1"));
			expected_tickets.add(new Ticket(2, "Working", "Request", "Workshop account", "sesmith5", "Inquiry", "Low", "ccgurley", null, notes));
			
			notes = new ArrayList<String>(Arrays.asList("Add Gradescope plugin to Moodle to import grades",
														"Checking with plugin provider"));
			expected_tickets.add(new Ticket(3, "Feedback", "Request", "Add Gradescope plugin to Moodle", "ahoward", "Software", "Medium", "itecs", "Awaiting Provider", notes));
			
			notes = new ArrayList<String>(Arrays.asList("Lights are not working in EB I 1011. ",
														"Cannot install dimmer switch.  Will leave on."));
			expected_tickets.add(new Ticket(4, "Resolved", "Incident", "Lights not working in EBI 1011", "jtking", "Hardware", "Medium", "facilities", "Workaround", notes));
			
			notes = new ArrayList<String>(Arrays.asList("I would like to request a new VM for my class",
														"Assigned to jtking",
														"VM created",
														"Request completed"));
			expected_tickets.add(new Ticket(5, "Closed", "Request", "New VM", "sesmith5", "Inquiry", "High", "jtking", "Completed", notes));
			
			notes = new ArrayList<String>(Arrays.asList("Deliver a large pizza to EBII 1221!", "No!"));
			expected_tickets.add(new Ticket(6, "Canceled", "Request", "Pizza", "wpack", "Inquiry", "Urgent", "", "Inappropriate", notes));
			
			for(int i = 0; i < expected_tickets.size(); i++) {
				Ticket exp_ticket = expected_tickets.get(i);
				Ticket act_ticket = ticket_1.get(i);
				Assertions.assertEquals(exp_ticket.getTicketId(), act_ticket.getTicketId(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + String.valueOf(exp_ticket.getTicketId()) + "\" as its ticket ID, but was instead \"" + String.valueOf(act_ticket.getTicketId())+ "\".");
				Assertions.assertEquals(exp_ticket.getState(), act_ticket.getState(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getState() + "\" as its State, but was instead \"" + act_ticket.getState()+ "\".");
				Assertions.assertEquals(exp_ticket.getTicketTypeString(), act_ticket.getTicketTypeString(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getTicketTypeString() + "\" as its ticket type, but was instead \"" + act_ticket.getTicketTypeString()+ "\".");
				Assertions.assertEquals(exp_ticket.getSubject(), act_ticket.getSubject(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getSubject() + "\" as its subject, but was instead \"" + act_ticket.getSubject() + "\".");
				Assertions.assertEquals(exp_ticket.getCaller(), act_ticket.getCaller(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getCaller() + "\" as its caller, but was instead \"" + act_ticket.getCaller() + "\".");
				Assertions.assertEquals(exp_ticket.getPriority(), act_ticket.getPriority(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getPriority() + "\" as its Priority, but was instead \"" + act_ticket.getPriority() + "\".");
				Assertions.assertEquals(exp_ticket.getOwner(), act_ticket.getOwner(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getOwner() + "\" as its owner, but was instead \"" + act_ticket.getOwner()+ "\".");
				Assertions.assertEquals(exp_ticket.getCancellationCode(), act_ticket.getCancellationCode(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getCancellationCode() + "\" as its cancellation code, but was instead \"" + act_ticket.getCancellationCode() + "\".");
				Assertions.assertEquals(exp_ticket.getResolutionCode(), act_ticket.getResolutionCode(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getResolutionCode() + "\" as its resolution code, but was instead \"" + act_ticket.getResolutionCode() + "\".");
				Assertions.assertEquals(exp_ticket.getFeedbackCode(), act_ticket.getFeedbackCode(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getFeedbackCode() + "\" as its feedback code, but was instead \"" + act_ticket.getFeedbackCode()+ "\".");
				Assertions.assertEquals(exp_ticket.getNotes(), act_ticket.getNotes(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \n\"" + exp_ticket.getNotes() + "\" as its notes, but was instead \n\"" + act_ticket.getNotes()+ "\".");
			}
			
			expected_tickets.clear();
			
		} catch(Exception e) {
			Assertions.fail("TicketReaderTest.testReadTicketFileOutput() - An unexpected IllegalArgumentException was thrown.");
		}
			
		//Test on 'ticket10.txt' file
		try {
			ArrayList<Ticket> ticket_10 = TicketReader.readTicketFile("test-files/ticket10.txt");
			Assertions.fail("TicketReaderTest.testReadTicketFileOutput() - An unexpected IllegalArgumentException was thrown.");
			
		} catch(IllegalArgumentException e) {
			//Error expected; carry on
		}
			
		//Test on 'ticket2.txt' file
		try {
			ArrayList<Ticket> ticket_2 = TicketReader.readTicketFile("test-files/ticket2.txt");
			
			notes = new ArrayList<String>(Arrays.asList("a note", "a note with\na new line", "a third note"));
			expected_tickets.add(new Ticket(3, "Closed", "Request", "Subject line", "caller", "Inquiry", "Medium", "owner", Command.RC_NOT_COMPLETED, notes));
			
			
			notes = new ArrayList<String>(Arrays.asList("a note 2", "a second note", "a note with\na new line"));
			expected_tickets.add(new Ticket(6, "Canceled", "Incident", "Subject line", "caller", "Software", "Low", "owner", Command.CC_DUPLICATE, notes));
			
			notes = new ArrayList<String>(Arrays.asList("a note 3"));
			expected_tickets.add(new Ticket(7, "New", "Incident", "Subject line", "caller", "Software", "Low", "", null, notes));
			
			for(int i = 0; i < expected_tickets.size(); i++) {
				Ticket exp_ticket = expected_tickets.get(i);
				Ticket act_ticket = ticket_2.get(i);
				Assertions.assertEquals(exp_ticket.getTicketId(), act_ticket.getTicketId(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + String.valueOf(exp_ticket.getTicketId()) + "\" as its ticket ID, but was instead \"" + String.valueOf(act_ticket.getTicketId())+ "\".");
				Assertions.assertEquals(exp_ticket.getState(), act_ticket.getState(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getState() + "\" as its State, but was instead \"" + act_ticket.getState()+ "\".");
				Assertions.assertEquals(exp_ticket.getTicketTypeString(), act_ticket.getTicketTypeString(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getTicketTypeString() + "\" as its ticket type, but was instead \"" + act_ticket.getTicketTypeString()+ "\".");
				Assertions.assertEquals(exp_ticket.getSubject(), act_ticket.getSubject(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getSubject() + "\" as its subject, but was instead \"" + act_ticket.getSubject() + "\".");
				Assertions.assertEquals(exp_ticket.getCaller(), act_ticket.getCaller(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getCaller() + "\" as its caller, but was instead \"" + act_ticket.getCaller() + "\".");
				Assertions.assertEquals(exp_ticket.getPriority(), act_ticket.getPriority(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getPriority() + "\" as its Priority, but was instead \"" + act_ticket.getPriority() + "\".");
				Assertions.assertEquals(exp_ticket.getOwner(), act_ticket.getOwner(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getOwner() + "\" as its owner, but was instead \"" + act_ticket.getOwner()+ "\".");
				Assertions.assertEquals(exp_ticket.getCancellationCode(), act_ticket.getCancellationCode(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getCancellationCode() + "\" as its cancellation code, but was instead \"" + act_ticket.getCancellationCode() + "\".");
				Assertions.assertEquals(exp_ticket.getResolutionCode(), act_ticket.getResolutionCode(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getResolutionCode() + "\" as its resolution code, but was instead \"" + act_ticket.getResolutionCode() + "\".");
				Assertions.assertEquals(exp_ticket.getFeedbackCode(), act_ticket.getFeedbackCode(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \"" + exp_ticket.getFeedbackCode() + "\" as its feedback code, but was instead \"" + act_ticket.getFeedbackCode()+ "\".");
				Assertions.assertEquals(exp_ticket.getNotes(), act_ticket.getNotes(), "TicketReaderTest.testReadTicketFileOutput() - Ticket number " + String.valueOf(i) + " should have had \n\"" + exp_ticket.getNotes() + "\" as its notes, but was instead \n\"" + act_ticket.getNotes()+ "\".");
			}
			
			notes.clear();
			expected_tickets.clear();
			
		} catch(IllegalArgumentException e) {
			Assertions.fail("TicketReaderTest.testReadTicketFileOutput() - An unexpected IllegalArgumentException was thrown.");
		}
		
	}
	
}
