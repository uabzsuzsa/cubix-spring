package hu.cubix.airport.service;

import org.springframework.stereotype.Service;


/**
 * A @Service tag - Bean class and business logic class, is shows for developers
 * 
 * 
 * A Service annotáció nem kell, mert konfigurációs osztályban már definiálva van,
 * mint Bean osztály.
 * 
 * @author Zsuzsa
 *
 */
//@Service
public class DefaultDiscountService implements DiscountService {

	@Override
	public int getDiscountPercent(int totalPrice) {
		return 10;
	}

	
}
