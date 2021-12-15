package testcases;



import org.testng.annotations.Test;

import utils.DP0010;
import wrappers.GenericWrappers;

public class TC0010 extends GenericWrappers {
@Test(dataProvider="ssk",dataProviderClass=DP0010.class)
 
 public void Immigration_FormC(String idname, String password, String cnfpassword, String question, String answer, String username, String gender, String dob, String designation, String emailid, String mobile, String phone, String nationality, String name, String capacity, String address, String state, String district, String accomodation, String rating, String email, String mcontact, String contact, String name1, String address1, String state1, String district1, String email1, String phone1, String mobile1, String name2, String address2, String state2, String district2, String email2, String phone2, String mobile2, String name3, String address3, String state3, String district3, String email3, String phone3, String mobile3) {
	invokeApp("chrome", " https://indianfrro.gov.in/frro/FormC/menuuserreg.jsp");
	clickByLink("Sign Up (Registration)");
	enterById("u_id",idname);
	enterById("u_pwd",password);
	enterById("u_repwd",cnfpassword);
	selectVisibileTextById("u_secques",question);
	enterById("u_secans",answer);
	enterById("u_name",username);
	selectVisibileTextById("u_gender",gender);
	enterById("u_dob",dob);
	enterById("u_designation",designation);
	enterById("u_emailid",emailid);
	enterById("u_mobile",mobile);
	enterById("u_phone",phone);
	selectVisibileTextById("u_nationality",nationality);
	enterById("name",name);
	enterById("capacity",capacity);
	enterById("address",address);
	selectVisibileTextById("state",state);
	waitProperty(1000);
	selectVisibileTextById("city_distr",district);
	selectVisibileTextById("acco_type",accomodation);
	selectVisibileTextById("star_rat",rating);
	enterById("email",email);
	enterById("mcontact",mcontact);
	enterById("contact",contact);
	waitProperty(1000);
	enterByName("name_o",name1);
	enterByName("address_o",address1);
	selectVisibileTextById("state_o",state1);
	waitProperty(1000);
	selectVisibileTextById("citydistr_o",district1);
	enterByName("emailid_o",email1);
	enterByName("phoneno_o",phone1);
	enterByName("mobile_o",mobile1);
	clickByXpath("/html/body/table/tbody/tr[3]/td/form/table/tbody/tr[29]/td/table[2]/tbody/tr/td[2]/input");
	waitProperty(1000);
	enterByName("name_o",name2);
	enterByName("address_o",address2);
	selectVisibileTextById("state_o",state2);
	waitProperty(1000);
	selectVisibileTextById("citydistr_o",district2);
	enterByName("emailid_o",email2);
	enterByName("phoneno_o",phone2);
	enterByName("mobile_o",mobile2);
	clickByXpath("/html/body/table/tbody/tr[3]/td/form/table/tbody/tr[29]/td/table[2]/tbody/tr/td[2]/input");
	waitProperty(1000);
	enterByName("name_o",name3);
	enterByName("address_o",address3);
	selectVisibileTextById("state_o",state3);
	waitProperty(1000);
	selectVisibileTextById("citydistr_o",district3);
	enterByName("emailid_o",email3);
	enterByName("phoneno_o",phone3);
	enterByName("mobile_o",mobile3);
	//closeAllBrowsers();
   }
 }