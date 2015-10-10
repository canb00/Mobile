package com.dominos;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dominos.DominosHomePage;
import com.dominos.utils.Configuration;

public class TestFactory {

	protected AndroidDriver driver;
	Configuration dominosConf;
	DominosHomePage mainPage = DominosHomePage.GetInstance(driver);
	DominosLoginPage loginPage;
	PizzasPages pizzaPages;
	PizzaDetailPage details;
	PaymentPage payment;
	
	@Test
	public void buyPizza() {
		mainPage.init();
		loginPage = mainPage.openLoginPage();
		mainPage = loginPage.enterCredentials();
		pizzaPages = mainPage.openPizzaPage();
		details = pizzaPages.selectPizza();
		payment = details.selectPizzaProperties();
		payment.makePayment();
		
		

	}

}
