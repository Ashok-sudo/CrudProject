package com.xtglobal.springboot.choclate.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Choclate")
public class DemoChoclate 
{
	
	@Id
	private int id;
	private String name;
	@Column(name="unit_price")
	private int unitPrice;
	@Column(name="quantity_available")
	private int quantityAvailable;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
public DemoChoclate() {
		
	}
	public DemoChoclate(int id, String name, int unitPrice, int quantityAvailable) 
	{
		this.id=id;
		this.name=name;
		this.unitPrice=unitPrice;
		this.quantityAvailable=quantityAvailable;
		
	}
	@Override
	public String toString() {
		return "DemoChoclate [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", quantityAvailable="
				+ quantityAvailable + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemoChoclate other = (DemoChoclate) obj;
		return  Objects.equals(name, other.name);
				
	}
	
	
	

}
