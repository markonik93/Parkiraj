package rs.ac.singidunum.fir.dipl.Parkiraj.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="uservehicle")
public class UserVehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uservehicle_id;
	private int user_id;
	private int vehicle_id;
	
	public UserVehicle(int uservehicle_id, int user_id, int vehicle_id) {
		this.uservehicle_id = uservehicle_id;
		this.user_id = user_id;
		this.vehicle_id = vehicle_id;
	}

	public UserVehicle() {
	}

	public int getUservehicle_id() {
		return uservehicle_id;
	}

	public void setUservehicle_id(int uservehicle_id) {
		this.uservehicle_id = uservehicle_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	
}
