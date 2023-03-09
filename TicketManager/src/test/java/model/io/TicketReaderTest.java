package model.io;

import java.util.List;
import java.util.ArrayList;

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
	 * Tests that reading an empty file returns an error
	 */
	@Test
	public void testReadTicketFileEmpty() {
		
	}
	
	/**
	 * Tests that reading a ticket file that contains a ticket missing its ID returns an error
	 */
	@Test
	public void testReadTicketFileMissingID() {
		
	}
	
	/**
	 * Tests that reading a ticket file that contains a ticket missing its State returns an error
	 */
	@Test
	public void testReadticketFileMissingState() {
		
	}
	
	/**
	 * Tests that reading a ticket file that contains a ticket missing its Type returns an error
	 */
	@Test
	public void testReadticketFileMissingType() {
		
	}
	
	/**
	 * Tests that reading a ticket file that contains a ticket missing its Subject returns an error
	 */
	@Test
	public void testReadticketFileMissingSubject() {
		
	}
	
	/**
	 * Tests that reading a ticket file that contains a ticket missing its Caller returns an error
	 */
	@Test
	public void testReadticketFileMissingCaller() {
		
	}
	
	/**
	 * Tests that reading a ticket file that contains a ticket missing its Category returns an error
	 */
	@Test
	public void testReadticketFileMissingCategory() {
		
	}
	
	/**
	 * Tests that reading a ticket file that contains a ticket missing its Priority returns an error
	 */
	@Test
	public void testReadticketFileMissingPriority() {
		
	}
	
	/**
	 * Tests that reading a ticket file that contains a ticket missing its Owner returns an error
	 */
	@Test
	public void testReadticketFileMissingOwner() {
		
	}
	
	/**
	 * Tests that reading a ticket file which is improperly formatted returns an error
	 */
	@Test
	public void testReadTicketFileFormatting() {
		
	}
	
	/**
	 * Tests that reading a ticket file with an invalid file path returns an error
	 */
	@Test
	public void testReadTicketFilePath() {
		
		try {
			
			ArrayList<Ticket> badTicket = TicketReader.readTicketFile("test-files/badPath");
			
		}catch(IllegalArgumentException e) {
			Assertions.fail("TicketReaderTest.testReadTicketFilePath() - Input an invalid path to the readTicket() method and got an error, as expected.");
		}
		
	}
	
	/**
	 * Tests that a Ticket produce by readTicketFile() has fields matching those of the input
	 */
	@Test
	public void testReadTicketFileOutput() {
		
		ArrayList<Ticket> expected_tickets = new ArrayList<Ticket>();
		ArrayList<String> notes = new ArrayList<String>();
		
		//Test on 'act_ticket_new.txt' file
		try {
			
			ArrayList<Ticket> act_ticket_new = TicketReader.readTicketFile("/TicketManager/test-files/act_ticket_new.txt");
			
			notes.add("Install latest Jenkins system on 216 VMs");
			expected_tickets.add(new Ticket(1, "New", "Request", "Jenkins Installation", "sesmith5", "Software", "Urgent", "", null, notes));
			
			Assertions.assertEquals(expected_tickets, act_ticket_new, "TicketReaderTest.testReadTicketFileOutput() - Tried to make tickets from 'act_ticket_new.txt' file, but failed.");
			
			notes.clear();
			expected_tickets.clear();
		} catch(IllegalArgumentException e) {
			Assertions.fail("TicketReaderTest.testRReadTicketFileOutput() - An unexpected IllegalArgumentException was thrown.");
		}
			
			
		//Test on 'act_ticket.txt' file
		try {
			ArrayList<Ticket> act_ticket = TicketReader.readTicketFile("test-files/act_ticket.txt");
			
			notes.add("note");
			expected_tickets.add(new Ticket(1, "New", "Incident", "Subject", "Caller", "Network", "Low", "", null, notes));
			
			Assertions.assertEquals(expected_tickets, act_ticket, "TicketReaderTest.testReadTicketFileOutput() - Tried to make tickets from 'act_ticket.txt' file, but failed.");
			
			notes.clear();
			expected_tickets.clear();
			
		} catch(IllegalArgumentException e) {
			
		}
			
		//Test on 'act_tickets.txt' file
		try {
			ArrayList<Ticket> act_tickets = TicketReader.readTicketFile("test-files/act_tickets.txt");
			
			notes.add("a note");
			notes.add("a note with \na new line");
			notes.add("a third note");
			
			expected_tickets.add(new Ticket(3, "Closed", "Request", "Subject line", "caller", "Inquiry", "Medium", "owner", Command.RC_NOT_COMPLETED, notes));
			
			notes.clear();
			
			notes.add("a note 2");
			notes.add("a second note");
			notes.add("a note with \na new line");
			
			expected_tickets.add(new Ticket(6, "Canceled", "Incident", "Subject line", "caller", "Software", "Low", "owner", Command.CC_DUPLICATE, notes));
			
			notes.clear();
			
			notes.add("a note 3");
			
			expected_tickets.add(new Ticket(7, "New", "Incident", "Subject line", "caller", "Software", "Low", "owner", null, notes));
			
			Assertions.assertEquals(expected_tickets, act_tickets, "TicketReaderTest.testReadTicketFileOutput() - Tried to make tickets from 'act_ticket.txt' file, but failed.");
			
			notes.clear();
			expected_tickets.clear();
			
		} catch(IllegalArgumentException e) {
			
		}
		
	}
	
}
