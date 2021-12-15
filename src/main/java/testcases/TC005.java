package testcases;

import org.testng.annotations.Test;
import utils.DP005;
import wrappers.GenericWrappers;

public class TC005 extends GenericWrappers {
@Test(dataProvider="ssk", dataProviderClass=DP005.class)
 
 public void IRCTCSignUp(String name, String password, String confirmpassword, String securityanswer, String firstname, String middlename, String lastname, String DOByear, String DOBmonth, String country, String email, String mobile, String country1, String address1, String address2, String address3, String pincode, String district, String postoffice, String phone, String offAddress1, String offAddress2, String offAddress3, String offPinCode, String offstate, String offcity, String offpostoffice, String offphone) {
	invokeApp("chrome", " https://www.irctc.co.in/nget/train-search");
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
	clickByLink("REGISTER");
	waitProperty(2000);
	enterById("userName",name);
	enterById("usrPwd",password);
	enterById("cnfUsrPwd",confirmpassword);
	clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div");
	clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li");
	clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div");
	clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li");
	enterByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[7]/input",securityanswer);
	clickByXpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button");
	waitProperty(1000);
	enterById("firstName",firstname);
	enterById("middleName",middlename);
	enterById("lastname",lastname);
	clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[5]/p-dropdown/div");
	clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[6]/li/span");
	clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/input");
	selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[1]/div/select[2]",DOByear);
	selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[1]/div/select[1]",DOBmonth);
	waitProperty(1000);
	clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[2]/table/tbody/tr[4]/td[4]/a");
	clickByXpath("//*[@id=\"unmarried\"]/div/div[2]");
	selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[8]/select",country);
	clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[9]/p-selectbutton/div/div[1]/span");
	enterById("email",email);
	enterById("mobile",mobile);
	selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[13]/select",country1);
	clickByXpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button");
	waitProperty(1000);
	enterById("resAddress1",address1);
	enterById("resAddress2",address2);
	enterById("resAddress3",address3);
	enterByName("resPinCode",pincode);
	TABkey();
    selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[6]/select",district);
    selectVisibileTextByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[7]/select",postoffice);
    enterById("resPhone",phone);
    clickByXpath("//*[@id=\"no\"]/div/div[2]");
    enterById("offAddress1",offAddress1);
    enterById("offAddress2",offAddress2);
    enterById("offAddress3",offAddress3);
    clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[10]/div[4]/p-dropdown/div");
    clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[10]/div[4]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[105]/li");
    enterById("offPinCode",offPinCode);
    enterById("offState",offstate);
    enterById("offCity",offcity);
    enterById("offPostOff",offpostoffice);
    enterById("offPhone",offphone);
    clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[13]/span[1]");
    //closeAllBrowsers();
 }
}