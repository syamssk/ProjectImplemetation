package testcases;



import org.testng.annotations.Test;

import utils.DP007;
import wrappers.GenericWrappers;

public class TC007 extends GenericWrappers {
@Test(dataProvider="ssk",dataProviderClass=DP007.class)

   public void SaloonMandatoryCheck(String name, String organisation, String address, String mobile, String email, String origin, String destination, String year1, String year2, String period, String coach, String Passengers, String purpose, String services) {
	
	invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
	clickByLink("HOLIDAYS");
	clickByLink("Stays");
	clickByLink("Lounge");
	switchToLastWindow();
	clickByXpath("//*[@id=\"sidebarCollapse\"]/i");
	clickByLink("Charter");
	waitProperty(1000);
	clickById("enquiry-tab");
	waitProperty(1000);
	enterByName("name",name);
	enterByName("organization",organisation);
	enterByName("address",address);
	enterByName("mobile",mobile);
	enterByName("email",email);
	selectVisibileTextByXpath("//*[@id=\"enquiry\"]/div/form/div/div[6]/select", "Saloon Charter");
	enterByName("originStation",origin);
	enterByName("destnStation",destination);
	clickByName("checkInDate");
	selectVisibileTextByXpath("//*[@id=\"enquiry\"]/div/form/div/div[9]/div/div/table/thead/tr[1]/th[2]/select",year1);
	clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[9]/div/div/table/thead/tr[1]/th[3]/span[1]");
	clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[9]/div/div/table/thead/tr[1]/th[3]/span[1]"); //Month selected by Double Click
	clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[9]/div/div/table/tbody/tr[3]/td[1]/span");    //Day 15
	clickByName("checkOutDate");
	selectVisibileTextByXpath("//*[@id=\"enquiry\"]/div/form/div/div[10]/div/div/table/thead/tr[1]/th[2]/select",year2);
	clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[10]/div/div/table/thead/tr[1]/th[3]/span[1]");
	clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[10]/div/div/table/thead/tr[1]/th[3]/span[1]");
	clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[10]/div/div/table/thead/tr[1]/th[3]/span[1]");//Month Selected by Triple Click
	clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[10]/div/div/table/tbody/tr[2]/td[6]/span");   //Day 10
	enterByName("durationPeriod",period);
	enterByName("coachDetails",coach);
	enterByName("numPassenger",Passengers);
	enterByName("charterPurpose",purpose);
	enterByName("services",services);
	clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[17]/button");
	verifyTextByXpath("//*[@id=\"enquiry\"]/div/form/div/div[4]/span", "Mobile no not valid.");
	//closeAllBrowsers();
  }
}