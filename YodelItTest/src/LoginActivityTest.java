
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity>{
	
	public LoginActivityTest(){
		super(LoginActivity.class);
	}
	
	public void testGetID(){
		//test for ID input from users
		//assert that it is a viable string and
		//within login ID length
	}
	
	public void testGetPass(){
		//test for password input from users
		//assert that it is not longer than the
		//allowed password length
	}
}
