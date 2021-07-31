package rs.ac.singidunum.fir.dipl.Parkiraj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.singidunum.fir.dipl.Parkiraj.entities.User;
import rs.ac.singidunum.fir.dipl.Parkiraj.entities.Vehicle;


public interface VehiclesRepository extends JpaRepository<Vehicle, Integer>{
	
	List<Vehicle> findAllVehiclesByUsers (User user);
}
