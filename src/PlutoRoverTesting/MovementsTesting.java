package PlutoRoverTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import PlutoRover.Map.Map;
import PlutoRover.Map.WrongMapValuesException;
import PlutoRover.Util.Cardinal;
import PlutoRover.Util.Directions;
import PlutoRover.Vehicle.Rover;

public class MovementsTesting {
	
	@Test
	public void movingForwardNorthIncreasesXByOne() throws WrongMapValuesException {
		Rover rover = new Rover(0, 0, Cardinal.NORTH, new Map(10,10));
		
		assertEquals(rover.getX(), 0);
		assertEquals(rover.getY(), 0);
		rover.move(Directions.FORWARD);
		assertEquals(rover.getX(), 1);
		assertEquals(rover.getY(), 0);
	}
	
	@Test
	public void movingBackwardsNorthDecreasesXByOne() throws WrongMapValuesException {
		Rover rover = new Rover(1, 0, Cardinal.NORTH, new Map(10,10));
		
		assertEquals(rover.getX(), 1);
		assertEquals(rover.getY(), 0);
		rover.move(Directions.BACKWARDS);
		assertEquals(rover.getX(), 0);
		assertEquals(rover.getY(), 0);
	}
	
	@Test
	public void rotatingRightFromNorthGoesToEast() throws WrongMapValuesException {
		Rover rover = new Rover(0, 0, Cardinal.NORTH, new Map(10,10));
		
		rover.setDirection(Cardinal.NORTH);
		assertEquals(rover.getDirection(), Cardinal.NORTH);
		rover.move(Directions.RIGHT);
		assertEquals(rover.getDirection(), Cardinal.EAST);
	}
	
	@Test
	public void rotatingLeftFromWestGoesToSouth() throws WrongMapValuesException {
		Rover rover = new Rover(0, 0, Cardinal.NORTH, new Map(10,10));
		
		rover.setDirection(Cardinal.WEST);
		assertEquals(rover.getDirection(), Cardinal.WEST);
		rover.move(Directions.LEFT);
		assertEquals(rover.getDirection(), Cardinal.SOUTH);
	}
	
	@Test
	public void goingOverTheMapHeightWrapsAround() throws WrongMapValuesException {
		Rover rover = new Rover(0, 0, Cardinal.NORTH, new Map(5,2));
		
		for(int i = 0; i <= 6; i++){
			rover.move(Directions.FORWARD);
		}
		assertEquals(rover.getX(), 2);
	}
	
	@Test
	public void goingOverTheMapWidthWrapsAround() throws WrongMapValuesException {
		Rover rover = new Rover(0, 0, Cardinal.EAST, new Map(2,5));
		
		for(int i = 0; i <= 6; i++){
			rover.move(Directions.FORWARD);
		}
		assertEquals(rover.getY(), 2);
	}
	
	@Test
	public void goingBelowHeightZeroWrapsAround() throws WrongMapValuesException {
		Rover rover = new Rover(0, 0, Cardinal.SOUTH, new Map(5,5));

		rover.move(Directions.FORWARD);
		assertEquals(rover.getX(), 4);
	}
	
	@Test
	public void goingBelowZeroWidthWrapsAround() throws WrongMapValuesException {
		Rover rover = new Rover(0, 0, Cardinal.WEST, new Map(5,5));

		rover.move(Directions.FORWARD);
		assertEquals(rover.getY(), 4);
	}

}
