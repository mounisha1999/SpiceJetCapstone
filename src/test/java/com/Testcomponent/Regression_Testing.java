package com.Testcomponent;

import org.testng.annotations.Test;

import com.Basecomponent.BaseClass;
import com.Pagecomponent.Booking;
import com.Pagecomponent.FlightsSearch;
import com.Pagecomponent.LoginPage;
import com.Pagecomponent.SignUp;

public class Regression_Testing extends BaseClass {

	@Test
	public void Valid_credentials() throws Throwable {

		SignUp sp = new SignUp();
		sp.signupCode();
	}

	public void search_flights_Oneway() {
		try {
			FlightsSearch flightsearch = new FlightsSearch();
			flightsearch.oneWay_Trip();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void valid_username_Password() {
		try {
			LoginPage loginpage = new LoginPage();
			loginpage.valid_Login(readProperty("Username"), readProperty("Password"));
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@Test
	public void inValidUsername_InvalidPassword() {
		try {
			LoginPage loginpage = new LoginPage();
			loginpage.invalid_Login(readProperty("Password"), readProperty("Username"));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Test
	public void blank_Username_Password() {
		try {
			LoginPage loginpage = new LoginPage();
			loginpage.blank_Login_code(readProperty(""), readProperty(""));
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@Test
	public void booking_validation() {
		try {
			Booking booking = new Booking();
			FlightsSearch searchflight = new FlightsSearch();
			searchflight.oneWay_Trip();
			booking.booking_Code();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
