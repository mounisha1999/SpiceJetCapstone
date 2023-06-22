package com.Pagecomponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utilities.WebUtils;

public class LoginPage extends WebUtils {

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-18tvxmy r-adyw6z r-1kfrs79")
	WebElement Login;

	@FindBy(xpath = "//input[normalize-space(@type)='tel']")
	WebElement userMobileNumber;

	@FindBy(xpath = "//input[@data-testid='password-input-box-cta']")
	WebElement password;

	@FindBy(xpath = "//div[@data-testid='login-cta']")
	WebElement submit;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa")
	WebElement email;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a']")
	WebElement signinValidation;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-1ttbpl1 r-18tvxmy r-1enofrn r-1bymd8e']")
	WebElement signinInvalidValidation;

	public LoginPage() {
		PageFactory.initElements(WebUtils.driver, this);
	}

	public void valid_Login(String Username, String Password) {

		try {
			clickbutton(Login);
			sendkey(userMobileNumber, Username);
			sendkey(password, Password);
			clickbutton(submit);
			String text = getText(signinValidation);
			Assert.assertEquals("N", text);
			implicitWait(15);
			getScreenShot("ValidLoginPage");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void invalid_Login(String Username, String Password) {
		try {
			clickbutton(Login);
			sendkey(userMobileNumber, Username);
			sendkey(password, Password);
			clickbutton(submit);
			String text = getText(signinInvalidValidation);
			Assert.assertEquals("Enter valid mobile number", text);
			implicitWait(10);
			getScreenShot("InvalidLoginPage");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void blank_Login_code(String Username, String Password) {
		try {
			clickbutton(Login);
			sendkey(userMobileNumber, Username);
			sendkey(password, Password);
			clickbutton(submit);
			String text = getText(signinInvalidValidation);
			Assert.assertEquals("Enter valid mobile number", text);
			implicitWait(10);
			getScreenShot("BlankLogin");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}