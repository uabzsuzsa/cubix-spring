package hu.cubix.airport.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hu.cubix.airport.dto.AirportDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AirportController {
	
	private List<AirportDTO> airports = new ArrayList<>();
	{
		airports.add(new AirportDTO(11, "Budapest Airport", "BUD"));
	}
	
	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("airports", airports);
		model.put("newAirport", new AirportDTO());
		System.out.println("model: "+model.get("airports"));
		return "index";
	}
	
	@PostMapping("/airport")
	public String createAirport(AirportDTO airport, Map<String, Object> model) {
		airports.add(airport);
		model.put("airports", airports);
		System.out.println("airport: "+airport);
		model.put("newAirport", new AirportDTO());
		// a browser-ből egy GET hívás fog jönni a home '/' url-re (http://localhost:8080/)
		return "redirect:/";
	}
	
	
	/**
	 * A kód redundáns, ezért a home() metódust hívjuk meg
	 * @param airport
	 * @param model
	 * @return
	 */
//	@PostMapping("/airport")
//	public String createAirport(AirportDTO airport, Map<String, Object> model) {
//		airports.add(airport);
//		model.put("airports", airports);
//		System.out.println("airport: "+airport);
//		model.put("newAirport", new AirportDTO());
//		return "index";
//	}
	
	/**
	 * a metódus végén mindig meghívja a home() metódust, de ebben az esetben
	 * az /airport mindig az utolsó beírt adattal fog visszajönni, ha a browser-ben     F5 -öt nyomunk
	 * @param airport
	 * @param model
	 * @return
	 */
//	@PostMapping("/airport")
//	public String createAirport(AirportDTO airport, Map<String, Object> model) {
//		airports.add(airport);
//		model.put("airports", airports);
//		System.out.println("airport: "+airport);
//		model.put("newAirport", new AirportDTO());
//		return home(model);
//	}

}
