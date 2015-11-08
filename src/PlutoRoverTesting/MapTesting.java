package PlutoRoverTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import PlutoRover.Map.Map;
import PlutoRover.Map.WrongMapValuesException;

public class MapTesting {
	Mockery context = new Mockery();

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

}
