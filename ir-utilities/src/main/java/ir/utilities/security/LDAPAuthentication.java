package ir.utilities.security;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.commons.lang3.StringUtils;

public class LDAPAuthentication {

	public boolean doIRAuthencation(String username, String password) {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return false;
		}

		String host = "10.192.45.42";
		String port = "389";
		String domain = "Corp";
		if (!username.contains(domain)) {
			username = username + "@" + domain;
		}

		return doAuthentication(host, port, username, password);
	}

	/**
	 * 
	 * @param host
	 * @param port
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean doAuthentication(String host, String port, String username, String password) {
		DirContext ctx = null;
		Hashtable<String, String> HashEnv = new Hashtable<String, String>();
		HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); 	// LDAP security level(none,simple,strong)
		HashEnv.put(Context.SECURITY_PRINCIPAL, username); 			// AD user name
		HashEnv.put(Context.SECURITY_CREDENTIALS, password); 		// AD password
		HashEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // LDAP factory
		HashEnv.put("com.sun.jndi.ldap.connect.timeout", "3000");	// 3 seconds
		HashEnv.put(Context.PROVIDER_URL, "ldap://" + host + ":" + port);	// port, default: 389
		try {
			ctx = new InitialDirContext(HashEnv);	// initial directory context
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		} finally {
			if (null != ctx) {
				try {
					ctx.close();
					ctx = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
