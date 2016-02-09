package com.dominos;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DominosHomePage extends DominosBasePageObject {	
	private static DominosHomePage instance;
	protected static Object lock = new Object();

	public DominosHomePage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static DominosHomePage GetInstance(AndroidDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new DominosHomePage(driver);

				}
			}
		}

		return instance;

	}

	
	public DominosLoginPage openLoginPage() {
		
		UntilElementAppear("android:id/home");
		FindWebElementById("android:id/home").click();
		FindWebElementById("tr.com.dominos:id/profileLoginLayout").click();
		return new DominosLoginPage(driver);
		
	}
	
	public PizzasPages openPizzaPage(){
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FindInputFieldByUIAutomatorAndClick("android.view.View", 10);
		return new PizzasPages(driver);
	}

}
