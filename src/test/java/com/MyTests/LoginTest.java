/**
 * 
 */
package com.MyTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;
import com.util.JiraPolicy;

/**
 * @author NaveenKhunteta
 *
 */
public class LoginTest extends BaseTest{
	
	@JiraPolicy(logTicketReady=false)
	@Test(priority=1, enabled=true)
	public void verifyLoginPageTitleTest(){
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Demo Web SHop");
	}
	
	@JiraPolicy(logTicketReady=true)
	@Test(priority=2, enabled=true)
	public void verifyLoginPageHeaderTest(){
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Get the membership");
	}
	
	@JiraPolicy(logTicketReady=true)
	@Test(priority=3)
	public void doLoginTest(){
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("cnugodari@gmail.com", "Pass@123");
		String headerHome = homePage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "Home");
	}
}


