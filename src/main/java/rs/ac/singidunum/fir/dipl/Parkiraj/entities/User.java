package rs.ac.singidunum.fir.dipl.Parkiraj.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	private String name;
	private String lastname;
	private String email;
	private String username;
	private String password;
	private String phone;
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name = "uservehicle", 
	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id"))
	private Set<Vehicle> vehicles = new HashSet<>() ;
	 
	
	public User(int user_id, String name, String lastname, String email, String username, String password, String phone) {
		this.user_id = user_id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}

	public User() {
		
	}
	

	public User(int user_id, String name, String lastname, String email, String username, String password, String phone,
			Set<Vehicle> vehicles) {
		this.user_id = user_id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.vehicles = vehicles;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", phone=" + phone + ", vehicles=" + vehicles
				+ "]";
	}
	
}
