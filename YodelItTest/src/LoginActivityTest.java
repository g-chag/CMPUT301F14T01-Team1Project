
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity>{
	
	public LoginActivityTest(){
		super(LoginActivity.class);
	}
	
	public void testGetID(){
		//test for ID input from users
		//assert that it is a viable string and
		//within login ID length if needed and
		//make sure that it is not a blank field
		String ID = "";
		try{
			GetID.setID(ID);
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Illegal Action: User name or Password" +
					"is Empty");
		}
		
	}
	
	public void testGetPass(){
		//test for password input from users
		//assert that it is not longer than the
		//allowed password length if needed and 
		//make sure that it is not a blank field
		String password = "";
		try{
			GetID.setPassword(password);
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Illegal Action: User name or Password" +
					"is Empty");
		}
	}
}
