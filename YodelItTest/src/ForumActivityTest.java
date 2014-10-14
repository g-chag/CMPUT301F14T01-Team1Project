
public class ForumActivityTest extends ActivityInstrumentationTestCase2<ForumActivity>{
	
	public ForumActivityTest(){
		super(ForumActivity.class);
	}
	
	public void testCategoryView(){
		//test for view display
		//assert not empty and number of items equal 
		//the number of expected category
	}
	
	public void testPostQuestion(){
		//test for question posting
		//assert it is not empty
		
		Question q = new Question("Do you see me?");
		QuestionList.postQuestion(q);
		assertEquals("Okay", 1, QuestionList.getCount());
		Question q2 = new Question("Do you see me now?");
		assertEquals("Okay", 2, QuestionList.getCount());
	}
	
	public void testPostAnswer(){
		//test for answer posting
		//assert it is not empty
		
		Answer a = new Answer("Yeah I see you");
		AnswerList.postAnswer(q);
		assertEquals("Okay", 1, AnswerList.getCount());
		Answer a2 = new Answer("Yeah I see you again");
		assertEquals("Okay", 2, AnswerList.getCount());
	}
	
	public void testPostReply(){
		//test for question reply
		//assert it is not empty
		
		Reply r = new Reply("I am replying now");
		ReplyList.postReply(r);
		assertEquals("Okay", 1, ReplyList.getCount());
		Reply r2 = new Reply("I am replying again");
		assertEquals("Okay", 2, ReplyList.getCount());
	}
	
	public void testPictureAttachment(){
		//test the uploaded picture size
		//assert error is raised when file bigger than 64kb
		Picture pic = new Picture(/*picture path*/);
		try{
			PicUpload.uploadPicture(pic);
			fail();
		} catch(Exception e){
			assertEquals(e.getMessage(), "Illegal Picture Size Exception");	
		}
	}
	
	public void testQAview(){
		//test for view display for questions and answers
		//assert that question is not empty
	}
	
	public void testReplyView(){
		//test for view display for replies on questions
		//assert that replies view is not empty after adding a reply
	}
	
	public void testUserTextView(){
		
	}
	
}
