package rs.ac.singidunum.fir.dipl.Parkiraj.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int city_id;
	private String city_name;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cityzone", 
	joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "city_id"), 
	inverseJoinColumns = @JoinColumn(name ="zone_id", referencedColumnName = "zone_id")) 
	private Set<Zone> zones;
	
	public City() {
	}

	public City(int city_id, String city_name) {
		this.city_id = city_id;
		this.city_name = city_name;
	}
	
	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
	
}
