package myTest;
import myClass.DaysDurationCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCalc {
	private static DaysDurationCalculator tempCalc;
	private int month1, day1, month2, day2, year;
	@Before 
	public void Setup(){

	}
	
	@Test
	public void TestCalc1(){
		
		
		int T;

		month1 = 1;
		day1 = 1;
		month2 = 2;
		day2 = 2;
		year = 2018;
		// preconditions : day1 and day2 must be in same year
		//               1 <= month1, month2 <= 12
		//               1 <= day1, day2 <= 31
		//               month1 <= month2
		//               The range for year: 1 ... 10000
		T = tempCalc.cal (month1, day1, month2, day2, year);
		System.out.println ("Result is: " + T);
		
	}
	
}
