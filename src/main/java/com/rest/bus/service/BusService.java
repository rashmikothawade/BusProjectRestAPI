package com.rest.bus.service;

import java.util.List;

import com.rest.bus.model.Bus;

public interface BusService {

	public void save(Bus b);

	public List<Bus> getAllData();

	public Bus getById(Integer busid);

	public String deleteById(Integer busid);

	public void saveAll(List<Bus> buslist);

	public List<Bus> getByFromandToLocation(String fromlocation, String tolocation);

	public List<Bus> findByBusname(String busname);

	public List<Bus> findByFromlocation(String fromlocation);
	
	public List<Bus> pagingAndSorting(int pageno,int pagesize,String sortBy);
	
	public void updateData(Integer busid,Bus b);

	public void updateTolocation(int busid,String tolocation);
}
