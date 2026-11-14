package com.rest.bus.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rest.bus.model.Bus;

import jakarta.transaction.Transactional;


public interface BusRepository extends JpaRepository<Bus, Integer>{

	public List<Bus> findByFromlocationAndTolocation(String fromlocation,String tolocation);
	
	public List<Bus> findByBusname(String busname);
	
	public List<Bus> findByFromlocation(String fromlocation);
	
	@Query("from Bus")
	public List<Bus> findAllRecord();
	
	@Modifying
	@Transactional
	@Query("update Bus set tolocation=:tlc where busid=:id")
	public void updateTolocation(@Param("id")int busid,@Param("tlc")String tolocation);

}
