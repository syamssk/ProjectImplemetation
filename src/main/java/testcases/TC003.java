package testcases;
import org.testng.annotations.Test;
import utils.DP003;
import wrappers.GenericWrappers;

public class TC003 extends GenericWrappers {
@Test(dataProvider="ssk", dataProviderClass=DP003.class)

    public void PANInd(String title, String firstname, String middlename, String lastname, String Ffirstname, String Fmiddlename, String Flastname, String mobile, String email, String income, String dob, String address1, String address2, String city, String state, String pincode, String country, String officename, String offadd1, String offadd2, String offcity, String offstate, String offpincode, String offcountry, String IDproof, String Addproof, String DOBproof, String Aadharproof, String offAddproof) {
	int country1=Integer.parseInt(country);
	int country2=Integer.parseInt(offcountry);
	invokeApp("chrome", "https://panind.com/india/new_pan/");
	selectVisibileTextById("pan_title",title);
	enterById("pan_firstname",firstname);
	enterById("pan_middlename",middlename);
	enterById("pan_lastname",lastname);
	enterById("pan_fatherfirstname",Ffirstname);
	enterById("pan_fathermiddlename",Fmiddlename);
	enterById("pan_fatherlastname",Flastname);
	enterById("pan_mobilenumber",mobile);
	enterById("pan_email",email);
	selectVisibileTextById("pan_sourceofincome",income);
	clickById("office");
	enterById("pan_dob",dob);
	enterById("pan_addressline1",address1);
	enterById("pan_addressline2",address2);	
	enterById("pan_cityname",city);
	selectVisibileTextById("pan_state",state);
	pagedown();
	enterById("pan_pincode",pincode);
	selectIndexById("pan_country",country1);
	enterById("pan_officename",officename);
	enterById("pan_officeaddressline1",offadd1);
	enterById("pan_officeaddressline2",offadd2);
	enterById("pan_officecityname",offcity);
	selectVisibileTextById("pan_officestate",offstate);
	enterById("pan_officepincode",offpincode);
	selectIndexById("pan_officecountry",country2);
	selectVisibileTextById("pan_identityproof",IDproof);
	selectVisibileTextById("pan_addressproof",Addproof);
	selectVisibileTextById("pan_DOBproof",DOBproof);
	selectVisibileTextById("pan_aadhaarproof",Aadharproof);
	selectVisibileTextById("pan_officeaddressproof",offAddproof);
	pagedown();
	clickById("pan_source");
  }
}
