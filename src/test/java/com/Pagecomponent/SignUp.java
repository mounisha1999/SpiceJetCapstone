package com.Pagecomponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebUtils;

public class SignUp extends WebUtils {

	@FindBy(xpath = "//div[text()='Signup']")
	WebElement signup;

	@FindBy(xpath = "//select[@class='form-control form-select ']")
	WebElement selecttitletosignup;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstnametosignup;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastnametexttosignup;

	@FindBy(xpath = "//select[@class='form-control form-select' and @tabindex='0']")
	WebElement selectcountry;

	@FindBy(xpath = "//input[@id='dobDate']")
	WebElement dateofbirth;

	@FindBy(xpath = "//input[normalize-space(@type)='tel']")
	WebElement phonenumber;

	@FindBy(xpath = "//input[@id='email_id']")
	WebElement emailid;

	@FindBy(xpath = "//input[@id='new-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='c-password']")
	WebElement conformpassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement button;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[1]")
	WebElement CheckIn;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[2]")
	WebElement FlightStatus;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[3]")
	WebElement ManageBooking;

	public SignUp() {
		PageFactory.initElements(WebUtils.driver, this);
	}

	public void signupCode() throws Throwable {
		try {
			clickbutton(signup);
			implicitWait(3);
			windowHandles();
			selectDownVisible(selecttitletosignup, "Mrs");
			sendkey(firstnametosignup, readProperty("firstname"));
			sendkey(lastnametexttosignup, readProperty("lastname"));
			sendkey(dateofbirth, readProperty("dateofbirth"));
			selectDownVisible(selectcountry, "India");
			sendkey(phonenumber, readProperty("mobilenumber"));
			sendkey(emailid, readProperty("emailid"));
			sendkey(password, readProperty("Password"));
			sendkey(conformpassword, readProperty("Password"));
			clickbutton(checkbox);
			clickbutton(checkbox);
			getScreenShot("button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
