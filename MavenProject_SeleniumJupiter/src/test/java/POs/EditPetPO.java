package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditPetPO extends BasePagePO{

	//locator as fields
	private By EditPet = By.xpath("/html/body/div/div/h2");
	
	//Owner add form
	private By Name = By.xpath("//*[@id=\"name\"]");
	private By Date = By.xpath("//*[@id=\"birthDate\"]");
	private By Type = By.xpath("//*[@id=\"type\"]");
	private By Dog = By.xpath("//*[@id=\"type\"]/option[3]");
	//private By Telephone = By.xpath("//input[@id='telephone']");
	private By ModifyPet = By.xpath("//button[@type='submit']");
	
	//notEmptyFields
	private By notEmptyFieldsOrAlreadyUsed = By.xpath("/html/body/div/div/form/div[1]/div[2]/div/span[2]");
	//private By notAlreadyUsed = By.xpath("/html/body/div/div/form/div[1]/div[2]/div/span[2]");
	private String lastname;
	private String url;
	
	
	public EditPetPO(WebDriver driver) {
		super(driver);
		url = "http://localhost:8080/owners/1/pets/14/edit"; 
		// in this case the last pet url is this one caused by the previous add execution
		visit(url);
	}
	
	public EditPetPO(WebDriver driver, String lastName) {
		super(driver);
		url = "http://localhost:8080/owners/1/pets/14/edit";
		visit(url);
		lastname = lastName;
	}
	
	public BasePagePO modify(String identifier, String modify) throws InterruptedException {
	    if (identifier.equals("name")) {
	    	clearAndType(Name, modify);
	    } else if (identifier.equals("date")) {
	    	clearAndType(Date, modify);
	    } else if (identifier.equals("type")) {
	    	if(modify.equals("dog")) {
	    		click(Type);
	    		click(Dog);
	    	}// do this for all the rest of types
	    }
	    Thread.sleep(1500);
	    click(ModifyPet);
	    String getUrl = getUrl();
	    //if ((identifier.equals("telephone") && (modify.length() > 10 || modify.matches("[a-zA-Z]+"))) || modify == null || modify.isEmpty()) {
	    if (getUrl.equals(url))return this; // if the url remains the same for some reasons should be caused by an error
	    else return new OwnerPO(driver, lastname);
	}

	public boolean Displayed() {
		return isIn(EditPet);
	}
	
	public boolean ShouldNotBeEmptyOrAlreadyPresent() {
		return isIn(notEmptyFieldsOrAlreadyUsed);
	}

}
