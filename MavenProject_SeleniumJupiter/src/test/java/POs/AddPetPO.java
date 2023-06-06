package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddPetPO extends BasePagePO{

	//locator as fields
	private By Pet = By.xpath("/html/body/div/div/h2");
	
	//Owner add form
	private By Name = By.xpath("/html/body/div/div/form/div[1]/div[2]/div/div/input");
	private By Date = By.xpath("/html/body/div/div/form/div[1]/div[3]/div/div/input");
	//private By Type = By.xpath("/html/body/div/div/form/div[1]/div[4]/div/select");
	//private By Bird = By.xpath("/html/body/div/div/form/div[1]/div[4]/div/select/option[1]");
	private By AddPet = By.xpath("//button[@type='submit']");
	
	//notEmptyFields
	private By notEmptyFieldsOrAlreadyUsed = By.xpath("/html/body/div/div/form/div[1]/div[2]/div/span[2]");
	//private By notAlreadyUsed = By.xpath("/html/body/div/div/form/div[1]/div[2]/div/span[2]");
	private String lastname;
	private String url;
	
	
	public AddPetPO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		url = "http://localhost:8080/owners/1/pets/new";
		visit(url);
	}
	
	public AddPetPO(WebDriver driver, String lastName) {
		// TODO Auto-generated constructor stub
		super(driver);
		url = "http://localhost:8080/owners/1/pets/new";
		visit(url);
		lastname = lastName;
	}
	
	public BasePagePO fill(String name, String bdate, String type) throws InterruptedException {
		type(Name, name);
		type(Date, bdate);
		// since we don't need to do nothing to go to the bird I set to do nothing
		Thread.sleep(1500);
		click(AddPet);
		Thread.sleep(1500);
		String getUrl = getUrl();
		if(getUrl.equals(url))return this;
		else return new OwnerPO(driver, lastname);
	}

	public boolean Displayed() {
		return isIn(Pet);
	}
	
	public boolean ShouldNotBeEmptyOrAlreadyPresent() {
		return isIn(notEmptyFieldsOrAlreadyUsed);
	}

}
