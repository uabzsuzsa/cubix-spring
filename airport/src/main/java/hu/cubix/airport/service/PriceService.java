package hu.cubix.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
	
	//@Autowired
	private DiscountService discountService;
	
	/**
	 * konstruktor paraméterként adjuk meg a DiscountService osztályt,
	 * mert mok object -eket könnyebben lehet később létrehozni
	 * a spring fordító dependency injuction -nek veszi úgy, 
	 * mint az Autowired annotációt, így ezt nem szükséges kirakni.
	 * 
	 * @param discountService
	 */
	public PriceService(DiscountService discountService) {
		this.discountService = discountService;
	}

	public int getFinalPrice(int price) {
		return (int)(price/100.0*(100-discountService.getDiscountPercent(price)));
	}
	
}
