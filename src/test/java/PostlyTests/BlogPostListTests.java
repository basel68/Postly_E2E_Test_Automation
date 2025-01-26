package PostlyTests;

import org.example.PageObjectModel.AddBlogpost;
import org.example.PageObjectModel.BlogpostList;
import org.example.PageObjectModel.CategoryList;
import org.example.PageObjectModel.NavBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BlogPostListTests extends BaseTest{
    BlogpostList blogpostList;
    @BeforeMethod
    public void childSetup(){
        NavBar navBar=new NavBar(driver);
        navBar.navigateToBlogpostListPage();
        blogpostList=new BlogpostList(driver);
        blogpostList.waitUntilPageObjectIsLoaded();
    }
    @Test
    public void blogPostListIsTruthy(){
        List<String> blogpostTitles=blogpostList.getBlogpostTitleList();
        Assert.assertFalse(blogpostTitles.isEmpty());
    }
    @Test
    public void addBlogpost(){
        AddBlogpost addBlogpost=new AddBlogpost(driver);
        blogpostList.clickAddBlogpostButton();
        addBlogpost.waitUntilPageIsLoaded();
        blogpostList=addBlogpost.addBlogPost("Test","htpp//djsadaj.com","trying out the functionality","","Bassel");
        blogpostList.waitUntilPageObjectIsLoaded();
        List<String> blogpostTitles=blogpostList.getBlogpostTitleList();
        Assert.assertTrue(blogpostTitles.contains("Test"));
    }
}
