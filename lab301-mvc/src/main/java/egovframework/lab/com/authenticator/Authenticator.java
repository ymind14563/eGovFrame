package egovframework.lab.com.authenticator;

import javax.naming.AuthenticationException;

public interface Authenticator {

	public boolean authenticate(String id, String password) throws AuthenticationException;
}
