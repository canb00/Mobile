package com.dominos;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PizzaDetailPage extends DominosBasePageObject {

	private static PizzaDetailPage instance;
	protected static Object lock = new Object();

	public PizzaDetailPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static PizzaDetailPage GetInstance(AndroidDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new PizzaDetailPage(driver);

				}
			}
		}

		return instance;

	}

	public PaymentPage selectPizzaProperties() {

		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FindInputFieldByUIAutomatorAndClick("android.widget.RadioButton", 12);
		FindInputFieldByUIAutomatorAndClick("android.widget.RadioButton", 23);
		FindInputFieldByUIAutomatorAndClick("android.view.View", 6);
		FindWebElementById("tr.com.dominos:id/action_repeatbtn").click();
		return new PaymentPage(driver);
	}

}
