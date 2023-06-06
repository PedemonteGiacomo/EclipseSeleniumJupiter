package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.FindOwnerPagePO;
import POs.HomePO;
import POs.OwnerPO;
import POs.OwnersPO;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class TestFindOwners {
	
	private FindOwnerPagePO find;
	private OwnerPO not_found;
	private	OwnersPO list;
	private OwnerPO individual;
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
	}
	
	@Test
	public void testSecondScenario(ChromeDriver driver) throws InterruptedException {
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		find = (FindOwnerPagePO) home.find();
		assertTrue(find.Displayed());
		Thread.sleep(1500);
		// goto black owner
		String LastName = "Black";
		individual = (OwnerPO) find.search(LastName);
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
	}
	
	@Test
	public void testThirdScenario(ChromeDriver driver) throws InterruptedException {
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		find = (FindOwnerPagePO) home.find();
		assertTrue(find.Displayed());
		Thread.sleep(1500);
		// goto black owner
		String LastName = "Bianchi";
		not_found = (OwnerPO) find.search(LastName);
		assertTrue(not_found.NotFound());
		Thread.sleep(1500);
	}

}

