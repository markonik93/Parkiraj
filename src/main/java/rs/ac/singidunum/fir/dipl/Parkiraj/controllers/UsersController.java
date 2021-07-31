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
import rs.ac.singidunum.fir.dipl.Parkiraj.repositories.UsersRepository;

@RestController
@RequestMapping("/users/")
public class UsersController {
	
	@Autowired
	private UsersRepository repository;
	
	//vraca sve usere koji se nalaze u bazi (metoda Get na localhost/users)
	@GetMapping("getAll")
	public List<User> gettAllUsers(){
		return (List<User>)repository.findAll();  // vraca iterable pa kastujemo u listu usera
	}
	
	//vraca usera sa odredjenim id-em
	@GetMapping("getById/{id}")
	public User getUser(@PathVariable int id) {
		return repository.findById(id).orElse(null);  // orElse(null) znaci da ako ne nadje nista nece vratiti nista
	}
	
	//kreiranje usera
	@PostMapping("add")
	public User addUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	//brisanje jednog usera
	@DeleteMapping("deleteById/{id}")
	public String deleteUser(@PathVariable int id) {
		try{
			repository.deleteById(id);
			return "";
		}catch (Exception e) {
			return "Došlo je do greške.";
		}
		
	}
	
	//azuririanje podataka usera
	@PutMapping("update")
	public User updateUser(@RequestBody User user) {
		User oldUser = repository.getOne(user.getUser_id());
		user.setVehicles(oldUser.getVehicles());
		return repository.save(user);
	}
	
	//vraca ukupan broj usera
	@GetMapping("count")
	public long getNumberOfUsers() {
		return repository.count();
	}
	
	//provarava za unete username i passvord da li korisnik postoji
	@PostMapping("isExist")
	public User checkIfExist(@RequestBody User user) {
		System.out.println(user.getUsername()+" "+user.getPassword());
		System.out.println(repository.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
		return repository.check(user.getUsername(), user.getPassword());
	}
	

}















