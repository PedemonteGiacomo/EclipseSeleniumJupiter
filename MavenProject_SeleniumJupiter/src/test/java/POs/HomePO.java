package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePO extends BasePagePO{

	//locator as fields
	private By FindOwnersButton = By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a/span[2]");
	private By imageHome = By.xpath("/html/body/div/div/div[1]/div/img");
	
	public HomePO(WebDriver driver) {
		super(driver);
		visit("http://localhost:8080/");
	}
	
	public BasePagePO find() {
		click(FindOwnersButton);
		return new FindOwnerPagePO(driver);
	}

	public boolean Displayed() {
		return isIn(imageHome);
	}

}
