package com.dominos.utils;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	private static Configuration instance;
	private static Object lock = new Object();
	private String fileName;
	private String deviceName;
	private String capabilityVersion;
	private String platformName;
	private String appActivity;
	private String appPackage;
	private String appiumURL;
	
	public String getActivityName() {
		return appActivity;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getCapabilityVersion() {
		return capabilityVersion;
	}

	public void setCapabilityVersion(String capabilityVersion) {
		this.capabilityVersion = capabilityVersion;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getAppActivity() {
		return appActivity;
	}

	public void setAppActivity(String appActivity) {
		this.appActivity = appActivity;
	}

	public String getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

	public String getAppiumURL() {
		return appiumURL;
	}

	public void setAppiumURL(String appiumURL) {
		this.appiumURL = appiumURL;
	}

	private Configuration() {
	}

	public static Configuration GetInstance() throws IOException {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new Configuration();
					instance.LoadData();
				}
			}
		}

		return instance;

	}

	private void LoadData() throws IOException {
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("Dominos.properties"));
		// login
		fileName = props.getProperty("fileName");
		deviceName = props.getProperty("deviceName");
		capabilityVersion = props.getProperty("capabilityVersion");
		platformName = props.getProperty("platformName");
		appPackage = props.getProperty("appPackage");
		appiumURL = props.getProperty("appiumURL");
	}
}
