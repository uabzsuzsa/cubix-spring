package hu.cubix.hr.zs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "hr")
@Component
public class HrConfigurationProperties {
	
	private Salary salary;
	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public static class Salary {
		
		private Special special;
		
		public Special getSpecial() {
			return special;
		}

		public void setSpecial(Special special) {
			this.special = special;
		}

		public static class Special {
		
		
			private Double limit1;
			private Double limit2;
			private Double limit3;
			private Integer percentDefault;
			private Integer percent1;
			private Integer percent2;
			private Integer percent3;
			
			public Double getLimit1() {
				return limit1;
			}
			public void setLimit1(Double limit1) {
				this.limit1 = limit1;
			}
			public Double getLimit2() {
				return limit2;
			}
			public void setLimit2(Double limit2) {
				this.limit2 = limit2;
			}
			public Double getLimit3() {
				return limit3;
			}
			public void setLimit3(Double limit3) {
				this.limit3 = limit3;
			}
			public Integer getPercentDefault() {
				return percentDefault;
			}
			public void setPercentDefault(Integer percentDefault) {
				this.percentDefault = percentDefault;
			}
			public Integer getPercent1() {
				return percent1;
			}
			public void setPercent1(Integer percent1) {
				this.percent1 = percent1;
			}
			public Integer getPercent2() {
				return percent2;
			}
			public void setPercent2(Integer percent2) {
				this.percent2 = percent2;
			}
			public Integer getPercent3() {
				return percent3;
			}
			public void setPercent3(Integer percent3) {
				this.percent3 = percent3;
			}
		}
		
	}
}

	
	


