package com.xtglobal.springboot.choclate.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind .annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xtglobal.springboot.choclate.entity.DemoChoclate;
import com.xtglobal.springboot.choclate.entity.response.ChoclateResponse;
import com.xtglobal.springboot.choclate.service.ChoclateService;

	
@RestController   
	public class ChoclateRestController 
	{
   
		@Autowired
		ChoclateService  service;
		
		
		@RequestMapping(value="/choclates/",method=RequestMethod.GET)
		public ResponseEntity<ChoclateResponse> getChoclates()
		{
			try 
			{
				return service.getChoclates();  
			}
			catch(Exception e) 
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured"); 
				
			return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			//return repository.findAll();
		}
		
		@RequestMapping(value="/choc/name",method=RequestMethod.GET)
		public ResponseEntity<ChoclateResponse> findProductWithSortingByName()
		{
			try
			{
				return service.findProductWithSortingByName();
			}
			catch (Exception e)
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription(" data will not found error occured");
				return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			 //return repository.findAll(Sort.by(Sort.Direction.DESC,"name"));
			
		}
		
		@RequestMapping(value="/choce/startlowlettername",method=RequestMethod.GET)
		public ResponseEntity<ChoclateResponse> findProductstartlowlettername()
		{
			try
			{
				return service.findProductstartlowlettername();
			}
			catch (Exception e) 
			{
				System.out.println(e);
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured");
			return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
				
			}
			
//			Pageable pageable=PageRequest.of(0, 1,Sort.by("name").ascending());
//			return repository.findAll(pageable);  
		}
		
		
		
		@RequestMapping(value="/choclate/minquantityavailable",method=RequestMethod.GET)
		public ResponseEntity<ChoclateResponse> findProductWithSortingmin()
		{ 

			try
			{
				return service.findProductWithSortingmin();
			}
			catch (Exception e)
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured");
				return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}

				// Pageable pageable=PageRequest.of(0, 1,Sort.by("id").ascending());
				  //return repository.findAll(pageable);  			 }
		} 
		
		
		@RequestMapping(value="/choclate/minunitprice",method=RequestMethod.GET)
		private ResponseEntity<ChoclateResponse> findProductWithSortingminbyunitprice()
		{ 

			try
			{
				return service.findProductWithSortingminbyunitprice();
			}
			catch (Exception e)
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured");
				return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}

				// Pageable pageable=PageRequest.of(0, 1,Sort.by("id").ascending());
				  //return repository.findAll(pageable);  			 }
		} 

		
		
		
		@RequestMapping(value="/choclates/{id}",method=RequestMethod.GET)
		public ResponseEntity<ChoclateResponse> getChocalteById(@PathVariable("id") int id)
		{
			try
			{
				return service.getChoclateById(id);
			}
			catch (Exception e)
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured");
			return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			
		}
		
		@RequestMapping(value="/choclates/",method=RequestMethod.POST)
		public ResponseEntity<ChoclateResponse> createChoclate(@RequestBody DemoChoclate choclate)
		{

			try
			{
				return service.createChoclate(choclate);
			}
			catch (Exception e)
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured");
				
				return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			//return repository.save(choclate);
		}
		
		@RequestMapping(value = "/getparticularchoclatename", method = RequestMethod.GET)  ///getparticularchoclatename?name=aasa
		public ResponseEntity<ChoclateResponse> getChoclate(@RequestParam(value="name") String name)
		{
			try
			{
				return  service.findByName(name);
			}
			catch (Exception e) 
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured");
				
				return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
		}
		
		
		@RequestMapping(value="/choclates/",method=RequestMethod.PUT)
		public ResponseEntity<ChoclateResponse> updateChoclate(@RequestBody DemoChoclate choclate)
		{
			try
			{
				return service.updateChoclate(choclate);
			}
			catch (Exception e)
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured");
				return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			
		}
	
		@RequestMapping(value="/choclatedeleted/{id}",method=RequestMethod.DELETE)
		public ResponseEntity<ChoclateResponse> deleteChoclateById(@PathVariable("id") int id)
		{
			try
			{
				return service.deleteChoclateById(id);
			}
			catch (Exception e)
			{
				ChoclateResponse choclateResponse = new ChoclateResponse();
				choclateResponse.setStatus(false);
				choclateResponse.setDescription("while processing error occured");
				
				return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
		}
		@GetMapping(value="/choco/getuniquename")
		public Set<DemoChoclate> getUniqueChoclatesWithName()
		{
			return service.getUniqueChoclatesWithName();
		}
		@GetMapping(value="/chocol/getMappedByUnitPrice")
		public Map<Integer,List<DemoChoclate>> getMapbyUnitPrice()
		{
			return service.getMapbyUnitPrice();
			
		}
		
		
		
		
		public static int add(int x,int y)
		{
			return x+y;
		}


		
	
	public List<String>	getGrades(List<Integer> scores)
	{
		List<String> grades = new ArrayList<>();
		for(Integer score: scores)
		{
			grades.add(computeGrade(score));
		}
			
		return grades;
		
	}

	private String computeGrade(Integer score) 
	{
	
		return score<70 ? "Fail":"Pass";
	}
	
	 }





