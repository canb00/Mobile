package com.dominos;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends DominosBasePageObject {

	private static PaymentPage instance;
	protected static Object lock = new Object();

	public PaymentPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static PaymentPage GetInstance(AndroidDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new PaymentPage(driver);

				}
			}
		}

		return instance;

	}

	public void makePayment() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FindInputFieldByUIAutomatorAndClick("android.widget.Button", 14);
		FindInputFieldByUIAutomatorAndClick("android.widget.TextView", 3);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FindInputFieldByUIAutomatorAndClick("android.view.View", 25);

	}

}
