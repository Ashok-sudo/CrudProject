package com.xtglobal.springboot.choclate.RestControlletr;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.xtglobal.springboot.choclate.ChoclateApplicationTests;
import com.xtglobal.springboot.choclate.controllers.ChoclateRestController;
import com.xtglobal.springboot.choclate.entity.DemoChoclate;
import com.xtglobal.springboot.choclate.entity.response.ChoclateResponse;
import com.xtglobal.springboot.choclate.service.ChoclateService;

public class ChoclateRestConrollerTest extends ChoclateApplicationTests
{
	

	@Mock
	ChoclateService service;
	
	@InjectMocks
	ChoclateRestController choclateRestController;
	
	@Test
	public void getChoclatesById() throws Exception
	{

		ChoclateResponse choclateResponse = new ChoclateResponse();
		choclateResponse.setStatus(true);
		List<DemoChoclate> list = new ArrayList<>();
		list.add(new DemoChoclate(1,"junit",1,2));
		choclateResponse.setData(list);
		ResponseEntity<ChoclateResponse> response = new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		 HttpStatus a =response.getStatusCode();
		// System.out.println(a);
		 System.out.println(service);
		when(service.getChoclateById(Mockito.anyInt())).thenReturn(response);
		//System.out.println(Mockito.anyInt());
		ResponseEntity<ChoclateResponse> choclate = choclateRestController.getChocalteById(1);
		List<DemoChoclate> data1 = choclate.getBody().getData();
		//System.out.println(data1);
		assertNotNull(data1);
		assertEquals("junit",data1.get(0).getName());
		
	}
	
	@Test
	public void getChoclaetByName() throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		choclateResponse.setStatus(true);
		List<DemoChoclate> list = new ArrayList<>();
		list.add(new DemoChoclate(1,"mock",1,8));
		choclateResponse.setData(list);
		ResponseEntity<ChoclateResponse> response = new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		when(service.findByName(Mockito.anyString())).thenReturn(response);
		ResponseEntity<ChoclateResponse> choclate = choclateRestController.getChoclate("mock");
		List<DemoChoclate> data1 = choclate.getBody().getData();
		assertNotNull(data1);
		assertEquals("mock",data1.get(0).getName());
 	}
	
	@Test
	public void deleteChoclate() throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		choclateResponse.setStatus(true);
		List<DemoChoclate> list = new ArrayList<>();
		list.add(new DemoChoclate(4,"asa",7,8));
		choclateResponse.setData(list);
		ResponseEntity<ChoclateResponse> response = new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		when(service.deleteChoclateById(Mockito.anyInt())).thenReturn(response);
		ResponseEntity<ChoclateResponse> choclate = choclateRestController.deleteChoclateById(4);
		System.out.println("choclated deletd succesfully");
		List<DemoChoclate> data1 = choclate.getBody().getData();
		System.out.println(data1);
		assertEquals(4,data1.get(0).getId());
	}
	

	@Test
	public void testCreateChoclate() throws Exception
	{
		
		ChoclateResponse choclateResponse = new ChoclateResponse();
		choclateResponse.setStatus(true);
		List<DemoChoclate> list = new ArrayList<>();
		list.add(new DemoChoclate(1,"net",2,3));
		list.add(new DemoChoclate(2,"work",5,2));
		choclateResponse.setData(list);
		ResponseEntity<ChoclateResponse> response = new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		when(service.createChoclate(null)).thenReturn(response);
		ResponseEntity<ChoclateResponse> choclate = choclateRestController.createChoclate(null);
		List<DemoChoclate> data1 = choclate.getBody().getData();
		System.err.println(data1);
		assertEquals(choclate.getBody().getData().size(),data1.size());
	
}
	
	@Test
	public void updateChoclate() throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		choclateResponse.setStatus(true);
		List<DemoChoclate> list = new ArrayList<>();
		list.add(new DemoChoclate(8,"net",2,3));
		list.add(new DemoChoclate(2,"work",5,2));
		choclateResponse.setData(list);
		ResponseEntity<ChoclateResponse> response = new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		when(service.updateChoclate(null)).thenReturn(response);
		ResponseEntity<ChoclateResponse> choclate = choclateRestController.updateChoclate(null);
		List<DemoChoclate> data1 = choclate.getBody().getData();
		System.err.println(data1);
		assertEquals(8,data1.get(0).getId());
		
	}
	
	
	@Test
	public void getChoclates() throws Exception
	{
	
		ChoclateResponse choclateResponse = new ChoclateResponse();
		choclateResponse.setStatus(true);
		List<DemoChoclate> list = new ArrayList<>();
		list.add(new DemoChoclate(3,"net",2,3));
		list.add(new DemoChoclate(4,"work",5,2));
		choclateResponse.setData(list);
		ResponseEntity<ChoclateResponse> response = new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		when(service.getChoclates()).thenReturn(response);
		ResponseEntity<ChoclateResponse> choclate = choclateRestController.getChoclates();
		List<DemoChoclate> data1 = choclate.getBody().getData();
		System.out.println(data1);
		assertEquals(2,data1.size());
		
		
}
	
	@Test
	public void findChoclatesLowLetterName() throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		choclateResponse.setStatus(true);
		List<DemoChoclate> list = new ArrayList<DemoChoclate>();
		list.add(new DemoChoclate(3,"net",2,3));
		choclateResponse.setData(list);
		//System.out.println(choclateResponse);
		ResponseEntity<ChoclateResponse> response = new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		System.out.println(response);
		when(service.findProductstartlowlettername()).thenReturn(response);
		ResponseEntity<ChoclateResponse> choclate = choclateRestController.findProductstartlowlettername();
		List<DemoChoclate> data1= choclate.getBody().getData();
		//System.out.println(data1);
		assertEquals("net", data1.get(0).getName());
		
		
	}
	
	
	
	
	
	
	

	
	
		
}



























