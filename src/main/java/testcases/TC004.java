package testcases;

import org.testng.annotations.Test;
import utils.DP004;
import wrappers.GenericWrappers;

public class TC004 extends GenericWrappers {
@Test(dataProvider="ssk", dataProviderClass=DP004.class)

  public void USvisaApplicationForm(String name, String surname, String nativename, String othersurname, String othergivenname, String email, String email1, String addemail, String DOBYear, String DOBMonth, String city, String state, String country, String nationality, String othercountry, String add1, String add2, String contactcity, String contactstate, String pincode, String phone, String contactcountry, String region, String language, String status, String purpose, String locationlanguage) {
	
	invokeApp("chrome", "https://app.onlineusvisa.com/basic-details/in?origin=home&country=in&type=N#");
	enterById("app-given-names",name);
	enterById("app-surname",surname);
	enterById("app-native-name",nativename);
	clickById("other-names-used-Yes");
	enterById("other-surname",othersurname);
	enterById("other-given-names",othergivenname);
	enterById("email",email);
	enterById("email-1",email1);
	pagedown();
	waitProperty(1000);
	clickById("additional-email-Yes");
	enterById("additional-email-detail",addemail);
	clickById("gender-Male");
	clickById("date-of-birth");
	selectVisibileTextByXpath("//*[@id=\"date-of-birth_root\"]/div/div/div/div/div[1]/select[1]",DOBYear);
	selectVisibileTextByXpath("//*[@id=\"date-of-birth_root\"]/div/div/div/div/div[1]/select[2]",DOBMonth);
	waitProperty(1000);
	clickByXpath("//*[@id=\"date-of-birth_table\"]/tbody/tr[1]/td[1]/div");
	enterById("city-of-birth",city);
	enterById("state-of-birth",state);
	selectVisibileTextById("country-of-birth",country);
	selectVisibileTextById("nationality",nationality);
	clickById("select-perm-resident-other-country-Yes");
	selectVisibileTextById("perm-resident-other-country",othercountry);
	clickById("datos-personales-button");
	waitProperty(1000);
	enterById("contact-street",add1);
	enterById("contact-street-2",add2);
	enterById("contact-city",contactcity);
	enterById("contact-state",contactstate);
	enterById("contact-zip",pincode);
	clickByXpath("//*[@id=\"phone-number\"]/div");
	clickByXpath("//*[@id=\"phone-number\"]/ul/li[96]");
	waitProperty(1000);
	enterByXpath("//*[@id=\"phone-number\"]/input[2]",phone);
	clickById("other-phonenumber-No");
	selectVisibileTextById("contact-country",contactcountry);
	pagedown();
	selectVisibileTextById("india-region",region);
	clickById("datos-contacto-button");
	enterById("languages",language);
	selectVisibileTextById("marital-status",status);
	selectVisibileTextById("purpose-of-trip",purpose);
	selectVisibileTextById("application-location-india-language",locationlanguage);
	pagedown();
	waitProperty(1000);
	clickById("accept-terms-");
	//clickById("siguiente");
  }
}