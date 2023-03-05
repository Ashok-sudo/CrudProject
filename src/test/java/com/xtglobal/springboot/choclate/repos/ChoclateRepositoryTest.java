package com.xtglobal.springboot.choclate.repos;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xtglobal.springboot.choclate.ChoclateApplicationTests;
import com.xtglobal.springboot.choclate.entity.DemoChoclate;

@Repository
class ChoclateRepositoryTest extends ChoclateApplicationTests
{

	
	@Autowired
	private ChoclateRepository choclateRepository;
	
	@Test
	public void testChoclateByName()
	{
		String name ="aasa";
		DemoChoclate choclate = new DemoChoclate();
		choclate.setName(name);
		choclateRepository.findByName(name);
		assertEquals("aasa", choclate.getName());

		
	}
	
	@Test
	public void testChoclateById()
	{
		
		
		DemoChoclate choclate = new DemoChoclate();
		choclate.setId(1);
		choclate.setName("Junit");
		choclateRepository.findById(1);
		assertEquals(1, choclate.getId());
	}
	
@Test
public void getChoclateByMinId() 
{
 
	
	DemoChoclate choclate = new DemoChoclate();
	choclate.setId(1); 
	choclate.setName("ashok");
	choclate.setQuantityAvailable(2);
	choclate.setUnitPrice(8);
	choclateRepository.getChoclateByMinId();
	assertNotNull(choclate);
	System.out.println(choclate);
	assertEquals(1, choclate.getId());
	
}





}


















