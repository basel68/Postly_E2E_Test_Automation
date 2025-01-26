package PostlyTests;

import org.example.PageObjectModel.AddCategory;
import org.example.PageObjectModel.CategoryList;
import org.example.PageObjectModel.NavBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryListTests extends BaseTest{
    CategoryList categoryList;
    @BeforeMethod
    public void childSetup(){
        NavBar navBar=new NavBar(driver);
        navBar.navigateToCategoryListPage();
        categoryList=new CategoryList(driver);
        categoryList.waitUntilPageObjectIsLoaded();
    }
    @Test
    public void categoryListSearch(){
        String categorySearched="Devops";
        categoryList.searchCategory("Devops");
        List<String> categories=categoryList.getCategoryNameList();
        for(String category:categories){
            category=category.toLowerCase();
            Assert.assertTrue(category.contains(categorySearched));
        }
    }
    @Test
    public void sortCategoryListAsc(){
        categoryList.sortAscCategory();
        List<String> actualCategories=categoryList.getCategoryNameList();
        categoryList.waitUntilPageObjectIsLoaded();
        for (int i = 0; i < actualCategories.size() - 1; i++) {
            Assert.assertTrue(
                    actualCategories.get(i).compareTo(actualCategories.get(i + 1)) <= 0,
                    "The list is not sorted in ascending order! Element " + actualCategories.get(i) +
                            " is greater than " + actualCategories.get(i + 1)
            );
        }
    }
    @Test
    public void sortCategoryListDesc(){
        categoryList.sortDescCategory();
        List<String> actualCategories=categoryList.getCategoryNameList();
        categoryList.waitUntilPageObjectIsLoaded();
        for (int i = 0; i < actualCategories.size() - 1; i++) {
            Assert.assertTrue(
                    actualCategories.get(i).compareTo(actualCategories.get(i + 1)) >= 0,
                    "The list is not sorted in descending order! Element " + actualCategories.get(i) +
                            " is less than " + actualCategories.get(i + 1)
            );
        }
    }
    @Test
    public void categoryListPagination(){
        List<String> categoryIds=categoryList.getCategoryIdList();
        categoryList.goToNextPage();
        categoryList.waitUntilPageObjectIsLoaded();
        List<String> newCategories=categoryList.getCategoryIdList();
        for(String categoryId:categoryIds){
            Assert.assertFalse(newCategories.contains(categoryId));
        }
        categoryList.goToPreviousPage();
        categoryList.waitUntilPageObjectIsLoaded();
        newCategories=categoryList.getCategoryIdList();
        for(String categoryId:categoryIds){
            System.out.println(categoryId);
            Assert.assertTrue(newCategories.contains(categoryId));
        }
    }
    @Test
    public void addCategory() {
        AddCategory addCategory=new AddCategory(driver);
        categoryList.clickAddCategoryButton();
        addCategory.waitForPageToLoad();
        CategoryList categoryList=addCategory.addCategory("NLP","dummyUrl");
        categoryList.waitUntilPageObjectIsLoaded();
        List<String> categories=categoryList.getCategoryNameList();
        Assert.assertTrue(categories.contains("NLP"));
    }
}
