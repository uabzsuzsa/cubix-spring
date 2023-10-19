package hu.cubix.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.airport.service.PriceService;

@SpringBootApplication
public class AirportApplication implements CommandLineRunner {
	// test modification
	@Autowired
	PriceService priceService;

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

	
	/**
	 * Mivel a main() metódus statikus, ezért ott nem lehet hivatkozni a priceService 
	 * beágyazott osztály példányára
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println(priceService.getFinalPrice(100));
		System.out.println(priceService.getFinalPrice(2000));
	}

}
