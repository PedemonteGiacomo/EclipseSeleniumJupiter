package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OwnerPO extends BasePagePO{

	//locator as fields
	private By Owner_individual = By.xpath("//th[contains(text(),'Name')]");
		
	//when the individual owner is targeted
	private By EditOwner = By.xpath("//a[contains(text(),'Owner')]");
	private By AddNewPet = By.xpath("//a[contains(text(),'New Pet')]");
	private By EditPet = By.xpath("/html/body/div/div/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/a");

	private By NotFound = By.xpath("//p[contains(text(),'has not been found')]");
	private String lastname;
	private By changedDatePet = By.xpath("/html/body/div/div/table[2]/tbody/tr[1]/td[1]/dl/dd[2]");
	private By changedTypePet = By.xpath("/html/body/div/div/table[2]/tbody/tr[1]/td[1]/dl/dd[3]");
	
	public OwnerPO(WebDriver driver, String lastName) {
		// TODO Auto-generated constructor stub
		super(driver);
		String url = "http://localhost:8080/owners?lastName=" + lastName;
		visit(url);
		lastname = lastName;
	}
	
	public BasePagePO add() {
		click(AddNewPet);
		return new AddPetPO(driver, lastname);
	}
	
	public BasePagePO editPet() {
		click(EditPet);
		return new EditPetPO(driver, lastname);
	}

	public boolean Displayed() {
		return isIn(Owner_individual);
	}
	
	public boolean NotFound() {
		return isIn(NotFound);
	}
	
	public boolean changedData(String data) {
		return find(changedDatePet).getText().equals(data);
	}
	
	public boolean changedTypePet(String type) {
		return find(changedTypePet).getText().equals(type);
	}
}
