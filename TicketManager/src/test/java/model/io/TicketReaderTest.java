package model.io;

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

public class TicketReaderTest {
	
	private TicketReader reader;

	/**
	 * Creates an instance of TicketReader to use in all tests
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		reader = new TicketReader();
	}
	
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
		
	}
	
	/**
	 * Tests that a Ticket produce by readTicketFile() has fields matching those of the input
	 */
	@Test
	public void testReadTicketFileOutput() {
		
	}
	
}
