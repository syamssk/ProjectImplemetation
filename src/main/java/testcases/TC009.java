package testcases;

import org.testng.annotations.Test;
import utils.DP009;
import wrappers.GenericWrappers;

public class TC009 extends GenericWrappers {
@Test(dataProvider="ssk",dataProviderClass=DP009.class)

	  public void BookHotels_GSTValidation(String email, String mobile, String title, String firstname, String lastname, String gstNo, String companyname, String companyaddress) {
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
		clickByLink("HOLIDAYS");
		clickByLink("Stays");
		clickByLink("Lounge");
		switchToLastWindow();
		clickByLink("Hotels");
		switchToLastWindow();
		clickByLink("Login");
		waitProperty(1000);
		clickByLink("Guest User Login");
		waitProperty(1000);
		enterById("modalLRInput12",email);
		enterById("modalLRInput13",mobile);
		clickByXpath("//*[@id=\"panel8\"]/div[1]/form/div[3]/button");
		waitProperty(1000);
		enterByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[1]/searchbox/input", "Hyderabad");
		waitProperty(1000);
		clickByLink("Hyderabad");
		waitProperty(1000);
		clickByName("dt12");
		clickByXpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[1]/div/button/span");
		clickByXpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-multi-year-view/table/tbody/tr[3]/td[1]");
		clickByXpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-year-view/table/tbody/tr[1]/td[3]");
		waitProperty(1000);
		clickByXpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[4]/td[1]/span");
		clickByName("dt13");
		clickByXpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[1]/div/button/span");
		clickByXpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-multi-year-view/table/tbody/tr[3]/td[1]");
		clickByXpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-year-view/table/tbody/tr[2]/td[1]");
		waitProperty(1000);
		clickByXpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[1]/td[6]");
		clickById("user-data-wrapper-id");
		selectVisibileTextByXpath("//*[@id=\"user-data-wrapper\"]/div[1]/div/div[1]/select", "1");
		selectVisibileTextByXpath("//*[@id=\"user-data-wrapper\"]/div[1]/div/div[2]/select", "3");
		clickByXpath("//*[@id=\"user-data-wrapper\"]/div[2]/button");
		clickByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[5]/button");
		waitProperty(2000);
		clickByXpath("/html/body/app-root/app-fulllayout/div/app-hotellist/main/div/div[2]/div/div[2]/div/div/div[3]/button");
		waitProperty(1000);
		getTextByXpath("/html/body/app-root/app-fulllayout/div/app-hoteldetail/main/div/div/div[2]/h3/a");
		waitProperty(1000);
		getTextByXpath("//*[@id=\"hotel-dtl-sticky-rooms\"]/div[2]/div[2]/div[1]/div");
		clickByXpath("//*[@id=\"hotel-dtl-sticky-photo\"]/div[1]/div[1]/div[2]/div/div/div[4]/button");
		waitProperty(2000);
		selectVisibileTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[1]/div/select",title);
		enterByName("firstName",firstname);
		enterByName("lastName",lastname);
		selectVisibileTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[5]/div/select", "ANDHRA PRADESH");
		selectVisibileTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[8]/div/select", "Yes");
		enterByName("gstNumber",gstNo);
		enterByName("companyName",companyname);
		enterByName("companyAddress",companyaddress);
		clickByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[12]/button[2]");
		verifyTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[9]/div/span", "Please Enter Valid GST Number");
		//closeAllBrowsers();
   }
}