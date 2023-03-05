package com.xtglobal.springboot.choclate.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.xtglobal.springboot.choclate.entity.DemoChoclate;
@Repository
public class ChoclateRepositoryImpl 
{
	
	
	public DemoChoclate getChoclateByMinName()
	{

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entityManager =emf.createEntityManager();
		Query query = entityManager.createQuery("select d from DemoChoclate d where d.name=(select min(d1.name) from DemoChoclate d1)");
		DemoChoclate result =(DemoChoclate) query.getSingleResult();
		return  result;
	}



}
