package codechallenge;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MarsRoverTestsNegativeSenarios {

	RoverPosition marsRover=new RoverPosition();
	
	private String plateuDimentionsInput;
	private String rover1Position;
	private String rover1Instructions;
	private String rover2Position;
	private String rover2Instructions;
	private String expectedoutput;
	
	public MarsRoverTestsNegativeSenarios(String plateuDimentionsInput, String rover1Position,
			String rover1Instructions, String rover2Position,
			String rover2Instructions, String expectedoutput) {
		this.plateuDimentionsInput = plateuDimentionsInput;
		this.rover1Position = rover1Position;
		this.rover1Instructions = rover1Instructions;
		this.rover2Instructions=rover2Instructions;
		this.rover2Position=rover2Position;
		this.expectedoutput = expectedoutput;
	}

	@Parameters
	public static Collection<Object[]> testConditions(){
		return Arrays.asList(new Object[][] {
	         { "5 5","3 3 X","MMRMMRMRRM","3 4 E","MMRMMRMRRM", "Error: Rover position must be N S W or E." },
	         { "-5 -5","3 3 E","MMRMMRMRRM","3 4 E","MMRMMRMRRM", "Error: Plateu dimentions cannot be empty or contain any negative number." },
	         { "5 5","-3 3 E","MMRMMRMRRM","3 3 E","MMRMMRMRRM", "Error: Rover position cannot be empty or contain any negative number and the position must be N S W or E."},
	         { "5 5","3 3 E","MMRMMRMRRM","-3 3 E","MMRMMRMRRM", "Error: Rover position cannot be empty or contain any negative number and the position must be N S W or E."},
	         { "10 10","20 3 E","MMRMMRMRRM","3 3 E","MMRMMRMRRM", "Error: The position of the rover cannot be outside the dimentions of the plateu" },
	         { "10 10","3 3 E","MMRMMRMRRM","20 3 E","MMRMMRMRRM", "Error: The position of the rover cannot be outside the dimentions of the plateu" },
	         { "10 10","10 3 E","MMRMMRMRRM","3 3 E","MMRMMRMRRM", "Error: The position of the rover cannot be outside the dimentions of the plateu" },
	         { "10 10","10 3 E","","3 3 E","MMRMMRMRRM", "Error: Instructions cannot be empty." },
	         { "10 10","","MMRMMRMRRM","3 3 E","MMRMMRMRRM", "Error: Rover position cannot be empty or contain any negative number and the position must be N S W or E." },
	         { "","10 3 E","MMRMMRMRRM","3 3 E","MMRMMRMRRM", "Error: Plateu dimentions cannot be empty or contain any negative number." },
	         { "5 5","1 2 N","LMLMLMLMM","1 2 E","MMRMMRMRRM", "Error: Both Rovers cannot start in the same position." },
	         { "5 5","1 2 N","LMLMLMLMM","1 3 N","MMRMMRMRRM", "Error: Rovers positions cannot intersect." },
	         { "5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRMLMMLMMMM", "Error: Rovers positions cannot intersect." }
	      });
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRoverPositionNegativeSenarios() {
		try
		   {
			 assertEquals(expectedoutput, marsRover.roversFinalPositionAndDirection(plateuDimentionsInput,rover1Position,rover1Instructions,rover2Position,rover2Instructions));
		   }
		   catch(IllegalArgumentException re)
		   {
		      assertEquals(expectedoutput, re.getMessage());
		      throw re;
		    }
	}

}
