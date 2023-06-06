package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.AddPetPO;
import POs.FindOwnerPagePO;
import POs.HomePO;
import POs.OwnerPO;
import POs.OwnersPO;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class TestAddNewPet {
	
	private FindOwnerPagePO find;
	//private OwnerPO not_found;
	private	OwnersPO list;
	private OwnerPO individual;
	private AddPetPO pet;
	private AddPetPO petFailed;
	private HomePO home;

	@Test
	public void testFirstScenario(ChromeDriver driver) throws InterruptedException {
		// start from the home page to check also if the click goes correctly
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		find = (FindOwnerPagePO) home.find();
		assertTrue(find.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) find.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// add pet
		pet = (AddPetPO) individual.add();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		individual = (OwnerPO) pet.fill("Charles", "30051999", null);
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
	}
	
	@Test
	public void testSecondScenario(ChromeDriver driver) throws InterruptedException {
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		find = (FindOwnerPagePO) home.find();
		assertTrue(find.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) find.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// add pet
		pet = (AddPetPO) individual.add();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		petFailed = (AddPetPO) pet.fill("Leo", "30051999", null);
		assertTrue(petFailed.ShouldNotBeEmptyOrAlreadyPresent());
		Thread.sleep(1500);
	}
	
	@Test
	public void testThirdScenario(ChromeDriver driver) throws InterruptedException {
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		find = (FindOwnerPagePO) home.find();
		assertTrue(find.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) find.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// add pet
		pet = (AddPetPO) individual.add();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		petFailed = (AddPetPO) pet.fill("", "30051999", null);
		assertTrue(petFailed.ShouldNotBeEmptyOrAlreadyPresent());
		Thread.sleep(1500);
	}

}

