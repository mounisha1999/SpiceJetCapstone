package com.Pagecomponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utilities.WebUtils;

public class Booking extends WebUtils {

	@FindBy(xpath = "(//div[@class='-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2")
	WebElement from;

	@FindBy(xpath = "//div[@data-testid='to-testID-destination']")
	WebElement to;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastname;

	@FindBy(id = "email_id")
	WebElement email;

	@FindBy(xpath = "//input[@maxlength='10' and @data-testid='contact-number-input-box']")
	WebElement mobile;

	@FindBy(id = "defaultCheck1")
	WebElement checkboxinsignup;

	@FindBy(xpath = "//input[@maxlength='15'and @class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy']")
	WebElement passportnumber;

	@FindBy(xpath = "(//input[@placeholder='DD/MM/YYYY'])[2]")
	WebElement passportvalidity;

	@FindBy(xpath = "//div[text()='2023']")
	WebElement passportyear;

	@FindBy(xpath = "//div[text()='July']")
	WebElement passportmonth;

	@FindBy(xpath = "//div[text()='29']")
	WebElement passportday;

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement continuepayment;

	public Booking() {
		PageFactory.initElements(WebUtils.driver, this);
	}

	public void booking_Code() {

		try {
			clickbutton(passportvalidity);
			clickbutton(passportyear);
			clickbutton(passportmonth);
			clickbutton(passportday);
			sendkey(firstname, readProperty("firstname"));
			sendkey(lastname, readProperty("lastname"));
			sendkey(email, readProperty("emailid"));
			sendkey(mobile, readProperty("mobilenumber"));
			implicitWait(3);
			clickbutton(from);
			clickbutton(to);
			sendkey(passportnumber, readProperty("passnumber"));
			clickbutton(continuepayment);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
