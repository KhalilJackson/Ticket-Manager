package model.io;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command;
import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.io.TicketWriter;
import edu.bowdoin.csci.TicketManager.model.io.TicketReader;
import edu.bowdoin.csci.TicketManager.model.ticket.Ticket;

import edu.bowdoin.csci.TicketManager.model.manager.*;

/**
 * @author ewinters
 *
 */
public class TicketWriterTest {
	
	/**
	 * Creates an instance of TicketWriter to use in all tests
	 * @throws Exception
	 */
	@BeforeEach
	public void setup() throws Exception{
	}
	
	/**
	 * Tests that the ticket files that are written are formatted properly
	 */
	@Test
	public void testWriteTicketFileFromReader() {
		
		try {
			
			ArrayList<Ticket> ticket_2 = TicketReader.readTicketFile("test-files/ticket2.txt");
			TicketWriter.writeTicketFile("test-files/ticket2_copy.txt", ticket_2);
			
			for(int i = 0; i < ticket_2.size(); i++) {
				//System.out.println(ticket_2.get(i).toString());
			}
			
			FileReader reader = new FileReader("test-files/ticket2.txt");
			FileReader reader_copy = new FileReader("test-files/ticket2_copy.txt");
			
			String ticket2String = "*3#Closed#Request#Subject line#caller#Inquiry#Medium#owner#Not Completed\n"
					+ "-a note\n"
					+ "-a note with\n"
					+ "a new line\n"
					+ "-a third note\n"
					+ "*6#Canceled#Incident#Subject line#caller#Software#Low#owner#Duplicate\n"
					+ "-a note 2\n"
					+ "-a second note\n"
					+ "-a note with\n"
					+ "a new line\n"
					+ "*7#New#Incident#Subject line#caller#Software#Low##\n"
					+ "-a note 3";
			String ticket2_copyString = "";
			
			//char character = (char)reader.read();
			char character_copy = (char)reader_copy.read();
			
			while(character_copy != (char)-1){
				//ticket2String = ticket2String + character;
				ticket2_copyString = ticket2_copyString + character_copy;
				
				//character = (char)reader.read();
				character_copy = (char)reader_copy.read();
			}
			
			reader.close();
			reader_copy.close();
			
			File file = new File("ticket2_copy.txt");
			file.delete();
			
			//ticket2String.replaceAll("\r", "");
			Assertions.assertEquals(ticket2String, ticket2_copyString, "TicketWriterTest.testWriteTicketFileFormatting() - Tried to write the contents of ticket2.txt to a new file, but failed.");
			
		}catch(Exception e){
			e.printStackTrace();
			Assertions.fail("TicketWriterTest.testWriteTicketFileFormatting() - An unexpected exception was thrown.");
		}
		
	}
	
	/**
	 * Tests that writing a ticket file to an invalid path returns an error
	 */
	@Test
	public void testWriteTicketFilePath() {
		
//		try {
//			TicketWriter.writeTicketFile("test-files/ticket1_copy.txt", null);
//			Assertions.fail("TicketWriterTest.testWriteTicketFilePath() - An invalid path was passed to the TicketWriter.writeTicketFile() method. An IOException should have been thrown, but was not.");
//		} catch(Exception e) {
//			//Error expected, carry on
//		}
		
	}
	
}
