
public class HomeActivityTest ActivityInstrumentationTestCase2<HomeActivity>{

	public HomeActivityTest(){
		super(HomeActivity.class);
	}
	
	public void testCategoryViewSearch(){
		//test for view display
		//Arbitrary search for categories 
		String searchKey = "Science";
        CategoryList.search(searchKey);        
        List<Category> searched = CategoryList.getCategory();
        assertTrue(searched.get(0).getCate().contains("Science"));
	}
}
