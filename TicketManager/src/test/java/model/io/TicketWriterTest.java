package model.io;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.io.TicketWriter;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;

import edu.bowdoin.csci.TicketManager.model.manager.*;

/**
 * @author ewinters
 *
 */
public class TicketWriterTest {

	private TicketWriter writer;
	
	/**
	 * Creates an instance of TicketWriter to use in all tests
	 * @throws Exception
	 */
	@BeforeEach
	public void setup() throws Exception{
		writer = new TicketWriter();
	}
	
	/**
	 * Tests that writing a file for an empty ticket list returns an error
	 */
	@Test
	public void testWriteTicketFileEmpty() {
		
	}
	
	/**
	 * Tests that writing a file for a ticket list containing a ticket with no ID returns an error
	 */
	@Test
	public void testWriteTicketFileID() {
		
	}
	
	/**
	 * Tests that writing a file for a ticket list containing a ticket with no state returns an error
	 */
	@Test
	public void testWriteTicketFileState() {
		
	}
	
	/**
	 * Tests that writing a file for a ticket list containing a ticket with no type returns an error
	 */
	@Test
	public void testWriteTicketFileType() {
		
	}
	
	/**
	 * Tests that writing a file for a ticket list containing a ticket with no subject returns an error
	 */
	@Test
	public void testWriteTicketFileSubject() {
		
	}
	
	/**
	 * Tests that writing a file for a ticket list containing a ticket with no caller returns an error
	 */
	@Test
	public void testWriteTicketFileCaller() {
		
	}
	
	/**
	 * Tests that writing a file for a ticket list containing a ticket with no category returns an error
	 */
	@Test
	public void testWriteTicketFileCategory() {
		
	}
	
	/**
	 * Tests that writing a file for a ticket list containing a ticket with no priority returns an error
	 */
	@Test
	public void testWriteTicketFilePriority() {
		
	}
	
	/**
	 * Tests that writing a file for a ticket list containing a ticket with no owner returns an error
	 */
	@Test
	public void testWriteTicketFileOwner() {
		
	}
	
	/**
	 * Tests that the ticket files that are written are formatted properly
	 */
	@Test
	public void testWriteTicketFileFormatting() {
		
	}
	
	/**
	 * Tests that writing a ticket file to an invalid path returns an error
	 */
	@Test
	public void testWriteTicketFilePath() {
		
	}
	
}
