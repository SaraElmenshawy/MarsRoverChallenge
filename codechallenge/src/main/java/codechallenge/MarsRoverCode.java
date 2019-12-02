package codechallenge;

import java.util.Scanner;

public class MarsRoverCode {
	public static void main(String[] args) {
		System.out.println("please enter the pleteu dimentions");
		Scanner input = new Scanner(System.in);
        String plateauDimentions = input.nextLine();
        
        System.out.println("please enter the first rover position and instructions.");
        String firstRoverPosition = input.nextLine();
        String firstRoverInstructions = input.nextLine();
        
        System.out.println("please enter the second rover position and instructions.");
        String secondRoverPosition = input.nextLine();
        String secondRoverInstructions = input.nextLine();
        input.close();  
        RoverPosition roverPositionInstruction=new RoverPosition();
        roverPositionInstruction.roversFinalPositionAndDirection(plateauDimentions, firstRoverPosition, firstRoverInstructions, secondRoverPosition, secondRoverInstructions);
	}
}
