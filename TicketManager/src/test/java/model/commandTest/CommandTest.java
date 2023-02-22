package edu.bowdoin.csci.TicketManager.model.command;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.bowdoin.csci.TicketManager.model.command.Command.CancellationCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.CommandValue;
import edu.bowdoin.csci.TicketManager.model.command.Command.FeedbackCode;
import edu.bowdoin.csci.TicketManager.model.command.Command.ResolutionCode;

/**
 * Command Test
 */
public class CommandTest {
	
	private String note = "a note";

	/**
	 * Test constructor.
	 */
	@Test
	public void testCommandCreationNull() {
		Command c = null;
		try {
			c = new Command(null, null, null, null, null, null);
			Assertions.fail("CommandTest - A Command cannot have a null CommandValue");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(c, "CommandTest - A command cannot have a null CommandValue");
		}
	}
	
	/**
	 * Test investigate
	 */
	@Test 
	public void testCommandCreationInvestigate() {
		Command c = null;
	
		try {
			c = new Command(CommandValue.PROCESS, "", null, null, null, note);
			Assertions.fail("CommandTest - new Command(CommandValue.PROCESS, \"\", null, null, null, note) - A PROCESS Command cannot have an empty string ownerId");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(c, "CommandTest - new Command(CommandValue.PROCESS, \"\", null, null, null, note) - A PROCESS Command cannot have a an empty string ownerId");
		}	
		
		String owner = "owner";
			
		try {	
			Command c1 = new Command(CommandValue.PROCESS, owner, null, null, null, note);
			Assertions.assertEquals(CommandValue.PROCESS, c1.getCommand(), "CommandTest - new Command(CommandValue.PROCESS, owner, null, null, null, note) - incorrect CommandValue");
			Assertions.assertEquals(owner, c1.getOwnerId(), "CommandTest - new Command(CommandValue.PROCESS, owner, null, null, null, note) - given owner should be returned");
			Assertions.assertNull(c1.getFeedbackCode(), "CommandTest - new Command(CommandValue.PROCESS, owner, null, null, null, note) - null on hold reason should return null");
			Assertions.assertNull(c1.getResolutionCode(), "CommandTest - new Command(CommandValue.PROCESS, owner, null, null, null, note) - null resolution should return null");
			Assertions.assertNull(c1.getCancellationCode(), "CommandTest - new Command(CommandValue.PROCESS, owner, null, null, null, note) - null cancellation code should return null");
			Assertions.assertEquals(note, c1.getNote(), "CommandTest - new Command(CommandValue.PROCESS, owner, null, null, null, note) - given note should be returned");
		} catch (Exception e) {
			Assertions.fail("CommandTest - new Command(CommandValue.PROCESS, owner, null, null, null, note) - Exception thrown when creating a valid PROCESS command" + e);
		}
	}
	
	/**
	 * Test hold
	 */
	@Test 
	public void testCommandCreationFeedback() {
		Command c = null;
		
		try { 
			c = new Command(CommandValue.FEEDBACK, null, null, null, null, note);
			Assertions.fail("CommandTest - new Command(CommandValue.FEEDBACK, null, null, null, null, note) - A FEEDBACK Command cannot have a null feedback reason");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(c, "CommandTest - new Command(CommandValue.FEEDBACK, null, null, null, null, note) - A FEEDBACK Command cannot have a null feedback reason");
		}	
		
		try {
			c = new Command(CommandValue.FEEDBACK, null, FeedbackCode.AWAITING_CALLER, null, null, null);
			Assertions.fail("CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_CALLER, null, null, null) - A FEEDBACK Command cannot have a null note");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(c, "CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_CALLER, null, null, null) - A FEEDBACK Command cannot have a null note");
		}
		
		try {
			c = new Command(CommandValue.FEEDBACK, null, FeedbackCode.AWAITING_PROVIDER, null, null, "");
			Assertions.fail("CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, \"\") - A FEEDBACK Command cannot have an empty note");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(c, "CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, \"\") - A FEEDBACK Command cannot have an empty note");
		}
			
	
		try {	
			Command c1 = new Command(CommandValue.FEEDBACK, null, FeedbackCode.AWAITING_PROVIDER, null, null, note);
			Assertions.assertEquals(CommandValue.FEEDBACK, c1.getCommand(), "CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, note) - incorrect CommandValue");
			Assertions.assertNull(c1.getOwnerId(), "CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, note) - given owner should be returned");
			Assertions.assertEquals(FeedbackCode.AWAITING_PROVIDER, c1.getFeedbackCode(), "CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, note) - on hold reason incorrect");
			Assertions.assertNull(c1.getResolutionCode(), "CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, note) - null resolution should return null");
			Assertions.assertNull(c1.getCancellationCode(), "CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, note) - null cancellation code should return null");
			Assertions.assertEquals(note, c1.getNote(), "CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, note) - given note should be returned");
		} catch (Exception e) {
			Assertions.fail("CommandTest - new Command(CommandValue.FEEDBACK, null, FeedbackReason.AWAITING_PROVIDER, null, null, note) - Exception thrown when creating a valid FEEDBACK command" + e);
		}
	}
	
	/**
	 * Test resolve
	 */
	@Test 
	public void testCommandCreationResolve() {
		Command c = null;
		
		try {
			c = new Command(CommandValue.RESOLVE, null, null, null, null, note);
			Assertions.fail("CommandTest - new Command(CommandValue.RESOLVE, null, null, null, null, note) - A RESOLVE Command cannot have a null resolution");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(c, "CommandTest - new Command(CommandValue.RESOLVE, null, null, null, null, note) - A RESOLVE Command cannot have a null resolution");
		}
				
		try {	
			Command c1 = new Command(CommandValue.RESOLVE, null, null, ResolutionCode.WORKAROUND, null, note);
			Assertions.assertEquals(CommandValue.RESOLVE, c1.getCommand(), "CommandTest - new Command(CommandValue.RESOLVE, null, null, ResolutionCode.WORKAROUND, null, note) - incorrect CommandValue");
			Assertions.assertNull(c1.getOwnerId(), "CommandTest - new Command(CommandValue.RESOLVE, null, null, ResolutionCode.WORKAROUND, null, note) - given owner should be returned");
			Assertions.assertNull(c1.getFeedbackCode(), "CommandTest - new Command(CommandValue.RESOLVE, null, null, ResolutionCode.WORKAROUND, null, note) - null on hold reason should return null");
			Assertions.assertEquals(ResolutionCode.WORKAROUND, c1.getResolutionCode(), "CommandTest - new Command(CommandValue.RESOLVE, null, null, ResolutionCode.WORKAROUND, null, note) - incorrect resolution");
			Assertions.assertNull(c1.getCancellationCode(), "CommandTest - new Command(CommandValue.RESOLVE, null, null, ResolutionCode.WORKAROUND, null, note) - null cancellation code should return null");
			Assertions.assertEquals(note, c1.getNote(), "CommandTest - new Command(CommandValue.RESOLVE, null, null, ResolutionCode.WORKAROUND, null, note) - given note should be returned");
		} catch (Exception e) {
			Assertions.fail("CommandTest - new Command(CommandValue.RESOLVE, null, null, ResolutionCode.WORKAROUND, null, note) - Exception thrown when creating a valid RESOLVE command" + e);
		}
	}
	
	/**
	 * Test confirm
	 */
	@Test 
	public void testCommandCreationConfirm() {
		Command c = null;

		try {
			c = new Command(CommandValue.CONFIRM, null, null, null, null, null);
			Assertions.fail("CommandTest - new Command(CommandValue.CONFIRM, null, null, null, null, null) - A CONFIRM Command cannot have a null note");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(c, "CommandTest - new Command(CommandValue.CONFIRM, null, null, null, null, null) - A CONFIRM Command cannot have a null note");
		}
		
		
		try {	
			Command c1 = new Command(CommandValue.CONFIRM, null, null, null, null, note);
			Assertions.assertEquals(CommandValue.CONFIRM, c1.getCommand(), "CommandTest - new Command(CommandValue.CONFIRM, null, null, null, null, note) - incorrect CommandValue");
			Assertions.assertNull(c1.getOwnerId(), "CommandTest - new Command(CommandValue.CONFIRM, null, null, null, null, note) - given owner should be returned");
			Assertions.assertNull(c1.getFeedbackCode(), "CommandTest - new Command(CommandValue.CONFIRM, null, null, null, null, note) - null on hold reason should return null");
			Assertions.assertNull(c1.getResolutionCode(), "CommandTest - new Command(CommandValue.CONFIRM, null, null, null, null, note) - null resolution should return null");
			Assertions.assertNull(c1.getCancellationCode(), "CommandTest - new Command(CommandValue.CONFIRM, null, null, null, null, note) - null cancellation code should return null");
			Assertions.assertEquals(note, c1.getNote(), "CommandTest - new Command(CommandValue.CONFIRM, null, null, null, null, note) - given note should be returned");
		} catch (Exception e) {
			Assertions.fail("CommandTest -new Command(CommandValue.CONFIRM, null, null, null, null, note) -  Exception thrown when creating a valid CONFIRM command" + e);
		}
	}
	
	/**
	 * Test reopen
	 */
	@Test 
	public void testCommandCreationReopen() {
		Command c = null;

		try {
			c = new Command(CommandValue.REOPEN, null, null, null, null, null);
			Assertions.fail("CommandTest - new Command(CommandValue.REOPEN, null, null, null, null, null) - A REOPEN Command cannot have a null note");
		} catch (IllegalArgumentException e) {
			Assertions.assertNull(c, "CommandTest - new Command(CommandValue.REOPEN, null, null, null, null, null) - A REOPEN Command cannot have a null note");
		}
					
		try {	
			Command c1 = new Command(CommandValue.REOPEN, null, null, null, null, note);
			Assertions.assertEquals(CommandValue.REOPEN, c1.getCommand(), "CommandTest - new Command(CommandValue.REOPEN, null, null, null, null, note) - incorrect CommandValue");
			Assertions.assertNull(c1.getOwnerId(), "CommandTest - new Command(CommandValue.REOPEN, null, null, null, null, note) - given owner should be returned");
			Assertions.assertNull(c1.getFeedbackCode(), "CommandTest - new Command(CommandValue.REOPEN, null, null, null, null, note) - null on hold reason should return null");
			Assertions.assertNull(c1.getResolutionCode(), "CommandTest - new Command(CommandValue.REOPEN, null, null, null, null, note) - null resolution should return null");
			Assertions.assertNull(c1.getCancellationCode(), "CommandTest - new Command(CommandValue.REOPEN, null, null, null, null, note) - null cancellation code should return null");
			Assertions.assertEquals(note, c1.getNote(), "CommandTest - new Command(CommandValue.REOPEN, null, null, null, null, note) - given note should be returned");
		} catch (Exception e) {
			Assertions.fail("CommandTest -new Command(CommandValue.REOPEN, null, null, null, null, note) -  Exception thrown when creating a valid REOPEN command" + e);
		}
	}
	
	/**
	 * Test cancel
	 */
	@Test 
	public void testCommandCreationCancel() {
		try {	
			Command c1 = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, note);
			Assertions.assertEquals(CommandValue.CANCEL, c1.getCommand(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.DUPLICATE, note) - incorrect CommandValue");
			Assertions.assertNull(c1.getOwnerId(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.DUPLICATE, note) - given owner should be returned");
			Assertions.assertNull(c1.getFeedbackCode(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.DUPLICATE, note) - null on hold reason should return null");
			Assertions.assertNull(c1.getResolutionCode(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.DUPLICATE, note) - null resolution should return null");
			Assertions.assertEquals(CancellationCode.DUPLICATE, c1.getCancellationCode(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.DUPLICATE, note) - incorrect cancellation code");
			Assertions.assertEquals(note, c1.getNote(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.DUPLICATE, note) - given note should be returned");
		} catch (Exception e) {
			Assertions.fail("CommandTest - new Command(CommandValue.CANCEL, null, null, null, CancellationCode.DUPLICATE, note) - Exception thrown when creating a valid CANCEL command" + e);
		}
		
		try {	
			Command c1 = new Command(CommandValue.CANCEL, null, null, null, CancellationCode.INAPPROPRIATE, note);
			Assertions.assertEquals(CommandValue.CANCEL, c1.getCommand(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.NOT_AN_INCIDENT, note) - incorrect CommandValue");
			Assertions.assertNull(c1.getOwnerId(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.NOT_AN_INCIDENT, note) - given owner should be returned");
			Assertions.assertNull(c1.getFeedbackCode(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.NOT_AN_INCIDENT, note) - null on hold reason should return null");
			Assertions.assertNull(c1.getResolutionCode(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.NOT_AN_INCIDENT, note) - null resolution should return null");
			Assertions.assertEquals(CancellationCode.INAPPROPRIATE, c1.getCancellationCode(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.NOT_AN_INCIDENT, note) - incorrect cancellation code");
			Assertions.assertEquals(note, c1.getNote(), "CommandTest - new Command(CommandValue.CANCEL, owner, null, null, CancellationCode.NOT_AN_INCIDENT, note) - given note should be returned");
		} catch (Exception e) {
			Assertions.fail("CommandTest - new Command(CommandValue.CANCEL, null, null, null, CancellationCode.NOT_AN_INCIDENT, note) - Exception thrown when creating a valid CANCEL command" + e);
		}

	}

}
