package com.rest.bus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bus.model.Bus;
import com.rest.bus.service.BusService;

@RestController
public class BusController {
	
	BusService bs;
	
	public BusController(BusService bs) {
		this.bs=bs;
	}
	
	@PostMapping("/save")
	public void saveData(@RequestBody Bus b) {
		bs.save(b);
	}
	
	@PostMapping("/saveall")
	public List<Bus> saveAll(@RequestBody List<Bus> buslist) {
		bs.saveAll(buslist);
		return buslist;
	}
	
	@GetMapping("/getalldata")
	public List<Bus> findAllData(){
		List <Bus>list =bs.getAllData();
		return list;
	}
	
	@GetMapping("/getbyid/{busid}")
	public Bus getById(@PathVariable Integer busid) {
		Bus b=bs.getById(busid);
		return b;
	}
	
	@DeleteMapping("/deletebyid/{busid}")
	public void deleteById(@PathVariable Integer busid) {
		bs.deleteById(busid);
		
	}
	@GetMapping("/getbyFromlocationandtolocation/{fromlocation}/{tolocation}")
	public List<Bus> getByName(@PathVariable String fromlocation,@PathVariable String tolocation){
		List<Bus> list= bs.getByFromandToLocation(fromlocation, tolocation);
		return list;
	}
	
	@GetMapping("/getbyBusname/{busname}")
	public List<Bus> getByBusname(@PathVariable String busname){
		List<Bus> list=bs.findByBusname(busname);
		return list;
	}
	
	@GetMapping("/getbyfromlocation/{fromlocation}")
	public List<Bus> getByfromlocation(@PathVariable String fromlocation){
		List<Bus> list=bs.findByFromlocation(fromlocation);
		return list;
	}
	
	@GetMapping("/pagingandsorting/{pageno}/{pagesize}/{sortBy}")
	public List<Bus> pagingAndSorting(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String sortBy){
		
		List<Bus> list=bs.pagingAndSorting(pageno, pagesize, sortBy);
		
		return list;
	}
	
	@PutMapping("/update/{busid}")
	public String update(@PathVariable Integer busid,@RequestBody Bus b) {
		
		bs.updateData(busid, b);
		bs.save(b);
		
		return "Record Updated...!!";
	}
	
	@PatchMapping("/updatetolocation/{busid}")
	public String updateTolocation(@PathVariable int busid,@RequestBody Bus b) {
		
		bs.updateData(busid, b);
		bs.save(b);
		return "Tolocation is updated";
	}
}
