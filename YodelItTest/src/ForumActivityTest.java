
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

		//make sure to disallow empty subject box
		Question q = new Question;
		q.subject("");
		q.content("Do you see me");
		try{
			QuestionList.postQuestion(q);
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Illegal Action: Subject is Empty");
		}
		
		//make sure to disallow empty content/question box
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
		
		//make sure to disallow empty content/answer box
		Answer a = new Answer;
		a.content("");
		try{
			AnswerList.postAnswer(a);
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Illegal Action: Content is Empty");
		}
		a.content("I have an answer now");
		AnswerList.postAnswer(a);
		assertEquals("Okay", 1, AnswerList.getCount());
		//add answers and make sure the count number goes up
	}
	
	public void testPostReply(){
		//test for question reply
		//assert it is not empty
		
		//make sure to disallow empty content/reply box
		Reply r = new Reply;
		r.content("");
		try{
			ReplyList.postAnswer(r);
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Illegal Action: Content is Empty");
		}
		r.content("I have a reply now");
		ReplyList.postAnswer(r);
		assertEquals("Okay", 1, ReplyList.getCount());
		//add answers and make sure the count number goes up
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
