package testcases;

import org.testng.annotations.Test;

import utils.DP001;
import wrappers.GenericWrappers;

public class TC001 extends GenericWrappers{
	
	@Test(dataProvider="fetchData", dataProviderClass=DP001.class)
	public void facebookSignUp(String firstName, String lastName, String email, String confirmEmail, String password, String date, String month, String year) {
		
		int dateDOB = Integer.parseInt(date);
		
		//invokeApp("chrome", "http://www.facebook.com");
		clickByLink("English (UK)");
		//clickByXpath("//a[contains(text(),'Create')][1]");xpathcreated
		clickByLink("Create New Account");
		waitProperty(1000);
		enterByName("firstname", firstName);
		enterByName("lastname", lastName);
		enterByName("reg_email__", email);
		enterByName("reg_email_confirmation__", confirmEmail);
		enterById("password_step_input", password);
		waitProperty(1000);
		selectIndexById("day", dateDOB);
		selectVisibileTextById("month", month);
		selectVisibileTextById("year", year);
		clickByXpath("(//input[@name='sex'])[2]");
	}
}
