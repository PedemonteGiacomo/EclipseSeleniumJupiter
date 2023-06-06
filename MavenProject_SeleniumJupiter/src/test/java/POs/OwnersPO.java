package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OwnersPO extends BasePagePO{

	//locator as fields
	private By Owners_list = By.xpath("//h2[contains(text(),'Owners')]");
	private By Franklin = By.xpath("//a[contains(text(),'George Franklin')]");
	
	public OwnersPO(WebDriver driver) {
		super(driver);
		String url = "http://localhost:8080/owners?lastName=";
		visit(url);
	}
	
	public BasePagePO choose() {
		click(Franklin);
		return new OwnerPO(driver,"Franklin");
	}

	public boolean Displayed() {
		return isIn(Owners_list);
	}
}
