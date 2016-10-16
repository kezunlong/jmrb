package ir.utilities.security;

import org.junit.Test;

import junit.framework.Assert;

public class LDAPAuthenticationTest {

	@Test
	public void testDoIRAuthencation() {
		LDAPAuthentication authentication = new LDAPAuthentication();
		boolean flag1 = authentication.doIRAuthencation("irfgoy", "IRIT*1qaz");
		boolean flag2 = authentication.doIRAuthencation("Corp\\irfgoy", "IRIT*1qaz");
		boolean flag3 = authentication.doIRAuthencation("irfgoy@Corp", "IRIT*1qaz");
		boolean flag4 = authentication.doIRAuthencation("irfgoy", "");
		boolean flag5 = authentication.doIRAuthencation("irfgoy", "xxx");
		boolean flag6 = authentication.doIRAuthencation("irfgoyxxx", "IRIT*1qaz");
		
		Assert.assertEquals(true, flag1);
		Assert.assertEquals(true, flag2);
		Assert.assertEquals(true, flag3);
		Assert.assertEquals(false, flag4);
		Assert.assertEquals(false, flag5);
		Assert.assertEquals(false, flag6);
		
	}

}
