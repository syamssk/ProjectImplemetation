package testcases;

import org.testng.annotations.Test;
import utils.DP006;
import wrappers.GenericWrappers;

public class TC006 extends GenericWrappers {
@Test(dataProvider="ssk",dataProviderClass=DP006.class)
  
  public void BookYourCoach_FTR(String id, String password, String confirmpassword, String securityquestion, String securityanswer, String DOByear, String DOBmonth, String email, String occupation, String firstname, String middlename, String lastname, String nationality, String flat, String street, String area, String country, String mobile, String pincode, String postoffice, String offflat, String offstreet, String offarea, String offcountry, String offmobile, String offpincode, String offpostoffice) {
	invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
	//MouseHoverByXpath("//a[text()=' HOLIDAYS ']");
	clickByLink("HOLIDAYS");
	clickByLink("Stays");
	clickByLink("Lounge");
	switchToLastWindow();
	clickByXpath("//*[@id=\"sidebarCollapse\"]/i");
	clickByLink("Book Your Coach/Train");
	switchToLastWindow();
    clickByLink("New User? Signup");
    enterById("userId",id);
    enterById("password",password);
    enterById("cnfPassword",confirmpassword);
    selectVisibileTextById("secQstn",securityquestion);
    enterById("secAnswer",securityanswer);
    clickById("dateOfBirth");
    selectVisibileTextByXpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]",DOByear);
    selectVisibileTextByXpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]",DOBmonth);
    clickByLink("20");
    clickById("gender0");
    clickById("maritalStatus1");
    enterById("email",email);
    selectVisibileTextById("occupation",occupation);
    enterById("fname",firstname);
    enterById("mname",middlename);
    enterById("lname",lastname);
    selectVisibileTextById("natinality",nationality);
    enterById("flatNo",flat);
    enterById("street",street);
    enterById("area",area);
    selectVisibileTextById("country",country);
    enterById("mobile",mobile);
    enterById("pincode",pincode);
    TABkey();
    selectVisibileTextById("postOffice",postoffice);
    pagedown();
    waitProperty(1000);
    clickById("sameAddresses1");
    enterById("flatNoOffice",offflat);
    enterById("streetOffice",offstreet);
    enterById("areaOffice",offarea);
    selectVisibileTextById("countryOffice",offcountry);
    enterById("mobileOffice",offmobile);
    enterById("pincodeOffice",offpincode);
    TABkey();
    selectVisibileTextById("postOfficeOffice",offpostoffice);
    pagedown();
    //closeAllBrowsers();
}
}