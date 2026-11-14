package com.rest.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rest.bus.exception.ResourceNotFoundException;
import com.rest.bus.exception.ResourceNotFoundException;
import com.rest.bus.model.Bus;
import com.rest.bus.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService{
	
	BusRepository br;
	public BusServiceImpl(BusRepository br) {
		this.br=br;
	}

	@Override
	public void save(Bus b) {
		br.save(b);
		
	}

	@Override
	public Bus getById(Integer busid) {
//		Bus b=br.findById(busid).get();
		
		Optional<Bus> bb=br.findById(busid);
		if(bb.isPresent()) {
			return bb.get();
			}
		else {
			throw new ResourceNotFoundException("Resource Not Found..."+busid);
		}
		
	}

	@Override
	public String deleteById(Integer busid) {
		br.deleteById(busid);
		return "Record Deleted....";
	}

	@Override
	public void saveAll(List<Bus> buslist) {
		br.saveAll(buslist);
		
	}
	@Override
	public List<Bus> getByFromandToLocation(String fromlocation,String tolocation) {
		List <Bus> buslist=br.findByFromlocationAndTolocation(fromlocation, tolocation);
		return buslist;
	}


	@Override
	public List<Bus> findByBusname(String busname) {
		List <Bus> buses=br.findByBusname(busname);
		return buses;
	}

	@Override
	public List<Bus> findByFromlocation(String fromlocation) {
		List <Bus> buses=br.findByFromlocation(fromlocation);
		return buses;
	}

	@Override
	public List<Bus> getAllData() {
//		List<Bus> buslist=(List<Bus>)br.findAll();
		List<Bus> buslist=br.findAllRecord();
		
		return buslist;
	}

	@Override
	public List<Bus> pagingAndSorting(int pageno, int pagesize, String sortBy) {
	
		Pageable pageable=PageRequest.of(pageno, pagesize, Sort.by(sortBy));
		List<Bus> list=br.findAll(pageable).getContent();
		return list;
	}

	@Override
	public void updateData(Integer busid, Bus b) {
		
		Bus existing=br.findById(busid).get();
		existing.setBusname(b.getBusname());
		existing.setPrice(b.getPrice());
		existing.setFromlocation(b.getFromlocation());
		existing.setTolocation(b.getTolocation());
		
		br.save(existing);
		
	}
	
	@Override
	public void updateTolocation(int busid, String tolocation) {
		
		br.updateTolocation(busid, tolocation);
		
		
	}

}
