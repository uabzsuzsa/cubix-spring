package hu.cubix.airport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.airport.service.DefaultDiscountService;
import hu.cubix.airport.service.DiscountService;
import hu.cubix.airport.service.SpecialDiscountService;

/**
 * Konfiguration osztály, ami ahhoz kell, hogy a két DiscountService leszármazott Bean
 * közül melyiket vegye a fordító figyelembe.
 * 
 * @author Zsuzsa
 *
 */
@Configuration
@Profile("prod")
public class ProdConfiguration {
	
	/**
	 * A Bean annotációt kell itt használni
	 * @return
	 */
	@Bean
	public DiscountService discountService() {
		return new SpecialDiscountService();
	}
}
