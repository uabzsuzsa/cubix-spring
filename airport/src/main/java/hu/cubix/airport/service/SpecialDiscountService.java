package hu.cubix.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hu.cubix.airport.config.AirportConfigurationProperties;
import hu.cubix.airport.config.AirportConfigurationProperties.Discount.Special;

/**
 * A Service annotáció nem kell, mert konfigurációs osztályban már definiálva van,
 * mint Bean osztály.
 * 
 * @author Zsuzsa
 *
 */
//@Service
public class SpecialDiscountService implements DiscountService{
	
	/**
	 * value annotation
	 * a változók értékei az application.properties fájlban vannak deklarálva
	 */
//	@Value("${airport.discount.special.limit}")
//	private int limit;
//	@Value("${airport.discount.special.lowerPercent}")
//	private int lowerPercent;
//	@Value("${airport.discount.special.higherPercent}")
//	private int higherPercent;
	
	/**
	 * az configurációs osztály beinjektálása ide, ha nem a configuration.properties fájlban 
	 * adjuk meg.
	 */
	@Autowired
	private AirportConfigurationProperties config;

	@Override
	public int getDiscountPercent(int totalPrice) {
		Special specialConfig = config.getDiscount().getSpecial();
		//return totalPrice > limit ? higherPercent : lowerPercent;
		return totalPrice > specialConfig.getLimit() ? specialConfig.getHigherPercent() : specialConfig.getLowerPercent();
	}

}
