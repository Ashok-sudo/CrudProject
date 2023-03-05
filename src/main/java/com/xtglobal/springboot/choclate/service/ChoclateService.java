  package com.xtglobal.springboot.choclate.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.xtglobal.springboot.choclate.entity.DemoChoclate;
import com.xtglobal.springboot.choclate.entity.response.ChoclateResponse;
import com.xtglobal.springboot.choclate.entitymanager.ChoclateRepositoryImpl;
import com.xtglobal.springboot.choclate.repos.ChoclateRepository;
@Service
public class ChoclateService 
{
	@Autowired
	ChoclateRepository repository;
	@Autowired
	ChoclateRepositoryImpl choclateRepoImpl;
	
	public ResponseEntity<ChoclateResponse> getChoclates() throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		List<DemoChoclate> data = (List<DemoChoclate>) repository.findAll();
		choclateResponse.setStatus(true);
		choclateResponse.setData(data);
		choclateResponse.setDescription("List of choclates data");
		return new ResponseEntity<ChoclateResponse> (choclateResponse,HttpStatus.OK);
	}
	public ResponseEntity<ChoclateResponse> findProductWithSortingByName() throws Exception 
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		List<DemoChoclate> data =((Collection<DemoChoclate>) repository.findAll()).stream()
								.sorted((c1,c2)->-c1.getName().compareTo(c2.getName()))
								.toList();
//		@FunctionalInterface
//		interface A
//		{
//			void add(int a,int b);
//		}
//		A a =->{
//			System.out.println(a+b);
//		} 
		
		
//		List<DemoChoclate> data1 =repository.findAll().stream()
//									.sorted(new Comparator<DemoChoclate>()
//											{
//											public int compare(DemoChoclate c1,DemoChoclate c2)
//											{
//												return -c1.getName().compareTo(c2.getName());
//											}
//											})
//									.toList();
		
		
		choclateResponse.setData(data);
		//choclateResponse.setData(data1);
		choclateResponse.setStatus(true);
		choclateResponse.setDescription("List of choclates data sorted by name in descending order");
		return new ResponseEntity<ChoclateResponse> (choclateResponse,HttpStatus.OK);
		
	}
	public ResponseEntity<ChoclateResponse> createChoclate(DemoChoclate choclate) throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		DemoChoclate dbchoclate = repository.findById(choclate.getId());
		
		if(dbchoclate == null)
		{
			repository.save(choclate); 
			choclateResponse.setStatus(true);
			choclateResponse.setDescription("choclate successfully created");
			return new ResponseEntity<ChoclateResponse> (choclateResponse,HttpStatus.CREATED);
		}
		choclateResponse.setStatus(false);
		choclateResponse.setDescription("choclate id already exist in database");
		
		
		
		return new ResponseEntity<ChoclateResponse> (choclateResponse,HttpStatus.CONFLICT);
		
		
	}
	public ResponseEntity<ChoclateResponse> findProductWithSortingmin()	throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		List<DemoChoclate> data = new LinkedList<>();
		DemoChoclate choclate=repository.getChoclateByMinId();  
		data.add(choclate);
		choclateResponse.setStatus(true);
		choclateResponse.setDescription("choclate with minimun quantity");
		choclateResponse.setData(data);
		return new ResponseEntity<ChoclateResponse> (choclateResponse,HttpStatus.OK);
		
	}
	
	
	public ResponseEntity<ChoclateResponse> findProductWithSortingminbyunitprice() throws Exception {
		ChoclateResponse choclateResponse = new ChoclateResponse();
		List<DemoChoclate> data = new LinkedList<>();
		DemoChoclate choclate = repository.getChoclateByMinUnit();
		data.add(choclate);
		choclateResponse.setStatus(true);
		choclateResponse.setDescription("choclate with minimun unit price");
		choclateResponse.setData(data);
		return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
	}
	
	public ResponseEntity<ChoclateResponse> findProductstartlowlettername() throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		List<DemoChoclate> data = new ArrayList<DemoChoclate>();
		DemoChoclate choclate= choclateRepoImpl.getChoclateByMinName();
		data.add(choclate);
		choclateResponse.setStatus(true);
		choclateResponse.setDescription("starting  low characters names printed");
		choclateResponse.setData(data);
		return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		
	}
	public ResponseEntity<ChoclateResponse> findByName(String name) throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		List<DemoChoclate> data = new ArrayList<>();
		DemoChoclate choclate = repository.findByName(name);
		data.add(choclate);
		choclateResponse.setStatus(true);
		choclateResponse.setDescription("particular name will be printed");
		choclateResponse.setData(data);
		return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);

	}
	public ResponseEntity<ChoclateResponse> getChoclateById(int id) throws Exception
	{
		
		ChoclateResponse choclateResponse = new ChoclateResponse();
		List<DemoChoclate> data = new ArrayList<>();
		DemoChoclate choclate = repository.findById(id);
		if(choclate!=null) 
		{

			data.add(choclate);
			choclateResponse.setStatus(true);
			choclateResponse.setDescription("id based records are printed");
			choclateResponse.setData(data);
		}
		else
		{
			choclateResponse.setStatus(false);
			choclateResponse.setDescription("no record found for given id "+id);
			
			
		}
		return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
	}
	public ResponseEntity<ChoclateResponse> deleteChoclateById(int id) throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		
		repository.deleteById(id);
		choclateResponse.setStatus(true);
		choclateResponse.setDescription("choclate with id "+id+" is deleted");
		return new ResponseEntity<ChoclateResponse>(choclateResponse,HttpStatus.OK);
		
		
		
	}
	public ResponseEntity<ChoclateResponse> updateChoclate(DemoChoclate choclate) throws Exception
	{
		ChoclateResponse choclateResponse = new ChoclateResponse();
		List<DemoChoclate> data = new ArrayList<>();
		repository.save(choclate);
		data.add(choclate);
		choclateResponse.setStatus(true);
		choclateResponse.setDescription("chocalte with id "+choclate.getId()+" is updated");
		choclateResponse.setData(data);
		return new ResponseEntity<ChoclateResponse> (choclateResponse,HttpStatus.OK);

	}
	public Set<DemoChoclate> getUniqueChoclatesWithName() {
		//List<DemoChoclate> list = repository.findAll();
		Set<DemoChoclate> set = ((Collection<DemoChoclate>) repository.findAll()).stream().collect(Collectors.toSet());
		return set;
	}
	public Map<Integer,List<DemoChoclate>> getMapbyUnitPrice() {
		
		Map<Integer,List<DemoChoclate>> map = ((Collection<DemoChoclate>) repository.findAll())
														.stream()
														.collect(Collectors.groupingBy(DemoChoclate::getUnitPrice));
		return map;
	}
	
	
	
//	public int sum(int x,int y)
//	{
//		int sum = (int) repository.sum();
//		return sum(10, 10);
//	}
	
	
	
}