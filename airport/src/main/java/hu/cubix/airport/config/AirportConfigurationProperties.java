package hu.cubix.airport.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Ha nincs @Component annotation, akkor ezt a hibaüzenetet dobja a fordító
 * Field config in hu.cubix.airport.service.SpecialDiscountService required 
 * a bean of type 'hu.cubix.airport.config.AirportConfigurationProperties' 
 * that could not be found.
 * 
 *
 */
@ConfigurationProperties(prefix = "airport")
@Component
public class AirportConfigurationProperties {
	
	private Discount discount;

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}


	/**
	 * a configuration.properties fájlban megadott sorrend szerint vannak a beágyazott osztályok
	 * a properties fájlban megadott hierarchia van itt mappelve
	 * 
	 * airport.discount.special.limit=1000
	 * airport.discount.special.lowerPercent=10
	 * airport.discount.special.higherPercent=15
	 * 
	 *
	 */
	public static class Discount{
		private Special special;
		
		public Special getSpecial() {
			return special;
		}

		public void setSpecial(Special special) {
			this.special = special;
		}

		public static class Special {
			private int limit;
			private int lowerPercent;
			private int higherPercent;
			public int getLimit() {
				return limit;
			}
			public void setLimit(int limit) {
				this.limit = limit;
			}
			public int getLowerPercent() {
				return lowerPercent;
			}
			public void setLowerPercent(int lowerPercent) {
				this.lowerPercent = lowerPercent;
			}
			public int getHigherPercent() {
				return higherPercent;
			}
			public void setHigherPercent(int higherPercent) {
				this.higherPercent = higherPercent;
			}
			
			
		}
	}

}
