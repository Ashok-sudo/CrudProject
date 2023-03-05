package com.xtglobal.springboot.choclate.entitymanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xtglobal.springboot.choclate.ChoclateApplicationTests;
import com.xtglobal.springboot.choclate.entity.DemoChoclate;
@Repository
public class ChoclateRepositoryImplTest extends ChoclateApplicationTests  
{

@Autowired
private ChoclateRepositoryImpl choclateRepositoryImpl;

@Test
public void getChoclateByMinName()
{	

	
	DemoChoclate choclate = new DemoChoclate();
	choclate.setId(1);
	choclate.setName("kill");
	choclate.setQuantityAvailable(3);
	choclate.setUnitPrice(2); 
	
	 choclateRepositoryImpl.getChoclateByMinName();
	 assertEquals("kill", choclate.getName());
}
}


	
	
	

