package com.xtglobal.springboot.choclate.entity.response;

import java.util.List;

import com.xtglobal.springboot.choclate.entity.DemoChoclate;

public class ChoclateResponse 
{
	
	
	private List<DemoChoclate> data;
	private String description;
	private boolean status;
	
	public List<DemoChoclate> getData() {
		return data;
	}
	public void setData(List<DemoChoclate> data) {
		this.data = data;
	}
	public boolean isStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "ChoclateResponse [data=" + data + ", status=" + status + ", description=" + description + "]";
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public char[] getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 
	

}
