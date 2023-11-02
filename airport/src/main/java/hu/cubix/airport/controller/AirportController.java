package hu.cubix.airport.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cubix.airport.dto.AirportDTO;

/**
 * api: rest api url -ek ide kerülnek
 * localhost:8080/api/airports
 * RequestMapping("/api/airports") : az összes GET,POST,..stb hívás, ami az osztályon
 * belül íródik, ez alá az url alá megy, nem kell külön jelölni.
 * @author Zsuzsa
 *
 */
@RestController
@RequestMapping("/api/airports")
public class AirportController {
	
	private Map<Long,AirportDTO> airports = new HashMap<>();
	{
		airports.put(11L,new AirportDTO(11, "Budapest Airport", "BUD"));
	}
	
	@GetMapping
	public List<AirportDTO> findAll() {
		//return airports.values().stream().toList();		
		return new ArrayList<>(airports.values());
	}
	
//	@PostMapping
//	public AirportDTO create(@RequestBody AirportDTO airport) {
//		airports.put(airport.getId(), airport);
//		return airport;
//	}
//	
//	@GetMapping("/{id}")
//	public AirportDTO findById(@PathVariable long id) {
//		return airports.get(id);
//	}
	
	@PostMapping
	public ResponseEntity<AirportDTO> create(@RequestBody AirportDTO airport) {
		
		if ( airports.containsKey(airport.getId()) ) {
			return ResponseEntity.badRequest().build();
		}
		airports.put(airport.getId(), airport);
		return ResponseEntity.ok(airport);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AirportDTO> update(@PathVariable long id, @RequestBody AirportDTO airport) {
		// a paraméterben küldött id lesz az erősebb
		airport.setId(id);
		if ( !airports.containsKey(id) ) {
			return ResponseEntity.notFound().build();
		}
		airports.put(id, airport);
		return ResponseEntity.ok(airport);
	}
	
	/**
	 * Ha nem talál adatot, akkor a 404 -es hibával tér vissza
	 * Ezt a ResponseEntity osztály tudja megcsinálni
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<AirportDTO> findById(@PathVariable long id) {
		AirportDTO airportDTO = airports.get(id);
		if ( airportDTO == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(airportDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		airports.remove(id);
	}
}
