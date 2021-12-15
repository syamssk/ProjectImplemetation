package testcases;
import org.testng.annotations.Test;

import utils.DP002;
import wrappers.GenericWrappers;

public class TC002 extends GenericWrappers{
	
@Test(dataProvider="ssk", dataProviderClass=DP002.class)
   public void PHPTravels(String firstName,String lastName,String email,String phone,String companyName,String address1,String address2,String city,String state,String 
		   postcode,String country,String customfield1, String customfield2) {
	
	int cf = Integer.parseInt(customfield1);
	invokeApp("chrome", "https://www.phptravels.org/register.php");
	enterById("inputFirstName", firstName);
	enterById("inputLastName", lastName);
	enterById("inputEmail", email);
	enterById("inputPhone", phone);
	enterById("inputCompanyName", companyName);
	enterById("inputAddress1", address1);
	enterById("inputAddress2", address2);
	enterById("inputCity", city);
	enterById("stateinput", state);
	enterById("inputPostcode", postcode);
	selectVisibileTextById("inputCountry", country);
	selectIndexById("customfield1", cf);
	enterById("customfield2", customfield2);
	clickByXpath("//*[@id=\"containerPassword\"]/div[4]/div/button");
	waitProperty(1000);
	clickByXpath("//*[@id=\"modalGeneratePassword\"]/div/div/div[2]/div[4]/div/button[1]");
	clickById("btnGeneratePasswordInsert");
	clickByClassName("bootstrap-switch-label");
  }
}
