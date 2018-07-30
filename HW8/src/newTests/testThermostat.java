package newTests;

import myClasses.Thermostat;
import myClasses.ProgrammedSettings;
import myClasses.DayType;
import myClasses.Period;

import org.junit.Before;
import org.junit.Test;

public class testThermostat {
	public Thermostat thermo;
	public ProgrammedSettings settings;
	
	@Before
	public void Setup(){
		thermo = new Thermostat(); // Needed object
		settings = new ProgrammedSettings(); // Needed object
		settings.setSetting (Period.MORNING, DayType.WEEKDAY, 69); // dTemp
		thermo.setPeriod (Period.MORNING); // dTemp		
	}

	@Test
	public void TestTTFT(){
		thermo.setCurrentTemp (63);
		thermo.setThresholdDiff (5);
		thermo.setOverride (true);
		thermo.setOverTemp (67); // c is false
		thermo.setMinLag (10);
		thermo.setTimeSinceLastRun (12);		
	}
	
	@Test
	public void TestFTFT(){
		thermo.setCurrentTemp (66); // a is false
		thermo.setThresholdDiff (5);
		thermo.setOverride (true);
		thermo.setOverTemp (67); // c is false
		thermo.setMinLag (10);
		thermo.setTimeSinceLastRun (12);		
	}

	@Test
	public void TestFTTT(){
		thermo.setCurrentTemp (66); // a is false
		thermo.setThresholdDiff (5);
		thermo.setOverride (true);
		thermo.setOverTemp (72); // to make c true
		thermo.setMinLag (10);
		thermo.setTimeSinceLastRun (12);		
	}

	// left off here, editing actual tests
	@Test
	public void TestFFTT(){
		thermo.setCurrentTemp (66); // a is false
		thermo.setThresholdDiff (5);
		thermo.setOverride (false); // b is false
		thermo.setOverTemp (72);
		thermo.setMinLag (10);
		thermo.setTimeSinceLastRun (12);
	}
	
	@Test
	public void TestTTTT(){
		thermo.setCurrentTemp (63);
		thermo.setThresholdDiff (5);
		thermo.setOverride (true);
		thermo.setOverTemp (72);
		thermo.setMinLag (10);
		thermo.setTimeSinceLastRun (12);		
	}
	
	@Test
	public void TestTTTF(){
		thermo.setCurrentTemp (63);
		thermo.setThresholdDiff (5);
		thermo.setOverride (true);
		thermo.setOverTemp (72);
		thermo.setMinLag (10);
		thermo.setTimeSinceLastRun (8); // d is false	
	}	
}
