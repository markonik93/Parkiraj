package rs.ac.singidunum.fir.dipl.Parkiraj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.fir.dipl.Parkiraj.entities.User;
import rs.ac.singidunum.fir.dipl.Parkiraj.entities.Vehicle;
import rs.ac.singidunum.fir.dipl.Parkiraj.repositories.UsersRepository;
import rs.ac.singidunum.fir.dipl.Parkiraj.repositories.VehiclesRepository;

@RestController
@RequestMapping("/vehicles/")
public class VehiclesController {

	@Autowired
	private VehiclesRepository repository;
	@Autowired
	private UsersRepository userRepository;

	// vraca sva vozila koja se nalaze u bazi (metoda Get na localhost/vehicles)
	@GetMapping("findAll")
	public List<Vehicle> gettAll() {
		return (List<Vehicle>) repository.findAll(); // vraca iterable pa kastujemo u listu usera
	}

	// vraca vozilo sa odredjenim id-em
	@GetMapping("findById/{id}")
	public Vehicle getVehicle(@PathVariable int id) {
		return repository.findById(id).orElse(null); // orElse(null) znaci da ako ne nadje nista nece vratiti nista
	}

	// kreiranje vozila
	@PostMapping("Add")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		System.out.println(vehicle.getUsers().isEmpty());
		for (User user : vehicle.getUsers()) {
			System.out.println(user.getName());
		}

		// User user = vehicle.getUsers().iterator().next();
		User user = userRepository.getOne(vehicle.getUsers().iterator().next().getUser_id());
		Vehicle savedVehicle = repository.save(vehicle);
		user.getVehicles().add(savedVehicle);

		userRepository.save(user);
		return savedVehicle;
	}

	// brisanje jednog vozila
	@DeleteMapping("deleteById/{id}")
	public void deleteVehicle(@PathVariable int id) {
		repository.deleteById(id);
	}

	// azuririanje vozila
	@PutMapping("update/{id}")
	public Vehicle updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
		Vehicle car = repository.save(vehicle);
		System.out.println("test test" + car.getVehicle_id());
		return car;
	}

	// vraca vozila za odredjenog usera
	@PostMapping("findByUser")
	public List<Vehicle> getVehiclesByUser(@RequestBody User user) {
		return (List<Vehicle>) repository.findAllVehiclesByUsers(user);
	}

}
