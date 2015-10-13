package com.dominos;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dominos.utils.Configuration;

public class DominosLoginPage extends DominosBasePageObject {

	private static DominosLoginPage instance;
	protected static Object lock = new Object();
	

	public DominosLoginPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static DominosLoginPage GetInstance(AndroidDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new DominosLoginPage(driver);

				}
			}
		}

		return instance;

	}


	public DominosHomePage enterCredentials() {	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		FindWebElementById("android:id/home").click();
		FillInputFieldByUIAutomator("android.widget.EditText",1,conf.getUsername());
		FillInputFieldByUIAutomator("android.widget.EditText",2,conf.getPassword());
		FindWebElementByIndex(5).click();
		
		return new DominosHomePage(driver);

	}


 }
