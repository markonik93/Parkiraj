package rs.ac.singidunum.fir.dipl.Parkiraj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.fir.dipl.Parkiraj.entities.City;
import rs.ac.singidunum.fir.dipl.Parkiraj.repositories.CitiesRepository;

@RestController
public class CitiesController {
	
	@Autowired
	private CitiesRepository repository;
	
	@GetMapping("/cities")
	public List<City> getAllCities(){
		return (List<City>)repository.findAll();
	}

}
