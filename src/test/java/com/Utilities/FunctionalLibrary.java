package com.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FunctionalLibrary {

	WebDriver driver;

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public void loadUrl(String url) {
		driver.get(url);
	}

	public void Maximize() {
		driver.manage().window().maximize();

	}

	public void implicitWait() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void type(WebElement element, String data) {

		element.sendKeys(data);

	}

	public void click(WebElement element) {

		element.click();

	}

	public void quit() {

		driver.quit();

	}

	public void close() {

		driver.close();

	}

	public void typeJS(WebElement element, String data) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + data + "')", element);

	}

	public void clickJS(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	public void selectByAttribute(WebElement element, String data) {

		new Select(element).selectByValue(data);
	}

	public void selectByIndex(WebElement element, int index) {

		new Select(element).selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String data) {

		new Select(element).selectByVisibleText(data);
	}

	public String getArrtribute(WebElement element) {

		return element.getAttribute("value");

	}

	public String getText(WebElement element) {

		return element.getText();
	}

	public String getTitle() {

		return driver.getTitle();

	}

	public String getUrl() {

		return driver.getCurrentUrl();
	}

	public void switchToWindow(String window) {

		if (window.equals("parentWindow")) {

			String pWid = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			List<String> listWindows = new ArrayList<String>();
			listWindows.addAll(allWindows);
			driver.switchTo().window(listWindows.get(0));
		} else if (window.equals("childWindow")) {

			String pWid = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			List<String> listWindows = new ArrayList<String>();
			listWindows.addAll(allWindows);
			driver.switchTo().window(listWindows.get(1));
		} else {
			System.err.println("Not matching");
		}
	}

	public int framesCount() {
		List<WebElement> lstFrames = driver.findElements(By.tagName("iframe"));
		return lstFrames.size();
	}

	public void switchToFrameByIndex(int index) {

		driver.switchTo().frame(index);
	}

	public void switchToFrameByIdName(String id) {

		driver.switchTo().frame(id);
	}

	public void switchToFrameByElementName(WebElement element) {
		driver.switchTo().frame(element);
	}
}
