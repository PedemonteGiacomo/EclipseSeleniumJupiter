package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePagePO {
	protected WebDriver driver;
	
	public BasePagePO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public WebElement find(By element) {
		return driver.findElement(element);
	}
	
	public void click(By element) {
		find(element).click();
	}

	public void type(By element, String text) {
		find(element).sendKeys(text);
	}
	
	public void clearAndType(By element, String text) {
	    find(element).clear();
	    find(element).sendKeys(text);
	}
	
	public boolean isIn(By element) {
		return find(element).isDisplayed();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
}