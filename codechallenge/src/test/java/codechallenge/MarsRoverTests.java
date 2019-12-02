package codechallenge;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MarsRoverTests {
	
	RoverPosition marsRover=new RoverPosition();
	private String plateuDimentionsInput;
	private String rover1Position;
	private String rover1Instructions;
	private String rover2Position;
	private String rover2Instructions;
	private String expectedoutput;
	
	public MarsRoverTests(String plateuDimentionsInput,String rover1Position,String rover1Instructions,String rover2Position,String rover2Instructions, String expectedoutput) {
		this.plateuDimentionsInput=plateuDimentionsInput;
		this.rover1Instructions=rover1Instructions;
		this.rover1Position=rover1Position;
		this.rover2Instructions=rover2Instructions;
		this.rover2Position=rover2Position;
		this.expectedoutput = expectedoutput;
	}
	
	@Parameters
	public static Collection<Object[]> testConditions(){
		return Arrays.asList(new Object[][] {
	         { "5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM", "1 3 N\n5 1 E" },
	         { "5 5","3 3 E","MMRMMRMRRM","1 2 N","LMLMLMLMM", "5 1 E\n1 3 N" },
	         { "1000 1000","10 7 S","MMMMMMRLMLLL","3 3 E","MMRMMRMRRM", "10 0 W\n5 1 E" },
	         { "20 20","3 3 W","MMRMMRMRRMS","10 7 S","MMMMMMRLMLLL", "1 5 W\n10 0 W" }
	      });
	}
	
	@Test
	public void testRoverPosition() {
	      assertEquals(expectedoutput, marsRover.roversFinalPositionAndDirection(plateuDimentionsInput,rover1Position,rover1Instructions,rover2Position,rover2Instructions));
	}

}
