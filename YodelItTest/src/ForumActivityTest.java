
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
		
		Question q = new Question;
		q.subject("");
		q.content("Do you see me");
		try{
			QuestionList.postQuestion(q);
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Illegal Action: Subject is Empty");
		}
		
		q.subject("Okay now I have a subject");
		q.content("");
		try{
			QuestionList.postQuestion(q);
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Illegal Action: Content is Empty");
		}
		
		q.subject("Okay now I have a subject");
		q.content("And I have content");		
		QuestionList.postQuestion(q);		
		assertEquals("Okay", 1, QuestionList.getCount());
	}
	
	public void testPostAnswer(){
		//test for answer posting
		//assert it is not empty
		
		Answer a = new Answer("Yeah I see you");
		q.postAnswer(q);
		assertEquals("Okay", 1, AnswerList.getCount());
		Answer a2 = new Answer("Yeah I see you again");
		assertEquals("Okay", 2, AnswerList.getCount());
		
		//add answers and make sure the count number goes up
	}
	
	public void testPostReply(){
		//test for question reply
		//assert it is not empty
		
		Reply r = new Reply("I am replying now");
		q.postReply(r);
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
	public void testSortView(){
		//test for view list to be sorted upon user request
		//assert order is right		
		
		
	}
	
	public void testUpvote(){
		//checking for question upvote now
		Question q = new Question("Upvote this please?");
		QuestionList.postQuestion(q);
		q.upvote();
		assertEquals("Okay", 1, QuestionList.getVoteCount());
		
		//checking for answer upvote now
		
		Answer a = new Answer("Upvote me now bro");
		q.postAnswer(a);
		a.upvote();
		assertEquals("Okay", 1, AnswerList.getVoteCount());
	}
	
	public void testGetAnsCount(){
		Question q = new Question("Upvote this please?");
		QuestionList.postQuestion(q);
		Answer a = new Answer("Upvote me now bro");
		q.postAnswer(a);
		assertEquals("Okay", 1, QuestionList.getAnsCount());
		
	}
	
	public void testSearch(){
		//test for searching
		//		
	}
	
	public void testVisited(){
		Question q = new Question("Upvote this please?");
		QuestionList.postQuestion(q);
		VisitedList.addQuestion(q);
		assertEquals("Okay", 1, VisitedList.getVisitedCount());		
	}
	
	public void testFavuorite(){
		Question q = new Question("Upvote this please?");
		QuestionList.postQuestion(q);
		FavouredList.addQuestion(q);
		assertEquals("Okay", 1, FavouredList.getVisitedCount());		
		
	}
	
	public void testUserNameChange(){
		String newUserName = "Mr. Bean";
		user.UserName = newUserName;
		main.update();
		assertEquals("Okay", UserName, newUserName);
		
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
