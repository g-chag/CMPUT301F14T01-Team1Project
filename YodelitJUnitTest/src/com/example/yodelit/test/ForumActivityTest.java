/*
public class ForumActivityTest extends ActivityInstrumentationTestCase2<ForumActivity>{
	
	public ForumActivityTest(){
		super(ForumActivity.class);
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
			ReplyList.postReply(r);
			fail();
		} catch (Exception e){
			assertEquals(e.getMessage(), "Illegal Action: Content is Empty");
		}
		r.content("I have a reply now");
		ReplyList.postReply(r);
		assertEquals("Okay", 1, ReplyList.getCount());
		//add answers and make sure the count number goes up
	}
	
	public void testPictureAttachment(){
		//test the uploaded picture size
		//assert error is raised when file bigger than 64kb
		Picture pic = new Picture
		pic.load(); //picture path);
		try{
			PicLoad.loadPicture(pic);
			fail();
		} catch(Exception e){
			assertEquals(e.getMessage(), "Illegal Picture Size Exception");	
		}
	}
	
	public void testSortView(){
		//test for view list to be sorted upon user request
		//assert order is right for date
		Question q = new Question;
		q.subject("Zebra");
		q.content("Black and White")		
        Calendar date = Calendar.getInstance();
        date.set(Calendar.MONTH, 10);
        date.set(Calendar.DATE, 1);
        date.set(Calendar.YEAR, 2014);
        Date post;
        post = date.getTime();
        q.setDate(post);

		Question q1 = new Question;
		q1.subject("Megalodon");
		q1.content("Scary Grey");
        Calendar date1 = Calendar.getInstance();
        date1.set(Calendar.MONTH, 7);
        date1.set(Calendar.DATE, 1);
        date1.set(Calendar.YEAR, 2014);
        Date post1;
        post1 = date1.getTime();
        q1.setDate(post1);
		

		Question q1 = new Question;
		q1.subject("Megalodon");
		q1.content("Scary Grey");
        Calendar date1 = Calendar.getInstance();
        date1.set(Calendar.MONTH, 7);
        date1.set(Calendar.DATE, 1);
        date1.set(Calendar.YEAR, 2014);
        Date post1;
        post1 = date1.getTime();
        q1.setDate(post1);

		Question q2 = new Question;
		q2.subject("Axolotl");
		q2.content("Weird");		
        Calendar date2 = Calendar.getInstance();
        date2.set(Calendar.MONTH, 9);
        date2.set(Calendar.DATE, 28);
        date2.set(Calendar.YEAR, 2014);
        Date post2;
        post2 = date2.getTime();
        q2.setDate(post2);
        
        QuestionList.postQuestion(q);
        QuestionList.postQuestion(q1);
        QuestionList.postQuestion(q2);
        
        QuestionList.sortDateLatest();
        
        List<Questions> ordered = QuestionList.getQuestions();
        assertTrue(ordered.get(0).getQuestionDate().after(ordered.get(1).getQuestionDate()));
        
        QuestionList.sortDateEarliest();
        
        List<Questions> ordered1 = QuestionList.getQuestions();
        assertTrue(ordered1.get(0).getQuestionDate().after(ordered1.get(1).getQuestionDate()));
        
        //then tests for sorting by picture uploaded
        Question q3 = new Question;
		q3.subject("Godzilla");
		q3.content("Scary and eats buildings");		
        Calendar date3 = Calendar.getInstance();
        date3.set(Calendar.MONTH, 6);
        date3.set(Calendar.DATE, 4);
        date3.set(Calendar.YEAR, 2014);
        Date post3;
        post3 = date3.getTime();
        q3.setDate(post3);
        Picture pic = new Picture
        pic.load(); //picture path);
        q3.upload(pic);
        
        QuestionList.postQuestion(q3);
        assertEquals("Okay", 1, ordered2.get(3).getQuestionPicStatus());
        
        QuestionList.sortByPicture();
        List<Questions> ordered2 = QuestionList.getQuestions();
        assertEquals("Okay", 1, ordered2.get(0).getQuestionPicStatus());
       
  
	}
	
	
	public void testUpvote(){
		//checking for question upvote now
		Question q = new Question;
		q.subject("testing");
		q.content("testing content");
		QuestionList.postQuestion(q);
		q.upvote();
		assertEquals("Okay", 1, QuestionList.getVoteCount());
		
		//checking for answer upvote now
		
		Answer a = new Answer("Upvote me now");
		q.postAnswer(a);
		a.upvote();
		assertEquals("Okay", 1, AnswerList.getVoteCount());
	}
	
	
	public void testGetCount(){
		Question q = new Question;
		q.subject("testing");
		q.content("testing content");
		QuestionList.postQuestion(q);
		Answer a = new Answer;
		a.content("testing answer");
		q.postAnswer(a);
		assertEquals("Okay", 1, AnswerList.getCount());
		assertEquals("Okay", 1, QuestionList.getCount());
		assertEquals("Okay", 1, AnswerList.getVoteCount());
		assertEquals("Okay", 1, QuestionList.getVoteCount());
	}
	
	public void testSearch(){
		//test for searching
		
		Question q1 = new Question;
		q1.subject("Megalodon");
		q1.content("Scary Grey")
		Question q2 = new Question;
		q2.subject("Megalodon continued");
		q2.content("Weird");
		Question q3 = new Question;
		q3.subject("Godzilla");
		q3.content("Scary and eats buildings");	
		Question q4 = new Question;
		q4.subject("Tyrannosaurus rex vs Megalodon");
		q4.content("Bloody");	
	     
        QuestionList.postQuestion(q1);
        QuestionList.postQuestion(q2);
        QuestionList.postQuestion(q3);
        QuestionList.postQuestion(q4);
        
        String searchKey = "Megalodon";
        QuestionList.search("Megalodon");        
        List<Questions> searched = QuestionList.getQuestions();
        
        for (int i = 0; i < 2; i++) {
			assertTrue(searched.get(i).getSubject().contains("Megalodon"));
		}
		
	}
	
	public void testVisited(){
		//testing for adding visited questions
		// to be added into an "archive" list knowing
		// he/she has visited
		Question q = new Question;
		q.subject("testing");
		q.content("testing content");
		QuestionList.postQuestion(q);
		VisitedList.addQuestion(q);
		assertEquals("Okay", 1, VisitedList.getVisitedCount());		
	}
	
	public void testFavourite(){
		//tests the favourite feature similar to the visited
		//except favourite is invoked by the user instead of 
		//by default
		
		Question q = new Question;
		q.subject("testing");
		q.content("testing content");
		QuestionList.postQuestion(q);
		FavouredList.addQuestion(q);
		assertEquals("Okay", 1, FavouredList.getFavouriteCount());		
		
	}
	
	public void testUserNameChange(){
		//ensure username/forum name is changeable
		// and the change actually goes through
		String newUserName = "Mr. Bean";
		user.UserName = newUserName;
		main.update();
		assertEquals("Okay", UserName, newUserName);
		
	}
	
	public void testReplyView(){
		//test for view display for replies on questions
		//assert that replies view is not empty after adding a reply
		Question q = new Question;
		q.subject("testing");
		q.content("testing content");
		QuestionList.postQuestion(q);
		Reply r = new Reply;
		r.subject("reply");
		r.content("testing reply");
		ReplyList.postReply(r);
		assertEquals("okay", "reply", ReplyList.get(0));	
	}

	
}
*/
