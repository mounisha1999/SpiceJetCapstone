package com.Pagecomponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.WebUtils;

public class FlightsSearch extends WebUtils {

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'])[2]")
	WebElement roundtrip;

	@FindBy(xpath = "(css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e")
	WebElement returndate;

	@FindBy(xpath = "(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[1]")
	WebElement date;

	@FindBy(xpath = "(//div[text()='20'])[9]")
	WebElement depdate;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")
	WebElement arrow;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement from;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement To;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement SearchFlights;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")
	WebElement validation;

	public FlightsSearch() {
		PageFactory.initElements(WebUtils.driver, this);
	}

	public void oneWay_Trip() {
		try {
			sendkey(from, "BOM");
			sendkey(To, "BKK");
			for (int i = 1; i <= 4; i++) {
				click(arrow);
			}
			implicitWait(10);
			clickbutton(depdate);
			clickbutton(SearchFlights);
			String text = getText(validation);
			Assert.assertEquals("Select your Departure to Bangkok", text);
			getScreenShot("OnewayTrip");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void round_Trip() {
		try {
			clickbutton(roundtrip);
			sendkey(from, "BOM");
			sendkey(To, "BKK");
			for (int i = 1; i <= 4; i++) {
				click(arrow);
			}
			implicitWait(10);
			clickbutton(depdate);
			clickbutton(returndate);
			clickbutton(SearchFlights);
			String text = getText(validation);
			Assert.assertEquals("Select your Departure to Bangkok", text);
			getScreenShot("Roundtrip");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}