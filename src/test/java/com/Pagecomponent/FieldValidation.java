package pagecomponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utilities.WebUtils;

public class FieldValidation extends WebUtils {

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[1]")
	WebElement checkIn;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[2]")
	WebElement flightStatus;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[3]")
	WebElement manageBooking;

	public FieldValidation() {
		PageFactory.initElements(WebUtils.driver, this);
	}

	public void Fields() {
		try {
			String text = getText(checkIn);
			Assert.assertEquals(text, "Check-In");
			test.log(Status.PASS, "checkin is successful");
			String text1 = getText(flightStatus);
			Assert.assertEquals(text1, "Flight Status");
			test.log(Status.PASS, "Flight status is successful");
			String text2 = getText(manageBooking);
			Assert.assertEquals(text2, "Manage Booking");
			test.log(Status.PASS, "ManageBooking is successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "Issue in validating Fields");
			e.printStackTrace();
		}

	}
}