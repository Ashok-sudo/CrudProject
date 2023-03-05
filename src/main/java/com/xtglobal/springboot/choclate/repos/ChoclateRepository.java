package com.xtglobal.springboot.choclate.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.xtglobal.springboot.choclate.entity.DemoChoclate;

   
@Repository
public interface ChoclateRepository extends JpaRepository<DemoChoclate, Integer>
{

	DemoChoclate findByName(String name);

	DemoChoclate findById(int id);
	
	@Query(nativeQuery = true,value ="select * from Choclate c where c.quantity_available=(select min(quantity_available) from Choclate)")
	DemoChoclate getChoclateByMinId();
	//@Query(nativeQuery = true,value="select * from Choclate d where d.name=(select min(name) from Choclate)")
	//DemoChoclate getChoclateByMinName();

	

	
	@Query(nativeQuery = true,value="select * from Choclate c where c.unit_price=(select min(unit_price) from Choclate)")
	DemoChoclate getChoclateByMinUnit();



	

	



	
	
	

}


