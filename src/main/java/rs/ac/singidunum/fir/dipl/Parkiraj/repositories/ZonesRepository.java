package rs.ac.singidunum.fir.dipl.Parkiraj.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import rs.ac.singidunum.fir.dipl.Parkiraj.entities.City;
import rs.ac.singidunum.fir.dipl.Parkiraj.entities.Zone;

public interface ZonesRepository extends CrudRepository<Zone, Integer>{

	List<Zone> findAllZonesByCities (City city);
	
}
