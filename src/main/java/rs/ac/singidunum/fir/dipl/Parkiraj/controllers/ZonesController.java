package rs.ac.singidunum.fir.dipl.Parkiraj.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.fir.dipl.Parkiraj.entities.City;
import rs.ac.singidunum.fir.dipl.Parkiraj.entities.Zone;
import rs.ac.singidunum.fir.dipl.Parkiraj.repositories.ZonesRepository;

@RestController
public class ZonesController {
	
	@Autowired
	private ZonesRepository repository;
	
	@GetMapping("/zones")
	public List<Zone> getAll(){
		return (List<Zone>)repository.findAll();
	}
	
	@PostMapping("/zones/city")
	public List<Zone> getZonesByCities(@RequestBody City city){
		return (List<Zone>)repository.findAllZonesByCities(city);
	}
	
}
