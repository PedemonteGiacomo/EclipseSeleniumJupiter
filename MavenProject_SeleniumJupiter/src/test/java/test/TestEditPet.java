package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.AddPetPO;
import POs.EditPetPO;
import POs.FindOwnerPagePO;
import POs.HomePO;
import POs.OwnerPO;
import POs.OwnersPO;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class TestEditPet {
	
	//change this
	private FindOwnerPagePO find;
	//private OwnerPO not_found;
	private	OwnersPO list;
	private OwnerPO individual;
	private EditPetPO pet;
	private EditPetPO petFailed;
	private HomePO home;

	@Test
	public void testFirstScenario(ChromeDriver driver) throws InterruptedException {
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
		pet = (EditPetPO) individual.editPet();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		individual = (OwnerPO) pet.modify("date", "10102020");
				//pet.modify("Charles", "30051999", null);
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		assertTrue(individual.changedData("2020-10-10"));
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
		pet = (EditPetPO) individual.editPet();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		String type = "dog";
		individual = (OwnerPO) pet.modify("type", type);
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		assertTrue(individual.changedTypePet(type));
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
		pet = (EditPetPO) individual.editPet();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		petFailed = (EditPetPO) pet.modify("name", "");
		assertTrue(petFailed.ShouldNotBeEmptyOrAlreadyPresent());
		Thread.sleep(1500);
	}

}

