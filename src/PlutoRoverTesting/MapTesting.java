package PlutoRoverTesting;

import static org.junit.Assert.*;
import PlutoRover.Map.*;

import org.junit.Test;

public class MapTesting {

	@Test(expected=WrongMapValuesException.class)
	public void creatingMapWithNegativeValuesReturnsException() throws WrongMapValuesException {
			Map map = new Map(-1,-1);
	}

	@Test(expected=WrongMapValuesException.class)
	public void creatingMapWithZeroValuesReturnsException() throws WrongMapValuesException {
			Map map = new Map(0,0);
	}
	
	@Test
	public void assertThatMapHeightAndWidthAreCorrect() throws WrongMapValuesException {
		int height = 5;
		int width = 2;
		
		Map map = new Map(height, width);
		
		assertEquals(map.getHeight(), height);
		assertEquals(map.getWidth(), width);
	}
	
	@Test
	public void canAddObstaclesToMap() throws WrongMapValuesException {
		Map map = new Map(10, 10);
		assertFalse(map.hasObstacle(1, 2));
		map.addObstacle(1, 2);
		assertTrue(map.hasObstacle(1, 2));
	}
}
