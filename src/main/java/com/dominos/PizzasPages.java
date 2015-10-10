package com.dominos;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PizzasPages extends DominosBasePageObject {
	
	private static PizzasPages instance;
	protected static Object lock = new Object();

	public PizzasPages(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static PizzasPages GetInstance(AndroidDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new PizzasPages(driver);

				}
			}
		}

		return instance;

	}
	
	public PizzaDetailPage selectPizza(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		UntilElementAppear("tr.com.dominos:id/actionbar_wrapper");
		
		FindInputFieldByUIAutomatorAndClick("android.view.View",2);
	return new PizzaDetailPage(driver);
		
	}


	
}
