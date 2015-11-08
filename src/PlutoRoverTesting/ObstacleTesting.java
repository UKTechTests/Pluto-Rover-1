package PlutoRoverTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import PlutoRover.Map.Map;
import PlutoRover.Map.WrongMapValuesException;
import PlutoRover.Util.Cardinal;
import PlutoRover.Util.Directions;
import PlutoRover.Util.Tuple;
import PlutoRover.Vehicle.Rover;

public class ObstacleTesting {

	@Test
	public void checkThatMovingAgainstAnObstacleDoesNotWork() throws WrongMapValuesException {
		Map map = new Map(5,5);
		Rover rover = new Rover(0, 0, Cardinal.NORTH,map);
		
		assertEquals(rover.getX(), 0);
		assertEquals(rover.getY(), 0);
		
		map.addObstacle(1, 0);

		rover.move(Directions.FORWARD);
		assertEquals(rover.getX(), 0);
		assertEquals(rover.getY(), 0);
	}
	
	@Test
	public void checkThatMovingAgainstAnObstacleReturnsThePositionOfTheObstacle() throws WrongMapValuesException {
		Map map = new Map(5,5);
		Rover rover = new Rover(0, 0, Cardinal.NORTH,map);
		
		assertEquals(rover.getX(), 0);
		assertEquals(rover.getY(), 0);
		
		map.addObstacle(1, 0);

		Tuple<Integer,Integer> obstacle = rover.move(Directions.FORWARD);
		assertNotNull(obstacle);
		Integer fst = obstacle.getFst();
		Integer snd = obstacle.getSnd();
		
		assertTrue(fst.equals(1));
		assertTrue(snd.equals(0));
	}
	
	@Test
	public void canAddObstaclesToMap() throws WrongMapValuesException {
		Map map = new Map(10, 10);
		assertFalse(map.hasObstacle(1, 2));
		map.addObstacle(1, 2);
		assertTrue(map.hasObstacle(1, 2));
	}
}
