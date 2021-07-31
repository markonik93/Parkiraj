package rs.ac.singidunum.fir.dipl.Parkiraj.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="zone")
public class Zone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int zone_id;
	
	private String zone_name;
	private String zone_number;
	
	
	@ManyToMany(mappedBy = "zones") 
	private Set<City> cities;

	public Zone(int zone_id, String zone_name, String zone_number) {
		this.zone_id = zone_id;
		this.zone_name = zone_name;
		this.zone_number = zone_number;
	}

	public Zone() {
		
	}

	public int getZone_id() {
		return zone_id;
	}

	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public String getZone_number() {
		return zone_number;
	}

	public void setZone_number(String zone_number) {
		this.zone_number = zone_number;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}		
}
