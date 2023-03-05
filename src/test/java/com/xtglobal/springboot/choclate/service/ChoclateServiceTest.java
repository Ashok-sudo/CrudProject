package com.xtglobal.springboot.choclate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.xtglobal.springboot.choclate.ChoclateApplicationTests;
import com.xtglobal.springboot.choclate.entity.DemoChoclate;
import com.xtglobal.springboot.choclate.entitymanager.ChoclateRepositoryImpl;
import com.xtglobal.springboot.choclate.repos.ChoclateRepository;

public class ChoclateServiceTest extends ChoclateApplicationTests
{
	
	@Mock
	ChoclateRepository repository;
	
	@Mock
	ChoclateRepositoryImpl choclateRepositoryImpl;
	
	@InjectMocks
	ChoclateService service;
	

	@Test
	public void getChoclates() throws Exception 
	{
		when(repository.findAll()).thenReturn(Stream.of(new DemoChoclate(1,"chik",1,2)).collect(Collectors.toList()));
		assertEquals(1,service.getChoclates().getBody().getData().size());
	}
	
	@Test
	public void addChoclates() throws Exception
	{
		DemoChoclate choclate = new DemoChoclate();
		choclate.setId(2);
		choclate.setName("Anuh");
		choclate.setQuantityAvailable(5);
		choclate.setUnitPrice(2);
		
		
		when(repository.findById(Mockito.anyInt())).thenReturn(null);
		when(repository.save(Mockito.any(DemoChoclate.class))).thenReturn(choclate);
		assertEquals(true,service.createChoclate(choclate).getBody().isStatus());
		
		when(repository.findById(Mockito.anyInt())).thenReturn(choclate);
		assertEquals(false,service.createChoclate(choclate).getBody().isStatus());
		
	
	}
	
	@Test
	public void updateChoclates() throws Exception
	{
		DemoChoclate choclate = new DemoChoclate();
		choclate.setId(2);
		choclate.setName("Anuh");
		choclate.setQuantityAvailable(5);
		choclate.setUnitPrice(7);
		
		when(repository.save(Mockito.any(DemoChoclate.class))).thenReturn(choclate);
		System.out.println(service.updateChoclate(choclate));

		assertEquals(true,service.updateChoclate(choclate).getBody().isStatus());
			}
	
	@Test
	public void deletechoclate() throws Exception 
	{
		DemoChoclate choclate = new DemoChoclate();
		choclate.setId(1);
		choclate.setName("narrow");
		choclate.setUnitPrice(5);
		choclate.setQuantityAvailable(18);
		System.out.println(choclate.getId());
		
		
		repository.deleteById(choclate.getId());
		//verify(service,times(1)).deleteChoclateById(choclate.getId());
		int a=service.deleteChoclateById(choclate.getId()).getStatusCodeValue();
		assertEquals(200,a);	
//		repository.deleteById(choclate.getId());
//		System.out.println(choclate.getId());
//		System.out.println(choclate.getName());
//		
		
		
	}
	
	@Test
	public void getChoclateById1() throws Exception
	{
		DemoChoclate choclate = new DemoChoclate();
		choclate.setId(1);
		choclate.setName("alan");
		choclate.setQuantityAvailable(3);
		choclate.setUnitPrice(3);
		
		
		when(repository.findById(Mockito.anyInt())).thenReturn(null);
		
		when(repository.findById(Mockito.anyInt())).thenReturn(choclate);
		assertEquals(true, service.getChoclateById(choclate.getId()).getBody().isStatus());
		
		when(repository.findById(Mockito.anyInt())).thenReturn(choclate);
		//System.out.println(choclate);
		//assertEquals(false,service.getChoclateById(choclate.getId()).getBody().isStatus());
		
		
	}
	
	
	@Test
	public void getChoclateById2() throws Exception
	{
		DemoChoclate choclate = new DemoChoclate();
		choclate.setId(1);
		choclate.setName("alan");
		choclate.setQuantityAvailable(3);
		choclate.setUnitPrice(3);
		
		
		when(repository.findById(Mockito.anyInt())).thenReturn(null);
		
		when(repository.findById(Mockito.anyInt())).thenReturn(choclate);
		assertEquals(true, service.getChoclateById(choclate.getId()).getBody().isStatus());
		
		when(repository.findById(Mockito.anyInt())).thenReturn(choclate);
		//System.out.println(choclate);
		//assertEquals(false,service.getChoclateById(choclate.getId()).getBody().isStatus());
		
		
	}
	
	
	
	
	
	@Test
	public void getChoclateByMinimumName() throws Exception
	{
		DemoChoclate choclate = new DemoChoclate();
		choclate.setId(8);
		choclate.setName("duck");
		choclate.setQuantityAvailable(3);
		choclate.setUnitPrice(9);
		
		when(choclateRepositoryImpl.getChoclateByMinName()).thenReturn(choclate);
		System.out.println(choclate.getName());
		//System.out.println(service.findProductWithSortingmin().getBody().getData().get(0).getName());
		assertEquals(true, service.findProductWithSortingmin().getBody().isStatus());
}

}


























