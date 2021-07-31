package rs.ac.singidunum.fir.dipl.Parkiraj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.fir.dipl.Parkiraj.entities.UserVehicle;
import rs.ac.singidunum.fir.dipl.Parkiraj.repositories.UserVehicleRepository;

@RestController
@RequestMapping("/uservehicles/")
public class UserVehicleController {
	
	@Autowired
	private UserVehicleRepository repository;
	
	//kreiranje uservozilo objekta
	@PostMapping("add")
	public UserVehicle addUserVehicle(@RequestBody UserVehicle userVehicle) {
		return repository.save(userVehicle);
	
	}

}
