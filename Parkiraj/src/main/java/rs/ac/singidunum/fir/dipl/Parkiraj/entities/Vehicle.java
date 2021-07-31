package rs.ac.singidunum.fir.dipl.Parkiraj.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicle_id;
	
	private String vehicle_name;
	private String license_plate_number;
	
	@ManyToMany(mappedBy = "vehicles")
    private Set<User> users;

	public Vehicle(int vehicle_id, String vehicle_name, String license_plate_number) {
		this.vehicle_id = vehicle_id;
		this.vehicle_name = vehicle_name;
		this.license_plate_number = license_plate_number;
	}
	
	
	public Vehicle(String vehicle_name, String license_plate_number) {
		super();
		this.vehicle_name = vehicle_name;
		this.license_plate_number = license_plate_number;
	}


	public Vehicle() {
		
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public String getLicense_plate_number() {
		return license_plate_number;
	}

	public void setLicense_plate_number(String license_plate_number) {
		this.license_plate_number = license_plate_number;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
		
}
