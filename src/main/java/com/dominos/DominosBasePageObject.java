package com.dominos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dominos.utils.Configuration;

public class DominosBasePageObject {

	protected AndroidDriver driver;
	private WebDriverWait wait;
	protected DesiredCapabilities capabilities;
	protected Configuration conf;

	protected DominosBasePageObject(AndroidDriver driver) {
		this.driver = driver;
		try {
			conf = Configuration.GetInstance();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		capabilities = new DesiredCapabilities();
		File app = new File(conf.getFileName());
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", conf.getDeviceName());
		capabilities.setCapability(CapabilityType.VERSION,
				conf.getCapabilityVersion());
		capabilities.setCapability("platformName", conf.getPlatformName());
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", conf.getAppPackage());
		capabilities.setCapability("rotatable", true);
		capabilities.setCapability("appActivity", conf.getActivityName());

	}

	public void init() {
		try {
			driver = new AndroidDriver(new URL(conf.getAppiumURL()),
					capabilities);
			wait = new WebDriverWait(driver, 30);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected WebElement FindWebElementByName(final String elementName) {

		return driver.findElement(By.name(elementName));
	}

	protected WebElement FindWebElementByIndex(int index) {
		WebElement element = driver
				.findElementByAndroidUIAutomator("new UiSelector().index("
						+ index + ")");
		return element;
	}

	protected WebElement FindWebElementById(final String elementID) {

		return driver.findElement(By.id(elementID));
	}

	protected void FillInputFieldWebElement(WebElement element, String text) {
		element.sendKeys(text);
	}

	protected WebElement UntilElementAppear(String elementID) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id(elementID)));
	}

	protected void FillInputFieldByUIAutomator(String className, int index,
			String text) {
		WebElement element = driver
				.findElementByAndroidUIAutomator("new UiSelector().className(\""
						+ className + "\").index(" + index + ")");

		FillInputFieldWebElement(element, text);
	}
	
	protected void FindInputFieldByUIAutomatorAndClick(String className, int index) {
		WebElement element = driver
				.findElementByAndroidUIAutomator("new UiSelector().className(\""
						+ className + "\").index(" + index + ")");
		System.out.println(element.getText());

		element.click();
	}
	
	protected void FindInputFieldByUIAutomatorByTextAndClick(String text) {
		WebElement element = driver
				.findElementByAndroidUIAutomator("new UiSelector().textStartsWith(\""
						+ text + "\")");

		element.click();
	}

	protected WebElement UntilElementAppearByClass(String elementID) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(elementID)));
	}


	public void close() {
		driver.close();
	}

}
