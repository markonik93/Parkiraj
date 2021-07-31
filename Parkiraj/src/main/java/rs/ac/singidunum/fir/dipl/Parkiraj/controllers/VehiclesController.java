package rs.ac.singidunum.fir.dipl.Parkiraj.controllers;

import java.util.ArrayList;
import java.util.HashSet;
//import java.util.ArrayList;
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

import rs.ac.singidunum.fir.dipl.Parkiraj.entities.SaveVehicle;

//import com.google.gson.Gson;

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
	 private UsersRepository urepository;

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
	// ?????????

	/*
	 * @PostMapping("Add") public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
	 * ArrayList<User> users =new ArrayList<User>(); Vehicle v= new Vehicle();
	 * v.setVehicle_name("test"); v.setLicense_plate_number("test1");
	 * //System.out.println("test test" + car.getVehicle_id()); int user_id = 0; for
	 * (User user : vehicle.getUsers()) { System.out.println(user.toString());
	 * users.add(user); v.getUsers().add(user); } //v.setUsers(users); Vehicle car =
	 * repository.save(v); return car; }
	 */

	@GetMapping("/test1")
	public String test1() {
		User user = new User();
		user.setName("Marko");
		user.setLastname("Nikolic");
		user.setEmail("idshh@dsa");
		user.setUsername("mmm");
		user.setPassword("mmmmmm");
		user.setPhone("51635446");
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		urepository.save(user);
		Vehicle vehicle1 = new Vehicle("astra", "bg6652");
		user.getVehicles().add(vehicle1);
		repository.save(vehicle1);
		return vehicle1.toString();

	}

	// kreiranje vozila
	@PostMapping("Add")
	public SaveVehicle addVehicle(@RequestBody SaveVehicle vehicle) {
		
		User u = new User(vehicle.getUserId(),vehicle.getName(),vehicle.getLastname(),vehicle.getEmail(),vehicle.getUsername(),vehicle.getPassword(),vehicle.getPhone());
		Vehicle vehicle1 = new Vehicle(vehicle.getVehicleName(),vehicle.getLicensePlateNumber());
		u.getVehicles().add(vehicle1);
		repository.save(vehicle1);
		return vehicle;
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
